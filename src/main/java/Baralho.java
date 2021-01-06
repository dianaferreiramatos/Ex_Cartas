
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {


    private ArrayList<Carta> baralho;

    public static enum NumCartasBaralho {
        BAR_40,
        BAR_52
    };

    private static final NumCartasBaralho BARALHO_POR_OMISSAO = NumCartasBaralho.BAR_40;

    // Constrói uma instância de {@code Baralho} recebendo o tipo de baralho.
    public Baralho(NumCartasBaralho tipoDeBaralho) {
        this.baralho = (tipoDeBaralho == NumCartasBaralho.BAR_40 ? new ArrayList<Carta>(40) :
                                                                            new ArrayList<Carta>(52));
        for (Carta.Naipe n : Carta.Naipe.values()) {
            for (Carta.Tipo t : Carta.Tipo.values()) {
                if (tipoDeBaralho == NumCartasBaralho.BAR_40
                        && t.compareTo(Carta.Tipo.SENA) > 0
                        && t.compareTo(Carta.Tipo.DAMA) < 0) {
                    continue;
                }
                this.baralho.add(new Carta(t, n));
            }
        }
    }

    //Constrói uma instância de {@code Baralho} com o baralho por omissão.
    public Baralho() {
        this(Baralho.BARALHO_POR_OMISSAO);
    }

    //construtor copia
        public Baralho(Baralho outroBaralho) {
        this.baralho = new ArrayList<>(outroBaralho.baralho.size());
        for (Carta c : outroBaralho.baralho) {
            this.baralho.add(new Carta(c));
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : this.baralho) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }


    public void baralhar() {
        Collections.shuffle(this.baralho);
    }


    public void partir() {

        // Reserva a primeira metade das cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(0, this.baralho.size() / 2));

        // Remove a primeira metade das cartas do baralho
        this.baralho.removeAll(mbar);

        // Coloca no final a primeira metade das cartas do baralho
        this.baralho.addAll(mbar);
    }


    public List<Carta> primeirasCartas(int n) {

        // Reserva as primeiras n cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(0,
                        (n < this.baralho.size() ? n : this.baralho.size())));

        // Remove as primeiras n cartas do baralho
        this.baralho.removeAll(mbar);

        return mbar;
    }

    // Remove e devolve as últimas n cartas do baralho.
    public List<Carta> ultimasCartas(int n) {
        // Reserva as últimas n cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(
                        (n > this.baralho.size() ? 0 : this.baralho.size() - n),
                        this.baralho.size()));

        // Remove as últimas n cartas do baralho
        this.baralho.removeAll(mbar);

        return mbar;
    }

}