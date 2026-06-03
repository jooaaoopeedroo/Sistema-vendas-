import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    // ===== PRODUTOS =====
    public boolean adicionarProduto(Produto p) {
        if (buscarProdutoPorCodigo(p.getCodigo()) != null) return false;
        produtos.add(p);
        return true;
    }

    public Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    // ===== CLIENTES =====
    public boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public boolean adicionarCliente(Cliente c) {
        if (!validarCPF(c.getCpf())) return false;
        if (buscarClientePorCPF(c.getCpf()) != null) return false;
        clientes.add(c);
        return true;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    // ===== VENDAS =====
    public String realizarVenda(String cpfCliente, String codigoProduto, int qtd) {
        Cliente cliente = buscarClientePorCPF(cpfCliente);
        Produto produto = buscarProdutoPorCodigo(codigoProduto);

        if (cliente == null) return "Cliente não encontrado";
        if (produto == null) return "Produto não encontrado";
        if (qtd <= 0) return "Quantidade inválida";
        if (produto.getEstoque() < qtd) return "Estoque insuficiente";

        Venda venda = new Venda(cliente);
        ItemVenda item = new ItemVenda(produto, qtd);

        venda.adicionarItem(item);
        produto.diminuirEstoque(qtd);

        vendas.add(venda);

        return "Venda realizada com sucesso! Total: R$ " + venda.getTotal();
    }

    public List<Venda> listarVendas() {
        return vendas;
    }

    public List<Venda> vendasPorCliente(String cpf) {
        List<Venda> resultado = new ArrayList<>();
        for (Venda v : vendas) {
            if (v.getCliente().getCpf().equals(cpf)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}