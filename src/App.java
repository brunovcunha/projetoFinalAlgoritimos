
// Descrição: Classe principal do projeto
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Jogos> jogosEstoque = new ArrayList<>();
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println(" _____           _____\n" +
                "|_   _|         |  __ \\\n" +
                "  | | ___  _ __ | |  \\/ __ _ _ __ ___   ___  ___\n" +
                "  | |/ _ \\| '_ \\| | __ / _` | '_ ` _ \\ / _ \\/ __|\n" +
                "  | | (_) | |_) | |_\\ \\ (_| | | | | | |  __/\\__ \\\n" +
                "  \\_/\\___/| .__/ \\____/\\__,_|_| |_| |_|\\___||___/\n" +
                "          | |  Inicializador de gerenciamento\n" +
                "          |_|\n");
        Thread.sleep(2000);
        menu();
    }

    public static void menu() {
        System.out.println("---Gerenciamento TopGames---");
        System.out.println("1-Estoque de jogos");
        System.out.println("2-Vendas");
        System.out.println("3-Relatórios");
        System.out.println("4- Sair");
        int n = s.nextInt();

        while (n != 4) {

            switch (n) {
                case 1:
                    System.out.println("---Estoque jogos---");
                    System.out.print(
                            "\n 1- Cadastrar jogo\n 2- Adicionar jogo\n 3- Remover jogo\n 4- Pesquisar Jogo\n 5- Sair\n");
                    int menJogos = s.nextInt();

                    while (menJogos != 5) {
                        switch (menJogos) {
                            case 1:
                                cadastrarJogo();
                                break;
                            case 2:
                                addJogo();
                                break;

                            case 3:
                                removerJogo();
                                break;
                            case 4:

                                break;
                        }
                        System.out.println("---Estoque jogos---");
                        System.out.print(
                                "\n 1- Cadastrar jogo\n 2- Adicionar jogo\n 3- Remover jogo\n 4- Pesquisar Jogo\n 5- Sair\n");
                        menJogos = s.nextInt();
                    }
                    break;

                case 2:
                    System.out.println("---Vendas---");
                    System.out.print("\n 1- Cadastrar venda\n 2- Alterar venda\n 3- Remover venda\n 4- voltar\n");
                    int menVendas = s.nextInt();

                    while (menVendas != 4) {
                        switch (menVendas) {
                            case 1:

                                break;

                            case 2:

                                break;

                            case 3:

                                break;
                        }
                        System.out.println("---Vendas---");
                        System.out.print("\n 1- Cadastrar venda\n 2- Alterar venda\n 3- Remover venda\n 4- voltar\n");
                        menVendas = s.nextInt();
                    }
                    break;

                case 3:
                    System.out.println("---Relatórios---");
                    System.out.print("\n 1- Listar Jogos\n 2- Listar Vendas\n 3- Listar estoque\n 4- voltar\n");
                    int menRelatorios = s.nextInt();

                    while (menRelatorios != 4) {
                        switch (menRelatorios) {
                            case 1:

                                break;

                            case 2:

                                break;

                            case 3:

                                break;
                        }
                        System.out.println("---Relatórios---");
                        System.out.print("\n 1- Listar Jogos\n 2- Listar Vendas\n 3- Listar estoque\n 4- voltar\n");
                        menRelatorios = s.nextInt();
                    }
                    break;
            }
            System.out.println("---Gerenciamento TopGames---");
            System.out.println("1-Estoque de jogos");
            System.out.println("2-Vendas");
            System.out.println("3-Relatórios");
            System.out.println("4- Sair");
            n = s.nextInt();
        }
    }

    public static void cadastrarJogo() {
        System.out.println("-----Cadastro-----");
        System.out.println("Deseja cadastrar um novo jogo?(s/n)");
        String op = s.next();
        s.nextLine();
        while (op.equals("s")) {
            Jogos jogo = new Jogos();

            System.out.println("Digite o nome: ");
            jogo.setNomeJogo(s.nextLine());
            System.out.println("Digite o gênero: ");
            jogo.setGenero(s.nextLine());
            System.out.println("Digite a plataforma: ");
            jogo.setPlataforma(s.nextLine());
            System.out.println("Digite a classificação: ");
            jogo.setClassificacao(s.nextLine());
            System.out.println("Digite a desenvolvedora: ");
            jogo.setDesenvolvedora(s.nextLine());
            System.out.println("Digite o preço: ");
            jogo.setPreco(s.nextDouble());
            System.out.println("Digite a quantidade: ");
            jogo.setQuantidade(s.nextInt());

            jogosEstoque.add(jogo);

            System.out.println("Deseja cadastrar um novo jogo?(s/n)");
            op = s.next();
            s.nextLine();
        }
    }
    public static void addJogo() {
        s.nextLine(); 
    
        String op = "s";
        while (op.equals("s")) {
            System.out.println("Qual jogo deseja adicionar?");
            String nomeJogo = s.nextLine();
    
            boolean add = false;
    
            for (Jogos jogo : jogosEstoque) {
                if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                    System.out.println();
                    System.out.println(jogo.getNomeJogo());
                    System.out.println(jogo.getQuantidade() + " unds em estoque");
                    add = true;
                    break;
                }
            }
    
            if (!add) {
                System.out.println(nomeJogo + " não foi encontrado");
                break;
            }
    
            System.out.println("Quantas unidades deseja adicionar?");
            int unidades;
            try {
                unidades = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido para a quantidade.");
                continue;
            }
    
            System.out.println("Adicionar " + unidades + " unidades ao jogo " + nomeJogo + "? (s/n)");
            op = s.next();
            s.nextLine(); 
    
            switch (op) {
                case "s":
                    for (Jogos jogo : jogosEstoque) {
                        if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                            System.out.println("Jogo: " + jogo.getNomeJogo() + " adicionado com sucesso!");
                            jogo.setQuantidade(jogo.getQuantidade() + unidades);
                            System.out.printf("Quantidade atual de %s = %d\n", jogo.getNomeJogo(),
                                    jogo.getQuantidade());
                            break;
                        }
                    }
                    break;
                case "n":
                    System.out.println("Operação cancelada");
                    break;
                default:
                    break;
            }
    
            System.out.println("Deseja adicionar outro jogo?(s/n)");
            op = s.next();
            s.nextLine(); 
        }
    }
    
    

    public static void removerJogo() {
        s.nextLine();
        String op = "s";

        while (op.equals("s")) {
            System.out.println("Lista de jogos");
            for (Jogos jogo : jogosEstoque) {
                System.out.println(jogo.getNomeJogo());
            }
            System.out.println("Qual jogo deseja remover?");
            String nomeJogo = s.nextLine();
            boolean removido = false;

            for (Jogos jogo : jogosEstoque) {
                if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                    System.out.println("\n" + jogo.getNomeJogo() + " foi removido");
                    jogosEstoque.remove(jogo);
                    removido = true;
                    break;
                }
            }

            if (!removido) {
                System.out.println(nomeJogo + " não foi encontrado");
            }

            System.out.println("Deseja remover outro jogo?(s/n)");
            op = s.next();
            s.nextLine();
        }
    }
}
