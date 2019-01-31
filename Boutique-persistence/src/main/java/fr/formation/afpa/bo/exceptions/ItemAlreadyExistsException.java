package fr.formation.afpa.bo.exceptions;

public class ItemAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemAlreadyExistsException() {
		super("L'item fourni existe déjà\r\n" + "");
	}

}
