package fr.formation.afpa.bo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="nbItem")
public class NbItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idNbItem;
	
	@ManyToOne
	@JoinColumn
	private Item item;
	
	@Column(name = "nombre")
	private int numberItem = 1;
	
	public NbItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NbItem(Long idNbItem, Item item, int numberItem) {
		super();
		this.idNbItem = idNbItem;
		this.item = item;
		this.numberItem = numberItem;
	}

	public NbItem(Item item, int nbItem) {
		super();
		this.item = item;
		this.numberItem = nbItem;
	}

	public Long getIdNbItem() {
		return idNbItem;
	}

	public void setIdNbItem(Long idNbItem) {
		this.idNbItem = idNbItem;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getNbItem() {
		return numberItem;
	}

	public void setNbItem(int nbItem) {
		this.numberItem = nbItem;
	}

}
