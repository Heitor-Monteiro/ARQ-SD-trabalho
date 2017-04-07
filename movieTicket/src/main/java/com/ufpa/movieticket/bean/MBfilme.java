/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Filme;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBfilme")
@ViewScoped
public class MBfilme extends AbstractBean {

    private Filme filme;

    public void cadastrarFilme() {
        try {
            rmiDaoGenerico().save(filme);
            getObjMessage().info("Cadastro efetuado!", "Filme cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public Filme getFilme() {
        if (filme == null) {
            filme = new Filme();
        }
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
