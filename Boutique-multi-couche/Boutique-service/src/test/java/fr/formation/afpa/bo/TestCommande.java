package fr.formation.afpa.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import fr.formation.afpa.bo.entities.Commande;
import fr.formation.afpa.bo.entities.CommandeRepository;
import fr.formation.afpa.bo.entities.Item;
import fr.formation.afpa.bo.entities.NbItem;
import fr.formation.afpa.bo.entities.NbItemRepository;
import fr.formation.afpa.bo.exceptions.CommandeAlreadyExistsException;
import fr.formation.afpa.bo.exceptions.CommandeNotAvailableException;
import fr.formation.afpa.bo.exceptions.CommandeNotValidException;
import fr.formation.afpa.bo.services.CommandeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestCommande {
	@Mock
	NbItemRepository nir;
	@Mock
	CommandeRepository cr;

	@InjectMocks
	CommandeService cs;

	List<Commande> clist = new ArrayList<>();

	@Before
	public void setUp() {
		Item i1 = new Item(1l, "Test", 122.0);
		Item i2 = new Item(2l, "Test2", 123.0);
		Item i3 = new Item(3l, "Test3", 124.0);
		Item i4 = new Item(4l, "Test4", 125.0);
		Item i5 = new Item(5l, "Test5", 126.0);

		NbItem nb1 = new NbItem(1l, i1, 5);
		NbItem nb2 = new NbItem(2l, i2, 1);
		NbItem nb3 = new NbItem(3l, i3, 6);
		NbItem nb4 = new NbItem(4l, i4, 3);
		NbItem nb5 = new NbItem(5l, i5, 8);
		Set<NbItem> nbset = new HashSet<>();
		Set<NbItem> nbset2 = new HashSet<>();
		nbset.add(nb1);
		nbset.add(nb2);
		nbset.add(nb3);
		nbset2.add(nb4);
		nbset2.add(nb5);
		Commande c1 = new Commande(1l, nbset);
		Commande c2 = new Commande(2l, nbset2);

		clist.add(c1);
		clist.add(c2);

	}

	@Test
	public void createTest() throws CommandeAlreadyExistsException, CommandeNotValidException, CommandeNotAvailableException {
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] os = invocation.getArguments();

				if (os != null && os.length != 0 && os[0] != null) {

					Commande w = (Commande) os[0];
					w.setIdCommande(152L);
					clist.add(w);
				}
				return null;
			}

		}).when(cr).save(Mockito.any(Commande.class));
		when(cr.findAll()).thenReturn(clist);

		Commande c = new Commande(new HashSet<NbItem>());

		cs.create(c);
		assertEquals(3, clist.size());

		Commande ctest = null;

		try {
			cs.create(ctest);
		} catch (CommandeNotValidException e) {
			e.printStackTrace();
		}

		ctest = clist.get(0);

		try {
			cs.create(ctest);
		} catch (CommandeAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAllTest() throws CommandeNotAvailableException {
		when(cr.findAll()).thenReturn(clist);

		assertEquals(2, cs.findAll().size());

		List<Commande> ctest = new ArrayList<>();
		
		try {
			when(cr.findAll()).thenReturn(ctest);
			cs.findAll();
		}catch(CommandeNotAvailableException e) {
			e.printStackTrace();
		}
	}

}
