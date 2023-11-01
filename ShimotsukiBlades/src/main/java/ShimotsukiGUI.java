import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ShimotsukiGUI extends JFrame {

    JLabel linha1,linha2;
    GravadorDeDados gravador = new GravadorDeDados();
    ImageIcon katanas = new ImageIcon("./imgs/katans.jpg");

    ShimotsukiInterface shimotsuki = new ShimotsukiShop();
    JMenuBar barraDeMenu = new JMenuBar();

    public ShimotsukiGUI(){
        setTitle("Shimotsuki Blades");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);

        linha1 = new JLabel("Shimotsuki Blades", JLabel.CENTER);
        linha1.setForeground(Color.GREEN);
        linha1.setFont(new Font("Serif",Font.BOLD,24));
        linha2 = new JLabel(katanas, JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarEspada = new JMenuItem(
                "Cadastrar Espada");
        menuCadastrar.add(menuCadastrarEspada);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarEspada = new JMenuItem(
                "Pesquisar Espada");
        menuPesquisar.add(menuPesquisarEspada);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverEspada = new JMenuItem(
                "Remover Espada");
        menuRemover.add(menuRemoverEspada);
        menuPesquisarEspada.addActionListener(
                new BladeSearchController(shimotsuki,this));
        menuRemoverEspada.addActionListener(
                new BladeRemoveController(shimotsuki,this));
        menuCadastrarEspada.addActionListener(
                new BladeAddController(shimotsuki,this));
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int resp = JOptionPane.showConfirmDialog(null,
                        "Tem certeza de que quer sair e salvar?");
                if (resp == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Salvo.");
                    shimotsuki.salvarDados();
                    System.exit(0);
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame janela = new ShimotsukiGUI();
        janela.setVisible(true);

    }
}
