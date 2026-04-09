package mdp2026.pokedex.service;

public class ExitAction<T> implements CommandAction<T>{

    @Override
    public CommandResult handleCommand(String[] input, int state, T model) {
        return new CommandResult(new String[0], -1);
    }

}