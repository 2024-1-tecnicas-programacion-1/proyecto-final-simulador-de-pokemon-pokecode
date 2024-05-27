package simulador.pokemon;

public abstract class Pokemon {
    protected String nombre;
    protected int salud;
    protected int puntosDeAtaque;
    protected TipoPokemon tipo;
    protected String estado;

    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = "Normal";
    }

    public void atacar(Pokemon oponente){
        
    }

    public void recibirDaño(int daño) {
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = "Debilitado";
        }
    }

    public void entrenar() {
        this.puntosDeAtaque += 5;
        this.salud += 20;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return nombre + " (Salud: " + salud + ", Ataque: " + puntosDeAtaque + ", Tipo: " + tipo + ")";
    }
}
