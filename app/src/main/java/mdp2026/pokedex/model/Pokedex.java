package mdp2026.pokedex.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pokedex {
    private List<Pokemon> pokemons;
    private boolean[] scoperti;
    private int ultimoIndice;

    public Pokedex(List<Pokemon> pks){
        if(pks == null)
            throw new IllegalArgumentException("Argomento non valido per il costruttore");
        pokemons = new ArrayList<>(pks);
        scoperti = new boolean[pks.size()];
    }

    public Pokemon getPokemon(int index){
        if(index < 1 || index > scoperti.length)
            throw new IllegalArgumentException("Indice non valido");
        scoperti[index-1] = true;
        ultimoIndice = index;
        return pokemons.get(index-1);
    }

    public int getUltimoIndice(){
        return this.ultimoIndice;
    }

    public List<Pokemon> tornaTuttiScoperti(){
        List<Pokemon> list = new LinkedList<>();
        for (int i = 0; i < scoperti.length; i++) {
            if(scoperti[i]) list.add(pokemons.get(i));
        }
        return list;
    }
}
