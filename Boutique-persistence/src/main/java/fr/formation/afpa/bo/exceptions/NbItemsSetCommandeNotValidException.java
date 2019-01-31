package fr.formation.afpa.bo.exceptions;

public class NbItemsSetCommandeNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemsSetCommandeNotValidException() {
		super("Des  NbItem contenu dans le Set NbItem de la Commande sont vides\r\n" + 
				"");
	}

}
