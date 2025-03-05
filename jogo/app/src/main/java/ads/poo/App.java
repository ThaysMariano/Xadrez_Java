package ads.poo;

import ads.poo.pecas.*;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.*;


public class App implements DrawListener {

    private final int dimensao;
    private Tabuleiro tabuleiro;
    private static Draw draw;

//-------------------------------------------------------------

    //construtor
    public App(int dimensao) {
        // Criando tabuleiro
        tabuleiro = new Tabuleiro(dimensao);

        // Objeto responsável por fazer a área de desenho (canvas)
        draw = new Draw();

        // Adicionando objeto desta classe como o
        // objeto que ficará ouvindo por eventos do mouse ou teclado
        draw.addListener(this);

        // Definindo a dimensão do tabuleiro
        this.dimensao = dimensao;

        // Definindo que a escala de cada eixo será de 0 a dimensao
        draw.setXscale(0, dimensao);
        draw.setYscale(0, dimensao);

        // Habilitando o uso de double buffering para deixar o desenho mais suave
        draw.enableDoubleBuffering();
    }


    public void desenharTela() {
        // Limpa a área de desenho
        draw.clear(Color.LIGHT_GRAY);
        // Desenha o tabuleiro
        this.desenharTabuleiro();
        //desenha o circulo da seleção
        tabuleiro.desenharSombraPecaSelecionada(draw);
        //desenha as peças
        desenharPecas();
        // Exibe a área de desenho, com todos os objetos desenhados
        draw.show();
    }


    public void desenharTabuleiro() {
        draw.setPenColor(Color.BLACK);
        for (int i = 0; i <= dimensao; i++) draw.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j++) draw.line(0, j, dimensao, j);

        //pintar os quadrados do tabuleiro em xadrez
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (((i + j) % 2) == 0) {
                    draw.setPenColor(Color.pink);
                } else {

                    draw.setPenColor(Color.white);
                }
                draw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }

    //metodo para desenhar as peças
    public void desenharPecas() {
        tabuleiro.desenharPecasNoTabuleiro(draw);
    }


    //evento do clique, seleciona e move as peças
    public void mousePressed(double x, double y) {
        // Se o usuário clicou dentro da casa do tabuleiro onde está uma peça
        //Na linha abaixo está sendo aplicado o polimorfismo
        for (Peca pecaNoTab : tabuleiro.getPecas()) {
            if ((Math.floor(x) == pecaNoTab.getx()) && (Math.floor(y) == pecaNoTab.gety())) {
                // Troca o estado da peca (selecionado ou não)
                pecaNoTab.marcaDesmarca();

            } else if (pecaNoTab.isSelecionada()) {
                if ( pecaNoTab.movimentoCadaPeca(x, y) && tabuleiro.verificarSeJaTemPeca(x, y) && tabuleiro.verificarCaminho(pecaNoTab, x, y)  ) {
                    // Move a peca para a nova posição e desmarca o círculo

                    //caso for o primeiro movimento de um peao seta como falso
                    if(pecaNoTab instanceof Peao){
                        ((Peao) pecaNoTab).setPrimeiroMovimento(false);
                    }

                    pecaNoTab.setx(Math.floor(x));
                    pecaNoTab.sety(Math.floor(y));
                    pecaNoTab.setSelecionada(false);
                }else{
                    System.out.println(pecaNoTab + ", movimento inválido!");
                    pecaNoTab.setSelecionada(false);
                }
            }
        }
        // Limpa a área de desenho, desenha o tabuleiro e os círculos
        desenharTela();
    }


    //motodo main
    public static void main(String[] args) {

        // Inicializa a aplicação com um tabuleiro 8x8 e desenha
        App app = new App(8);
        app.desenharTela();

    }
}
