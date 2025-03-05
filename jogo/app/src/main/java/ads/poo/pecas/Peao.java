package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Peao extends Peca {

    private boolean primeiroMovimento;

// ---------------------------------------------------

    public Peao(double xAtual, double yAtual) {
        super(xAtual, yAtual);
        this.primeiroMovimento=true;
    }

    @Override
    public boolean movimentoCadaPeca(double xClique, double yClique) {
        if(primeiroMovimento){
            if((Math.floor(yClique) - yAtual <=2) && (Math.floor(yClique) - yAtual >=0) && (Math.floor(xClique) == xAtual)){
                return true;
            }
        }else if((Math.floor(yClique) - yAtual <=1) && (Math.floor(yClique) - yAtual >0) && (Math.floor(xClique) == xAtual)){
                return true;
        }
        return false;
    }
    @Override
    public boolean desenharPeca(Draw draw) {
        draw.picture(xAtual +0.5, yAtual+0.5, "peao.png", 0.8, 0.8);
        return true;
    }

    @Override
    public String toString() {
        return "Peão";
    }

// ---------------------------------------------------

    //setter

    public void setPrimeiroMovimento(boolean primeiroMovimento) {
        this.primeiroMovimento = primeiroMovimento;
    }
}
