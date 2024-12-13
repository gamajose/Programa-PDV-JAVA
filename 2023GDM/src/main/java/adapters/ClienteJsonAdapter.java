/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import model.Cliente;

/**
 *
 * @author Deibidson Mesquita
 */
public class ClienteJsonAdapter implements JsonSerializer<Cliente> {

    @Override
    public JsonElement serialize(Cliente t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", t.getId());
        jsonObject.addProperty("cpf", t.getCpf());
        jsonObject.addProperty("email", t.getEmail());
        jsonObject.addProperty("celular", t.getCelular());
        jsonObject.addProperty("status", t.getStatus());
        jsonObject.addProperty("limiteCredito", t.getLimiteCredito());
        jsonObject.add("pessoaJuridica", new Gson().toJsonTree(t.getPessoaJuridica()));
        jsonObject.add("endereco", new Gson().toJsonTree(t.getListaEndereco()));
        return jsonObject;
    }

}
