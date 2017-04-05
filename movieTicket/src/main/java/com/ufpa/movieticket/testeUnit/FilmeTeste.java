/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.testeUnit;

import com.ufpa.movieticket.bean.MBfilme;
import java.util.Date;

/**
 *
 * @author thiberius
 */
public class FilmeTeste {

    public static void main(String[] args) {
        
        Date data = new Date(2017, 03, 02);
        
        
        MBfilme teste = new MBfilme();
        
        teste.getFilme().setNomeFilme("Logan");
        teste.getFilme().setGenero("Ação");
        teste.getFilme().setAnoLancamento(data);
        teste.getFilme().setGenero("Lorem ipsum dolor sit amet, consectetur "
                + "adipiscing elit. Etiam non volutpat ipsum, non vestibulum "
                + "orci. Vivamus viverra porta odio imperdiet accumsan. "
                + "Maecenas a metus sem. Class aptent taciti sociosqu ad "
                + "litora torquent per conubia nostra, per inceptos himenaeos. "
                + "Nulla quam dolor, facilisis ac interdum et, convallis at urna.");
        teste.getFilme().setClassificacao("16");
        
        teste.cadastrarFilme();
        
    }
}
