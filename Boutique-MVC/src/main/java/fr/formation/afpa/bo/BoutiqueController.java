package fr.formation.afpa.bo;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import fr.formation.afpa.bo.entities.Commande;
import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.exceptions.NbItemNotAvailableException;
import fr.formation.afpa.bo.exceptions.NbItemNotFoundException;
import fr.formation.afpa.bo.exceptions.NbItemNotValidException;
import fr.formation.afpa.bo.services.CommandeService;
import fr.formation.afpa.bo.services.ItemService;
import fr.formation.afpa.bo.services.NbItemService;

@Controller
public class BoutiqueController {
	@Autowired
	private ItemService is;
	@Autowired
	private NbItemService nis;
	@Autowired
	private CommandeService cs;

	private Set<NbItem> nbList = new HashSet<>();
	private double totalPrice = 0;

	@GetMapping("/")
	public String accueil(Model m) throws Exception {
		m.addAttribute("list", is.findAll());
		return "index";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/ajout/{id}")
	public String addItemInPanier(@PathVariable(name = "id") String id, Model m, HttpServletRequest serv,
			HttpSession session) throws NumberFormatException, Exception {
		session = serv.getSession();
		if (session.getAttribute("panier") != null) {
			nbList = (Set<NbItem>) session.getAttribute("panier");
		}
		NbItem n = new NbItem(is.findById(Long.parseLong(id)), 1);
		boolean isInside = false;

		totalPrice = 0;
		if (nbList.size() == 0) {
			nbList.add(n);
			nis.create(n);
		} else {
			for (NbItem nbtest : nbList) {
				if (nbtest.getItem().getCode_item() == n.getItem().getCode_item()) {
					isInside = true;
				}
			}

			if (!isInside) {
				nbList.add(n);
				nis.create(n);
			}

		}

		for (NbItem ntst : nbList) {
			totalPrice += ntst.getNbItem() * ntst.getItem().getPrixItem();
		}

		session.setAttribute("panier", nbList);
		session.setAttribute("total", totalPrice);
		m.addAttribute("cart", nbList);
		m.addAttribute("total", totalPrice);

		return "redirect:/panier";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/update/{id}/{nb}")
	public String updateNbItem(@PathVariable(name = "id") String id, @PathVariable(name = "nb") String nb, Model m,
			HttpServletRequest serv, HttpSession session) throws NumberFormatException, NbItemNotFoundException,
			NbItemNotValidException, NbItemNotAvailableException {
		
		session = serv.getSession();
		NbItem n = nis.findById(Long.parseLong(id));
		n.setNbItem(Integer.parseInt(nb));
		NbItem ntrans = new NbItem();
		nbList = (Set<NbItem>) session.getAttribute("panier");
		for (NbItem nt : nbList) {
			if (nt.getIdNbItem() == n.getIdNbItem()) {
				ntrans = nt;
			}
		}

		totalPrice = 0;
		nbList.remove(ntrans);
		nbList.add(n);
		nis.update(n);

		for (NbItem ntst : nbList) {
			totalPrice += ntst.getNbItem() * ntst.getItem().getPrixItem();
		}

		session.setAttribute("panier", nbList);
		session.setAttribute("total", totalPrice);
		m.addAttribute("cart", nbList);
		m.addAttribute("total", totalPrice);
		return "redirect:/panier";

	}

	@GetMapping("/panier")
	public String showPanier(Model m, HttpSession session, HttpServletRequest serv) throws NbItemNotAvailableException {
		session = serv.getSession();
		nbList = new HashSet<>();
		totalPrice = 0;
		try {
			
			for(NbItem n : nis.findAll()) {
				nbList.add(n);
				totalPrice += n.getNbItem()*n.getItem().getPrixItem();
			}
			
		}catch(NbItemNotAvailableException e) {
			return "redirect:/";
		}
		session.setAttribute("panier", nbList);
		session.setAttribute("total",  totalPrice);
		m.addAttribute("cart", nbList);
		m.addAttribute("total", totalPrice);
		return "panier";

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/delete/{id}")
	public String deleteNbItemPanier(@PathVariable(name = "id") String id, Model m, HttpSession session,
			HttpServletRequest serv) throws NumberFormatException, Exception {

		session = serv.getSession();
		NbItem nbRemove = nis.findById(Long.parseLong(id));
		nbList = (Set<NbItem>) session.getAttribute("panier");
		nis.delete(nbRemove);
		nbList.remove(nbRemove);
		
		totalPrice = 0;
		for (NbItem ntst : nbList) {
			totalPrice += ntst.getNbItem() * ntst.getItem().getPrixItem();
		}
		
		session.setAttribute("panier", nbList);
		session.setAttribute("total", totalPrice);
		m.addAttribute("cart", nbList);
		m.addAttribute("total", totalPrice);
		return "redirect:/panier";
	}

	@GetMapping("/clear")
	public String clearCart(HttpServletRequest serv, HttpSession session) throws NbItemNotValidException, NbItemNotFoundException, NbItemNotAvailableException {
		
		for(NbItem n : nbList) {
			nis.delete(n);
		}
		totalPrice = 0;
		nbList = new HashSet<>();
		session = serv.getSession();
		session.removeAttribute("panier");
		session.setAttribute("total",  totalPrice);
		
		return "redirect:/panier";
	}

	@GetMapping("/payer")
	public String showBill(Model m, HttpSession session, HttpServletRequest serv) {
		session = serv.getSession();
		m.addAttribute("bill", session.getAttribute("panier"));
		m.addAttribute("total", (double) session.getAttribute("total"));
		return "paiement";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/billing")
	public String validCommand(HttpServletRequest serv, HttpSession session) throws Exception {
		session = serv.getSession();
		cs.create(new Commande((Set<NbItem>) session.getAttribute("panier")));
		totalPrice = 0;
		nbList = new HashSet<>();
		session.removeAttribute("panier");
		session.removeAttribute("total");
		return "redirect:/";
	}
}
