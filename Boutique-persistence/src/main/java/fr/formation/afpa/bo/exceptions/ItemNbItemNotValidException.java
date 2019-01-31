package fr.formation.afpa.bo.exceptions;

public class ItemNbItemNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNbItemNotValidException() {
		super("L'item contenu dans NbItem est vide\r\n" + 
				"");
	}

}
