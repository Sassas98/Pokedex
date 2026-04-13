package mdp2026.pokedex.service;

/**
 * Metood che rappresenta il comando help
 */
public class PokedexConsoleHelpAction<T> implements CommandAction<T>{

    @Override
    public CommandResult handleCommand(String[] input, int state, T model) {
        return new CommandResult(new String[]{
            "help - mostra tutti i comandi",
            "esci - conclude il programma",
            "<DA MENU>",
            "dettaglio [1-155] - mostra il dettaglio di un pokemon e lo rivela",
            "elenco - mostra tutti i pokemon scoperti",
            "cerca [...] cerca tra tutti i pokemon scoperti quelli che contengono la parola nel nome",
            "<DA DETTAGLIO>",
            "prossimo - va al prossimo pokemon scoperto",
            "precedente - va al precedente pokemon scoperto",
            "indietro - torna al menu"
        }, state);
    }

}
