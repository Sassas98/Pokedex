package mdp2026.pokedex.service;

/**
 * Astrazione che rappresenta un comportamento generico
 * ispirato alla macchina di Turing
 */
public interface CommandAction<T> {

    /**
     * metodo che gestisce un insieme di stati e input in modo tale
     * da raggiungere un output
     * @param input input ricevuti
     * @param state stato attuale
     * @param model modello con le informazioni
     * @return record che unisce nuovo stato e linee di output
     */
    public CommandResult handleCommand(String[] input, int state, T model);
}
