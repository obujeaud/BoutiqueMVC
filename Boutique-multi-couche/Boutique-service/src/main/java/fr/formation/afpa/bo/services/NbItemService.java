package fr.formation.afpa.bo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.afpa.bo.entities.ItemRepository;
import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.entities.NbItemRepository;
import fr.formation.afpa.bo.exceptions.NbItemAlreadyExistsException;
import fr.formation.afpa.bo.exceptions.NbItemNotAvailableException;
import fr.formation.afpa.bo.exceptions.NbItemNotFoundException;
import fr.formation.afpa.bo.exceptions.NbItemNotValidException;

@Service
public class NbItemService implements IService<NbItem, Exception> {
	@Autowired
	NbItemRepository nir;
	@Autowired
	ItemRepository ir;

	@Override
	public NbItem create(NbItem t) throws 
			NbItemNotValidException, NbItemAlreadyExistsException {
		// TODO Auto-generated method stub
		boolean isInside = false;
		if (t == null) {
			throw new NbItemNotValidException();
		}else if (t.getIdNbItem() != null) {
			for(NbItem n : nir.findAll()) {
				if(n.getIdNbItem() == t.getIdNbItem()) {
					isInside = true;
				}
			}
			
			if(isInside) {
				throw new NbItemAlreadyExistsException();
			}else {
				throw new NbItemNotValidException();
			}
		}
		return nir.save(t);
	}

	@Override
	public NbItem findById(Long id) throws NbItemNotFoundException {
		// TODO Auto-generated method stub
		if(nir.findById(id) == null) {
			throw new NbItemNotFoundException();
		}
		return nir.findById(id).get();
	}

	@Override
	public List<NbItem> findAll() throws NbItemNotAvailableException {
		// TODO Auto-generated method stub
		if(((List<NbItem>) nir.findAll()).size() == 0) {
			throw new NbItemNotAvailableException();
		}
		return (List<NbItem>) nir.findAll();
	}

	@Override
	public NbItem update(NbItem t) throws NbItemNotValidException, NbItemNotFoundException, NbItemNotAvailableException {
		// TODO Auto-generated method stub
		boolean isInside = false;
		if(t == null) {
			throw new NbItemNotValidException();
		}
		
		for(NbItem n : findAll()) {
			if(n.getIdNbItem() == t.getIdNbItem()) {
				isInside = true;
			}
		}
		
		if(!isInside) {
			throw new NbItemNotFoundException();
		}
		
		return nir.save(t);
	}

	@Override
	public void deleteById(Long id) throws NbItemNotFoundException {
		// TODO Auto-generated method stub
		if(nir.findById(id) == null) {
			throw new NbItemNotFoundException();
		}
		nir.deleteById(id);
	}

	@Override
	public void delete(NbItem t) throws NbItemNotValidException, NbItemNotFoundException, NbItemNotAvailableException {
		// TODO Auto-generated method stub
		boolean isInside = false;
		if(t == null) {
			throw new NbItemNotValidException();
		}
		
		for(NbItem n : findAll()) {
			if(n.getIdNbItem() == t.getIdNbItem()) {
				isInside = true;
			}
		}
		
		if(!isInside) {
			throw new NbItemNotFoundException();
		}
		nir.delete(t);
	}

}
