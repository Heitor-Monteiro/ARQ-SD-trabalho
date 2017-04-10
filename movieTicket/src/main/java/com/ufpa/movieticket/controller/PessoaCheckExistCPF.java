/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.movieticket.controller;

import com.ufpa.movieticket.model.Pessoa;
import com.ufpa.movieticket.bean.AbstractBean;
import java.util.List;

/**
 *
 * @author thiberius
 */
public class PessoaCheckExistCPF extends AbstractBean {
    private boolean checkExistCPF(Pessoa pessoa) {
        boolean var = false;
        try {
            List<Pessoa> list;
            list = (List<Pessoa>) rmiDaoGenerico().list("select p from Pessoa p where p.cpf = '" + pessoa.getCpf() + "'");
            var = list.isEmpty();
        } catch (Exception e) {
        }
        return var;
    }
}
