import java.util.ArrayList;
import java.util.Objects;

public class Baralho {

    ArrayList<Carta> cartasBaralho = new ArrayList<>();
    TipoNaipe naipeBaralho;

    public Baralho(ArrayList<Carta> cartasBaralho, TipoNaipe naipeBaralho) {
        this.cartasBaralho = cartasBaralho;
        this.naipeBaralho = naipeBaralho;
    }

    public ArrayList<Carta> getCartasBaralho() {
        return cartasBaralho;
    }

    public void setCartasBaralho(ArrayList<Carta> cartasBaralho) {
        this.cartasBaralho = cartasBaralho;
    }

    public TipoNaipe getNaipeBaralho() {
        return naipeBaralho;
    }

    public void setNaipeBaralho(TipoNaipe naipeBaralho) {
        this.naipeBaralho = naipeBaralho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baralho baralho = (Baralho) o;
        return Objects.equals(cartasBaralho, baralho.cartasBaralho) &&
                naipeBaralho == baralho.naipeBaralho;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartasBaralho, naipeBaralho);
    }

    @Override
    public String toString() {
        return "Baralho{" +
                "cartasBaralho=" + cartasBaralho +
                ", naipeBaralho=" + naipeBaralho +
                '}';
    }
}
