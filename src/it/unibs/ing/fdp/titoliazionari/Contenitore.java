package it.unibs.ing.fdp.titoliazionari;
import java.io.Serializable;

public class Contenitore implements Serializable{
	/*
	 * This class is use for the creation of the file of bailouts
	 */
	private ElencoTitoli elencoTitoli;
	private Portafoglio portafoglio;
	/**
	 * This is the constructor of a Class that is use for contain the stocks's list and the wallet 
	 * @param _elencoTitoli	stock's list
	 * @param _portafoglio	wallet
	 */
	public Contenitore (ElencoTitoli _elencoTitoli, Portafoglio _portafoglio)
	{
		elencoTitoli=_elencoTitoli;
		portafoglio = _portafoglio;
		
	}
	/**
	 * 
	 * @return stocks's list
	 */
	
	public ElencoTitoli getElencoTitoli()
	{
		return elencoTitoli;
	}
	
	public Portafoglio getPortafoglio()
	{
		return portafoglio;
	}
}
