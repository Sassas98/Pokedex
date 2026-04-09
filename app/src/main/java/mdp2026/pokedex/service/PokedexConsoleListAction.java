package mdp2026.pokedex.service;

import java.util.List;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.Pokemon;

public class PokedexConsoleListAction<T extends Pokedex> implements CommandAction<T>{

    @Override
    public CommandResult handleCommand(String[] input, int state, T model) {
        List<Pokemon> pokemons = model.tornaTuttiScoperti();
        String[] array = componiArray(pokemons);
        return new CommandResult(array, 0);
    }

    private String[] componiArray(List<Pokemon> pokemons){
        if(pokemons.isEmpty())
            return new String[]{"Nessun pokemon scoperto..."} ;
        String[] array = new String[pokemons.size()];
        for (int i = 0; i < array.length; i++) {
            Pokemon p = pokemons.get(i);
            array[i] = p.getNumero() + " - " + p.getNome(); 
        }
        return array;
    }

}