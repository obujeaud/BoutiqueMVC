package fr.formation.afpa.bo.exceptions;

public class ItemNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotValidException() {
		super("L'item fourni est vide");
	}

}
