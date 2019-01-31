package fr.formation.afpa.bo.exceptions;

public class NbItemsSetCommandeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NbItemsSetCommandeNotFoundException() {
		super("Des items de NbItem contenu dans Commande sont introuvable\r\n" + 
				"");
	}

}
