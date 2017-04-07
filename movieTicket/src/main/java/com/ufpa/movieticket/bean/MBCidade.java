/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Cidade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBcidade")
@ViewScoped
public class MBCidade extends AbstractBean {

    private Cidade cidade;

    public void cadastrarCidade() {
        try {
            getDaoGenerico().save(cidade);
            getObjMessage().info("Cadastro efetuado!", "Cidade cadastrada com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public Cidade getCidade() {
        if (cidade == null) {
            cidade = new Cidade();
        }
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
