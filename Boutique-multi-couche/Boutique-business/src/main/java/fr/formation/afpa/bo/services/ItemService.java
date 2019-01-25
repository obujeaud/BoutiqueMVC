package fr.formation.afpa.bo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.afpa.bo.entities.Item;
import fr.formation.afpa.bo.entities.ItemRepository;

@Service
public class ItemService implements IService<Item, Exception> {
	@Autowired
	ItemRepository ir;

	@Override
	public Item create(Item t) throws Exception {
		// TODO Auto-generated method stub
		return ir.save(t);
	}

	@Override
	public Item findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return ir.findById(id).get();
	}

	@Override
	public List<Item> findAll() throws Exception {
		// TODO Auto-generated method stub
		return (List<Item>) ir.findAll();
	}

	@Override
	public Item update(Item t) throws Exception {
		// TODO Auto-generated method stub
		return ir.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		ir.deleteById(id);
	}

	@Override
	public void delete(Item t) throws Exception {
		// TODO Auto-generated method stub
		ir.delete(t);
	}

}
