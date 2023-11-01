import java.io.Serializable;
import java.util.Objects;

public class Blade implements Serializable {

    private CategoriaBlade categoria;
    private String nomeDaEspada;
    private LaminaBlade tipoDaLamina;
    private Double preco;
    private String codigo;


    public Blade (CategoriaBlade categoria, String nomeDaEspada, LaminaBlade tipoDaLamina, Double preco, String codigo){

        this.categoria = categoria;
        this.nomeDaEspada = nomeDaEspada;
        this.tipoDaLamina = tipoDaLamina;
        this.preco = preco;
        this.codigo = codigo;

    }

    public CategoriaBlade getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBlade categoria) {
        this.categoria = categoria;
    }

    public String getNomeDaEspada() {
        return nomeDaEspada;
    }

    public void setNomeDaEspada(String nomeDaEspada) {
        this.nomeDaEspada = nomeDaEspada;
    }

    public LaminaBlade getTipoDaLamina() {
        return tipoDaLamina;
    }

    public void setTipoDaLamina(LaminaBlade tipoDaLamina) {
        this.tipoDaLamina = tipoDaLamina;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blade blade = (Blade) o;
        return categoria == blade.categoria && Objects.equals(nomeDaEspada, blade.nomeDaEspada) && tipoDaLamina == blade.tipoDaLamina && Objects.equals(preco, blade.preco) && Objects.equals(codigo, blade.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, nomeDaEspada, tipoDaLamina, preco, codigo);
    }

    public String toString(){
        return "CATEGORIA: " + this.categoria + "\nNOME DA ESPADA: " + this.nomeDaEspada + "\nTIPO DA LÂMINA: " + this.tipoDaLamina +
                "\nPREÇO: " + this.preco + "\nCÓDIGO: " + this.codigo;
    }
}
