package fr.formation.afpa.bo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.entities.NbItemRepository;

@Service
public class NbItemService implements IService<NbItem, Exception> {
	@Autowired
	NbItemRepository nir;

	@Override
	public NbItem create(NbItem t) throws Exception {
		// TODO Auto-generated method stub
		return nir.save(t);
	}

	@Override
	public NbItem findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return nir.findById(id).get();
	}

	@Override
	public List<NbItem> findAll() throws Exception {
		// TODO Auto-generated method stub
		return (List<NbItem>) nir.findAll();
	}

	@Override
	public NbItem update(NbItem t) throws Exception {
		// TODO Auto-generated method stub
		return nir.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		nir.deleteById(id);
	}

	@Override
	public void delete(NbItem t) throws Exception {
		// TODO Auto-generated method stub
		nir.delete(t);
	}

}
