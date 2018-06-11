package it.unibs.ing.fdp.titoliazionari;
import java.io.File;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

/**
 * 
 * @author Gentian&Peter
 *
 */
public class UtilitaTitoli {
	
	private static final String MSG_SALUTO = "GRAZIE DI AVER USATO IL NOSTRO PROGRAMMA";
	private static final String MENU_ELENCO_TITOLI ="GESTIONE ELENCO TITOLI";
	private final static String [] voci_elenco = 
		{
				"Crea nuovo titolo"
		};
	private static final String MSG_PREZZO_TITOLO="INSCERISCI IL PREZZO DEL TITLO:	";
	private static final String MSG_NOME_TITOLO="INSCERISCI IL NOME DEL TITLO:	";
	private final static String MSG_NOME_PORTFOLIO = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO:	";
	private final static String MSG_NUMERO_AZIONI = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s:	";
	static final String MENU_PORTAFOGLIO="SIMULAZIONE ATTIVATA' PORTAFOGLIO";
	public final static String MSG_INTRO_GIORNO = "GIORNO N.%d NUOVA SITUAZIONE INVESTIMENTI";
	public static final String voci_sim[]=
		{
			"Avvia simulazione",
			"Gestisi titoli"
		};
	public final static String MSG_SALVA = "SALVATAGGIO DATI";
	
	/**
	 * @return nuovoElenco is the list of stocks instantiate from user
	 * @param MENU_ELENCO_TITOLI is the title for instantiate
	 * @param voci is the array which contains the menu items
	 * @param nuovoElenco is the parameter for instantiate the constructor for ElencoTitoli()
	 */
	public static ElencoTitoli creaElencoTitoli()
	{
		/*
		 * This method is used for create the menu' that will be used to manage the stocks
		 */
		
		ElencoTitoli nuovoElenco = new ElencoTitoli();
			
		
		MyMenu menu_elenco_titoli = new MyMenu(MENU_ELENCO_TITOLI, voci_elenco);//inizalizzazione menu principale
		
		boolean fine = false;//serve per uscire dal menu
		
		do 
		{
			int voceSelezionata = menu_elenco_titoli.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
		
			switch ( voceSelezionata ) 
			{
			case 1:
				Titolo nuovoTitolo = creaTitolo();
				nuovoElenco.addTitolo(nuovoTitolo);
				break;
			 case 0:
				   fine = true;
				 break;
			   default:
				   System.out.println("Operazione non riconosciuta.");
			}

		}while(!fine);
		
		return nuovoElenco;
	}
	/**
	 * @return Titolo: is the new stock with parameter Name and Price
	 */
	public static Titolo creaTitolo()
	{
		/*
		 * this is the method that make the stocks
		 */
		String nome = InputDati.leggiStringaNonVuota(MSG_NOME_TITOLO);
		double prezzo = InputDati.leggiDoubleConMinimo(String.format(MSG_PREZZO_TITOLO,nome), 0); // Impongo prezzo >= 0
		
		return new Titolo(nome, prezzo);
	}
	/**
	 * 
	 * @param elenco is the list of stocks crated
	 * @return the jointly of title and lots
	 */
	public static Portafoglio creaPortafoglio(ElencoTitoli elenco)
	{
		String nome = InputDati.leggiStringaNonVuota(MSG_NOME_PORTFOLIO);
		Portafoglio portafoglio= new Portafoglio(nome,elenco);
		for (int i = 0; i < elenco.numTitoli(); i++)
		{
		 Titolo t = elenco.getTitolo(i);
		 int dimLotto = InputDati.leggiInteroConMinimo(String.format(MSG_NUMERO_AZIONI, t.toString()), 1); // Impongo numero di azioni >= 1
		 portafoglio.addLotto(new Lotto (t, dimLotto) );
		}
	 return portafoglio;
	}
	/**
	 * Print the greeting of the program
	 */
	public static void saluto()
	{
		System.out.println(MSG_SALUTO);
	}
	public static ElencoTitoli aggiornaElencoTitoli(ElencoTitoli nuovoElenco)
	{
		/*
		 * This method is used for create the menu' that will be used to manage the stocks
		 */
		
		MyMenu menu_elenco_titoli = new MyMenu(MENU_ELENCO_TITOLI, voci_elenco);//inizalizzazione menu principale
		
		boolean fine = false;//serve per uscire dal menu
		
		do 
		{
			int voceSelezionata = menu_elenco_titoli.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
		
			switch ( voceSelezionata ) 
			{
			case 1:
				Titolo nuovoTitolo = creaTitolo();
				nuovoElenco.addTitolo(nuovoTitolo);
				break;
			 case 0:
				   fine = true;
				 break;
			   default:
				   System.out.println("Operazione non riconosciuta.");
			}

		}while(!fine);
		
		return nuovoElenco;
	}
}
	

