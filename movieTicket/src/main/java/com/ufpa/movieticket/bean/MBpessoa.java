/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Pessoa;
import com.ufpa.movieticket.model.Cartaocred;
import com.ufpa.movieticket.model.CartaocredId;
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
                getDaoGenerico().save(pessoa);
                criarCartaoCred(pessoa);
                getDaoGenerico().save(cartaoCred);

                getObjMessage().info("Cadastro efetuado!", "Cliente cadastrado com sucesso");
            }
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void cadastrarAdm() {
        try {
            getPessoa().setTipoPessoa("adm");
            getDaoGenerico().save(pessoa);
            criarCartaoCred(pessoa);

            getObjMessage().info("Cadastro efetuado!", "Admoinistrador cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    private void criarCartaoCred(Pessoa pessoa) {
        CartaocredId id = new CartaocredId();
        id.setFkPessoa(pessoa.getPkPessoa());
        cartaoCred.setId(id);
        getDaoGenerico().save(cartaoCred);
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
