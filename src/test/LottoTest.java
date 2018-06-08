package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fdp.titoliazionari.Lotto;
import it.unibs.ing.fdp.titoliazionari.Titolo;

public class LottoTest {
	@SuppressWarnings("deprecation")
	@Test
	public void calculateLottoValue() throws Exception {
		Titolo titolo = new Titolo("XYZ", 10.1);
		Lotto lotto = new Lotto(titolo, 15);
		assertArrayEquals(151.5, lotto.valore());
	}

	private void assertArrayEquals(double d, double valore) {
		// TODO Auto-generated method stub
		
	}
}
