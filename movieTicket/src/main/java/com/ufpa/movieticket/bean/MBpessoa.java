/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.DAO.GenericoDAO;
import com.ufpa.movieticket.model.Pessoa;
import com.ufpa.movieticket.model.Cartaocred;
import com.ufpa.movieticket.model.CartaocredId;
import java.rmi.Naming;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBpessoa")
@ViewScoped
public class MBpessoa extends AbstractBean {

    private Pessoa pessoa;
    private Cartaocred cartaoCred;
    private boolean termoUso = false;

    public void cadastrarCliente() {

        try {
            if (termoUso) {

                getPessoa().setTipoPessoa("cli");
                rmiDaoGenerico().save(pessoa);
                criarCartaoCred(pessoa);
                getObjMessage().info("Cadastro efetuado!", "Cliente cadastrado com sucesso");
            }
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void cadastrarAdm() {
        try {
            getPessoa().setTipoPessoa("adm");
            rmiDaoGenerico().save(pessoa);
            criarCartaoCred(pessoa);

            getObjMessage().info("Cadastro efetuado!", "Admoinistrador cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    private void criarCartaoCred(Pessoa pessoa) {
        try {
            CartaocredId id = new CartaocredId();
            id.setFkPessoa(pessoa.getPkPessoa());
            cartaoCred.setId(id);
            rmiDaoGenerico().save(cartaoCred);
        } catch (Exception e) {
        }
    }

    public Pessoa getPessoa() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cartaocred getCartaoCred() {
        if (cartaoCred == null) {
            cartaoCred = new Cartaocred();
        }
        return cartaoCred;
    }

    public void setCartaoCred(Cartaocred cartaoCred) {
        this.cartaoCred = cartaoCred;
    }

    public boolean isTermoUso() {
        return termoUso;
    }

    public void setTermoUso(boolean termoUso) {
        this.termoUso = termoUso;
    }

}
