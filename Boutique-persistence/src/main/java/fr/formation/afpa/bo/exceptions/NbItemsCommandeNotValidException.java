package fr.formation.afpa.bo.exceptions;

public class NbItemsCommandeNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemsCommandeNotValidException() {
		super("Le Set NbItem contenu dans Commande est vide\r\n" + 
				"");
	}

}
