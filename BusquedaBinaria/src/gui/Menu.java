package gui;

//Elementos Graficos
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
//Eventos
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
//Controlador
import controllers.NumbersController;

public class Menu extends JFrame implements ActionListener {
    
    private JTextField inputMaxSize;
    private JButton btnGraficar;
    private JLabel txtInitialSize,txtMaxSize,txtTitle;
    private final int WIDTH,HEIGTH;
    
    private JPanel tablero;
    private Grafica graficador;
    
    private NumbersController controller;
    
    public Menu(){
        WIDTH = 1200;
        HEIGTH = 600;
        
        inputMaxSize = new JTextField();
        btnGraficar = new JButton("Graficar");
        txtTitle = new JLabel("Dimensiones de la serie de arreglos");
        txtInitialSize = new JLabel("Tamaño minimo de la serie: ");
        txtMaxSize = new JLabel("Tamaño Maximo de la serie: ");
        
        graficador = new Grafica("Busqueda Binaria", "Tamaño de los arreglos", "Operaciones elementales");
        
        controller = new NumbersController();
       
    }
    
    public void initTemplate(){
        setLayout(null);
        setSize(new Dimension(WIDTH,HEIGTH));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        
    
    }
    
    public void initComponents(){
        controller.initComponents();
        //graficador.crearGrafica("", controller.getRangeX(), controller.getRangeY());
        
        tablero = graficador.getGrafica();
        tablero.setSize(new Dimension(WIDTH,400));
        tablero.setLocation(0, 0);
        getContentPane().add(tablero);
        
        txtTitle.setSize(new Dimension(300,20));
        txtTitle.setFont(new Font("Arial", Font.BOLD,15));
        txtTitle.setLocation(50, 420);
        add(txtTitle);
        
        txtInitialSize.setSize(new Dimension(300,20));
        txtInitialSize.setLocation(30, 460);
        txtInitialSize.setFont(new Font("Arial", Font.BOLD,15));
        add(txtInitialSize);
        
        txtMaxSize.setSize(new Dimension(300,20));
        txtMaxSize.setLocation(30,500);
        txtMaxSize.setFont(new Font("Arial", Font.BOLD,15));
        add(txtMaxSize);
        
        inputMaxSize.setSize(new Dimension(50,20));
        inputMaxSize.setLocation(250, 500);
        inputMaxSize.setHorizontalAlignment(JLabel.CENTER);
        add(inputMaxSize);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
