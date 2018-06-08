package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fdp.titoliazionari.Titolo;

public class TitoloTest {
	
	@Test
	public void stringRepresentationShouldChangeAsEffectOfValueChanges() throws Exception {
		Titolo titolo = new Titolo("Donald Duck, INC.", 100);
		titolo.variazGiornaliera();
		assertNotEquals(0,titolo.getPrezzo());
	}

}
