package mdp2026.pokedex.console;

import mdp2026.pokedex.utility.TextInput;
import mdp2026.pokedex.utility.TextOutput;

public interface IOConsoleView {
    
    public void start();

    public IOConsoleView setInput(TextInput in);

    public IOConsoleView setOutput(TextOutput out);

}
