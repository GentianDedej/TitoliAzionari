package it.unibs.ing.fdp.titoliazionari;

import java.io.Serializable;

import it.unibs.fp.mylib.NumeriCasuali;
/**
 * 
 * @author Gentian & Peter
 *
 */
public class Titolo implements Serializable {
	
	private String nome;
	private double prezzo ;
	final static String STRINGA="\t%s PREZZO DI %.3f";
	/**
	 * 
	 * @return name of the stock
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return price of the stock
	 */
	
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * This is the constructor of the Class Titolo.
	 * @param nome is the name of the stock
	 * @param prezzo is the price of the stock
	 */
	public Titolo(String nome, double prezzo) {
	
		this.nome = nome;
		this.prezzo = prezzo;
	}
	/*
	 * this method is use for change the value of stock on the time with random changes
	 */
	public void variazGiornaliera  ()
	{
		double val=NumeriCasuali.estraiDouble(-20, 20);
		prezzo = (prezzo-(val/100*prezzo));	
	}
	/**
	 * This method is use for get the price's value of the stock
	 * @return
	 */
	public double valoreTitolo()
	{
		return prezzo;
	}
	/**
	 * This method is use for get the string that describe the stock
	 * @return characteristics of stock	
	 */
	public String toString()
	{
		return String.format(STRINGA, nome,prezzo);
	}
	
	
}
