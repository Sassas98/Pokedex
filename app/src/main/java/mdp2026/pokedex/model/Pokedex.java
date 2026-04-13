package mdp2026.pokedex.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe con la responsabilità di gestire le informazioni (Pokemon)
 * e il loro stato (scoperto o da scoprire)
 */
public class Pokedex {
    private List<Pokemon> pokemons;
    private boolean[] scoperti;

    public Pokedex(List<Pokemon> pks){
        if(pks == null)
            throw new IllegalArgumentException("Argomento non valido per il costruttore");
        pokemons = new ArrayList<>(pks);
        scoperti = new boolean[pks.size()];
    }

    /**
     * Metodo che torna un pokemon, se questo si trova in un dato range
     * oltre a restituirlo, se era non scoperto, diventa scoperto
     * @param index indice dato
     * @return Pokemon
     */
    public Pokemon getPokemon(int index){
        if(index < 1 || index > scoperti.length)
            throw new IllegalArgumentException("Indice non valido");
        scoperti[index-1] = true;
        return pokemons.get(index-1);
    }

    /**
     * getter per la restituzione di tutti i pokemon attualmente scoperti
     * @return tutti i pokemon attualmente scoperti
     */
    public List<Pokemon> tornaTuttiScoperti(){
        List<Pokemon> list = new LinkedList<>();
        for (int i = 0; i < scoperti.length; i++) {
            if(scoperti[i]) list.add(pokemons.get(i));
        }
        return list;
    }
}
