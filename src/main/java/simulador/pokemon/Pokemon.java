package simulador.pokemon;

public abstract class Pokemon {

   
    protected String nombre;
    protected int salud;
    protected int puntosDeAtaque;
    protected TipoPokemon[] tipos;
    protected String estado;


    
    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon... tipos) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipos = tipos;
        this.estado = "Normal";
    }

    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipos, oponente.getTipos());
        
        int daño = (int) (this.puntosDeAtaque * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println("");
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + daño + " puntos de daño.");
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

    public TipoPokemon[] getTipos() {
        return tipos;
    }

    public String getEstado() {
        return estado;
    }

}