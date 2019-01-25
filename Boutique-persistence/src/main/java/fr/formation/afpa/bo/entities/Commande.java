package fr.formation.afpa.bo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import fr.formation.afpa.bo.entities.NbItem;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idCommande;
	
	@ManyToMany
	@JoinTable
	private Set<NbItem> l;
	
	private double totalPrice;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Set<NbItem> l) {
		super();
		this.l = l;
		for(NbItem n : l) {
			setTotalPrice(getTotalPrice() + n.getItem().getPrixItem()*n.getNbItem());
		}
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Set<NbItem> getL() {
		return l;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}
}