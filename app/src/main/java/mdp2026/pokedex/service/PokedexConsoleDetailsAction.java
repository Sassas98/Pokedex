package mdp2026.pokedex.service;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.Pokemon;

/**
 * Classe che rappresenta il dettaglio di un Pokémon
 * La wildcard resta generica per permettere interoperabilità con estensioni
 */
public class PokedexConsoleDetailsAction<T extends Pokedex> implements CommandAction<T>{

    @Override
    public CommandResult handleCommand(String[] input, int state, T model) {
        int i = 0;
        try{
            i = Integer.parseInt(input[0]);
        }catch(Exception ex){
            throw new IllegalArgumentException( input.length < 1 ? "Input [1-155] assente" : "Input " + input[0] + " non è un numero");
        }
        Pokemon p = model.getPokemon(i);
        return new CommandResult(new String[]{
"--------------",
"Pokémon n." + p.getNumero() + " " + p.getNome(),
"Tipo " + p.getTipo1() + (p.getTipo2() == null ? "" : " - " + p.getTipo2()),
"Altezza " + p.getAltezza() + " cm",
"Peso " + p.getPeso() + " kg",
"--------------",
        }, 1);
    }

}