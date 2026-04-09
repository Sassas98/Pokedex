package mdp2026.pokedex.model;

import java.util.LinkedList;
import java.util.List;

public class PokedexMemoryWrapper extends Pokedex{

    private final Pokedex pks;
    private int ultimoIndice;

    public PokedexMemoryWrapper(Pokedex pks) {
        super(new LinkedList<>());
        this.pks = pks;
    }

    @Override
    public Pokemon getPokemon(int index){
        ultimoIndice = index;
        return pks.getPokemon(index);
    }

    @Override
    public List<Pokemon> tornaTuttiScoperti(){
         return pks.tornaTuttiScoperti();
    }

    public int getUltimoIndice(){
        return this.ultimoIndice;
    }

}
