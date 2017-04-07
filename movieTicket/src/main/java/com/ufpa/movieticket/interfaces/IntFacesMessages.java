/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.faces.application.FacesMessage;

/**
 *
 * @author thiberius
 */
public interface IntFacesMessages extends Remote{
    
    public void info(String title, String message) throws RemoteException;
    
    public void error(String title, String message) throws RemoteException;
    
    public void fatalError(String title, String message) throws RemoteException;
    
    public void warn(String title, String message) throws RemoteException;
    
    public String teste() throws RemoteException;
}
