package mdp2026.pokedex.service;

import java.util.LinkedList;
import java.util.List;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.Pokemon;

public class PokedexConsoleSearchCommand<T extends Pokedex> implements CommandAction<T>{

    @Override
    public CommandResult handleCommand(String[] input, int state, T model) {
        String search = input.length < 1 ? "" : input[0].toLowerCase();
        List<Pokemon> pokemonTrovati = cercaTraPokemon(model.tornaTuttiScoperti(), search);
        String[] array = componiArray(pokemonTrovati);
        return new CommandResult(array, 0);
    }

    private String[] componiArray(List<Pokemon> pokemons){
        String[] array = new String[pokemons.size() + 1];
        if(pokemons.isEmpty()){
            array[0] = "Nessun pokémon trovato";
        }else{
            array[0] = "Pokémon trovati:";
            for (int i = 1; i < array.length; i++) {
                Pokemon p = pokemons.get(i-1);
                array[i] = p.getNumero() + " - " + p.getNome(); 
            }
        }
        return array;
    }


    private List<Pokemon> cercaTraPokemon(List<Pokemon> pokemons, String search){
        List<Pokemon> pokemonTrovati = new LinkedList<>();
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getNome().toLowerCase().contains(search))
                pokemonTrovati.add(pokemon);
        }
        return pokemonTrovati;
    }

}