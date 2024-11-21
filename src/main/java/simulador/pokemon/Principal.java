package simulador.pokemon;

import simulador.entrenador.Entrenador;
import simulador.batalla.Batalla;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.pokemon.Bellsprout;
import simulador.pokemon.Exeggcute;
import simulador.pokemon.Farfetchd;
import simulador.pokemon.Growlithe;
import simulador.pokemon.Hitmonlee;
import simulador.pokemon.Onix;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Psyduck;
import simulador.pokemon.Tentacool;
import simulador.pokemon.Voltorb;
import simulador.pokemon.Zubat;

public class Principal {

    public static List<Entrenador> entrenadores = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Opcion no valida. Intenta nuevamente.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("================================================================");
        System.out.println("           Bienvenido al simulador de batallas pokemon :)       ");
        System.out.println("================================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("=======================================");
        System.out.println("           SIMULADOR DE BATALLAS       ");
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokemones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
    }

    private static void gestionarEntrenadores() {
        boolean volver = false;

        while (!volver) {
            System.out.println("");
            System.out.println("");
        System.out.println("========================================");
        System.out.println("           GESTIONAR ENTRENADORES       ");
        System.out.println("========================================");
            System.out.println("");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menu principal");
            System.out.print("Elige una opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Opcion no valida. Intenta nuevamente.");
            }
        }
    }


    private static void registrarNuevoEntrenador() {

        System.out.println("");
        System.out.println("");
        System.out.print("Introduce el nombre del nuevo entrenador: ");
        String nombre = sc.nextLine();

        Entrenador objetoEntrenador = new Entrenador(nombre);
        entrenadores.add(objetoEntrenador);
        System.out.println("");
        System.out.println("Entrenador " + nombre + " registrado exitosamente.");
    }

    private static void verListaDeEntrenadores() {

        System.out.println("");
        System.out.println("");
        System.out.println("Lista de entrenadores registrados:");

      

        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }
    }


    private static void seleccionarEntrenador() {
    System.out.println("");
    System.out.println("");
    System.out.print("Introduce el nombre del entrenador que deseas seleccionar: ");
    String nombreEntrenador = sc.nextLine();

    Entrenador entrenadorSeleccionado = null;
    for (Entrenador entrenador : entrenadores) {
        if (entrenador.getNombre().equalsIgnoreCase(nombreEntrenador)) {
            entrenadorSeleccionado = entrenador;
            break;
        }
    }

    if (entrenadorSeleccionado != null) {
        boolean volver = false;

        while (!volver) {
            System.out.println("");
            System.out.println("");
            System.out.println("Entrenador: " + entrenadorSeleccionado.getNombre());
            System.out.println("");
            System.out.println("1. Ver equipo de Pokemones");
            System.out.println("2. Agregar Pokemon al equipo");
            System.out.println("3. Entrenar Pokemon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("");
                    System.out.println("Opcion no valida. Intenta nuevamente.");
            }
        }
    } else {
        System.out.println("");
        System.out.println("Entrenador no encontrado. Intenta nuevamente.");
    }
}



    private static void agregarPokemonAlEquipo(Entrenador entrenador) {
        System.out.println("");
        System.out.println("");
        System.out.println("Introduce el nombre del Pokemon que deseas agregar: ");
        System.out.println("");
        System.out.println("Estos son los pokemones disponibles:");
        System.out.println("");
        System.out.println("Bellsprout, Exeggcute, Farfetch'd, Growlithe, Hitmonlee, Onix, Psyduck, Tentacool, Voltorb, Zubat");
        System.out.println("");
        String nombre = sc.nextLine();

        Pokemon nuevoPokemon = crearPokemon(nombre);
        if (nuevoPokemon != null) {
            entrenador.agregarPokemon(nuevoPokemon);
            System.out.println("");
            System.out.println("Pokemon " + nombre + " agregado al equipo de " + entrenador.getNombre());
        } else {
            System.out.println("");
            System.out.println("Pokemon no valido. Intenta nuevamente.");
        }
    }

        private static void entrenarPokemon(Entrenador entrenador) {
            entrenador.mostrarPokemones();
            System.out.println("");
            System.out.println("");
            System.out.print("Introduce el numero del Pokemon que deseas entrenar: ");
            
            int indice = sc.nextInt() - 1;
            sc.nextLine();
    
            if (indice >= 0 && indice < entrenador.getPokemones().size()) {
                Pokemon pokemon = entrenador.getPokemones().get(indice);
                pokemon.entrenar();
                System.out.println("");
                System.out.println("");
                System.out.println("El Pokemon " + pokemon.getNombre() + " ha sido entrenado.");
            } else {
                System.out.println("");
                System.out.println("Indice no valido. Intenta nuevamente.");
            }
        }


        private static void gestionarPokemones() {
            boolean volver = false;
    
            while (!volver) {
                System.out.println("");
                System.out.println("");
                System.out.println("=======================================");
                System.out.println("            GESTIONAR POKEMONES        ");
                System.out.println("=======================================");
                System.out.println("1. Ver todos los Pokemones registrados");
                System.out.println("2. Registrar nuevo Pokemon");
                System.out.println("3. Volver al menu principal");
                System.out.print("Elige una opcion: ");
    
                int opcion = sc.nextInt();
                sc.nextLine();
    
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
                        System.out.println("");
                        System.out.println("Opcion no valida. Intenta nuevamente.");
                }
            }
        }


        private static void verTodosLosPokemones() {
            System.out.println("");
            System.out.println("");
            System.out.println("Pokemones registrados:");
            for (Entrenador entrenador : entrenadores) {
                System.out.println("");
                System.out.println("Entrenador: " + entrenador.getNombre());
                entrenador.mostrarPokemones();
            }
        }

 
        private static void registrarNuevoPokemon() {
            System.out.println("");
            System.out.println("");
            System.out.print("Introduce el nombre del Pokemon: ");
            String nombre = sc.nextLine();
    
            Pokemon nuevoPokemon = crearPokemon(nombre);
            if (nuevoPokemon != null) {
                System.out.println("");
                System.out.print("Introduce el nombre del entrenador al que pertenece el Pokemon: ");
                String nombreEntrenador = sc.nextLine();
    
                Entrenador entrenadorEncontrado = null;
    
                for (Entrenador entrenador : entrenadores) {
                    if (entrenador.getNombre().equals(nombreEntrenador)) {
                        entrenadorEncontrado = entrenador;
                        break;
                    }
                }
    
                if (entrenadorEncontrado != null) {
                    entrenadorEncontrado.agregarPokemon(nuevoPokemon);
                    System.out.println("");
                    System.out.println("Pokemon " + nombre + " agregado al equipo de " + entrenadorEncontrado.getNombre());
                } else {
                    System.out.println("");
                    System.out.println("Entrenador no encontrado. Intenta nuevamente.");
                }
            } else {
                System.out.println("");
                System.out.println("Pokemon no valido. Intenta nuevamente.");
            }
        }
    

     public static Pokemon crearPokemon(String nombre) {
            switch (nombre) {
                case "Growlithe":
                    return new Growlithe();
                case "Psyduck":
                    return new Psyduck();
                case "Bellsprout":
                    return new Bellsprout();
                case "Voltorb":
                    return new Voltorb();
                case "Exeggcute":
                    return new Exeggcute();
                case "Onix":
                    return new Onix();
                case "Zubat":
                    return new Zubat();
                case "Farfetch'd":
                    return new Farfetchd();
                case "Hitmonlee":
                    return new Hitmonlee();
                case "Tentacool":
                    return new Tentacool();
                default:
                    return null;
            }
        }
    

        private static void iniciarBatalla() {
    System.out.println("");
    System.out.println("");
    System.out.print("Introduce el nombre del primer entrenador: ");
    String nombreEntrenador1 = sc.nextLine();
    System.out.println("");
    System.out.println("");
    System.out.print("Introduce el nombre del segundo entrenador: ");
    String nombreEntrenador2 = sc.nextLine();

    Entrenador entrenador1 = null;
    Entrenador entrenador2 = null;

    for (Entrenador entrenador : entrenadores) {
        if (entrenador.getNombre().equalsIgnoreCase(nombreEntrenador1)) {
            entrenador1 = entrenador;
        }
        if (entrenador.getNombre().equalsIgnoreCase(nombreEntrenador2)) {
            entrenador2 = entrenador;
        }
    }

    if (entrenador1 != null && entrenador2 != null) {
        Pokemon pokemon1 = entrenador1.elegirPokemon();
        Pokemon pokemon2 = entrenador2.elegirPokemon();

        if (pokemon1 != null && pokemon2 != null) {
            Batalla batalla = new Batalla(entrenador1, entrenador2);
            batalla.iniciarBatalla();
        } else {
            System.out.println("");
            System.out.println("Uno o ambos entrenadores no tienen Pokemones disponibles.");
        }
    } else {
        System.out.println("");
        System.out.println("Uno o ambos entrenadores no encontrados. Intenta nuevamente.");
    }
    }
}