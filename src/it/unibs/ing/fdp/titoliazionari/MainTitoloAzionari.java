/**
 * 
 */
package it.unibs.ing.fdp.titoliazionari;

import java.io.File;

import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

/**
 * @author Peter&Gentian
 *
 */
public class MainTitoloAzionari {
	
	
	private static final String FILE_CARICATO_CORRETTAMENTE = "File caricato correttamente";
	private final static String NOMEFILE = "dati.dat";
	private final static String MSG_NO_CAST = "ERRORE CON IL CAST PER ASSEGNAMENTO ELEMENTI";
	private static final String MSG_NON_TROVATO_SALVATAGGI = "Nessun file trovato in memoria, crazione nuovo file";
	private static final String MSG_STATO_PORTAFOGLIO="STATO DEL PORTAFOGLIO";
	
	
	public static void main(String[] args) 
	{
		File filet = new File(NOMEFILE);
		
		 Portafoglio portafoglio = null;
		  
		  ElencoTitoli listaTitoli = null;
		  
		  Contenitore contenitore = null;
		  
		  boolean caricamento=false;
		  
		  if (filet.exists())
		  {
			  try
			  {
				  contenitore = (Contenitore)ServizioFile.caricaSingoloOggetto(filet);
				  listaTitoli=contenitore.getElencoTitoli();
				  portafoglio=contenitore.getPortafoglio();	
				  
			  }
			  catch (ClassCastException e) {
				// TODO: handle exception
				  System.out.println(MSG_NO_CAST);
				  }
			  finally
			  {
				  if((portafoglio!=null)&&(listaTitoli!=null))
				  {
					  System.out.println(FILE_CARICATO_CORRETTAMENTE);
					  caricamento=true;
				  }
			  }
		  }
		  if (!caricamento)
		  {
			  System.out.println(MSG_NON_TROVATO_SALVATAGGI);
			  listaTitoli=UtilitaTitoli.creaElencoTitoli();
			  portafoglio =UtilitaTitoli.creaPortafoglio(listaTitoli);
			 
		  }
		  System.out.println(MSG_STATO_PORTAFOGLIO);
		  System.out.println(portafoglio);
		  MyMenu menu_stato_portaf = new MyMenu(UtilitaTitoli.MENU_PORTAFOGLIO, UtilitaTitoli.voci_sim);//inizalizzazione menu principale
			
			boolean fine = false;//serve per uscire dal menu
			int giorni = 0;
			do 
			{
				int voceSelezionata = menu_stato_portaf.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
				
				switch ( voceSelezionata ) 
				{
				case 1:
					{
					 giorni++;
					 listaTitoli.simulaVariazione();
					 System.out.println(String.format(UtilitaTitoli.MSG_INTRO_GIORNO, giorni));
					 System.out.println(portafoglio.toString());
					 break;
					}
				    
				 case 0:
					 System.out.println(UtilitaTitoli.MSG_SALVA);
					 contenitore = new Contenitore(listaTitoli,portafoglio);
					 ServizioFile.salvaSingoloOggetto(filet, contenitore);
					 UtilitaTitoli.saluto();
					 fine = true;
					   
					 break;
				   default:
					   System.out.println("Operazione non riconosciuta.");
				}

			}while(!fine);	  
		  
	}
	
	

}
