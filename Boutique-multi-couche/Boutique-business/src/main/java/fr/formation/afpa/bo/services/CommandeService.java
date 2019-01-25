package fr.formation.afpa.bo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.afpa.bo.entities.Commande;
import fr.formation.afpa.bo.entities.CommandeRepository;


@Service
public class CommandeService implements IService<Commande, Exception> {
	@Autowired
	CommandeRepository cr;

	@Override
	public Commande create(Commande t) throws Exception {
		// TODO Auto-generated method stub
		return cr.save(t);
	}

	@Override
	public Commande findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public List<Commande> findAll() throws Exception {
		// TODO Auto-generated method stub
		return (List<Commande>) cr.findAll();
	}

	@Override
	public Commande update(Commande t) throws Exception {
		// TODO Auto-generated method stub
		return cr.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public void delete(Commande t) throws Exception {
		// TODO Auto-generated method stub
		cr.delete(t);
	}

}
