package mdp2026.pokedex.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.service.CommandAction;
import mdp2026.pokedex.service.ExitAction;
import mdp2026.pokedex.service.PokedexConsoleDetailsAction;
import mdp2026.pokedex.service.PokedexConsoleHelpAction;
import mdp2026.pokedex.service.PokedexConsoleListAction;
import mdp2026.pokedex.service.PokedexConsoleNextCommand;
import mdp2026.pokedex.service.PokedexConsolePrevCommand;
import mdp2026.pokedex.service.PokedexConsoleSearchCommand;

public class BasicPokedexConsoleView extends PokedexConsoleView{

    public BasicPokedexConsoleView(Pokedex pokedex){
        super(pokedex);
    }

    @Override
    protected List<Map<String, CommandAction<Pokedex>>> buildCommands() {
        List<Map<String, CommandAction<Pokedex>>> list = new ArrayList<>();
        list.add(costruisciComandiStatoZero());
        list.add(costruisciComandiStatoUno());
        return list;
    }

    private Map<String, CommandAction<Pokedex>> costruisciComandiStatoZero() {
        Map<String, CommandAction<Pokedex>> map = costruisciComandiGenerali();
        map.put("dettaglio", new PokedexConsoleDetailsAction());
        map.put("elenco", new PokedexConsoleListAction());
        map.put("cerca", new PokedexConsoleSearchCommand());
        return map;
    }

    private Map<String, CommandAction<Pokedex>> costruisciComandiStatoUno() {
        Map<String, CommandAction<Pokedex>> map = costruisciComandiGenerali();
        map.put("indietro", new PokedexConsoleListAction());
        map.put("prossimo", new PokedexConsoleNextCommand());
        map.put("precedente", new PokedexConsolePrevCommand());
        return map;
    }

    private Map<String, CommandAction<Pokedex>> costruisciComandiGenerali() {
        HashMap<String, CommandAction<Pokedex>> map = new HashMap<>();
        map.put("help", new PokedexConsoleHelpAction<>());
        map.put("esci", new ExitAction<>());
        return map;
    }

}
