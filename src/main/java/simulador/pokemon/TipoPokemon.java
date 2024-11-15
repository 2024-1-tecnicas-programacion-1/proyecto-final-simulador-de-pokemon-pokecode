package simulador.pokemon;


public enum TipoPokemon {
    FUEGO, AGUA, PLANTA, VENENO, ELECTRICO, PSIQUICO, ROCA, TIERRA, NORMAL, VOLADOR, HADA, LUCHA, ACERO, BICHO, HIELO, FANTASMA;

 public static double obtenerMultiplicadorDeDaño(TipoPokemon[] atacantes, TipoPokemon[] defensores) {
        double multiplicador = 1.0;
        for (TipoPokemon atacante : atacantes) {
            for (TipoPokemon defensor : defensores) {
                multiplicador *= obtenerMultiplicadorDeDaño(atacante, defensor);
            }
        }
        return multiplicador;
    }
 
  private static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
        
        switch (atacante) {
            case FUEGO:
                switch (defensor) {
                    case PLANTA, BICHO, HIELO:
                        return 2;
                    case FUEGO, VENENO, ELECTRICO, PSIQUICO, TIERRA, NORMAL, VOLADOR, HADA, LUCHA, FANTASMA:
                        return 1;
                    case AGUA, ROCA, ACERO:
                        return 0.5;
                }
                
            case AGUA:
                switch (defensor) {
                    case FUEGO, ROCA, TIERRA:
                        return 2;
                    case AGUA, VENENO, ELECTRICO, PSIQUICO, NORMAL, VOLADOR, HADA, LUCHA, ACERO, BICHO, HIELO, FANTASMA:
                        return 1;
                    case PLANTA:
                        return 0.5;
                }
                
            case PLANTA:
                switch (defensor) {
                    case AGUA, ROCA, TIERRA:
                        return 2;
                    case PLANTA, ELECTRICO, PSIQUICO, NORMAL, HADA, LUCHA, HIELO, FANTASMA:
                        return 1;
                    case FUEGO, VENENO, VOLADOR, ACERO, BICHO:
                        return 0.5;
                }
                
            case VENENO:
                switch (defensor) {
                    case PLANTA, HADA:
                        return 2;
                    case FUEGO, AGUA, ELECTRICO, PSIQUICO, TIERRA, NORMAL, VOLADOR, LUCHA, ACERO, BICHO, HIELO:
                        return 1;
                    case ROCA, FANTASMA:
                        return 0.5;
                }
                
            case ELECTRICO:
                switch (defensor) {
                    case AGUA, VOLADOR:
                        return 2;
                    case FUEGO, PLANTA, VENENO, PSIQUICO, ROCA, NORMAL, HADA, LUCHA, ACERO, BICHO, HIELO, FANTASMA:
                        return 1;
                    case ELECTRICO:
                        return 0.5;
                    case TIERRA:
                        return 0;
                }
                
            case PSIQUICO:
                switch (defensor) {
                    case VENENO, LUCHA:
                        return 2;
                    case FUEGO, AGUA, PLANTA, ELECTRICO, PSIQUICO, ROCA, TIERRA, NORMAL, VOLADOR, ACERO, BICHO, HIELO, FANTASMA:
                        return 1;
                    case HADA:
                        return 1;
                }
                
            case ROCA:
                switch (defensor) {
                    case FUEGO, VOLADOR, BICHO, HIELO:
                        return 2;
                    case AGUA, PLANTA, VENENO, PSIQUICO, NORMAL, FANTASMA, HADA:
                        return 1;
                    case ACERO, LUCHA, TIERRA:
                        return 0.5;
                }
                
            case TIERRA:
                switch (defensor) {
                    case FUEGO, ELECTRICO, VENENO, ROCA, ACERO:
                        return 2;
                    case AGUA, PLANTA, PSIQUICO, NORMAL, HADA, LUCHA, BICHO, HIELO, FANTASMA:
                        return 1;
                    case VOLADOR:
                        return 0;
                }
                
            case NORMAL:
                switch (defensor) {
                    case ROCA, ACERO:
                        return 0.5;
                    case FANTASMA:
                        return 0;
                    default:
                        return 1;
                }
            case VOLADOR:
                switch (defensor) {
                    case PLANTA, LUCHA, BICHO:
                        return 2;
                    case FUEGO, AGUA, VENENO, PSIQUICO, NORMAL, VOLADOR, HADA, HIELO, FANTASMA:
                        return 1;
                    case ELECTRICO, ROCA, ACERO:
                        return 0.5;
                }
                break;
            case HADA:
                switch (defensor) {
                    case LUCHA:
                        return 2;
                    case FUEGO, VENENO, ACERO:
                        return 0.5;
                    default:
                        return 1;
                }
            case LUCHA:
                switch (defensor) {
                    case NORMAL, ROCA, ACERO, HIELO:
                        return 2;
                    case VENENO, VOLADOR, PSIQUICO, BICHO, HADA:
                        return 0.5;
                    case FANTASMA:
                        return 0;
                    default:
                        return 1;
                }
            case ACERO:
                switch (defensor) {
                    case HADA, ROCA, HIELO:
                        return 2;
                    case FUEGO, AGUA, ELECTRICO, ACERO:
                        return 0.5;
                    default:
                        return 1;
                }
            case BICHO:
                switch (defensor) {
                    case PLANTA, PSIQUICO:
                        return 2;
                    case FUEGO, LUCHA, VENENO, VOLADOR, FANTASMA, ACERO, HADA:
                        return 0.5;
                    default:
                        return 1;
                }
            case HIELO:
                switch (defensor) {
                    case PLANTA, TIERRA, VOLADOR:
                        return 2;
                    case FUEGO, AGUA, ACERO:
                        return 0.5;
                    default:
                        return 1;
                }
            case FANTASMA:
                switch (defensor) {
                    case PSIQUICO, FANTASMA:
                        return 2;
                    case NORMAL:
                        return 0;
                    default:
                        return 1;           
                }
                
        }
        
        return 1;
        
    }
    
}
