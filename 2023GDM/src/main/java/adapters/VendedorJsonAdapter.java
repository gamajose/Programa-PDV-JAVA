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
import model.Vendedor;

/**
 *
 * @author Deibidson Mesquita
 */
public class VendedorJsonAdapter implements JsonSerializer<Vendedor> {

    @Override
    public JsonElement serialize(Vendedor t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", t.getId());
        jsonObject.addProperty("cpf", t.getCpf());
        jsonObject.add("departamento", new Gson().toJsonTree(t.getDepartamento(), type));
        return jsonObject;
    }

}
