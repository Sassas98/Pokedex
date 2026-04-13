package mdp2026.pokedex.console;

import mdp2026.pokedex.utility.TextInput;
import mdp2026.pokedex.utility.TextOutput;

/**
 * Questa interfaccia definisce la responsabilità di impostare
 * un input, un output e di avviare una view console
 */
public interface IOConsoleView {
    
    /**
     * Metodo per l'avvio della visualizzazione tramite console
     */
    public void start();

    /**
     * Metodo per l'impostazione dell'input
     * @param in input
     * @return oggetto aggiornato, che sia nuovo o corrente
     */
    public IOConsoleView setInput(TextInput in);

    /**
     * Metodo per l'impostazione dell'output
     * @param out output
     * @return oggetto aggiornato, che sia nuovo o corrente
     */
    public IOConsoleView setOutput(TextOutput out);

}
