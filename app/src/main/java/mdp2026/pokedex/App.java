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
        // genero un builder per il pokedex
        PokedexGetter builder = new JsonFilePokedexGetter();
        // creo il pokedex
        Pokedex pokedex = builder.buildPokedex();
        // lo inserisco in un wrapper per la memorizzazione dell'indice nei dettagli
        PokedexMemoryWrapper pokedexWrapper = new PokedexMemoryWrapper(pokedex);
        // creo la view
        IOConsoleView view = new BasicPokedexConsoleView(pokedexWrapper);
        // e la inizializzo facendola anche partire
        view.setInput(new ScannerTextInput())
            .setOutput(new StandardTextOutput())
            .start();
    }
}
