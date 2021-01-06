public class Carta implements Comparable<Carta> {


    public static enum Tipo {
        DUQUE, TERNO, QUADRA, QUINA, SENA, OITO, NOVE, DEZ,
        DAMA, VALETE, REI, MANILHA, AS
    };

    public static enum Naipe {
        COPAS, OUROS, ESPADAS, PAUS
    };


    private Tipo tipo;
    private Naipe naipe;

    private static final Tipo DEFAULT_TIPO = Tipo.DUQUE;
    private static final Naipe DEFAULT_NAIPE = Naipe.COPAS;

    public Carta(Tipo tipo, Naipe naipe) {
        this.tipo = tipo;
        this.naipe = naipe;
    }

     //ignorar este construtor, nao acrescenta valor neste exercicio
     //public Carta(String descricao) {
     //   String[] arrayDescricao = descricao.split(" ");
     //   this.tipo = Tipo.valueOf(arrayDescricao[0]);
     //  this.naipe = Naipe.valueOf(arrayDescricao[2]);
     //}


    public Carta() {
        this(DEFAULT_TIPO, DEFAULT_NAIPE);
    }

    public Carta(Carta outraCarta) {
        this(outraCarta.tipo, outraCarta.naipe);
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public Naipe getNaipe() {
        return this.naipe;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;

    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;

    }

    @Override
    public String toString() {
        return this.tipo.toString() + " de " + this.naipe.toString();
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Carta outraCarta = (Carta) outroObjeto;
        return this.tipo == outraCarta.tipo
                && this.naipe == outraCarta.naipe;
    }

    @Override
    public int compareTo(Carta outraCarta) {
        int resultado = this.getNaipe().compareTo(outraCarta.getNaipe());

        if (resultado == 0) {
            resultado = this.getTipo().compareTo(outraCarta.getTipo());
        }

        return resultado;
    }

}