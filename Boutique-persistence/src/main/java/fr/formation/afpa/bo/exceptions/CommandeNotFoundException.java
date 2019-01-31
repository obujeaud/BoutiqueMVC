package fr.formation.afpa.bo.exceptions;

public class CommandeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandeNotFoundException() {
		super("La commande est introuvable\r\n" + 
				"");
	}

}
