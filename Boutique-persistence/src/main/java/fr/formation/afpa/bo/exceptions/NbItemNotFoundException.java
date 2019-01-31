package fr.formation.afpa.bo.exceptions;

public class NbItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemNotFoundException() {
		super("L'id fourni est introuvable\r\n" + 
				"");
	}

}
