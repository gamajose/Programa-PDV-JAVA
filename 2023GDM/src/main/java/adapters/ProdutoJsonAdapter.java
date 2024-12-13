/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import model.Produto;

/**
 *
 * @author Deibidson Mesquita
 */
public class ProdutoJsonAdapter implements JsonSerializer<Produto> {

    @Override
    public JsonElement serialize(Produto t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("codigo", t.getCodigo());
        jsonObject.addProperty("descricao", t.getDescricao());
        jsonObject.addProperty("marca", t.getMarca());
        jsonObject.addProperty("cor", t.getCor());

        JsonObject estoqueObject = new JsonObject();
        estoqueObject.addProperty("qtdeDisponivel", t.getEstoque().getQtdeDisponivel());
        estoqueObject.addProperty("status", t.getEstoque().getStatus());
        jsonObject.add("estoque", jsc.serialize(estoqueObject));

        jsonObject.addProperty("preco", t.getPreco());
        jsonObject.addProperty("referencia", t.getReferencia());
        jsonObject.addProperty("obs", t.getObs());
        return jsonObject;
    }

}
