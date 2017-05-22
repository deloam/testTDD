package Objetos;

import java.util.Random;
import operacao.Algoritimo;

//Classe que define uma possível solução
public final class Rainha {

    private double aptidao;
    private final int[] posicoesY;
    private Tabuleiro tabuleiro;
    private int colisoes;

    public Rainha(boolean rainhasAleatorias) {
        /*
         tamanho do tabuleiro
         posição do vetor é X e valor da posição é Y
         */
        posicoesY = new int[8];
        //gera um tabuleiro para ser mapeado
        tabuleiro = new Tabuleiro();
        //normaliza p tabuleiro de acordo com todas as posições deixando com valor de -1(onde não tem peças), será util em Tabuleiro
        for (int i = 0; i < posicoesY.length; i++) {
            posicoesY[i] = -1;
        }
        for (int i = 0; i < 5; i++) {
            //se aleatorio for verdadeiro, gerará a primeira população aleatoriamente
            if (rainhasAleatorias) {
                posicoesY[gerarXAleatorioExclusivo()] = this.gerarYAleatorioExclusivo();
                tabuleiro.atualizaTabuleiro(posicoesY);
            }
        }
        if (rainhasAleatorias) {
            geraAptidao();
        }
    }

    //Gera aleatóriamente um valor de Y sem colisões
    public int gerarYAleatorioExclusivo() {
        int y;
        Random r;
        boolean encontrou;

        do {
            r = new Random();
            y = r.nextInt(8);
            encontrou = false;

            for (int i = 0; i < 8; i++) {
                if (posicoesY[i] == y) {
                    encontrou = true;
                    break;
                }
            }

        } while (encontrou);

        return y;
    }

    //Gera aleatóriamente um valor de X sem colisões
    public int gerarXAleatorioExclusivo() {
        int y;
        Random r;
        boolean encontrou;

        do {
            r = new Random();
            y = r.nextInt(8);
            encontrou = false;

            for (int i = 0; i < 8; i++) {
                if (posicoesY[y] == i) {
                    encontrou = true;
                    break;
                }
            }

        } while (encontrou);

        return y;
    }

    //Gera a aptidão baseado no número de colisões

    public void geraAptidao() {
        this.colisoes = geraColisoes();
        this.aptidao = colisoes;
    }

    //adiciona uma rainha no tabuleiro
    public void addRainha(int x, int y) {
        Random r = new Random();
        if (r.nextDouble() < Algoritimo.getTaxaDeMutacao()) {
            y = gerarYAleatorioExclusivo();
        }
        posicoesY[x] = y;
        tabuleiro.atualizaTabuleiro(posicoesY);
    }

    public double getAptidao() {
        return aptidao;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getColisoes() {
        return colisoes;
    }

    public int geraColisoes() {
        int x = 0;
        int y = 0;
        int tempx = 0;
        int tempy = 0;

        int conflicts = 0;
        /*
         posição 0 - superior esquerdo
         posição 1 - inferior direito
         posição 2 - inferior esquerdo
         posição 3 - superior direito
         */
        int dx[] = new int[]{-1, 1, -1, 1};
        int dy[] = new int[]{-1, 1, 1, -1};
        boolean done;

        //Checa na horizontal
        for (int i = 0; i < 8; i++) {
            y = posicoesY[i];
            if (y != -1) {
                for (int j = 0; j < 8; j++) {
                    if (posicoesY[j] == y && j != i) {
                        conflicts++;
                    }
                }
            }
        }

        //Checa nas diagonais
        for (int i = 0; i < 8; i++) {
            x = i;
            y = this.posicoesY[i];
            if (y != -1) {
                for (int j = 0; j <= 3; j++) {
                    tempx = x;
                    tempy = y;
                    done = false;
                    while (!done) {
                        tempx += dx[j];
                        tempy += dy[j];
                        if ((tempx < 0 || tempx >= 8) || (tempy < 0 || tempy >= 8)) {
                            done = true;
                        } else {
                            if (tabuleiro.getTabuleiro()[tempx][tempy]) {
                                conflicts++;
                            }
                        }
                    }
                }
            }
        }

        return conflicts;
    }

    public int[] getPosicoesY() {
        return posicoesY;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 8; i++) {
            s += "[" + i + "," + posicoesY[i] + "] ";
        }
        return s;
    }
}
