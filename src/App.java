
// Descrição: Classe principal do projeto
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
  public static List<Jogos> jogosEstoque = new ArrayList<>();
  public static List<Venda> vendas = new ArrayList<>();
  public static List<Jogos> jogos = new ArrayList<>();
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

    //Alguns jogos para teste
    Jogos jogo01, jogo02, jogo03;
    jogo01 = new Jogos("God of War", "Ação", "PS4", "18+", "Santa Monica Studios", 59.99, 5);
    jogo02 = new Jogos("The Legend of Zelda", "RPG", "Nintendo Switch", "10+", "Nintendo", 59.99, 5);
    jogo03 = new Jogos("Super Mario World", "Plataforma", "Super Nintendo", "L", "Nintendo", 249.99, 5);

    jogosEstoque.add(jogo01);
    jogosEstoque.add(jogo02);
    jogosEstoque.add(jogo03);

    addJogoGenero(jogo01, jogo01.getGenero());
    addJogoGenero(jogo02, jogo02.getGenero());
    addJogoGenero(jogo03, jogo03.getGenero());

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
        alterarVenda();
        break;

      case 3:
        removerVenda();
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
        jogosGenero();
        break;

      case 2:
        listaVendas();
        break;

      case 3:
        listaEstoque();
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
      String genero = s.nextLine();
      jogo.setGenero(genero);
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
    
      addJogoGenero(jogo, genero);

      System.out.println("Deseja cadastrar um novo jogo?(s/n)");
      op = s.next();
      s.nextLine();
    }
    menuEstoque();
  }

  // Funcao responsavel por adcionar jogos pelo genero através de um map
  public static void addJogoGenero(Jogos jogo, String genero){
    if (jogosGenero.containsKey(genero)) {
        jogosGenero.get(genero).add(jogo);
    } else {
        List<Jogos> jogosDoGenero = new ArrayList<>();
        jogosDoGenero.add(jogo);
        jogosGenero.put(genero, jogosDoGenero);
    }
  }

  //Funcao responsavel pela escolha de remoção ou adição de jogos
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

  //Funcao responsavel por remover quantidades de um jogo existente
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

  // funcao responsavel por remover um jogo permanentemente do estoque
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

  //Funcao responsavel por cadastrar novas vendas
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

    if (!encontrado) {
      System.out.println(nomeJogo + " não foi encontrado");
    } else {
      System.out.print("Id venda: ");
      venda.setIdVenda(s.nextInt());
      System.out.print("Cliente: ");
      venda.setCliente(s.next());
      System.out.print("Data da venda: ");
      venda.setDataVenda(s.next());
      System.out.print("Quantidade: ");
      venda.setUnidadesVendidas(s.nextInt());
      venda.setValorTotal(venda.getUnidadesVendidas(), venda.getJogos().get(0).getPreco());
      System.out.println("Valor total: " + venda.getValorTotal());
      System.out.print("Forma de pagamento: ");
      venda.setFormaPagamento(s.next());
      System.out.print("Status: ");
      venda.setStatus(s.next());
      System.out.println();

      vendas.add(venda);
      System.out.println("Venda cadastrada com sucesso!");

    }

    menuVendas();

  }

  //Funccao responsavel por alterar uma venda existente
  public static void alterarVenda() {
    s.nextLine();
    System.out.println("------");
    System.out.println("Vendas: ");
    for (Venda venda : vendas) {
      System.out.print(venda.getIdVenda() + " - ");
      System.out.println(venda.getCliente());
    }
    System.out.println("------");

    System.out.println("----Alterar Venda----");
    System.out.print("Id da venda: ");

    int idVenda = s.nextInt();

    s.nextLine();
    boolean encontrado = false;

    for (Venda venda : vendas) {
      if (venda.getIdVenda() == idVenda) {
        encontrado = true;
      }
    }

    if (!encontrado) {
      System.out.println("Venda não encontrada");
    } else {
      System.out.println("------");

      for (Venda venda : vendas) {
        System.out.println("Alterar quantidade de jogos, quantidade: " + venda.getUnidadesVendidas());
        System.out.println("Deseja remover ou adicionar jogos?(r/a)");

        String escolha = s.nextLine();

        if (escolha.equalsIgnoreCase("r")) {
          System.out.println("Jogo: " + venda.getJogos().get(0).getNomeJogo());
          ;
          System.out.print("Remover quantas unidades? ");
          int unidades = s.nextInt();

          System.out.println("Remover: " + unidades + " unidades ?(s/n)");

          char op = s.next().charAt(0);

          if (op == 's') {
            venda.setUnidadesVendidas(venda.getUnidadesVendidas() - unidades);
            System.out.println("Quantidade removida com sucesso!");
            System.out.println("Nova quantidade: " + venda.getUnidadesVendidas());
            break;
          } else {
            System.out.println("Cancelado");
            break;
          }
        } else {
          System.out.println("Jogo: " + venda.getJogos().get(0).getNomeJogo());
          ;
          System.out.print("Adicionar quantas unidades? ");
          int unidades = s.nextInt();

          System.out.println("Adicionar: " + unidades + " unidades ?(s/n)");

          char op = s.next().charAt(0);

          if (op == 'n') {
            System.out.println("Cancelado");
            break;
          } else {
            venda.setUnidadesVendidas(venda.getUnidadesVendidas() + unidades);
            System.out.println("Quantidade adicionada com sucesso!");
            System.out.println("Nova quantidade: " + venda.getUnidadesVendidas());
            break;
          }
        }

      }
    }

    menuVendas();
  }

  //Funcao responsavel por remover uma venda existente
  public static void removerVenda() {
    s.nextLine();
    System.out.println("------");
    System.out.println("Vendas: ");

    for (Venda venda : vendas) {
      System.out.print(venda.getIdVenda() + " - ");
      System.out.println(venda.getCliente());
    }

    System.out.println("Qual venda deseja remover?(id)");

    int idVenda = s.nextInt();

    for (Venda venda : vendas) {
      if (venda.getIdVenda() == idVenda) {
        System.out.println("------");
        System.out.println("Deseja remover a venda" + venda.getIdVenda() + " ?(s/n)");

        char op = s.next().charAt(0);

        if (op == 's') {
          vendas.remove(venda);
          System.out.println("Venda removida com sucesso!");
          break;
        } else {
          System.out.println("Operação cancelada!");
        }
      } else {
        System.out.println("Venda não encontrada!");
        break;
      }
    }

    menuVendas();
  }

  //Funcao responsavel por listar as vendas existentes
  public static void listaVendas() {
    s.nextLine();
    System.out.println("t------");
    System.out.println("Vendas: ");
    for (Venda venda : vendas) {
      System.out.println("\t------");
      System.out.println("\t" + venda.getIdVenda() + " - " + venda.getCliente());
      System.out.println("\tData venda: " + venda.getDataVenda());
      System.out.println("\tJogos: " + venda.getJogos().get(0).getNomeJogo());
      System.out.println("\tUnidades vendidas: " + venda.getUnidadesVendidas());
      System.out.println("\tValor: " + venda.getValorTotal());
      System.out.println("\tForma de pagamento: " + venda.getFormaPagamento());
      System.out.println("\tValor total: " + venda.getValorTotal());
      System.out.println("\tStatus: " + venda.getStatus());
      System.out.println("\t------");
    }

    menuRelatorios();
  }

  //Lista jogos em estoque
  public static void listaEstoque() {
    s.nextLine();
    System.out.println("------");
    System.out.println("Estoque: ");
    for (Jogos jogo : jogosEstoque) {
      System.out.println("------");
      System.out.println("\t" + jogo.getNomeJogo());
      System.out.println("\tEstoque: " + jogo.getQuantidade());
      System.out.println("------");
    }
    menuRelatorios();
  }

  //Lista jogos pelo seu genero, através de um mapa
  public static void jogosGenero(){
    System.out.println("------");
    System.out.println("Gêneros: ");
    System.out.println("\t1- Ação");
    System.out.println("\t2- Aventura");
    System.out.println("\t3- RPG");
    System.out.println("\t4- Corrida");
    System.out.println("\t5- Terror");
    System.out.println("\t6- Ficção");
    System.out.println("\t7- Fantasia");
    System.out.println("\t8- Plataforma");
    System.out.println("\t9- Estratégia");
    System.out.println("\t10- Simulação");
    System.out.println("\t11- Esportes");
    System.out.println("------");

    System.out.println("Qual gênero deseja buscar?(id)");
    int idGenero = s.nextInt();

    s.nextLine();
    String genero;

    switch(idGenero){
      case 1: genero = "Ação"; break;
      case 2: genero = "Aventura"; break;
      case 3: genero = "RPG"; break;
      case 4: genero = "Corrida"; break;
      case 5: genero = "Terror"; break;
      case 6: genero = "Ficção"; break;
      case 7: genero = "Fantasia"; break;
      case 8: genero = "Plataforma"; break;
      case 9: genero = "Estratégia"; break;
      case 10: genero = "Simulação"; break;
      case 11: genero = "Esportes"; break;
      default: System.out.println("Opção inválida!"); return;
    }

    if(jogosGenero.containsKey(genero)){
      System.out.println("Jogos do gênero " + genero + ": ");
      for(Jogos jogo : jogosGenero.get(genero)){
        System.out.println("\t" + jogo.getNomeJogo());
      }
    } else{
      System.out.println("Não há jogos do gênero " + genero);
    }
    System.out.println();

    System.out.println("Buscar novo gênero?(s/n)");
    char op = s.next().charAt(0);

    if(op == 's'){
      jogosGenero();
    } else{
      return;
  }
}
}
