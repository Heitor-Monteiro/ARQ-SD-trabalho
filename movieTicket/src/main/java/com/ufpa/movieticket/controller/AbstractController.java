/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.controller;

import com.ufpa.movieticket.bean.*;
import com.ufpa.movieticket.DAO.GenericoDAO;
import com.ufpa.movieticket.tools.FacesMessages;
import java.io.Serializable;
import java.rmi.Naming;
import java.util.Date;

/**
 *
 * @author thiberius
 */
public abstract class AbstractController implements Serializable {

    public GenericoDAO rmiDaoGenerico() {
        try {
            GenericoDAO obj = (GenericoDAO) Naming.lookup("rmi://192.168.1.101:5001/GenericoDAO");
            return obj;
        } catch (Exception e) {
        }
        return null;
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
