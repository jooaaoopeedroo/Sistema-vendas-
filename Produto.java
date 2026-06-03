public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void diminuirEstoque(int qtd) {
        this.estoque -= qtd;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " | R$ " + preco + " | Estoque: " + estoque;
    }
}