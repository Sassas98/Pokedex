package mdp2026.pokedex.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mdp2026.pokedex.model.PokedexMemoryWrapper;
import mdp2026.pokedex.service.CommandAction;
import mdp2026.pokedex.service.ExitAction;
import mdp2026.pokedex.service.PokedexConsoleDetailsAction;
import mdp2026.pokedex.service.PokedexConsoleHelpAction;
import mdp2026.pokedex.service.PokedexConsoleListAction;
import mdp2026.pokedex.service.PokedexConsoleNextCommand;
import mdp2026.pokedex.service.PokedexConsolePrevCommand;
import mdp2026.pokedex.service.PokedexConsoleSearchCommand;

/**
 * Implementazione che mette insieme i comandi e segue i requisi espressi dalla versione corrente
 */
public class BasicPokedexConsoleView extends PokedexConsoleView<PokedexMemoryWrapper>{

    public BasicPokedexConsoleView(PokedexMemoryWrapper pokedex){
        super(pokedex);
    }

    @Override
    protected List<Map<String, CommandAction<PokedexMemoryWrapper>>> buildCommands() {
        List<Map<String, CommandAction<PokedexMemoryWrapper>>> list = new ArrayList<>();
        list.add(costruisciComandiStatoZero());
        list.add(costruisciComandiStatoUno());
        return list;
    }


    /**
     * Costruisce i comandi comuni
     * @return la mappa dei comandi -> azioni in menu
     */
    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiStatoZero() {
        Map<String, CommandAction<PokedexMemoryWrapper>> map = costruisciComandiGenerali();
        map.put("dettaglio", new PokedexConsoleDetailsAction<>());
        map.put("elenco", new PokedexConsoleListAction<>());
        map.put("cerca", new PokedexConsoleSearchCommand<>());
        return map;
    }

    /**
     * Costruisce i comandi dello stato 1: il dettaglio
     * @return la mappa dei comandi -> azioni in dettaglio
     */
    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiStatoUno() {
        Map<String, CommandAction<PokedexMemoryWrapper>> map = costruisciComandiGenerali();
        map.put("indietro", new PokedexConsoleListAction<>());
        map.put("prossimo", new PokedexConsoleNextCommand());
        map.put("precedente", new PokedexConsolePrevCommand());
        return map;
    }

    /**
     * Costruisce i comandi comuni
     * @return la mappa dei comandi -> azioni in tutte le fasi
     */
    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiGenerali() {
        HashMap<String, CommandAction<PokedexMemoryWrapper>> map = new HashMap<>();
        map.put("help", new PokedexConsoleHelpAction<>());
        map.put("esci", new ExitAction<>());
        return map;
    }

}
