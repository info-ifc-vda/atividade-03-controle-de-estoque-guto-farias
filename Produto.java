public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private int estoqueMinimo;

    public Produto(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinimo) {
        this.codigo = codigo;
        this.nome = nome;
        setPreco(preco); // usar setter para garantir que o preço não seja negativo
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            this.preco = 0.0;
        } else {
            this.preco = preco;
        }
    }

    public void aplicarDesconto(double percentual) {
        if (percentual <= 0 || percentual > 50) {
            System.out.println("Desconto inválido. Deve ser entre 0 e 50%.");
            return;
        }
        double novoPreco = preco - (preco * (percentual / 100));
        setPreco(novoPreco);
        System.out.println("Desconto de " + percentual + "% aplicado. Novo preço: R$ " + preco);
    }

    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente. Estoque atual: " + quantidadeEstoque);
            return;
        }

        quantidadeEstoque -= quantidade;
        System.out.println("Venda realizada! Restam " + quantidadeEstoque + " unidades.");

        // Verifica se estoque ficou baixo
        if (verificarEstoqueBaixo()) {
            System.out.println("Atenção: Estoque abaixo do mínimo!");
        }
    }

    public void repor(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para reposição.");
            return;
        }
        quantidadeEstoque += quantidade;
        System.out.println("Reposição realizada. Novo estoque: " + quantidadeEstoque);
    }

    private boolean verificarEstoqueBaixo() {
        return quantidadeEstoque < estoqueMinimo;
    }

    public void exibirInfo() {
        System.out.println("\n=== Detalhes do Produto ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Estoque mínimo: " + estoqueMinimo);
        System.out.println("============================");
    }
}
