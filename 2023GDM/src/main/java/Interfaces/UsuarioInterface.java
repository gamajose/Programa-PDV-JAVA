/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import model.Usuario;

/**
 *
 * @author Deibidson Mesquita
 */
public interface UsuarioInterface {

    public void salvaUser(Usuario u);

    public void delete(Usuario u);

    public Usuario getUsuario(String senha, String login);

    public List<Usuario> listaUsuarios();

    public Usuario getByCodigo(long id);

    public void atualiza(Usuario u);

    public boolean verificaPermissao(String user);
}
