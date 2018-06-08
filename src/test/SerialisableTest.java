package test;

import it.unibs.ing.fdp.*;
import it.unibs.ing.fdp.titoliazionari.Contenitore;
import it.unibs.ing.fdp.titoliazionari.ElencoTitoli;
import it.unibs.ing.fdp.titoliazionari.Lotto;
import it.unibs.ing.fdp.titoliazionari.Portafoglio;
import it.unibs.ing.fdp.titoliazionari.Titolo;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.junit.Test;


/**
 * Created by sam on 22/05/17.
 */
public class SerialisableTest {

    @Test
    public void isSerializable(){
      isSerializable(ElencoTitoli.class);
      isSerializable(Portafoglio.class);
      isSerializable(Titolo.class);
      isSerializable(Lotto.class);
      isSerializable(Contenitore.class);
    }

    private void isSerializable(Class t){
        assertTrue( t.getCanonicalName() + " do not implements Serializable", Serializable.class.isAssignableFrom(t));

    }

}
