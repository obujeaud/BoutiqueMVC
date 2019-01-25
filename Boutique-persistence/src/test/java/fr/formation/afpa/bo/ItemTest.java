package fr.formation.afpa.bo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.formation.afpa.bo.entities.Item;
import fr.formation.afpa.bo.entities.ItemRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=TestApplication.class)
public class ItemTest {
	@Autowired
	TestEntityManager entity;
	@Autowired
	ItemRepository ir;
	
	@Before
	public void setUp() {
		Item i1 = new Item("Test", 2.0);
		Item i2 = new Item("Test2", 5.0);
		Item i3 = new Item("Test3", 15.0);
		entity.persist(i1);
		entity.persist(i2);
		entity.persist(i3);
	}
	
	@Test
	public void findAllTest() {
		assertEquals(3,  ((List<Item>) ir.findAll()).size());
	}

}
