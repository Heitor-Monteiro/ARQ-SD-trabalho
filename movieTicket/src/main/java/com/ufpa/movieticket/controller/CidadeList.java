/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.controller;

import com.ufpa.movieticket.model.Cidade;
import java.util.List;

/**
 *
 * @author thiberius
 */
public class CidadeList extends AbstractController {

    private Cidade cidade;
    private List<Cidade> listCidade;
    private String tipoPesquisa;
    private String textoPesquisa;

    public void listCidade() {
        try {
            listCidade = rmiDaoGenerico().
                    list("select c from Cidade c where "
                            + "c." + tipoPesquisa + " like '%" + textoPesquisa + "%'");
            if (!listCidade.isEmpty()) {
                getObjMessage().warn("Item não encontrado!", "A cidade não foi encontrada.");
            }
        } catch (Exception e) {
        }
    }

    public String getTipoPesquisa() {
        return tipoPesquisa;
    }

    public void setTipoPesquisa(String tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }

    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListCidade() {
        return listCidade;
    }

    public void setListCidade(List<Cidade> listCidade) {
        this.listCidade = listCidade;
    }

}
