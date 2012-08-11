/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.util;

import java.math.BigInteger;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Factorial {
    
    //-- BigInteger solution.
    public static BigInteger getFactorial(Integer input) {
        if (input > 20) {
            throw new IllegalArgumentException("input too big, should be <= 20");
        }
        //-- BigInteger solution.
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= input; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        return n;
    }
}
