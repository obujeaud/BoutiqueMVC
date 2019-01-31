package fr.formation.afpa.bo.exceptions;

public class ItemNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotAvailableException() {
		super("Aucun item disponible\r\n" + 
				"");
	}

}
