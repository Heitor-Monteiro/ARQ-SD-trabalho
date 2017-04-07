/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Cinema;
import com.ufpa.movieticket.controller.CidadeList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBcinema")
@ViewScoped
public class MBcinema extends AbstractBean {

    private Cinema cinema;
    private CidadeList objListCidade;
    
    
    
    
    
    
    
    public void cadastrarCinema() {
        try {
            
            getObjListCidade().listCidade();
            cinema.setCidade(getObjListCidade().getCidade());
            getDaoGenerico().save(cinema);
            getObjMessage().info("Cadastro efetuado!", "Cinema cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public Cinema getCinema() {
        if (cinema == null) {
            cinema = new Cinema();
        }
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public CidadeList getObjListCidade() {
        if (objListCidade == null) {
            objListCidade = new CidadeList();
        }
        return objListCidade;
    }

}
