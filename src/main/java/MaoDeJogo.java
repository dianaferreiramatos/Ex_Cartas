import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MaoDeJogo {

    private ArrayList<Carta> maoJogador;

    //construtor
    public MaoDeJogo(List<Carta> mao) {
        maoJogador = new ArrayList(mao);
    }

    //construtor vazio
    public MaoDeJogo() {
        maoJogador = new ArrayList<>();
    }

    //construtor copia
    public MaoDeJogo(MaoDeJogo outraMaoDeJogo) {
        maoJogador = new ArrayList<>();
        for(Carta c : outraMaoDeJogo.maoJogador) {
            maoJogador.add(new Carta(c));
        }
    }

    public List<Carta> getMaoDeJogo() {
        return new ArrayList<Carta>(maoJogador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaoDeJogo maoDeJogo = (MaoDeJogo) o;
        return Objects.equals(maoJogador, maoDeJogo.maoJogador);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : maoJogador) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }


    //devolve um conjunto com os varios tipos de carta
    public List<Carta.Tipo> tiposDeCarta() {
        List<Carta.Tipo> tiposDeCarta = new ArrayList();

        for (Carta carta : this.maoJogador) {
            tiposDeCarta.add(carta.getTipo());
        }
        return tiposDeCarta;
    }


    //Devolve quantas cartas de um dado tipo existem na mão de jogo.
    public int contarCartasDoTipo(Carta.Tipo tipo) {
        int soma = 0;

        for (Carta carta : this.maoJogador) {
            if(carta.getTipo().equals(tipo)) {
                soma++;
            }
        }
        return soma;
    }


    //Ordena a mão de jogo por naipe e, dentro do mesmo naipe, ordena por tipo
    public void ordenar() {
        //é suficiente utilizar o Collections.sort uma vez que estamos a usar ENUMS, e nesse caso a ordem definida
        //no ENUM já está ordenada. por detrás desse método os argumento estao ordenados por um "numero".
        Collections.sort(this.maoJogador);
    }

}
