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
import model.Pedido;

/**
 *
 * @author Deibidson Mesquita
 */
public class PedidoJsonAdapter implements JsonSerializer<Pedido> {

    @Override
    public JsonElement serialize(Pedido t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", t.getId());
        jsonObject.addProperty("status", t.getStatus());
        jsonObject.addProperty("total", t.getTotal());
        jsonObject.addProperty("obs", t.getObs());
        jsonObject.addProperty("tipoPedido", t.getTipoPedido());

        JsonObject Vendedor = new JsonObject();
        Vendedor.addProperty("id", t.getVendedor().getId());
        Vendedor.addProperty("nome", t.getVendedor().getNome());

        jsonObject.add("vendedor", jsc.serialize(Vendedor));
        jsonObject.add("enderecoEntrega", new Gson().toJsonTree(t.getEnderecoEntrega()));

        return jsonObject;
    }

}
