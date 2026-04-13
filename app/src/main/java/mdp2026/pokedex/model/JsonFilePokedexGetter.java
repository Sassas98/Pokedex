package mdp2026.pokedex.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import mdp2026.pokedex.utility.ResourceReader;

/**
 * Implementazione che restituisce un semplice Pokedex tramite la lettura di un apposito json
 */
public class JsonFilePokedexGetter extends ResourceReader implements PokedexGetter {

    @Override
    public Pokedex buildPokedex() {
        String json = leggiFile("data.json");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Pokemon>>(){}.getType();
        List<Pokemon> list = gson.fromJson(json, listType);
        return new Pokedex(list);
    }

}
