package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;

public class Torre extends Peca{

    public Torre(double xAtual, double yAtual) {
        super(xAtual, yAtual);
    }

    @Override
    public boolean movimentoCadaPeca(double xClique, double yClique) {
        if(Math.floor(xClique)==xAtual){
            return true;
        } else if (Math.floor(yClique)==yAtual) {
            return true;
        }
        return false;
    }

    @Override
    public boolean desenharPeca(Draw draw) {
        draw.picture(xAtual +0.5, yAtual+0.5, "torre.png", 0.8, 0.8);
        return true;
    }

    @Override
    public String toString() {
        return "Torre";
    }
}
