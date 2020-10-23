package gui;

//Elementos Graficos
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Eventos
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
//Controlador
import controllers.NumbersController;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener {

    private JTextField inputMaxSize;
    private JButton btnGraficar;
    private JLabel txtInitialSize, txtMaxSize, txtTitle;
    private final int WIDTH, HEIGTH;

    private JPanel tablero;
    private Grafica graficador;

    private NumbersController controller;

    public Menu() {
        WIDTH = 1200;
        HEIGTH = 600;

        inputMaxSize = new JTextField();
        btnGraficar = new JButton("Graficar");
        txtTitle = new JLabel("Dimensiones de la serie de arreglos");
        txtInitialSize = new JLabel("Tamaño minimo de la serie: ");
        txtMaxSize = new JLabel("Tamaño Maximo de la serie: ");

        graficador = new Grafica("Busqueda Binaria", "N", "OE(N)");

        controller = new NumbersController();

    }

    public void initTemplate() {
        setLayout(null);
        setSize(new Dimension(WIDTH, HEIGTH));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);

    }

    public void initComponents() {

        tablero = graficador.getGrafica();
        tablero.setSize(new Dimension(WIDTH, 400));
        tablero.setLocation(0, 0);
        getContentPane().add(tablero);

        txtTitle.setSize(new Dimension(300, 20));
        txtTitle.setFont(new Font("Arial", Font.BOLD, 15));
        txtTitle.setLocation(50, 420);
        add(txtTitle);

        txtInitialSize.setSize(new Dimension(300, 20));
        txtInitialSize.setLocation(30, 460);
        txtInitialSize.setFont(new Font("Arial", Font.BOLD, 15));
        add(txtInitialSize);

        txtMaxSize.setSize(new Dimension(300, 20));
        txtMaxSize.setLocation(30, 500);
        txtMaxSize.setFont(new Font("Arial", Font.BOLD, 15));
        add(txtMaxSize);

        inputMaxSize.setSize(new Dimension(50, 20));
        inputMaxSize.setLocation(250, 500);
        inputMaxSize.setHorizontalAlignment(JLabel.CENTER);
        add(inputMaxSize);

        btnGraficar.setSize(new Dimension(250, 50));
        btnGraficar.setFont(new Font("Arial", Font.BOLD, 20));
        btnGraficar.setLocation(475, 500);
        btnGraficar.addActionListener(this);
        add(btnGraficar);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == btnGraficar) {
            ArrayList<Double> logx = new ArrayList<>();
            ArrayList<Double> logy = new ArrayList<>();

            int maxSize = 0;
            try {
                maxSize = Integer.parseInt(inputMaxSize.getText());

                for (int j = 1; j < maxSize; j++) {
                    controller.start(j);
                    logx.add(Double.parseDouble(String.valueOf(j)));
                    logy.add((Math.log(j)/Math.log(2)));
                }
                
                graficador.getDatos().removeAllSeries();
                graficador.crearGrafica("Busqueda Binaria", controller.getRangeX(), controller.getRangeY());
                graficador.agregarGrafica("Log base 2", logx, logy);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese Numeros", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
