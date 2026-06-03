import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itens = new ArrayList<>();
    private double total;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
        total += item.getSubtotal();
    }

    public Cliente getCliente() { return cliente; }
    public double getTotal() { return total; }
    public List<ItemVenda> getItens() { return itens; }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + " | Total: R$ " + total;
    }
}