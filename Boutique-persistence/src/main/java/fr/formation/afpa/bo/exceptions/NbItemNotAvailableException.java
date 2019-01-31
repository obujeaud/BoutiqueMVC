package fr.formation.afpa.bo.exceptions;

public class NbItemNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemNotAvailableException() {
		super("Aucun NbItem disponible\r\n" + 
				"");
	}

}
