package fr.formation.afpa.bo.exceptions;

public class ItemNbItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNbItemNotFoundException() {
		super("L'item contenu dans NbItem est introuvable\r\n" + 
				"");
	}

}
