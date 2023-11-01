import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShimotsukiTest {
    @Test
    public void testaCadastroEPesquisa(){
        try {
            ShimotsukiShop shimotsuki = new ShimotsukiShop();
            shimotsuki.recuperaDados();
            assertTrue(shimotsuki.listaDeBldes().isEmpty());
            shimotsuki.cadastrarBlade(CategoriaBlade.KATANA,"Sandai Kitetsu",LaminaBlade.ACO,100.0,"001");
            assertEquals("001",shimotsuki.pesquisarBlade("001").getCodigo());
        }catch (BladeExistenteException | BladeNaoEcontradaException e){
            System.out.println("não deveria lançar exceção");
        }
    }
    @Test
    public void testaRemovedor (){
        try {
            ShimotsukiShop shimotsuki = new ShimotsukiShop();
            shimotsuki.recuperaDados();
            assertTrue(shimotsuki.listaDeBldes().isEmpty());
            shimotsuki.cadastrarBlade(CategoriaBlade.KATANA,"Sandai Kitetsu",LaminaBlade.ACO,100.0,"001");
            assertEquals("001",shimotsuki.pesquisarBlade("001").getCodigo());
            assertTrue(shimotsuki.removerBlade("001"));
            assertTrue(shimotsuki.listaDeBldes().isEmpty());
        }catch (BladeExistenteException | BladeNaoEcontradaException e){
            System.out.println("não deveria lançar exceção");
        }
    }

    @Test
    public void testaGravacao() throws BladeExistenteException, BladeNaoEcontradaException {
        File f = new File(GravadorDeDados.ARQUIVO_BLADES);
        if (f.exists()){
            f.delete();
        }
        ShimotsukiShop shimotsuki = new ShimotsukiShop();
        shimotsuki.recuperaDados();
        shimotsuki.cadastrarBlade(CategoriaBlade.KATANA,"Sandai Kitetsu",LaminaBlade.ACO,100.0,"001");
        shimotsuki.salvarDados();
        assertEquals("001",shimotsuki.pesquisarBlade("001").getCodigo());
        assertTrue(f.exists());
        f.delete();
    }

}
