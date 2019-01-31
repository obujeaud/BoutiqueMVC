package fr.formation.afpa.bo.exceptions;

public class NbItemNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemNotValidException() {
		super("Le NbItem est vide\r\n" + 
				"");
	}

}
