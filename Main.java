import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            System.out.println("\n===== SISTEMA DE VENDAS =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Listar Clientes");
            System.out.println("5 - Realizar Venda");
            System.out.println("6 - Listar Vendas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();

                    boolean ok = sistema.adicionarProduto(
                        new Produto(codigo, nome, preco, estoque)
                    );

                    System.out.println(ok ? "Produto cadastrado!" : "Código já existe!");
                    break;

                case 2:
                    for (Produto p : sistema.listarProdutos()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("CPF (11 dígitos): ");
                    String cpf = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeC = sc.nextLine();

                    boolean okC = sistema.adicionarCliente(new Cliente(cpf, nomeC));
                    System.out.println(okC ? "Cliente cadastrado!" : "CPF inválido ou já existe!");
                    break;

                case 4:
                    for (Cliente c : sistema.listarClientes()) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.print("CPF cliente: ");
                    String cpfV = sc.nextLine();
                    System.out.print("Código produto: ");
                    String codV = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();

                    System.out.println(sistema.realizarVenda(cpfV, codV, qtd));
                    break;

                case 6:
                    for (var v : sistema.listarVendas()) {
                        System.out.println(v);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;
            }
        }
    }
}