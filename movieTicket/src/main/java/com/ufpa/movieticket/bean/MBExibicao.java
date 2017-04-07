/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Exibicao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBexibicao")
@ViewScoped
public class MBExibicao extends AbstractBean {

    private Exibicao exibicao;

    public void cadastrarExibicao() {
        try {
            getDaoGenerico().save(exibicao);
            getObjMessage().info("Cadastro efetuado!", "Exibição cadastrada com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
    }

    public Exibicao getExibicao() {
        if (exibicao == null) {
            exibicao = new Exibicao();
        }
        return exibicao;
    }

    public void setExibicao(Exibicao exibicao) {
        this.exibicao = exibicao;
    }

}
