package mdp2026.pokedex.service;

public interface CommandAction<T> {
    public CommandResult handleCommand(String[] input, int state, T model);
}
