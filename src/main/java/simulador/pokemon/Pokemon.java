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
        
    }//Cierra Pokemon

    
    public void atacar(Pokemon oponente){
        
    }//Cierra Atacar

    
    public void recibirDaño(int daño) {
        
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = "Debilitado";
            
        }//Cierra if
        
    }//Cierra recibirDaño

    
    public void entrenar() {
        
        this.puntosDeAtaque += 5;
        this.salud += 20;
        
    }//Cierra entrenar

    
    public String getNombre() {
        
        return nombre;
        
    }//Cierra getNombre

    
    public int getSalud() {
        
        return salud;
        
    }//Cierra getSalud

    
    public int getPuntosDeAtaque() {
        
        return puntosDeAtaque;
        
    }//Cierra getPuntosDeAtaque

    
    public TipoPokemon getTipo() {
        
        return tipo;
        
    }//Cierra getTipo

    public String getEstado() {
        
        return estado;
        
    }//Cierra getEstado

    @Override
    
    public String toString() {
        
        return nombre + " (Salud: " + salud + ", Ataque: " + puntosDeAtaque + ", Tipo: " + tipo + ")";
        
    }//Cierra toString
    
}//Cierra Abstract Class Pokemon
