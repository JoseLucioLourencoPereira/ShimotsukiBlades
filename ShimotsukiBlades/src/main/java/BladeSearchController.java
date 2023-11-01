import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BladeSearchController implements ActionListener {
    private ShimotsukiInterface shimotsuki;
    private JFrame janelaPrincipal;

    public BladeSearchController (ShimotsukiInterface shimotsuki, JFrame janelaPrincipal){
        this.shimotsuki = shimotsuki;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,"Informe o Código da espada que quer encontrar: ");

        try {
            shimotsuki.pesquisarBlade(codigo);
            JOptionPane.showMessageDialog(janelaPrincipal,shimotsuki.pesquisarBlade(codigo).toString());
        }
        catch (BladeNaoEcontradaException m){
            JOptionPane.showMessageDialog(janelaPrincipal,m.getMessage());
        }
    }
}
