package mdp2026.pokedex.console;

import java.util.List;
import java.util.Map;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.service.CommandAction;
import mdp2026.pokedex.service.CommandResult;
import mdp2026.pokedex.utility.TextInput;
import mdp2026.pokedex.utility.TextOutput;

public abstract class PokedexConsoleView<T extends Pokedex> implements IOConsoleView {

    private int state;
    private TextInput in;
    private TextOutput out;
    private final T pokedex;
    private final List<Map<String,CommandAction<T>>> commands;

    public PokedexConsoleView(T pokedex){
        this.pokedex = pokedex;
        this.state = 0;
        commands = buildCommands();
    }

    protected abstract List<Map<String,CommandAction<T>>> buildCommands();

    @Override
    public IOConsoleView setInput(TextInput in) {
        this.in = in;
        return this;
    }

    @Override
    public IOConsoleView setOutput(TextOutput out) {
        this.out = out;
        return this;
    }

    @Override
    public void start() {
        if(in == null || out == null)
            throw new IllegalStateException("IO non impostato");
        while(state >= 0){
            try{
                handleInput(in.readInput());
            }catch(Exception ex){
                out.println(ex.getMessage());
            }
        }
    }

    private void handleInput(String input) {
        String[] words = input.split(" ");
        String comando = words[0].toLowerCase();
        if(!commands.get(state).containsKey(comando))
            throw new IllegalArgumentException("Comando " + comando +  " non valido. Usare help per conoscere i comandi valiti.");
        CommandResult result = commands.get(state).get(comando).handleCommand(getArgs(words), state, pokedex);
        state = result.state();
        for(String line : result.output()){
            out.println(line);
        }
    }

    private String[] getArgs(String[] input){
        String[] result = new String[input.length -1];
        for (int i = 1; i < input.length; i++) {
            result[i-1] = input[i];
        }
        return result;
    }

}
