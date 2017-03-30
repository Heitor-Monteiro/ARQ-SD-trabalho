/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.bean;

import com.ufpa.movieticket.DAO.GenericoDAO;
import com.ufpa.movieticket.DAO.GenericoDAOImpl;
import com.ufpa.movieticket.tools.FacesMessages;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author thiberius
 */
public abstract class AbstractBean implements Serializable {

    private GenericoDAO daoGenerico;

    public GenericoDAO getDaoGenerico() {
        if (daoGenerico == null) {
            daoGenerico = new GenericoDAOImpl();
        }
        return daoGenerico;
    }

    private FacesMessages message;

    public FacesMessages getObjMessage() {
        if (message == null) {
            message = new FacesMessages();
        }
        return message;
    }

    private Date data;

    public Date getObjData() {
        if (data == null) {
            data = new Date();
        }
        return data;
    }
}
