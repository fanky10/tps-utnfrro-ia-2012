/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.explcomb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.grupoia.main.util.Factorial;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class ExplosionCombinatoriaTest {
    @Test
    public void getResultsTest(){
        List<String> ciudades = new ArrayList<String>();
        ciudades.add("Tokyo");
        ciudades.add("Paris");
        ciudades.add("Londres");
        List<String[]> result = PermutationGenerator.getResults(ciudades);
        BigInteger resultado = Factorial.getFactorial(ciudades.size());
        assertTrue(resultado.equals(BigInteger.valueOf(result.size())));
    }
    
}
