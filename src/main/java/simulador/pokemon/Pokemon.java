package simulador.pokemon;

public abstract class Pokemon {
    protected String nombre;
    protected int salud;
    protected int puntoDeAtaque;
    protected TipoPokemon tipo;
    protected Estado estado;


    public Pokemon(String nombre, int salud, int puntoDeAtaque, TipoPokemon tipo, Estado estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntoDeAtaque = puntoDeAtaque;
        this.tipo = tipo;
        this.estado = Estado.NORMAL;
       
    }
    
    public void atacar( Pokemon oponente){
    int danio = (int) (this.puntoDeAtaque * tipo.obtenerMultiplicadorDeDaño(this.tipo, oponente.tipo));
    oponente.recbibirDaño(danio);
    }
    public void recbibirDaño(int danio){
    this.salud -= danio;
    
    }
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
