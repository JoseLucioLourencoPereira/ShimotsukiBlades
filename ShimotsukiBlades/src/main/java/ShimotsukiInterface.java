public interface ShimotsukiInterface {

    public boolean cadastrarBlade(CategoriaBlade categoria, String nomeDaEspada, LaminaBlade tipoDaLamina, Double preco, String codigo) throws BladeExistenteException;

    public boolean removerBlade (String codigo) throws BladeNaoEcontradaException;

    public Blade pesquisarBlade(String codigo) throws BladeNaoEcontradaException;
    public void salvarDados();
    public void recuperaDados();

}
