/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import model.Departamento;

/**
 *
 * @author Deibidson Mesquita
 */
public interface DapartamentoInt {

    public void salva(Departamento p);

    public Departamento depPorCodigo(long codigo);

    public void delete(Departamento p);

    public List<Departamento> listaTodos();
}
