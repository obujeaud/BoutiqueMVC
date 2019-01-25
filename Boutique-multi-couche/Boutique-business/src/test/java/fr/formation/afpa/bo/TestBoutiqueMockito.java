package fr.formation.afpa.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import fr.formation.afpa.bo.entities.Item;
import fr.formation.afpa.bo.entities.ItemRepository;
import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.entities.NbItemRepository;
import fr.formation.afpa.bo.services.ItemService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestBoutiqueMockito {
	@Mock
	ItemRepository ir;
	@Mock
	NbItemRepository nir;

	@InjectMocks
	ItemService is;

	List<Item> ilist = new ArrayList<>();
	List<NbItem> nblist = new ArrayList<>();

	@Before
	public void setUp() {
		Item n1 = new Item("Test", 1.0);
		Item n2 = new Item("Test2", 1.0);
		Item n3 = new Item("Test3", 1.0);
		Item n4 = new Item("Test4", 1.0);
		ilist.add(n1);
		ilist.add(n2);
		ilist.add(n3);
		ilist.add(n4);
		NbItem nb1 = new NbItem(n1, 2);
		nblist.add(nb1);
	}

	@Test
	public void findAllTest() throws Exception {
		when(ir.findAll()).thenReturn(ilist);
		assertEquals(4, is.findAll().size());
	}

}
