package simulador.pokemon;

public abstract class Pokemon {
    protected String nombre;
    protected int salud;
    protected int puntoDeAtaque;
    protected TipoPokemon tipo;


    public Pokemon(String nombre, int salud, int puntoDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntoDeAtaque = puntoDeAtaque;
        this.tipo = tipo;
        
    }
    public void atacar(){}
    public void recbibirDaño(){}
    public void entrenar (){
        this.puntoDeAtaque +=5;
        this.salud +=10;
    
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntoDeAtaque() {
        return puntoDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

   
}
