package fr.formation.afpa.bo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppBoutique implements CommandLineRunner{
	@Autowired
	private ItemRepository ir;
	
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
	}

}
