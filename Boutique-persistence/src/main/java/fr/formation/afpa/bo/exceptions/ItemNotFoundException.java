package fr.formation.afpa.bo.exceptions;

public class ItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException() {
		super("L'item recherché est introuvable\r\n" + 
				"");
	}

}
