package Visual;

import Objetos.Tabuleiro;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

public class TabuleiroVisual extends JPanel {

    private int tamanhoQuadrado = 50;
    private Tabuleiro tabuleiro;
    private final int widthComponent;
    public static boolean cavalo[][] = new boolean[8][8];
    public static int mata = 8;

    public TabuleiroVisual(Tabuleiro tabuleiro, int w) {
        this.tabuleiro = tabuleiro;
        this.widthComponent = w;
        tamanhoQuadrado = (int) widthComponent / 8;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
// ---- para posições do cavalo e rainha
        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
// --- serve para colocar realmente o cavalo por ultimo
        boolean tiraErro = false;
        int cont = 0;
        for (int y = 0; y < 8; y++) {

            cont++;
            for (int x = 0; x < 8; x++) {
                cavalo[x][y] = false;
                if (cont % 2 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                cont++;
                g.fillRect(tamanhoQuadrado * x, tamanhoQuadrado * y, tamanhoQuadrado, tamanhoQuadrado);
            }
        }
        // pinta nas damas
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tabuleiro.getTabuleiro()[x][y]) {
                    cavalo[x][y] = true;
                    xx.add(x);
                    yy.add(y);
                    g.setColor(Color.RED);
                    g.fillOval(tamanhoQuadrado * x, tamanhoQuadrado * y, tamanhoQuadrado, tamanhoQuadrado);
                }
            }
        }
        //pinta onde pode ter possiveis colições mano (vertical e horizontal)
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (!tabuleiro.estaLivre(x, y)) {
                    tiraErro = true;
                    //vertical
                    for (int k = 0; k < 8; k++) {
                        cavalo[x][k] = true;
                        g.setColor(Color.RED);
                        g.fillRect(tamanhoQuadrado * x + 20, tamanhoQuadrado * k + 20, tamanhoQuadrado / 2, tamanhoQuadrado / 2);
                    }
                    //horizontal
                    for (int k = 0; k < 8; k++) {
                        cavalo[k][y] = true;
                        g.setColor(Color.red);
                        g.fillRect(tamanhoQuadrado * k + 20, tamanhoQuadrado * y + 20, tamanhoQuadrado / 2, tamanhoQuadrado / 2);
                    }
                }
            }
        }
        //------ pinta onde pode ter colicoes nas diagonais -----//
      
        int tempx = 0;
        int tempy = 0;
        /*
         posição 0 - superior esquerdo
         posição 1 - inferior direito
         posição 2 - inferior esquerdo
         posição 3 - superior direito
         */
        int dx[] = new int[]{-1, 1, -1, 1};
        int dy[] = new int[]{-1, 1, 1, -1};

        boolean pare;
        //Checa nas diagonais
        if (tiraErro) {
            for (int i = 0; i < xx.size(); i++) {
                for (int d = 0; d <= 3; d++) {
                    tempx = xx.get(i);
                    tempy = yy.get(i);
                    pare = false;
                    while (!pare) {
                        tempx += dx[d];
                        tempy += dy[d];
                        if ((tempx < 0 || tempx >= 8) || (tempy < 0 || tempy >= 8)) {
                            pare = true;
                        } else {
                            if (!tabuleiro.getTabuleiro()[tempx][tempy]) {
                                cavalo[tempx][tempy] = true;
                                g.setColor(Color.red);
                                g.fillRect(tamanhoQuadrado * tempx + 20, tamanhoQuadrado * tempy + 20, tamanhoQuadrado / 2, tamanhoQuadrado / 2);
                            }
                        }
                    }
                }
            }
            xx.clear();
            yy.clear();
        }
        //------------ Pinta o Cavalo (Vai no Cavalinho ---------- / /

        boolean kk = true;
        // x - vertical
        // y - horizontal
        int cx[] = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int cy[] = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        //pega todas as posições possiveis que o cavalo pode está, em X e Y
        if (tiraErro && kk) {
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (!cavalo[x][y]) {
                        xx.add(x);
                        yy.add(y);
                    }
                }
            }
            mata = 8;
            //verifica se pode ter possiveis colioes do cavalo com as rainhas
            for (int i = 0; i < xx.size(); i++) {
                for (int j = 0; j < 8; j++) {
                    tempx = xx.get(i);
                    tempy = yy.get(i);
                    tempx += cx[j];
                    tempy += cy[j];
                    if ((tempx < 0 || tempx >= 8) || (tempy < 0 || tempy >= 8)) {
                        mata--;
                    } else {
                        if (tabuleiro.estaLivre(tempx, tempy)) {
                            mata--;
                        }
                    }
                }
                if (mata == 0) {
                    g.setColor(Color.BLUE);
                    g.fillOval(tamanhoQuadrado * xx.get(i), tamanhoQuadrado * yy.get(i), tamanhoQuadrado, tamanhoQuadrado);
                    xx.clear();
                    kk = false;
                } else {
                    mata = 8;
                }
            }
            if (mata > 0) {
                // mata=8;
            }
        }

    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        tamanhoQuadrado = (int) widthComponent / 8;
        paintComponent(super.getGraphics());
    }
}
