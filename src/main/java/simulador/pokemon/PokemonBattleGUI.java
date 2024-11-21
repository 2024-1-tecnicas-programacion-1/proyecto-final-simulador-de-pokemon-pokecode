package simulador.pokemon;

import simulador.entrenador.Entrenador;
import simulador.pokemon.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonBattleGUI extends JFrame {

    private JTextField nombreEntrenador1Field, nombreEntrenador2Field;
    private JComboBox<String> pokemonList1, pokemonList2;
    private DefaultListModel<String> equipoModel1, equipoModel2;
    private JList<String> equipoList1, equipoList2;
    private JButton agregarPokemonButton1, agregarPokemonButton2, batallaButton;
    private Entrenador entrenador1, entrenador2;
    private JComboBox<String> pokemonBatalla1, pokemonBatalla2;

    public PokemonBattleGUI() {
        setTitle("Simulador de Batalla Pokémon");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        JLabel nombreLabel1 = new JLabel("Nombre Entrenador 1:");
        nombreEntrenador1Field = new JTextField();
        JLabel nombreLabel2 = new JLabel("Nombre Entrenador 2:");
        nombreEntrenador2Field = new JTextField();

        pokemonList1 = new JComboBox<>(new String[] {
            "Growlithe", "Psyduck", "Bellsprout", "Voltorb", "Exeggcute", "Onix", "Zubat", "Farfetch'd", "Hitmonlee", "Tentacool"
        });
        pokemonList2 = new JComboBox<>(new String[] {
            "Growlithe", "Psyduck", "Bellsprout", "Voltorb", "Exeggcute", "Onix", "Zubat", "Farfetch'd", "Hitmonlee", "Tentacool"
        });

        equipoModel1 = new DefaultListModel<>();
        equipoModel2 = new DefaultListModel<>();
        equipoList1 = new JList<>(equipoModel1);
        equipoList1.setVisibleRowCount(6);
        equipoList2 = new JList<>(equipoModel2);
        equipoList2.setVisibleRowCount(6);

        agregarPokemonButton1 = new JButton("Agregar Pokémon Entrenador 1");
        agregarPokemonButton2 = new JButton("Agregar Pokémon Entrenador 2");
        batallaButton = new JButton("Iniciar Batalla");

        pokemonBatalla1 = new JComboBox<>();
        pokemonBatalla2 = new JComboBox<>();

        agregarPokemonButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPokemon(1);
            }
        });

        agregarPokemonButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPokemon(2);
            }
        });

        batallaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla();
            }
        });

        panel.add(nombreLabel1);
        panel.add(nombreEntrenador1Field);
        panel.add(new JLabel("Selecciona Pokémon Entrenador 1:"));
        panel.add(pokemonList1);
        panel.add(agregarPokemonButton1);
        panel.add(new JScrollPane(equipoList1));
        panel.add(new JLabel("Selecciona Pokémon Entrenador 1 para batalla:"));
        panel.add(pokemonBatalla1);
        
        panel.add(nombreLabel2);
        panel.add(nombreEntrenador2Field);
        panel.add(new JLabel("Selecciona Pokémon Entrenador 2:"));
        panel.add(pokemonList2);
        panel.add(agregarPokemonButton2);
        panel.add(new JScrollPane(equipoList2));
        panel.add(new JLabel("Selecciona Pokémon Entrenador 2 para batalla:"));
        panel.add(pokemonBatalla2);
        
        panel.add(batallaButton);

        add(panel);

        setVisible(true);
    }

    private void agregarPokemon(int entrenadorNumero) {
        String nombreEntrenador1 = nombreEntrenador1Field.getText();
        String nombreEntrenador2 = nombreEntrenador2Field.getText();
        
        if (entrenadorNumero == 1 && nombreEntrenador1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el nombre del Entrenador 1.");
            return;
        }
        if (entrenadorNumero == 2 && nombreEntrenador2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el nombre del Entrenador 2.");
            return;
        }

        if (entrenador1 == null && entrenadorNumero == 1) {
            entrenador1 = new Entrenador(nombreEntrenador1);
        }
        if (entrenador2 == null && entrenadorNumero == 2) {
            entrenador2 = new Entrenador(nombreEntrenador2);
        }

        String pokemonSeleccionado = (entrenadorNumero == 1) ? (String) pokemonList1.getSelectedItem() : (String) pokemonList2.getSelectedItem();
        Pokemon pokemon = crearPokemon(pokemonSeleccionado);

        if (entrenadorNumero == 1 && entrenador1.getPokemones().size() < 6) {
            entrenador1.agregarPokemon(pokemon);
            equipoModel1.addElement(pokemon.getNombre());
            actualizarComboBox();
        } else if (entrenadorNumero == 2 && entrenador2.getPokemones().size() < 6) {
            entrenador2.agregarPokemon(pokemon);
            equipoModel2.addElement(pokemon.getNombre());
            actualizarComboBox();
        } else {
            JOptionPane.showMessageDialog(this, "Ya has alcanzado el límite de 6 Pokémon.");
        }
    }

    private Pokemon crearPokemon(String nombre) {
        switch (nombre) {
            case "Growlithe": return new Growlithe();
            case "Psyduck": return new Psyduck();
            case "Bellsprout": return new Bellsprout();
            case "Voltorb": return new Voltorb();
            case "Exeggcute": return new Exeggcute();
            case "Onix": return new Onix();
            case "Zubat": return new Zubat();
            case "Farfetch'd": return new Farfetchd();
            case "Hitmonlee": return new Hitmonlee();
            case "Tentacool": return new Tentacool();
            default: return null;
        }
    }

    private void actualizarComboBox() {
        pokemonBatalla1.removeAllItems();
        pokemonBatalla2.removeAllItems();

        for (Pokemon pokemon : entrenador1.getPokemones()) {
            pokemonBatalla1.addItem(pokemon.getNombre());
        }
        for (Pokemon pokemon : entrenador2.getPokemones()) {
            pokemonBatalla2.addItem(pokemon.getNombre());
        }
    }

    private void iniciarBatalla() {
        if (entrenador1 == null || entrenador2 == null) {
            JOptionPane.showMessageDialog(this, "Ambos entrenadores deben ser creados.");
            return;
        }

        String pokemonSeleccionado1 = (String) pokemonBatalla1.getSelectedItem();
        String pokemonSeleccionado2 = (String) pokemonBatalla2.getSelectedItem();

        Pokemon pokemon1 = obtenerPokemonSeleccionado(entrenador1, pokemonSeleccionado1);
        Pokemon pokemon2 = obtenerPokemonSeleccionado(entrenador2, pokemonSeleccionado2);

        if (pokemon1 == null || pokemon2 == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un Pokémon para la batalla.");
            return;
        }

        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            pokemon1.atacar(pokemon2);
            if (pokemon2.getSalud() <= 0) {
                JOptionPane.showMessageDialog(this, "¡" + pokemon1.getNombre() + " ha ganado!");
                return;
            }
            pokemon2.atacar(pokemon1);
            if (pokemon1.getSalud() <= 0) {
                JOptionPane.showMessageDialog(this, "¡" + pokemon2.getNombre() + " ha ganado!");
                return;
            }
        }
    }

    private Pokemon obtenerPokemonSeleccionado(Entrenador entrenador, String nombre) {
        for (Pokemon pokemon : entrenador.getPokemones()) {
            if (pokemon.getNombre().equals(nombre)) {
                return pokemon;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PokemonBattleGUI());
    }
}
