/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.model.Cartaocred;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiberius
 */
@ManagedBean(name = "MBcartaoCred")
@ViewScoped
public class MBcartaoCred extends AbstractBean {

    private Cartaocred cartaoCred;

    public void updateCartaoCred() {
        try {
            rmiDaoGenerico().update(cartaoCred);
        } catch (Exception e) {
        }
    }

}
