import java.util.List;

public class Main {

    public static void main(String[] args) {


        Baralho b = new Baralho(Baralho.NumCartasBaralho.BAR_40);
        b.baralhar();

        //Retirar 4 cartas do baralho e criar uma mão de jogo
        MaoDeJogo jogo = new MaoDeJogo(b.darCartas(4));
        System.out.format("Mão jogador: %n%s", jogo.toString());

        //Tipos de carta existentes na mão de jogo
        List<Carta.Tipo> tipos = jogo.tiposDeCarta();
        System.out.format("%nTipos de carta: %s ", tipos);

        //Número de cartas por tipo de crta, na mão de jogo
        for (Carta.Tipo t : tipos)
            System.out.format("%nExistem %d cartas do tipo %s. ",jogo.contarCartasDoTipo(t), t);

        //Ordenar
        jogo.ordenar();
        System.out.format("%nMão ordenada: %n%s ", jogo.toString());

    }

}