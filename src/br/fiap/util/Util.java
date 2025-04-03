package br.fiap.util;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Util {
    private Produto produto[] = new Produto[2];
    private Fornecedor[] fornecedor = new Fornecedor[2];
    private int indxProduto = 0;
    private int indxFornecedor = 0;

    public void menu(){
        int opcao;
        String msg = "1. Cadastrar produto\n2. Pesquisar produto por nome\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar";

        while(true){
            opcao = parseInt(showInputDialog(msg));
            if (opcao == 4){
                return; //para o método
            }
            switch (opcao){
                case 1: cadastrarProduto();
                break;
                case 2: pesquisarProduto();
                break;
                case 3: pesquisarFornecedor();
                break;
                default: showInputDialog(null, "Opção inválida!");
            }
        }



    }

    private void cadastrarProduto() {
       String nome;
       int qtdEstoque;
       double valorUnitario;
       Fornecedor fornecedor = pesquisarFornecedor();

       if (fornecedor == null) {
           fornecedor = cadastrarFornecedor();
       }
       nome = showInputDialog("Nome do produto");
       qtdEstoque = parseInt(showInputDialog("Quantidade em esqtoque"));
       valorUnitario = parseDouble(showInputDialog("Valor unitário"));
       produto[indxProduto] = new Produto(nome, valorUnitario, fornecedor, qtdEstoque);
       indxProduto++;
    }

    private Fornecedor cadastrarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor"));
        String nome = showInputDialog("Nome do fornecedor");
        fornecedor[indxFornecedor] = new Fornecedor(nome, cnpj);
        indxFornecedor++;
        return fornecedor[indxFornecedor-1];
    }

    private void pesquisarProduto(){
        String aux = "Produto não encontrado";
        String nome = showInputDialog("Nome do produto");

        for (int i=0; i<indxProduto; i++){

            if (produto[i].getNome().equalsIgnoreCase(nome)){
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário do produto: " + produto[i].getValor() + "\n";
                aux += "Fornecedor do produto: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null, aux);
    }

    private Fornecedor pesquisarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor"));

        for (int i=0; i<indxFornecedor; i++){
            if (fornecedor[i].getCnpj() == cnpj){
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "CNPJ não cadastrado");
        return null;
    }


}

