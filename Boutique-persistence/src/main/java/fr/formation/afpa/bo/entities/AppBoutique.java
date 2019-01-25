package fr.formation.afpa.bo.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppBoutique implements CommandLineRunner{
	@Autowired
	private ItemRepository ir;
	@Autowired
	private NbItemRepository nir;
	@Autowired
	private CommandeRepository cr;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(AppBoutique.class).headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ir.save(new Item("Poubelle", 12.0));
		ir.save(new Item("Bonsai", 150.0));
		ir.save(new Item("Aspirateur", 75.0));
		ir.save(new Item("TV", 1325.0));
		ir.save(new Item("Veste", 59.0));
		

		Item i1 = ir.findById(1l).get();
		Item i2 = ir.findById(4l).get();
		
		NbItem nb1 = new NbItem(i1, 3);
		NbItem nb2 = new NbItem(i2, 2);
		
		nir.save(nb1);
		nir.save(nb2);
		
		Set<NbItem> sitem = new HashSet<>();
		sitem.add(nir.findById(1l).get());
		sitem.add(nir.findById(2l).get());
		
		Commande c = new Commande(sitem);
		cr.save(c);
	}

}
