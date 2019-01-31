package fr.formation.afpa.bo.exceptions;

public class CommandeNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandeNotValidException() {
		super("La commande est vide\r\n" + 
				"");
	}

}
