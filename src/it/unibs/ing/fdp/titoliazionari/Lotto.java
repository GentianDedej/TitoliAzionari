package it.unibs.ing.fdp.titoliazionari;

import java.io.Serializable;
/**
 * @author Gentian&Peter
 */

public class Lotto implements Serializable {
	private Titolo azione ;
	private double quantita;
	private final static String STRING=" IL LOTTO HA UNA QUANTITA' DI %d";
	/**
	 * 
	 * @param azione is the stock
	 * @param quantita is the quantity of stock bought
	 */
	public Lotto(Titolo azione, int quantita) {
		this.azione = azione;
		this.quantita = quantita;
	}
	/**
	 * 
	 * @return the stock
	 */
	public Titolo getAzione() {
		return azione;
	}
	public void setAzione(Titolo azione) {
		this.azione = azione;
	}
	/**
	 * 
	 * @return the quantity
	 */
	public double getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	/**
	 * this method is use for get the value of the lot
	 * @return quantity * stock price
	 */
	public double valore ()
	{
	 return quantita*azione.getPrezzo();
	}
	/**
	 * @return the description of the lot
	 */
	public String toString()
	{
		return quantita + " " + azione.toString();
	}
	

}
