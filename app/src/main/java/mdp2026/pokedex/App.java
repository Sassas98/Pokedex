package mdp2026.pokedex;

import mdp2026.pokedex.console.BasicPokedexConsoleView;
import mdp2026.pokedex.console.IOConsoleView;
import mdp2026.pokedex.model.JsonFilePokedexGetter;
import mdp2026.pokedex.model.Pokedex;
import mdp2026.pokedex.model.PokedexGetter;
import mdp2026.pokedex.model.PokedexMemoryWrapper;
import mdp2026.pokedex.utility.ScannerTextInput;
import mdp2026.pokedex.utility.StandardTextOutput;

public class App {
    public static void main(String[] args) {
        PokedexGetter builder = new JsonFilePokedexGetter();
        Pokedex pokedex = builder.buildPokedex();
        PokedexMemoryWrapper pokedexWrapper = new PokedexMemoryWrapper(pokedex);
        IOConsoleView view = new BasicPokedexConsoleView(pokedexWrapper);
        view.setInput(new ScannerTextInput())
            .setOutput(new StandardTextOutput())
            .start();
    }
}
