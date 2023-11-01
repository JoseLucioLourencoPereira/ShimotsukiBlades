import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BladeAddController implements ActionListener {
    private ShimotsukiInterface shimotsuki;
    private JFrame janelaPrincipal;

    public BladeAddController(ShimotsukiInterface shimotsuki, JFrame janela){
        this.shimotsuki = shimotsuki;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoriaBlade categoria = null;
        LaminaBlade lamina = null;
        int categoriaBlade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a Categoria da espada ?\n1 - Katana\n" +
                "2 - Sabre\n3 - Claymore\n4 - Jian\n5 - Bastarda\n6 - Xifo\n"));

        switch (categoriaBlade){
            case 1 -> {
                categoria = CategoriaBlade.KATANA;
            }
            case 2 -> {
                categoria = CategoriaBlade.SABRE;
            }
            case 3 ->{
                categoria = CategoriaBlade.CLAYMORE;
            }
            case 4 -> {
                categoria = CategoriaBlade.JIAN;
            }
            case 5 -> {
                categoria = CategoriaBlade.BASTARDA;
            }
            case 6 -> {
                categoria = CategoriaBlade.XIFO;
            }
        }

        String nomeDaEspada = JOptionPane.showInputDialog(janelaPrincipal,"Informe o nome da Espada:\n");
        int tipoDalamina = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Informe o Tipo da Lâmina:\n" +
                "1 - Aço\n2 - Alumínio\n3 - Ferro\n4 - Madeira\n"));

        switch (tipoDalamina){
            case 1 -> {
                lamina = LaminaBlade.ACO;
            }
            case 2 -> {
                lamina = LaminaBlade.ALUMINIO;
            }
            case 3 ->{
                lamina = LaminaBlade.FERRO;
            }
            case 4 -> {
                lamina = LaminaBlade.MADEIRA;
            }
        }

        double preco = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Informe o Preço da Espada:\n"));
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,"Informe o Código da Esapda\n");

        try {
            shimotsuki.cadastrarBlade(categoria,nomeDaEspada,lamina,preco,codigo);
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Espada Cadastrada com sucesso");
        }catch (BladeExistenteException s){
            JOptionPane.showMessageDialog(janelaPrincipal,s.getMessage());
        }
    }
}
