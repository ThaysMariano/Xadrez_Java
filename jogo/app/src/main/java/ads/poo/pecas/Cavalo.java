package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;

public class Cavalo extends Peca{

    public Cavalo(double xAtual, double yAtual) {
        super(xAtual, yAtual);
    }

    @Override
    public boolean movimentoCadaPeca(double xClique, double yClique) {

        if( ((Math.floor(yClique) == yAtual+2)||(Math.floor(yClique)== yAtual-2)) &&  ((Math.floor(xClique) == xAtual+1)|| (Math.floor(xClique) == xAtual-1))){
            return true;

        } else if (((Math.floor(xClique) == xAtual+2)|| (Math.floor(xClique) == xAtual-2)) && ((Math.floor(yClique)== yAtual+1)|| (Math.floor(yClique)==yAtual-1))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean desenharPeca(Draw draw) {
        draw.picture(xAtual +0.5, yAtual+0.5, "cavalo.png", 0.8, 0.8);
        return true;
    }

    @Override
    public String toString() {
        return "Cavalo";
    }
}
