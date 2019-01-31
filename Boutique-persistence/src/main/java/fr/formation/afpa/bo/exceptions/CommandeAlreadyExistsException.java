package fr.formation.afpa.bo.exceptions;

public class CommandeAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandeAlreadyExistsException() {
		super("La commande possède un id\r\n" + 
				"");
	}

}
