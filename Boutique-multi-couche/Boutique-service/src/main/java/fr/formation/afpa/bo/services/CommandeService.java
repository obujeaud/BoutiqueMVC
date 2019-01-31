package fr.formation.afpa.bo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.afpa.bo.entities.Commande;
import fr.formation.afpa.bo.entities.CommandeRepository;
import fr.formation.afpa.bo.entities.NbItemRepository;
import fr.formation.afpa.bo.exceptions.CommandeAlreadyExistsException;
import fr.formation.afpa.bo.exceptions.CommandeNotAvailableException;
import fr.formation.afpa.bo.exceptions.CommandeNotFoundException;
import fr.formation.afpa.bo.exceptions.CommandeNotValidException;

@Service
public class CommandeService implements IService<Commande, Exception> {
	@Autowired
	CommandeRepository cr;
	@Autowired
	NbItemRepository nir;

	@Override
	public Commande create(Commande t) throws CommandeNotValidException, CommandeAlreadyExistsException, CommandeNotAvailableException {
		// TODO Auto-generated method stub
		boolean isInside = false;
		if (t == null) {
			throw new CommandeNotValidException();
		}else if (t.getIdCommande() != null) {
			for(Commande n : cr.findAll()) {
				if(n.getIdCommande() == t.getIdCommande()) {
					isInside = true;
				}
			}
			
			if(isInside) {
				throw new CommandeAlreadyExistsException();
			}else {
				throw new CommandeNotValidException();
			}
		}
		return cr.save(t);
	}

	@Override
	public Commande findById(Long id) throws CommandeNotAvailableException {
		// TODO Auto-generated method stub
		if (cr.findById(id) == null) {
			throw new CommandeNotAvailableException();
		}
		return cr.findById(id).get();
	}

	@Override
	public List<Commande> findAll() throws CommandeNotAvailableException {
		// TODO Auto-generated method stub
		if (((List<Commande>) cr.findAll()).size() == 0) {
			throw new CommandeNotAvailableException();
		}
		return (List<Commande>) cr.findAll();
	}

	@Override
	public Commande update(Commande t) throws CommandeNotFoundException, CommandeNotValidException, CommandeNotAvailableException {
		// TODO Auto-generated method stub
		boolean isInside = false;
		if(t == null) {
			throw new CommandeNotValidException();
		}
		
		for(Commande n : findAll()) {
			if(n.getIdCommande() == t.getIdCommande()) {
				isInside = true;
			}
		}
		
		if(!isInside) {
			throw new CommandeNotFoundException();
		}
		return cr.save(t);
	}

	@Override
	public void deleteById(Long id) throws CommandeNotFoundException {
		// TODO Auto-generated method stub
		if(cr.findById(id) == null) {
			throw new CommandeNotFoundException();
		}
		cr.deleteById(id);
	}

	@Override
	public void delete(Commande t) throws CommandeNotValidException, CommandeNotFoundException {
		// TODO Auto-generated method stub
		
		if(t == null) {
			throw new CommandeNotValidException();
		}
		
		if(cr.findById(t.getIdCommande()) == null) {
			throw new CommandeNotFoundException();
		}
		
		cr.delete(t);
	}

}
