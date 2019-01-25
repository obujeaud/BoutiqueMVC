package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.afpa.bo.services.ItemService;

@Controller
public class BoutiqueController {
	@Autowired
	ItemService is;
	
	@GetMapping("/")
	public String accueil(Model m) throws Exception {
		m.addAttribute("list",  is.findAll());
		return "index";
	}
}
