package pt.ulusofona.lp2.paint;

import org.w3c.dom.css.Rect;
import pt.ulusofona.lp2.paint.provided.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AppLauncher {

    static final int WIDTH = 800;  // altura da área pintável
    static final int HEIGHT = 600;  // largura da área pintável

    static java.util.List<Quadrado> quadrados = new ArrayList<>();
    static java.util.List<Rectangulo> rectangulos = new ArrayList<>();

    static void createAndShowGUI() {

        // inicializa a janela do Paint
        JFrame frame = new JFrame("Paint (Episódio 3)");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        // inicializa a área "pintável" do Paint
        Screen screen = new Screen(WIDTH, HEIGHT);
        screen.reset();
        frame.getContentPane().add(screen, BorderLayout.CENTER);

        // inicializa a barra de ferramentas
        JToolBar toolBar = criaBarraFerramentas(frame);

        // crio um botão para adicionar quadrados
        JButton criaQuadradoBtn = new JButton(getIcon("icon_quadrado.png"));
        toolBar.add(criaQuadradoBtn);

        // crio um botão para adicionar rectângulos
        JButton criaRectanguloBtn = new JButton(getIcon("icon_rectangulo.png"));
        toolBar.add(criaRectanguloBtn);

        JButton moveEsquerdaBtn = new JButton(getIcon("icon_left.png"));
        toolBar.add(moveEsquerdaBtn);
        JButton moveDireitaBtn = new JButton(getIcon("icon_right.png"));
        toolBar.add(moveDireitaBtn);
        JButton moveBaixoBtn = new JButton(getIcon("icon_down.png"));
        toolBar.add(moveBaixoBtn);
        JButton moveCimaBtn = new JButton(getIcon("icon_up.png"));
        toolBar.add(moveCimaBtn);

        // mostra no écran o Paint
        frame.pack();
        frame.setVisible(true);

        // define o que acontece quando se carrega no botão "criaQuadradoBtn"
        criaQuadradoBtn.addActionListener(event -> {

            // gera uma altura aleatória entre 30 e 80
            int altura = (int) (Math.random() * 50) + 30;

            // gera um par do coordenadas aleatórias
            int x = (int) (Math.random() * (WIDTH - altura));
            int y = (int) (Math.random() * (HEIGHT - altura));

            Quadrado quadrado = new Quadrado(x, y, altura, getCorAleatoria());

            quadrados.add(quadrado);

            quadrado.pinta(screen);

            System.out.println("Adicionei " + quadrado);
        });

        // define o que acontece quando se carrega no botão "criaQuadradoBtn"
        criaRectanguloBtn.addActionListener(event -> {

            // gera uma altura aleatória entre 30 e 80
            int altura = (int) (Math.random() * 50) + 30;

            // gera uma largura aleatória entre 30 e 80
            int largura = (int) (Math.random() * 50) + 30;

            // gera um par do coordenadas aleatórias
            int x = (int) (Math.random() * (WIDTH - altura));
            int y = (int) (Math.random() * (HEIGHT - largura));

            Rectangulo rectangulo = new Rectangulo(x, y, altura, largura, getCorAleatoria());

            rectangulos.add(rectangulo);

            rectangulo.pinta(screen);

            System.out.println("Adicionei " + rectangulo);
        });

        // define o que acontece quando se carrega no botão "moveEsquerdaBtn"
        moveEsquerdaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Quadrado quadrado: quadrados) {
                quadrado.moveEsquerda();
                quadrado.pinta(screen);
            }
            for (Rectangulo rectangulo: rectangulos) {
                rectangulo.moveEsquerda();
                rectangulo.pinta(screen);
            }
        });

        // define o que acontece quando se carrega no botão "moveDireitaBtn"
        moveDireitaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Quadrado quadrado: quadrados) {
                quadrado.moveDireita();
                quadrado.pinta(screen);
            }
            for (Rectangulo rectangulo: rectangulos) {
                rectangulo.moveDireita();
                rectangulo.pinta(screen);
            }
        });

        // define o que acontece quando se carrega no botão "moveBaixoBtn"
        moveBaixoBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Quadrado quadrado: quadrados) {
                quadrado.moveBaixo();
                quadrado.pinta(screen);
            }
            for (Rectangulo rectangulo: rectangulos) {
                rectangulo.moveBaixo();
                rectangulo.pinta(screen);
            }
        });

        // define o que acontece quando se carrega no botão "moveCimaBtn"
        moveCimaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Quadrado quadrado: quadrados) {
                quadrado.moveCima();
                quadrado.pinta(screen);
            }
            for (Rectangulo rectangulo: rectangulos) {
                rectangulo.moveCima();
                rectangulo.pinta(screen);
            }
        });

    }

    static JToolBar criaBarraFerramentas(JFrame frame) {
        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.WEST);
        toolBar.setLayout(new GridLayout(10, 1, 0, 5));
        toolBar.setFloatable(false);
        toolBar.setBorderPainted(true);
        toolBar.setMargin(new Insets(10, 5, 10, 5));
        return toolBar;
    }

    static ImageIcon getIcon(String iconName) {
        return new ImageIcon(AppLauncher.class.getResource("/" + iconName));
    }

    // esta função retorna uma côr aleatória
    static Color getCorAleatoria() {
        return new Color(new Random().nextInt(0xFFFFFF));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
