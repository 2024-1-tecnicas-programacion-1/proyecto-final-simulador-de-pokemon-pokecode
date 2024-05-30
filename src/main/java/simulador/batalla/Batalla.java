package simulador.batalla;

import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Batalla {

    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void iniciarBatalla() {
        Pokemon pokemon1 = entrenador1.elegirPokemon();
        Pokemon pokemon2 = entrenador2.elegirPokemon();

        if (pokemon1 == null || pokemon2 == null) {
            System.out.println("");
            System.out.println("Uno o ambos entrenadores no tienen Pokémon disponibles.");
            return;
        }
        
        System.out.println("");
        System.out.println("¡Comienza la batalla entre " + entrenador1.getNombre() + " y " + entrenador2.getNombre() + "!");
        System.out.println("");
        System.out.println(entrenador1.getNombre() + " elige a " + pokemon1.getNombre());
        System.out.println("");
        System.out.println(entrenador2.getNombre() + " elige a " + pokemon2.getNombre());

        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            pokemon1.atacar(pokemon2);
            if (pokemon2.getSalud() > 0) {
                pokemon2.atacar(pokemon1);
            }
        }

        if (pokemon1.getSalud() > 0) {
            System.out.println("");
            System.out.println(entrenador1.getNombre() + " ha ganado la batalla con " + pokemon1.getNombre() + " aún en pie.");
        } else if (pokemon2.getSalud() > 0) {
            System.out.println("");
            System.out.println(entrenador2.getNombre() + " ha ganado la batalla con " + pokemon2.getNombre() + " aún en pie.");
        } else {
            System.out.println("");
            System.out.println("La batalla terminó en empate, ambos Pokémon están debilitados.");
        }
    }
}