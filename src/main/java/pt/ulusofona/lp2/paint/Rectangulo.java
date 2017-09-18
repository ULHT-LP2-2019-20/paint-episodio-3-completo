package pt.ulusofona.lp2.paint;

import pt.ulusofona.lp2.paint.provided.Screen;

import java.awt.*;

public class Rectangulo {

    int x, y;   // coordenadas do canto superior esquerdo
    int altura, largura;
    Color cor;

    Rectangulo(int x, int y, int altura, int largura, Color cor) {
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
    }

    void moveCima() {
        if (this.y > 0) {
            this.y--;
        }
    }

    void moveBaixo() {
        if (this.y < AppLauncher.HEIGHT - altura) {
            this.y++;
        }
    }

    void moveEsquerda() {
        if (this.x > 0) {
            this.x--;
        }
    }

    void moveDireita() {
        if (this.x < AppLauncher.WIDTH - altura) {
            this.x++;
        }
    }

    void pinta(Screen screen) {

        for (int posX = x; posX < x + largura; posX++) {
            for (int posY = y; posY < y + altura; posY++) {
                screen.drawPixel(posX, posY, cor);
            }
        }
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "x=" + x +
                ", y=" + y +
                ", altura=" + altura +
                ", largura=" + largura +
                ", cor=" + cor +
                '}';
    }
}
