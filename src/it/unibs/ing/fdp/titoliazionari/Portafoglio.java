package it.unibs.ing.fdp.titoliazionari;

import java.io.Serializable;
import java.util.ArrayList;

public class Portafoglio implements Serializable {
	private int azione;
	private String nome;
	private ElencoTitoli elencoTitoli;
	private ArrayList<Lotto> lotto;
	private final static String DESC_DENOMINAZIONE = "PORTAFOGLIO: %s %n";
	private final static String INTRO_COMPOSIZIONE = "COMPOSTO:\n";
	private final static String DESC_TOTALE = "VALORE TOTALE= %1.2f";
	/**
	 * @author Gentian&Peter
	 */
	/**
	 * 
	 * @param nome name of the wallet
	 * @param elenco list of stocks
	 */
	public Portafoglio(String nome, ElencoTitoli elenco)
	{
		this.nome=nome;
		elencoTitoli=elenco;
		lotto=new ArrayList<Lotto>();
		
	}
	public int getAzione() {
		return azione;
	}
	
	
	public void setAzione(int azione) {
		this.azione = azione;
	}
	
	
	public ElencoTitoli getElencoTitoli() {
		return elencoTitoli;
	}
	
	
	public void setElencoTitoli(ElencoTitoli elencoTitoli) {
		this.elencoTitoli = elencoTitoli;
	}
	
	/**
	 * 
	 * @param azione stock to add to wallet
	 * @param elencoTitoli list of stock
	 * @param lotto	list of lots
	 */
	public Portafoglio(int azione, ElencoTitoli elencoTitoli, ArrayList<Lotto> lotto) {
		super();
		this.azione = azione;
		this.elencoTitoli = elencoTitoli;
		this.lotto = lotto;
	}
	
	/**
	 * 
	 * @param azione stock to add to wallet
	 * @param elencoTitoli list of stock
	 */
	public Portafoglio(int azione, ElencoTitoli elencoTitoli) {
		this.azione = azione;
		this.elencoTitoli = elencoTitoli;
	}
	
	/**
	 * 
	 * @return value of total 
	 */
	public double valore ()
	{
		 double valore_lotto = 0;
		 for (int i = 0; i < lotto.size(); i++)
			{
			 Lotto l = (Lotto) lotto.get(i);
			 valore_lotto = valore_lotto + l.valore();
			}
			
		 return valore_lotto;
	}
	public String toString()
	{
		 StringBuffer result = new StringBuffer();
			
		 result.append (String.format(DESC_DENOMINAZIONE, nome));
		 result.append (INTRO_COMPOSIZIONE);
	
		 for (int i = 0; i < lotto.size(); i++)
			{
			 result.append( lotto.get(i).toString() + "\n");
			}
			
		 result.append(String.format(DESC_TOTALE, valore()));
		 
		 return result.toString();
	}
	
	public void simulazioniVarazioni()
	{
		elencoTitoli.simulaVariazione();
	}
	
	public void addLotto(Lotto l) {
		
		lotto.add(l);
	}
}
