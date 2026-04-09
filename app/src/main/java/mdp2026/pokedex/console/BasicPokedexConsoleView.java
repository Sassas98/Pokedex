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

    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiStatoZero() {
        Map<String, CommandAction<PokedexMemoryWrapper>> map = costruisciComandiGenerali();
        map.put("dettaglio", new PokedexConsoleDetailsAction<>());
        map.put("elenco", new PokedexConsoleListAction<>());
        map.put("cerca", new PokedexConsoleSearchCommand<>());
        return map;
    }

    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiStatoUno() {
        Map<String, CommandAction<PokedexMemoryWrapper>> map = costruisciComandiGenerali();
        map.put("indietro", new PokedexConsoleListAction<>());
        map.put("prossimo", new PokedexConsoleNextCommand());
        map.put("precedente", new PokedexConsolePrevCommand());
        return map;
    }

    private Map<String, CommandAction<PokedexMemoryWrapper>> costruisciComandiGenerali() {
        HashMap<String, CommandAction<PokedexMemoryWrapper>> map = new HashMap<>();
        map.put("help", new PokedexConsoleHelpAction<>());
        map.put("esci", new ExitAction<>());
        return map;
    }

}
