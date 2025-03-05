package ads.poo.pecas;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.*;

public abstract class Peca implements DrawListener {

    protected double xAtual;
    protected double yAtual;
    protected boolean selecionada;

//----------------------------------------------------

    //construtor
    public Peca(double xAtual, double yAtual) {
        this.xAtual = Math.floor(xAtual);
        this.yAtual = Math.floor(yAtual);
        this.selecionada = false;
    }

    //movimento de cada  tipo de peça
    public abstract boolean movimentoCadaPeca(double xClique, double yclique);

    //desenho de cada tipo de peça
    public abstract boolean desenharPeca(Draw draw);

    //inverter seleção de peça
    public void marcaDesmarca() {
        this.selecionada = !this.selecionada;
    }

    @Override
    public abstract String toString();


//----------------------------------------------------

    //getters e setters

    public double gety() {
        return yAtual;
    }

    public double getx() {
        return xAtual;
    }

    public void setx(double x) {
        this.xAtual = x;
    }

    public void sety(double y) {
        this.yAtual = y;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public boolean isSelecionada() {
        return selecionada;
    }
}
