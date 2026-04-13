package mdp2026.pokedex.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Estensione del Pokedex, atto a wrappare un
 * instanza interna al fine di memorizzare 
 * gli indici usati in getPokemon, così che diventi possibile
 * ottemperare a funzioni di next o prev lato console
 */
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

    /**
     * Getter che restituisce l'ultimo indice usato
     * @return ultimo indice usato
     */
    public int getUltimoIndice(){
        return this.ultimoIndice;
    }

}
