import models.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        boolean sair = false;

        do {
            System.out.println("[1]- Cadastrar Produto");
            System.out.println("[2]- Listar Produtos");
            System.out.println("[0]- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("##### Cadastro de Produto #####");
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor do produto: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Disponível para venda (sim/não): ");
                    boolean disponivel = scanner.nextLine().equalsIgnoreCase("sim");

                    produtos.add(new Produto(nome, descricao, valor, disponivel));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("##### Lista de Produtos #####");
                    produtos.stream()
                            .sorted(Comparator.comparingDouble(Produto::getValor))
                            .forEach(System.out::println);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!sair);
    }
}