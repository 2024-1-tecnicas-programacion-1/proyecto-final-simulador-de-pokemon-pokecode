package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Pokemon;

public class Entrenador {

    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (pokemones.size() < 6) {
            pokemones.add(pokemon);
        } else {
            System.out.println("El equipo ya esta completo. No se puede agregar mas Pokemones.");
        }
    }

    public void mostrarPokemones() {
        System.out.println("Pokemones de " + nombre + ":");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i));
        }
    }

    public Pokemon elegirPokemon() {
        mostrarPokemones();
        if (!pokemones.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Selecciona el numero del Pokemon para la batalla: ");
            int indice = sc.nextInt() - 1;

            if (indice >= 0 && indice < pokemones.size()) {
                return pokemones.get(indice);
            } else {
                System.out.println("Indice no valido. Seleccionando el primer Pokemon.");
                return pokemones.get(0);
            }
        } else {
            System.out.println("No hay Pokemones disponibles.");
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public Pokemon getPokemon() {
      
        return null;
      
    }
}
