package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;

public class Bispo extends Peca{

    public Bispo(double xAtual, double yAtual) {
        super(xAtual, yAtual);
    }

    @Override
    public boolean movimentoCadaPeca(double xClique, double yClique) {
        if(Math.abs(xAtual - Math.floor(xClique)) == Math.abs(yAtual-Math.floor(yClique))){
            return true;
        }
        return false;
    }

    @Override
    public boolean desenharPeca(Draw draw) {
        draw.picture(xAtual +0.5, yAtual+0.5, "bispo.png", 0.8, 0.8);
        return true;
    }

    @Override
    public String toString() {
        return "Bispo";
    }
}
