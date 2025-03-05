package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;

public class Rei extends Peca {

    public Rei(double xAtual, double yAtual) {
        super(xAtual, yAtual);
    }

    @Override
    public boolean movimentoCadaPeca(double xClique, double yClique) {
        if(Math.abs(Math.floor(xClique) - xAtual)==1 && (Math.floor(yClique)==yAtual)){
            return true;
        } else if (Math.abs(Math.floor(yClique) - yAtual)==1 && (Math.floor(xClique)==xAtual)) {
            return true;
        }
        else if((Math.abs(xAtual - Math.floor(xClique)) == Math.abs(yAtual-Math.floor(yClique))) && ((Math.abs(Math.floor(xClique) - xAtual)==1) || (Math.abs(Math.floor(yClique) - yAtual)==1))) {
            return  true;
        }
        return false;
    }

    @Override
    public boolean desenharPeca(Draw draw) {
        draw.picture(xAtual +0.5, yAtual+0.5, "rei.png", 0.8, 0.8);
        return true;
    }

    @Override
    public String toString() {
        return "Rei";
    }
}
