package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<Entrenador> entrenadores = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    gestionarEntrenadores();
                    break;
                case 2:
                    gestionarPokemones();
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Simulador de Batallas Pokémon");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void gestionarEntrenadores() {
        boolean volver = false;

        while (!volver) {
            System.out.println("Gestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarNuevoEntrenador();
                    break;
                case 2:
                    verListaDeEntrenadores();
                    break;
                case 3:
                    seleccionarEntrenador();
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    private static void registrarNuevoEntrenador() {
        System.out.print("Introduce el nombre del nuevo entrenador: ");
        String nombre = sc.nextLine();
        Entrenador entrenador = new Entrenador(nombre);
        entrenadores.add(entrenador);
        System.out.println("Entrenador " + nombre + " registrado exitosamente.");
    }

    private static void verListaDeEntrenadores() {
        System.out.println("Lista de entrenadores registrados:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }
    }

    private static void seleccionarEntrenador() {
        System.out.print("Introduce el número del entrenador que deseas seleccionar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar el buffer

        if (indice >= 0 && indice < entrenadores.size()) {
            Entrenador entrenadorSeleccionado = entrenadores.get(indice);
            boolean volver = false;

            while (!volver) {
                System.out.println("Entrenador: " + entrenadorSeleccionado.getNombre());
                System.out.println("1. Ver equipo de Pokémones");
                System.out.println("2. Agregar Pokémon al equipo");
                System.out.println("3. Entrenar Pokémon");
                System.out.println("4. Volver a Gestionar Entrenadores");
                System.out.print("Elige una opción: ");

                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        entrenadorSeleccionado.mostrarPokemones();
                        break;
                    case 2:
                        agregarPokemonAlEquipo(entrenadorSeleccionado);
                        break;
                    case 3:
                        entrenarPokemon(entrenadorSeleccionado);
                        break;
                    case 4:
                        volver = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            }
        } else {
            System.out.println("Índice no válido. Intenta nuevamente.");
        }
    }

    private static void agregarPokemonAlEquipo(Entrenador entrenador) {
        System.out.print("Introduce el nombre del Pokémon que deseas agregar: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la salud del Pokémon: ");
        int salud = sc.nextInt();
        System.out.print("Introduce los puntos de ataque del Pokémon: ");
        int puntosDeAtaque = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Introduce el tipo del Pokémon: ");
        String tipoStr = sc.nextLine();
        TipoPokemon tipo = TipoPokemon.valueOf(tipoStr.toUpperCase());

        Pokemon nuevoPokemon = new Pokemon(nombre, salud, puntosDeAtaque, tipo);
        entrenador.agregarPokemon(nuevoPokemon);
        System.out.println("Pokémon " + nombre + " agregado al equipo de " + entrenador.getNombre());
    }

    private static void entrenarPokemon(Entrenador entrenador) {
        entrenador.mostrarPokemones();
        System.out.print("Introduce el número del Pokémon que deseas entrenar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar el buffer

        if (indice >= 0 && indice < entrenador.getPokemones().size()) {
            Pokemon pokemon = entrenador.getPokemones().get(indice);
            pokemon.entrenar();
            System.out.println("El Pokémon " + pokemon.getNombre() + " ha sido entrenado.");
        } else {
            System.out.println("Índice no válido. Intenta nuevamente.");
        }
    }

    private static void gestionarPokemones() {
        boolean volver = false;

        while (!volver) {
            System.out.println("Gestionar Pokémones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    verTodosLosPokemones();
                    break;
                case 2:
                    registrarNuevoPokemon();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    private static void verTodosLosPokemones() {
        System.out.println("Pokémones registrados:");
        for (Entrenador entrenador : entrenadores) {
            System.out.println("Entrenador: " + entrenador.getNombre());
            entrenador.mostrarPokemones();
        }
    }

    private static void registrarNuevoPokemon() {
        System.out.print("Introduce el nombre del Pokémon: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la salud del Pokémon: ");
        int salud = sc.nextInt();
        System.out.print("Introduce los puntos de ataque del Pokémon: ");
        int puntosDeAtaque = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Introduce el tipo del Pokémon: ");
        String tipoStr = sc.nextLine();
        TipoPokemon tipo = TipoPokemon.valueOf(tipoStr.toUpperCase());

        System.out.print("Introduce el nombre del entrenador al que pertenece el Pokémon: ");
        String nombreEntrenador = sc.nextLine();

        Entrenador entrenador = null;
        for (Entrenador e : entrenadores) {
            if (e.getNombre().equalsIgnoreCase(nombreEntrenador)) {
                entrenador = e;
                break;
            }
        }

        if (entrenador != null) {
            Pokemon nuevoPokemon = new Pokemon(nombre, salud, puntosDeAtaque, tipo);
            entrenador.agregarPokemon(nuevoPokemon);
            System.out.println("Pokémon " + nombre + " agregado al equipo de " + entrenador.getNombre());
        } else {
            System.out.println("Entrenador no encontrado. Intenta nuevamente.");
        }
    }

    private static void iniciarBatalla() {
        System.out.print("Introduce el número del primer entrenador: ");
        int indice1 = sc.nextInt() - 1;
        System.out.print("Introduce el número del segundo entrenador: ");
        int indice2 = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar el buffer

        if (indice1 >= 0 && indice1 < entrenadores.size() && indice2 >= 0 && indice2 < entrenadores.size()) {
            Entrenador entrenador1 = entrenadores.get(indice1);
            Entrenador entrenador2 = entrenadores.get(indice2);
            // Lógica para iniciar la batalla entre entrenador1 y entrenador2
            System.out.println("Batalla iniciada entre " + entrenador1.getNombre() + " y " + entrenador2.getNombre());
        } else {
            System.out.println("Índices no válidos. Intenta nuevamente.");
        }
    }
}
