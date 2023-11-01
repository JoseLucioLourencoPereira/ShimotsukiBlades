import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShimotsukiShop implements ShimotsukiInterface{

    private Map<String,Blade> blades;
    private GravadorDeDados gravador = new GravadorDeDados();

    public ShimotsukiShop () {
        this.blades = new HashMap<>();
        recuperaDados();
    }

    public void salvarDados(){
        try {
            this.gravador.salvarBlades((this.blades));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void recuperaDados(){
        try{
            this.blades = this.gravador.recuperarBlades();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastrarBlade (CategoriaBlade categoria, String nomeDaEspada, LaminaBlade tipoDaLamina, Double preco,
                                   String codigo) throws BladeExistenteException{
        if (blades.containsValue(codigo)){
            throw new BladeExistenteException("ESTA ESPADA JÁ ESTÁ CADASTRADA!");
        }else{
            this.blades.put(codigo,new Blade(categoria,nomeDaEspada,tipoDaLamina,preco,codigo));
            return true;
        }
    }

    @Override
    public boolean removerBlade(String codigo) throws BladeNaoEcontradaException {
        if (this.blades.containsKey(codigo)){
            this.blades.remove(codigo);
            return true;
        }else{
            throw new BladeNaoEcontradaException("ESPADA NÃO EXISTE NO ACERVO!");
        }
    }

    @Override
    public Blade pesquisarBlade(String codigo)throws BladeNaoEcontradaException {
        if (this.blades.containsKey(codigo)){
            return this.blades.get(codigo);
        }else{
            throw new BladeNaoEcontradaException("ESPADA NÃO ENCONTRADA OU NÃO EXISTE NO ACERVO!");
        }
    }

    public Map listaDeBldes (){
        return blades;
    }
}
