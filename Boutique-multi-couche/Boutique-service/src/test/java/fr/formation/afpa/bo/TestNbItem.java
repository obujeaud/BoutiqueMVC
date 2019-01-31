package fr.formation.afpa.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import fr.formation.afpa.bo.entities.Item;
import fr.formation.afpa.bo.entities.ItemRepository;
import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.entities.NbItemRepository;
import fr.formation.afpa.bo.exceptions.ItemNbItemNotFoundException;
import fr.formation.afpa.bo.exceptions.ItemNbItemNotValidException;
import fr.formation.afpa.bo.exceptions.NbItemAlreadyExistsException;
import fr.formation.afpa.bo.exceptions.NbItemNotAvailableException;
import fr.formation.afpa.bo.exceptions.NbItemNotFoundException;
import fr.formation.afpa.bo.exceptions.NbItemNotValidException;
import fr.formation.afpa.bo.services.NbItemService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestNbItem {
	@Mock
	ItemRepository ir;
	@Mock
	NbItemRepository nir;

	@InjectMocks
	NbItemService nis;

	List<NbItem> nbList = new ArrayList<>();
	List<Item> itemList = new ArrayList<>();

	@Before
	public void setUp() {
		Item i1 = new Item(1l, "Test", 122.0);
		Item i2 = new Item(2l, "Test2", 123.0);
		Item i3 = new Item(3l, "Test3", 124.0);
		Item i4 = new Item(4l, "Test4", 125.0);
		Item i5 = new Item(5l, "Test5", 126.0);

		itemList.add(i1);
		itemList.add(i2);
		itemList.add(i3);
		itemList.add(i4);
		itemList.add(i5);

		NbItem nb1 = new NbItem(1l, i1, 5);
		NbItem nb2 = new NbItem(2l, i2, 1);
		NbItem nb3 = new NbItem(3l, i3, 6);
		NbItem nb4 = new NbItem(4l, i4, 3);
		NbItem nb5 = new NbItem(5l, i5, 8);

		nbList.add(nb1);
		nbList.add(nb2);
		nbList.add(nb3);
		nbList.add(nb4);
		nbList.add(nb5);
	}

	@Test
	public void findAll() throws NbItemNotAvailableException {

		try {
			List<NbItem> n = new ArrayList<>();
			when(nir.findAll()).thenReturn(n);
			nis.findAll();
		} catch (NbItemNotAvailableException e) {
			e.printStackTrace();
		}

		try {
			when(nir.findAll()).thenReturn(nbList);
			assertEquals(5, nis.findAll().size());
		} catch (NbItemNotAvailableException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCreate() throws ItemNbItemNotValidException, ItemNbItemNotFoundException, NbItemNotValidException,
			NbItemAlreadyExistsException, NbItemNotFoundException {

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] os = invocation.getArguments();

				if (os != null && os.length != 0 && os[0] != null) {

					NbItem w = (NbItem) os[0];
					w.setIdNbItem(152L);
					nbList.add(w);
				}
				return null;
			}

		}).when(nir).save(Mockito.any(NbItem.class));
		when(nir.findAll()).thenReturn(nbList);

		NbItem ntest = new NbItem(itemList.get(1), 2);
		nis.create(ntest);
		assertEquals(6, nbList.size());
		assertEquals(152l, nbList.get(5).getIdNbItem().longValue());

		NbItem n = null;

		try {
			nis.create(n);
		} catch (NbItemNotValidException e) {
			e.printStackTrace();
		}

		n = nbList.get(nbList.size() - 1);

		try {
			nis.create(n);
		} catch (NbItemAlreadyExistsException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void updateTest() throws NbItemNotValidException, NbItemNotFoundException, NbItemNotAvailableException {
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] os = invocation.getArguments();

				if (os != null && os.length != 0 && os[0] != null) {

					NbItem w = (NbItem) os[0];
					w.setNbItem(10);

					for (NbItem wa : nbList) {

						if (wa.getIdNbItem() == w.getIdNbItem()) {

							wa.setItem(w.getItem());
							wa.setNbItem(w.getNbItem());
						}
					}
				}
				return null;
			}

		}).when(nir).save(Mockito.any(NbItem.class));
		when(nir.findAll()).thenReturn(nbList);

		NbItem nb = nbList.get(0);
		nb.setNbItem(10);

		assertEquals(10, nbList.get(0).getNbItem());

		try {
			nb = null;
			nis.update(nb);
		} catch (NbItemNotValidException e) {
			e.printStackTrace();
		}

		try {
			nb = new NbItem(new Item(), 15664);
			nis.update(nb);
		} catch (NbItemNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteTest() throws NbItemNotFoundException, NbItemNotValidException, NbItemNotAvailableException {
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] os = invocation.getArguments();

				if (os != null && os.length != 0 && os[0] != null) {

					NbItem w = (NbItem) os[0];
					nbList.remove(w);
				}
				return null;
			}

		}).when(nir).delete(Mockito.any(NbItem.class));
		when(nir.findAll()).thenReturn(nbList);

		NbItem nb = nbList.get(2);

		try {
			nis.delete(nb);
			assertEquals(4, nbList.size());
		} catch (NbItemNotAvailableException e) {
			e.printStackTrace();
		} catch (NbItemNotFoundException e) {
			e.printStackTrace();
		}

		try {
			NbItem n = new NbItem();
			nis.delete(n);
		} catch (NbItemNotFoundException e) {
			e.printStackTrace();
		}

		try {
			NbItem n = null;
			nis.delete(n);
		} catch (NbItemNotValidException e) {
			e.printStackTrace();
		}
	}

}
