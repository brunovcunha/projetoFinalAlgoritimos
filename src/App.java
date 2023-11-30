// Descrição: Classe principal do projeto
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<Jogos> jogosEstoque = new ArrayList<Jogos>();
    public static Scanner s = new Scanner(System.in);   
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao sistema de vendas de jogos");  
        menu();
        validaMenu();
    }


    public static int opcaoMenu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a opção desejada: ");
        int opcao = s.nextInt();
        s.nextLine();
        return opcao;
    }
    
    public static void validaMenu() {
        int opcao;
        do {
            opcao = opcaoMenu();
            if (opcao < 1 || opcao > 11) {
                System.out.println("Opção inválida");
                menu();
            } else {
                switch (opcao) {
                    case 1:
                        cadastrarJogo();
                        break;
                
                    case 11:
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } while (opcao != 11);
    }

    public static void menu(){
        System.out.println("------Estoque de jogos------");
        System.out.println("1 - Cadastrar jogo");
        System.out.println("2 - Remover jogo");
        System.out.println("3 - Adicionar jogo ao estoque");
        System.out.println("4 - Remover jogo do estoque");
        System.out.println("------Vendas------");
        System.out.println("5 - Cadastrar venda");
        System.out.println("6 - Cancelar venda");
        System.out.println("7 - Finalizar venda");
        System.out.println("------Relatórios------");
        System.out.println("8 - Listar jogos");
        System.out.println("9 - Listar vendas");
        System.out.println("10 - Listar estoque");
        System.out.println("------Sair------");
        System.out.println("11 - Sair");
    }

    public static void cadastrarJogo(){
        Jogos jogo = new Jogos();
        
        System.out.println("-----Cadastro-----");
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
    }
}