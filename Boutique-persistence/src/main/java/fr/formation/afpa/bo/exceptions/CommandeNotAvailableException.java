package fr.formation.afpa.bo.exceptions;

public class CommandeNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandeNotAvailableException() {
		super("Aucune commande disponible\r\n" + 
				"");
	}

}
