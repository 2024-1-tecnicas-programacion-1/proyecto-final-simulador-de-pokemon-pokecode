package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {
    
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        
        System.out.println(pokemon1.getNombre() + " vs. " + pokemon2.getNombre());
        
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            pokemon1.atacar(pokemon2);
            
            if (pokemon2.getSalud() > 0) {
                pokemon2.atacar(pokemon1);
                
            }
        }
        
        if (pokemon1.getSalud() <= 0) {
            System.out.println(pokemon1.getNombre() + " ha sido derrotado.");
        }
        
        if (pokemon2.getSalud() <= 0) {
            System.out.println(pokemon2.getNombre() + " ha sido derrotado.");
        }
    }
}
