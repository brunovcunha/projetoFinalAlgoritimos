
// Descrição: Classe principal do projeto
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
  public static List<Jogos> jogosEstoque = new ArrayList<>();
  public static List<Venda> vendas = new ArrayList<>();
  public static HashMap<String, List<Jogos>> jogosGenero = new HashMap<>();

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

    Jogos jogo01;
    jogo01 = new Jogos("God of War", "Ação", "PS4", "18+", "Santa Monica Studios", 59.99, 5);;

    jogosEstoque.add(jogo01);
    
    menu();
  }

  // Menu principal que chama os submenus
  public static void menu() {
    int n;

    do {
      System.out.println("---Gerenciamento TopGames---");
      System.out.println("1-Estoque de jogos");
      System.out.println("2-Vendas");
      System.out.println("3-Relatórios");
      System.out.println("4- Sair");
      n = s.nextInt();
      s.nextLine();

      switch (n) {
        case 1:
          menuEstoque();
          break;

        case 2:
          menuVendas();
          break;

        case 3:
          menuRelatorios();
          break;
      }
    } while (n != 4);

    System.out.println("Saindo...");
  }

  // Sub-menu estoque
  public static void menuEstoque() {
    System.out.println("---Estoque jogos---");
    System.out.print(
        "\n 1- Cadastrar jogo\n 2- Gerenciar Estoque\n 3- Apagar jogo\n 4- Pesquisar Jogo\n 5- Voltar\n");
    int menJogos = s.nextInt();

    switch (menJogos) {
      case 1:
        cadastrarJogo();
        break;
      case 2:
        gerenciarEstoque();
        break;
      case 3:
        apagarJogo();
        break;
      case 4:
        pesquisarJogo();
        break;

      case 5:
        return;
    }
  }

  // Sub-menu vendas
  public static void menuVendas() {
    System.out.println("---Vendas---");
    System.out.print("\n 1- Cadastrar venda\n 2- Alterar venda\n 3- Remover venda\n 4- voltar\n");
    int menVendas = s.nextInt();
    switch (menVendas) {
      case 1:
      cadastrarVenda();
        break;

      case 2:

        break;

      case 3:

        break;

      case 4:
        return;
    }
  }

  // Sub-menu relatorios
  public static void menuRelatorios() {
    System.out.println("---Relatórios---");
    System.out.print("\n 1- Listar Jogos por Genero\n 2- Listar Vendas\n 3- Listar estoque\n 4- voltar\n");
    int menRelatorios = s.nextInt();
    switch (menRelatorios) {
      case 1:

        break;

      case 2:

        break;

      case 3:

        break;

      case 4:
        return;
    }

  }

  // Funcao responsavel por armazenar um novo jogo no estoque
  public static void cadastrarJogo() {
    System.out.println("-----Cadastro-----");
    System.out.println("Deseja cadastrar um novo jogo?(s/n)");
    String op = s.next();
    s.nextLine();
    while (op.equals("s")) {
      Jogos jogo = new Jogos();

      System.out.print("Digite o nome: ");
      jogo.setNomeJogo(s.nextLine());
      System.out.print("Digite o gênero: ");
      jogo.setGenero(s.nextLine());
      System.out.print("Digite a plataforma: ");
      jogo.setPlataforma(s.nextLine());
      System.out.print("Digite a classificação: ");
      jogo.setClassificacao(s.nextLine());
      System.out.print("Digite a desenvolvedora: ");
      jogo.setDesenvolvedora(s.nextLine());
      System.out.print("Digite o preço: ");
      jogo.setPreco(s.nextDouble());
      System.out.print("Digite a quantidade: ");
      jogo.setQuantidade(s.nextInt());

      jogosEstoque.add(jogo);
      jogosGenero.computeIfAbsent(jogo.getGenero(), k -> new ArrayList<>()).add(jogo);

      System.out.println("Deseja cadastrar um novo jogo?(s/n)");
      op = s.next();
      s.nextLine();
    }
    menuEstoque();
  }

  public static void gerenciarEstoque() {
    System.out.println("-----Gerenciar estoque-----");
    System.out.println("Digite 1 para adicionar ou 2 para remover (1/2)");
    int op = s.nextInt();
    switch (op) {
      case 1:
        addJogo();
        break;
      case 2:
        removerJogo();
        break;
      default:
        System.out.println("Opção inválida");
        menuEstoque();
        break;
    }
  }

  // Funcao responsavel por armazenar quantidades de um jogo existente
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

      if (add == true) {
        System.out.println("Quantas unidades deseja adicionar?");
        int unidades;
        try {
          unidades = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
          System.err.println("Por favor, insira um número válido para a quantidade.");
          continue;
        }

        System.out.println("Adicionar " + unidades + " unidades ao jogo " + nomeJogo + "? (s/n)");
        op = s.next();
        s.nextLine();

        switch (op) {
          case "s":
            for (Jogos jogo : jogosEstoque) {
              if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                System.out.println();
                System.out.println("Jogo: " + jogo.getNomeJogo() + " adicionado com sucesso!");
                jogo.setQuantidade(jogo.getQuantidade() + unidades);
                System.out.printf("Quantidade atual de %s = %d\n", jogo.getNomeJogo(),
                    jogo.getQuantidade());
                System.out.println();
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
      } else {
        if (!add) {
          System.out.println(nomeJogo + " não foi encontrado");
          System.out.println("Deseja adicionar outro jogo?(s/n)");
          op = s.next();
          if (op.equals("s")) {
            addJogo();
          } else {
            menuEstoque();
            break;
          }
        }
        return;
      }
    }
  }

  public static void removerJogo() {
    s.nextLine();

    String op = "s";
    while (op.equals("s")) {
      System.out.println("Qual jogo deseja remover?");
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

      if (add == true) {
        System.out.println("Quantas unidades deseja remover?");
        int unidades;
        try {
          unidades = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
          System.err.println("Por favor, insira um número válido para a quantidade.");
          continue;
        }

        System.out.println("Remover " + unidades + " unidades do jogo " + nomeJogo + "? (s/n)");
        op = s.next();
        s.nextLine();

        switch (op) {
          case "s":
            for (Jogos jogo : jogosEstoque) {
              if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                System.out.println();
                System.out.println("Jogo: " + jogo.getNomeJogo() + " removido com sucesso!");
                jogo.setQuantidade(jogo.getQuantidade() - unidades);
                System.out.printf("Quantidade atual de %s = %d\n", jogo.getNomeJogo(),
                    jogo.getQuantidade());
                System.out.println();
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

        System.out.println("Deseja remover outro jogo?(s/n)");
        op = s.next();
        s.nextLine();
      } else {
        if (!add) {
          System.out.println(nomeJogo + " não foi encontrado");
          System.out.println("Deseja remover outro jogo?(s/n)");
          op = s.next();
          if (op.equals("s")) {
            addJogo();
          } else {
            menuEstoque();
            break;
          }
        }
        return;
      }
    }
  }

  // funcao responsavel por remover um jogo do estoque
  public static void apagarJogo() {
    s.nextLine();
    String op = "s";

    while (op.equals("s")) {
      int cont = 1;
      System.out.println("Lista de jogos");
      for (Jogos jogo : jogosEstoque) {
        System.out.println(cont++ + "- " + jogo.getNomeJogo());
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
    menuEstoque();
  }

  // funcao que retorna dados de um jogo pesquisado
  public static void pesquisarJogo() {
    s.nextLine();
    System.out.println("----Pesquisa Rapida----");
    System.out.print("Nome do jogo: ");

    String nomeJogo = s.nextLine();
    boolean encontrado = false;

    for (Jogos jogo : jogosEstoque) {
      if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
        System.out.println();
        System.out.println("Nome: " + jogo.getNomeJogo());
        System.out.println("Gênero: " + jogo.getGenero());
        System.out.println("Plataforma: " + jogo.getPlataforma());
        System.out.println("Classificação: " + jogo.getClassificacao());
        System.out.println("Desenvolvedora: " + jogo.getDesenvolvedora());
        System.out.println("Preço: " + jogo.getPreco());
        System.out.println("Quantidade: " + jogo.getQuantidade());
        System.out.println();
        encontrado = true;
        break;
      }
    }

    if (!encontrado) {
      System.out.println(nomeJogo + " não foi encontrado");
    }

    System.out.println("Deseja pesquisar outro jogo?(s/n)");

    if (s.next().equalsIgnoreCase("s")) {
      pesquisarJogo();
    } else {
      menuEstoque();
    }
  }

  public static void cadastrarVenda() {
    s.nextLine();
    Venda venda = new Venda();
    System.out.println("----Cadastro de Venda----");
    System.out.print("Nome do jogo: ");
    String nomeJogo = s.nextLine();
    boolean encontrado = false;

    for (Jogos jogo : jogosEstoque) {
      if (jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
          venda.getJogos().add(jogo);
          encontrado = true;
          break;
      }
    }
       
    if(!encontrado) {
      System.out.println(nomeJogo + " não foi encontrado");
    } else{
      System.out.println("Id venda: ");
      venda.setIdVenda(s.nextInt());
      System.out.println("Cliente: ");
      venda.setCliente(s.next());
      System.out.println("Data da venda: ");
      venda.setDataVenda(s.next());
      System.out.println("Quantidade: ");
      venda.setUnidadesVendidas(s.nextInt());
      System.out.println("Valor total: ");
      System.out.println(venda.getValorTotal());
      System.out.println("Forma de pagamento: ");
      venda.setFormaPagamento(s.next());
      System.out.println("Status: ");
      venda.setStatus(s.next());

      vendas.add(venda);
      System.out.println("Venda cadastrada com sucesso!");
      
    }

    menuVendas();
    
  }
  }

