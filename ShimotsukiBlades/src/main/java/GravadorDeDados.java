
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_BLADES = "blades.dat";

    public HashMap<String, Blade> recuperarBlades() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_BLADES));
            return (HashMap<String, Blade>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os dados");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_BLADES);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarBlades(Map<String, Blade> blades) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BLADES));
            out.writeObject(blades);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os contatos no arquivo "+ARQUIVO_BLADES);
        }
    }
}
