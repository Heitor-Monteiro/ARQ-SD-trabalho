package com.ufpa.movieticket.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface GenericoDAO<T> extends Remote {
    
    public void save(T entidade) throws RemoteException;
    public T getById(String model, Integer id) throws RemoteException;
    public List<T> list(String sqlHQL) throws RemoteException;    
    public void remove(Object entidade) throws RemoteException;
    public void update(Object entidade) throws RemoteException;
    public int validate(String username, String password) throws RemoteException;	
}
