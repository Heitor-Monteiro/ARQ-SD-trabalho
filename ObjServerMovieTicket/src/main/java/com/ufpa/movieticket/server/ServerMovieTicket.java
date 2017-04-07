/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.server;

import com.ufpa.movieticket.DAO.GenericoDAO;
import com.ufpa.movieticket.DAO.GenericoDAOImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

/**
 *
 * @author thiberius
 */
public class ServerMovieTicket {
    private static final String ip = "192.168.1.101";

    public static void main(String args[]) throws RemoteException {
        startGenericoDAO();
    }

    private static void hostPort(int port) throws RemoteException {
        System.setProperty("java.rmi.server.hostname", ip);
        LocateRegistry.createRegistry(port);
    }

    private static void startGenericoDAO() throws RemoteException {
        try {
            int port = 5001;
            hostPort(port);
            System.out.println("MovieTicket ----- Criando o objeto GenericoDAO...");
            GenericoDAO obj = new GenericoDAOImpl();
            System.out.println("MovieTicket ----- conectando o objeto GenericoDAO no Registry...");
            Naming.rebind("rmi://"+ip+":"+port+"/GenericoDAO", obj); // registra o objeto
        } catch (Exception e) {
            System.out.println("GenericoDAO.metodo: " + e);
        }
        System.out.println("GenericoDAO pronto para receber chamadas RMI...");
    }
}
