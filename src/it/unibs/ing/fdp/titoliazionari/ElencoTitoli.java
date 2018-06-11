package it.unibs.ing.fdp.titoliazionari;

import java.io.Serializable;
import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
/**
 * 
 * @author Gentian&Peter
 *
 */


public class ElencoTitoli implements Serializable {
	private ArrayList <Titolo> insieme;
	private int numero ;
	private final static String DESC="L'ELENCO HA \n";
	/**
	 * 
	 * @return stocks's array
	 */
	public ArrayList<Titolo> getInsieme() {
		return insieme;
	}
	public void setInsieme(ArrayList<Titolo> insieme) {
		this.insieme = insieme;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public ElencoTitoli()
	{
		insieme=new ArrayList<Titolo>();
	}
	public void addTitolo(Titolo l)
	{
		insieme.add(l);
		
	}
	public double valoreElenco(ElencoTitoli elenco)
	{
		double valore=0 ;
		for(int i=0;i<elenco.getNumero();i++)
		{ 
			Titolo valoreT =elenco.insieme.get(i);
			valore =valoreT.getPrezzo()+valore;
		}
		return valore;
	}
	/**
	 * Method toString for describe stocks list
	 */
	public String toString ()
		{
		 StringBuffer result = new StringBuffer();
		 result.append(DESC);
		 
		 for (int i = 0; i < insieme.size(); i++)
			{
			 result.append( insieme.get(i).toString() + "\n");
			}
			
		 return result.toString();
	}
	/**
	 * 
	 * @return Stocks's list
	 */
	public int numTitoli() {
		return insieme.size();
	}
	/**
	 * Method for get the stocks in any position
	 * @param i i is the index of stock to get
	 * @return the stock in index position
	 */
	public Titolo getTitolo (int i)
		{
		 return insieme.get(i);
		}
	/**
	 * This method is use for change all stocks on the list
	 */
	public void simulaVariazione()
	{
	 for (int i = 0; i < insieme.size(); i++)
		{
		 Titolo t = insieme.get(i);
		 t.variazGiornaliera();
		}
	}
}
