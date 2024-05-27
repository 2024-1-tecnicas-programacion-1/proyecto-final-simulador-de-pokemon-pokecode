package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void agregarPokemon(Pokemon pokemon) {
        pokemones.add(pokemon);
    }

    public void mostrarPokemones() {
        System.out.println("Equipo de Pokémones de " + nombre + ":");
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNombre() + " (Salud: " + pokemon.getSalud() + ", Ataque: " + pokemon.getPuntosDeAtaque() + ", Tipo: " + pokemon.getTipo() + ")");
        }
    }
}