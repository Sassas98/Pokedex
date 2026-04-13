package mdp2026.pokedex.service;

import java.util.List;

import mdp2026.pokedex.model.PokedexMemoryWrapper;
import mdp2026.pokedex.model.Pokemon;

/**
 * Classe che rappresenta il comando di "andare al prossimo" Pokémon scoperto
 * PokedexConsoleDetailsAction viene usato per evitare codice ripetuto
 */
public class PokedexConsoleNextCommand implements CommandAction<PokedexMemoryWrapper>{

    @Override
    public CommandResult handleCommand(String[] input, int state, PokedexMemoryWrapper model) {
        List<Pokemon> pokemons = model.tornaTuttiScoperti();
        Pokemon p = trovaProssimoPokemon(pokemons, model.getUltimoIndice());
        return new PokedexConsoleDetailsAction<>().handleCommand(new String[]{ p.getNumero() + "" }, state, model);
    }

    /**
     * Metodo di servizio atto a trovare il prokémon successivo
     * @param pokemons pokemon tra cui cercare
     * @param ultimoIndice ultimo indice
     * @return pokémon successivo
     */
    private Pokemon trovaProssimoPokemon(List<Pokemon> pokemons, int ultimoIndice) {
        for (int i = 0; i < pokemons.size(); i++) {
            if(pokemons.get(i).getNumero() == ultimoIndice){
                if(i + 1 == pokemons.size()) 
                    return pokemons.getFirst();
                return pokemons.get(i + 1);
            }
        }
        throw new IllegalStateException("Pokémon successivo non trovato");
    }

}