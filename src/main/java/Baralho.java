
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

    //Construtor
    public Baralho(NumCartasBaralho tipoDeBaralho) {
        //se o baralho for de 40 cria uma lista com 40 cartas e se for de 52 cria com 52
        this.baralho = (tipoDeBaralho == NumCartasBaralho.BAR_40 ? new ArrayList<Carta>(40) :
                                                                            new ArrayList<Carta>(52));
        //cada carta tem um naipe
        for (Carta.Naipe n : Carta.Naipe.values()) {
            //cada carta tem um tipo
            for (Carta.Tipo t : Carta.Tipo.values()) {
                //se o baralho for de 40 cartas, 8 9 e 10 não entram
                if (tipoDeBaralho == NumCartasBaralho.BAR_40
                        && t.compareTo(Carta.Tipo.SENA) > 0
                        && t.compareTo(Carta.Tipo.DAMA) < 0) {
                    continue;
                }
                //adiciona carta ao baralho
                this.baralho.add(new Carta(t, n));
            }
        }
    }

    //construtor vazio
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


    public List<Carta> darCartas(int n) {

        List<Carta> maoBaralhoParaJogador = new ArrayList<>(
                this.baralho.subList(0,
                        (n < this.baralho.size() ? n : this.baralho.size())));

        // Remove as primeiras n cartas do baralho
        this.baralho.removeAll(maoBaralhoParaJogador);

        return maoBaralhoParaJogador;
    }

}