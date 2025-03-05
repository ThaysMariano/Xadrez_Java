package ads.poo;

import ads.poo.pecas.*;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;
import java.util.ArrayList;


public class Tabuleiro {

    private ArrayList<Peca> pecas= new ArrayList<>();

//---------------------------------------------------

    public Tabuleiro(int dimensao) {
        //peoes
        for (int i = 0; i < dimensao; i++) {
            pecas.add(new Peao(i, 1));
        }
        //torres
        pecas.add(new Torre(0, 0));
        pecas.add(new Torre(7, 0));
        //cavalos
        pecas.add(new Cavalo(1,0));
        pecas.add(new Cavalo(6,0));
        //bispos
        pecas.add(new Bispo(2,0));
        pecas.add(new Bispo(5,0));
        //rainha
        pecas.add(new Rainha(4,0));
        //rei
        pecas.add(new Rei(3,0));
    }

    public boolean verificarCaminho(Peca pAtual, double xClique, double yClique) {
        double xCliqueFloor = Math.floor(xClique);
        double yCliqueFloor = Math.floor(yClique);
        //Nas linhas abaixo está sendo aplicado o polimorfismo
        if (pAtual.movimentoCadaPeca(xClique, yClique)) {
            for(Peca peca : pecas) {
                //vertical +
                if (xCliqueFloor == pAtual.getx() && yCliqueFloor > pAtual.gety()) {
                    for (double i = pAtual.gety() + 1; i <= yCliqueFloor; i++) {
                        if (peca.getx() == xCliqueFloor && peca.gety() == i) {
                            return false;
                        }
                    }

                    //vertical -
                } else if (xCliqueFloor == pAtual.getx() && yCliqueFloor < pAtual.gety()) {
                    for (double i = pAtual.gety() - 1; i >= yCliqueFloor; i--) {
                        if (peca.getx() == xCliqueFloor && peca.gety() == i) {
                            return false;
                        }
                    }
                }
                //horizontal +
                else if (yCliqueFloor == pAtual.gety() && xCliqueFloor > pAtual.getx()) {
                    for (double i = pAtual.getx() + 1; i <= xCliqueFloor; i++) {
                        if (peca.gety() == yCliqueFloor && peca.getx() == i) {
                            return false;
                        }
                    }
                }
                //horizontal -
                else if (yCliqueFloor == pAtual.gety() && xCliqueFloor < pAtual.getx()) {
                    for (double i = pAtual.getx() - 1; i >= xCliqueFloor; i--) {
                        if (peca.gety() == yCliqueFloor && peca.getx() == i) {
                            return false;
                        }
                    }
                //diagonais
                } else{

                    //decidir se é positivo ou negativo o movimento
                    int xAgora = (xCliqueFloor > pAtual.getx()) ? 1 : -1;
                    int yAgora = (yCliqueFloor > pAtual.gety()) ? 1 : -1;

                    double x = pAtual.getx() + xAgora;
                    double y = pAtual.gety() + yAgora;

                    // Percorrer a diagonal
                    while (x != xCliqueFloor && y != yCliqueFloor) {
                        if (peca.getx() == x && peca.gety() == y) {
                            return false;
                        }
                        x += xAgora;
                        y += yAgora;
                    }
                }
            }
        }
        return true;
    }


    //desenha cada peça no tabuleiro
    //Na linha abaixo está sendo aplicado o polimorfismo
    public boolean desenharPecasNoTabuleiro(Draw draw) {
        for (Peca peca : pecas) {
            peca.desenharPeca(draw);
        }
        return true;
    }


    //desenha um circulo magenta na peca selecionada
    //Na linha abaixo está sendo aplicado o polimorfismo
    public boolean desenharSombraPecaSelecionada(Draw draw) {
        for (Peca p : pecas) {
            Color cor;
            if (p.isSelecionada()) {
                cor = Color.magenta;
                draw.setPenColor(cor);
                draw.filledCircle(p.getx() + 0.5, p.gety() + 0.5, .375);
            }
        }
        return  true;
    }

    //verifica se há uma peça na posição do clique
    //Na linha abaixo está sendo aplicado o polimorfismo
    public boolean verificarSeJaTemPeca(double xClique, double yClique){
        for(Peca p : pecas) {
            if (Math.floor(xClique) == p.getx() && Math.floor(yClique) == p.gety()) {
                return false;
            }
        }
        return true;
    }

// ---------------------------------------------------

    // getter
    public ArrayList<Peca> getPecas() {
        return pecas;
    }


}

