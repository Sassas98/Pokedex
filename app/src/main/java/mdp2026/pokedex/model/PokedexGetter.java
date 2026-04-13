package mdp2026.pokedex.model;

/**
 * Interfaccia che definisce un builder di un pokedex generico, 
 * atto a generalizzare la fonte di provenienza del Pokedex
 */
public interface PokedexGetter {
    public Pokedex buildPokedex();
}
