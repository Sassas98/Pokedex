package mdp2026.pokedex.service;

import java.util.List;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.Pokemon;

public class PokedexConsolePrevCommand implements CommandAction<Pokedex>{

    @Override
    public CommandResult handleCommand(String[] input, int state, Pokedex model) {
        List<Pokemon> pokemons = model.tornaTuttiScoperti();
        Pokemon p = trovaPrecedentePokemon(pokemons, model.getUltimoIndice());
        return new PokedexConsoleDetailsAction().handleCommand(new String[]{ p.getNumero() + "" }, state, model);
    }

    private Pokemon trovaPrecedentePokemon(List<Pokemon> pokemons, int ultimoIndice) {
        for (int i = pokemons.size() - 1; i >= 0; i--) {
            if(pokemons.get(i).getNumero() == ultimoIndice){
                if(i == 0) 
                    return pokemons.getLast();
                return pokemons.get(i - 1);
            }
        }
        throw new IllegalStateException("Pokémon precedente non trovato");
    }

}