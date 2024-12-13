/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.Conta;
import model.Crediario;

/**
 *
 * @author deibi
 */
public interface CrediarioInterface {

    public void saveCrediario(Crediario c);

    public Crediario getCrediarioByConta(Conta c);

    public void delete(long id);

    public void deleteCrediarioByContaId(long id);

    public Crediario getCrediarioById(long id);

}
