package mdp2026.pokedex.service;

import java.util.List;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.Pokemon;

public class PokedexConsoleNextCommand implements CommandAction<Pokedex>{

    @Override
    public CommandResult handleCommand(String[] input, int state, Pokedex model) {
        List<Pokemon> pokemons = model.tornaTuttiScoperti();
        Pokemon p = trovaProssimoPokemon(pokemons, model.getUltimoIndice());
        return new PokedexConsoleDetailsAction().handleCommand(new String[]{ p.getNumero() + "" }, state, model);
    }

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