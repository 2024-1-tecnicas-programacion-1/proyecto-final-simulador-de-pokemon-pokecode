package simulador;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Bellsprout;
import simulador.pokemon.Exeggcute;
import simulador.pokemon.Growlithe;
import simulador.pokemon.Hitmonlee;
import simulador.pokemon.Onix;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Psyduck;
import simulador.pokemon.Tentacool;
import simulador.pokemon.TipoPokemon;
import simulador.pokemon.Voltorb;
import simulador.pokemon.Zubat;
import simulador.pokemon.Farfetchd;

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
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    
            }//Cierra Switch
            
        }//Cierra While
        
    }//Cierra main

    
    private static void mostrarMenuPrincipal() {
        
        System.out.println("\n");
        System.out.println("Simulador de Batallas Pokémon");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
       
    }//Cierra mostrarMenuPrincipal

    
    private static void gestionarEntrenadores() {
        
        boolean volver = false;

        while (!volver) {
            System.out.println("\n");
            System.out.println("Gestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            System.out.println("\n");

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
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    
            }//Cierra Switch
            
        }//Cierra While
        
    }//Cierra gestionarEntrenadores
    
    
    private static void registrarNuevoEntrenador() {
        
        System.out.println("\n");
        System.out.print("Introduce el nombre del nuevo entrenador: ");
        String nombre = sc.nextLine();
        
        Entrenador objetoEntrenador = new Entrenador(nombre);
        //Objeto Entrenador
        
        entrenadores.add(objetoEntrenador);
        System.out.println("Entrenador " + nombre + " registrado exitosamente.");
        System.out.println("\n");
        
    }//Cierra registrarNuevoEntrenador

    
    private static void verListaDeEntrenadores() {
        
        System.out.println("Lista de entrenadores registrados:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
            
        }// Cierra verListaDeEntrenadores
        
    }

    private static void seleccionarEntrenador() {
        
        System.out.print("Introduce el número del entrenador que deseas seleccionar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice >= 0 && indice < entrenadores.size()) {
            Entrenador entrenadorSeleccionado = entrenadores.get(indice);
            boolean volver = false;

            while (!volver) {
                System.out.println("\n");
                System.out.println("Entrenador: " + entrenadorSeleccionado.getNombre());
                System.out.println("1. Ver equipo de Pokémones");
                System.out.println("2. Agregar Pokémon al equipo");
                System.out.println("3. Entrenar Pokémon");
                System.out.println("4. Volver a Gestionar Entrenadores");
                System.out.print("Elige una opción: ");
                System.out.println("\n");

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
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            }
        } else {
            System.out.println("Índice no válido. Intenta nuevamente.");
            
        }//Cierra if-else
        
    }//Cierra seleccionarEntrenador

    
    private static void agregarPokemonAlEquipo(Entrenador entrenador) {
        
        System.out.println("\n");
        
        System.out.print("Introduce el nombre del Pokémon que deseas agregar: ");
        String nombre = sc.nextLine();
        
        System.out.print("Introduce la salud del Pokémon: ");
        int salud = sc.nextInt();
        
        System.out.print("Introduce los puntos de ataque del Pokémon: ");
        int puntosDeAtaque = sc.nextInt(); 
        sc.nextLine();
        
        System.out.print("Introduce el tipo del Pokémon: ");
        String tipoStr = sc.nextLine();
        
        TipoPokemon tipo = TipoPokemon.valueOf(tipoStr.toUpperCase());
        
        System.out.println("\n");

        // TODO: Depende del pokemon que escojan (menú)
        
        Pokemon nuevoPokemon = new Growlithe();
        entrenador.agregarPokemon(nuevoPokemon);
        System.out.println("Pokémon " + nombre + " agregado al equipo de " + entrenador.getNombre());
        
    }//Cierra agregarPokemonAlEquipo

    
    private static void entrenarPokemon(Entrenador entrenador) {
       
        entrenador.mostrarPokemones();
        System.out.print("Introduce el número del Pokémon que deseas entrenar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice >= 0 && indice < entrenador.getPokemones().size()) {
            Pokemon pokemon = entrenador.getPokemones().get(indice);
            pokemon.entrenar();
            System.out.println("El Pokémon " + pokemon.getNombre() + " ha sido entrenado.");
        } else {
            System.out.println("Índice no válido. Intenta nuevamente.");
            
        }//Cirra if-else
        
    }//Cierra entrenadorPokemon
    

    private static void gestionarPokemones() {
        
        boolean volver = false;
       
        while (!volver) {
            
            System.out.println("Gestionar Pokémones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");

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
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    
            }//Cierra gestionarPokemones
            
        }//Cierra While
        
    }//Cierra gestionarPokemon

    
    private static void verTodosLosPokemones() {
        
        System.out.println("Pokémones registrados:");
        
        for (Entrenador entrenador : entrenadores) {
            System.out.println("Entrenador: " + entrenador.getNombre());
            entrenador.mostrarPokemones();
            
        }//Cierra For
        
    }//Cierra verTodosLosPokemones

    
    private static void registrarNuevoPokemon() {
        
        System.out.print("Introduce el nombre del Pokémon: ");
        String nombre = sc.nextLine();
        
        System.out.print("Introduce la salud del Pokémon: ");
        int salud = sc.nextInt();
        
        System.out.print("Introduce los puntos de ataque del Pokémon: ");
        int puntosDeAtaque = sc.nextInt(); 
        sc.nextLine();
        System.out.print("Introduce el tipo del Pokémon: ");

        System.out.print("Introduce el nombre del entrenador al que pertenece el Pokémon: ");
        String nombreEntrenador = sc.nextLine();
        
        Entrenador entrenadorEncontrado = null;
        
        for (int i=0 ;i<entrenadores.size();i++){
            
            Entrenador objetoEntrenador = entrenadores.get(i);
            
            if(objetoEntrenador.getNombre().equals(nombreEntrenador)){
                entrenadorEncontrado = objetoEntrenador;
                break;
                //i = entrenadores.size();
                
            }//Cierra if
            
        }//Cierra For
        
    }//Cierra registrarNuevoPokemon

    
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
                
        }//Cierra Switch-Case
        
    }//Cierra crearPokemon

    
    private static void iniciarBatalla() {
        
        System.out.print("Introduce el número del primer entrenador: ");
        int indice1 = sc.nextInt() - 1;
        
        System.out.print("Introduce el número del segundo entrenador: ");
        int indice2 = sc.nextInt() - 1;
        
        sc.nextLine();

        if (indice1 >= 0 && indice1 < entrenadores.size() && indice2 >= 0 && indice2 < entrenadores.size()) {
            
            Entrenador entrenador1 = entrenadores.get(indice1);
            Entrenador entrenador2 = entrenadores.get(indice2);
     
            System.out.println("Batalla iniciada entre " + entrenador1.getNombre() + " y " + entrenador2.getNombre());
            
        } else {
            
            System.out.println("Índices no válidos. Intenta nuevamente.");
            
        }//Cierra if-else
        
    }//Cierra iniciarBatalla
    
} //Cierra Principal
