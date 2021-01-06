import java.util.Objects;

public class Carta {

    public static TipoCarta tipo;
    public static TipoNaipe naipe;

    public Carta(TipoCarta tipo, TipoNaipe naipe) {
        this.tipo = tipo;
        this.naipe = naipe;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarta tipo) {
        this.tipo = tipo;
    }

    public TipoNaipe getNaipe() {
        return naipe;
    }

    public void setNaipe(TipoNaipe naipe) {
        this.naipe = naipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return tipo == carta.tipo &&
                Objects.equals(naipe, carta.naipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, naipe);
    }

    @Override
    public String toString() {
        return "Carta{" +
                "tipo=" + tipo +
                ", naipe=" + naipe +
                '}';
    }
}
