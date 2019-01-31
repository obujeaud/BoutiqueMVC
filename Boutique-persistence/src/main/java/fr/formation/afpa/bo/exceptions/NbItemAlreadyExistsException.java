package fr.formation.afpa.bo.exceptions;

public class NbItemAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemAlreadyExistsException() {
		super("Le NbItem possède déjà un id\r\n" + 
				"");
	}

}
