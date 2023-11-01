import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BladeRemoveController implements ActionListener {
    private ShimotsukiInterface shimotsuki;
    private JFrame janelaPrincipal;

    public BladeRemoveController(ShimotsukiInterface shimotsuki, JFrame janelaPrincipal){
        this.shimotsuki = shimotsuki;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,"Qual o Codigo da Espada que irá ser removida?");

        try{
            shimotsuki.removerBlade(codigo);

            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Espada removida com sucesso");
        }
        catch (BladeNaoEcontradaException m){
            JOptionPane.showMessageDialog(janelaPrincipal,m.getMessage());
        }
    }
}
