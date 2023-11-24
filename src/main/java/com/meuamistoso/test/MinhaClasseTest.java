package com.meuamistoso.test;

import com.meuamistoso.controller.CriarJogoController; 

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinhaClasseTest {

    @Test
    public void testSomar() {
        CriarJogoController minhaClasse = new CriarJogoController();
        int resultado = minhaClasse.somar(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    public void testSubtrair() {
        MinhaClasse minhaClasse = new MinhaClasse();
        int resultado = minhaClasse.subtrair(5, 3);
        assertEquals(2, resultado);
    }
}
