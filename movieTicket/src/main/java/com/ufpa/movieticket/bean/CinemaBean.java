/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Cinema;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "cinemaBean")
@ViewScoped
public class CinemaBean extends AbstractBean {

    private Cinema cinema;

    public void cadastrarCinema() {
        try {
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

}
