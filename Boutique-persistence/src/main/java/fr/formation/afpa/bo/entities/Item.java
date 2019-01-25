package fr.formation.afpa.bo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long code_item;
	@Column(name="designation")
	private String designationItem;
	@Column(name="prix")
	double prixItem;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Item(String designationItem, double prixItem) {
		super();
		this.designationItem = designationItem;
		this.prixItem = prixItem;
	}


	public Long getCode_item() {
		return code_item;
	}


	public void setCode_item(Long code_item) {
		this.code_item = code_item;
	}


	public String getDesignationItem() {
		return designationItem;
	}


	public void setDesignationItem(String designationItem) {
		this.designationItem = designationItem;
	}


	public double getPrixItem() {
		return prixItem;
	}


	public void setPrixItem(double prixItem) {
		this.prixItem = prixItem;
	}

}
