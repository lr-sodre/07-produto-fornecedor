package br.fiap.main;
import br.fiap.fornecedor.Fornecedor;

public class Main {

    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor("xpto", 1);

        System.out.print(fornecedor.getNome());
        fornecedor.setNome("fiap");
        System.out.print(fornecedor.getNome());




    }
}
