/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.Empresa;

/**
 *
 * @author Deibidson Mesquita
 */
public interface DadosDoSistemInterface {

    public Empresa dadosDaEmpresa();

    public void registrarEmpresa(Empresa e);

    public boolean verificaSeExisteCadastroEmpresa();
}
