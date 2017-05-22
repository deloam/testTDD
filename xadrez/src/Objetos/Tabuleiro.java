package Objetos;

//Define um tabuleiro de dimensão 8x8
public class Tabuleiro {

    public boolean[][] tabuleiro;

    public Tabuleiro() {

        tabuleiro = new boolean[8][8];
        zeraTabuleiro();
    }
//normaliza todo o tabuleiro para falso, será usado isso em TabuleiroVisual, na hora dos prints

    public void zeraTabuleiro() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tabuleiro[x][y] = false;
            }
        }
    }
// pega valor -1 definido em Rainha, onde é -1 = não tem peça(se valor for diferente de -1 então tabuleiro[X][Y] = true

    public void atualizaTabuleiro(int posicoesY[]) {
        zeraTabuleiro();
        for (int i = 0; i < 8; i++) {
            if (posicoesY[i] != -1) {
                tabuleiro[i][posicoesY[i]] = true;
            }
        }
    }

    public boolean[][] getTabuleiro() {
        return tabuleiro;
    }
//procura uma dada posição X e Y e retorna false de no tabuleiro for true(aonde é true quer dizer q tem peça ali
    // e então não está livre retornando falso

    public boolean estaLivre(int x, int y) {
        boolean livre = true;
        if (tabuleiro[x][y]) {
            livre = false;
        }
        return livre;
    }

    @Override
    public String toString() {
        String r = "";
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tabuleiro[x][y]) {
                    r += " x";
                } else {
                    r += " o";
                }
            }
            r += "\n";
        }
        return r;
    }
}
