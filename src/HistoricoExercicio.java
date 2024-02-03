/*[M1S04] Ex 1 - Lista de Cursos e Professores
Criar dois ArrayList para armazenar lista de cursos e professores.
Utilizando um laço de repetição, pedir ao usuário que informe alguns cursos/professores ou um comando para sair (pode ser "0", mas fique à vontade para mudar).
Para isso, criar funções para:
Adicionar curso/professores na lista
Ao sair listar os cursos/professores inseridos

import java.util.ArrayList;
import java.util.Scanner;

public class CursosProfessores {

    public static void main(String[] args) {
        // ArrayLists para armazenar 'cursos' e 'professores'
        ArrayList<String> cursos = new ArrayList<>();
        ArrayList<String> professores = new ArrayList<>();

        // Scanner para entrada de informação
        Scanner scanner = new Scanner(System.in);

        // Laço de repetição
        while (true) {
            System.out.println("Digite o nome do curso (ou 0 para sair): ");
            String curso = scanner.nextLine();

            // Quebra do laço
            if (curso.equals("0")) {
                break;
            }

            // Adicionar curso à lista de cursos
            cursos.add(curso);

            // Pedir o nome do professor
            System.out.println("Digite o nome do professor: ");
            String professor = scanner.nextLine();

            // Adicionar professor à lista de professores
            professores.add(professor);
        }

        // Exibindo a lista de cursos e professores
        listarCursosProfessores(cursos, professores);

        // Fechando o scanner
        scanner.close();
    }

    // Função para listar cursos e professores
    private static void listarCursosProfessores(ArrayList<String> cursos, ArrayList<String> professores) {
        System.out.println("\nLista de Cursos e Professores:");

        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("abstracao.Curso: " + cursos.get(i) + ", abstracao.Professor: " + professores.get(i));
        }
    }
}*/



/*[M1S04] Ex 2 - Lista de cursos e professores - Com menu de opções
Vamos melhorar nosso sistema!
O usuário precisa manipular as listas de cursos e professores, portanto precisaremos adicionar a funcionalidade de um menu de opções:
Opções (números são sugestões para executar as ações):

(1) Listar
(2) Adicionar
(0) Sair
Quando a opção escolhida for "Listar", utilizar a função de listagem criada no Exercício 1.
Quando a opção escolhida for "Adicionar", utilizar a função criada para adicionar no Exercício 1.
Altere a função listar para que seja exibido o índice ao lado de cada item, usaremos posteriormente.


import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCursosProfessores {

    public static void main(String[] args) {
        // ArrayLists para armazenar 'cursos' e 'professores'
        ArrayList<String> cursos = new ArrayList<>();
        ArrayList<String> professores = new ArrayList<>();

        // Scanner para entrada de informação
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            // Menu de opções
            System.out.println("\nOpções:");
            System.out.println("(1) Listar");
            System.out.println("(2) Adicionar");
            System.out.println("(0) Sair");

            // Escolha da opção do usuário
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê o número digitado pelo usuário
            scanner.nextLine(); // Consumir a quebra de linha deixada após a leitura de um número

            // Ação de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    // Listar cursos e professores
                    listarCursosProfessores(cursos, professores);
                    break;
                case 2:
                    // Adicionar curso e professor
                    adicionarCursoProfessor(cursos, professores, scanner);
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        // Fechando o scanner
        scanner.close();
    }

    // Função para listar cursos e professores
    private static void listarCursosProfessores(ArrayList<String> cursos, ArrayList<String> professores) {
        System.out.println("\nLista de Cursos e Professores:");

        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("Índice: " + i + ", abstracao.Curso: " + cursos.get(i) + ", abstracao.Professor: " + professores.get(i));
        }
    }

    // Função para adicionar curso e professor
    private static void adicionarCursoProfessor(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        // Adicionar curso
        System.out.println("Digite o nome do curso: ");
        String curso = scanner.nextLine();
        cursos.add(curso);

        // Adicionar professor
        System.out.println("Digite o nome do professor: ");
        String professor = scanner.nextLine();
        professores.add(professor);

        System.out.println("abstracao.Curso e professor adicionados.");
    }
}*/


/*[M1S04] Ex 3 - Lista de cursos e professores - Nova opção no menu
Após esta refatoração realizada no Exercício 2, adicione uma opção no menu para que o curso/professores seja removido
Nova opção (números são sugestões para executar as ações):

(3) Remover
Criar 3 novas funções (nomes das funções são apenas sugestões):
    "listarPedirIndice":
        -> utilizar a função de listagem (com índices - conforme alterado no Exercício 2)
        -> pedir ao usuário que escolha um item da lista
        -> retornar o índice escolhido
    "removerItemLista":
        -> utilizar a função "listarPedirIndice"
        -> utilizar a função "removerItem" (próxima função a ser criada) e passar como parâmetro o índice retornado da função "listarPedirIndice"
    "removerItem":
        -> precisa receber o índice por parâmetro
        -> na sequência realizar a remoção do item existente no índice

import java.util.ArrayList;
import java.util.Scanner;

public class OpçãoMenu {

    public static void main(String[] args) {
        // ArrayLists para armazenar 'cursos' e 'professores'
        ArrayList<String> cursos = new ArrayList<>();
        ArrayList<String> professores = new ArrayList<>();

        // Scanner para entrada de informação
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            // Menu de opções
            System.out.println("\nOpções:");
            System.out.println("(1) Listar");
            System.out.println("(2) Adicionar");
            System.out.println("(3) Remover");
            System.out.println("(0) Sair");

            // Escolha da opção do usuário
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê o número digitado pelo usuário
            scanner.nextLine(); // Consumir a quebra de linha deixada após a leitura de um número

            // Ação de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    // Listar cursos e professores
                    listarCursosProfessores(cursos, professores);
                    break;
                case 2:
                    // Adicionar curso e professor
                    adicionarCursoProfessor(cursos, professores, scanner);
                    break;
                case 3:
                    // Remover curso e professor
                    removerItemLista(cursos, professores, scanner);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        // Fechando o scanner
        scanner.close();
    }

    // Função para listar cursos e professores com índices
    private static void listarCursosProfessores(ArrayList<String> cursos, ArrayList<String> professores) {
        System.out.println("\nLista de Cursos e Professores:");

        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("Índice: " + i + ", abstracao.Curso: " + cursos.get(i) + ", abstracao.Professor: " + professores.get(i));
        }
    }

    // Função para adicionar curso e professor
    private static void adicionarCursoProfessor(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        // Adicionar curso
        System.out.println("Digite o nome do curso: ");
        String curso = scanner.nextLine();
        cursos.add(curso);

        // Adicionar professor
        System.out.println("Digite o nome do professor: ");
        String professor = scanner.nextLine();
        professores.add(professor);

        System.out.println("abstracao.Curso e professor adicionados.");
    }

    // Função para listar, pedir o índice e remover item da lista
    private static void removerItemLista(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        // Listar cursos e professores com índices
        listarCursosProfessores(cursos, professores);

        // Pedir ao usuário que escolha um item da lista
        int indiceEscolhido = listarPedirIndice(cursos, professores, scanner);

        // Remover curso e professor
        removerItem(cursos, professores, indiceEscolhido);
    }

    // Função para listar e pedir o índice
    private static int listarPedirIndice(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        System.out.print("Escolha o índice do item que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha deixada após a leitura de um número
        return indice;
    }

    // Função para remover item da lista
    private static void removerItem(ArrayList<String> cursos, ArrayList<String> professores, int indice) {
        if (indice >= 0 && indice < cursos.size()) {
            cursos.remove(indice);
            professores.remove(indice);
            System.out.println("Item removido.");
        } else {
            System.out.println("Índice inválido. Nenhum item removido.");
        }
    }
} */


/*[M1S04] Ex 4 - Lista de cursos concluídos
Continuando nosso projeto!
Vamos criar uma nova lista para armazenar os cursos que já foram concluídos pelo usuário.
Após criar a lista, será necessário adicionar mais opções no menu:
Novas opção (números são sugestões para executar as ações):

(4) Marcar como concluído
(5) Listar concluídos
Criar novas função (nome da função é apenas sugestão):
    "marcarComoConcluído":
utilizar a função "listarPedirIndice" (criada no Exercício 3)
adicionar na nova lista de concluídos o curso escolhido pelo usuário
remover item da lista de cursos utilizando a função "removerItem" (criada no Exercício 3). Dessa forma o curso/professores será movido para a nova lista.

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class PCursosConcluidos {

    public static void main(String[] args) {
        // ArrayLists para armazenar 'cursos', 'professores' e 'cursosConcluidos'
        ArrayList<String> cursos = new ArrayList<>();
        ArrayList<String> professores = new ArrayList<>();
        ArrayList<String> cursosConcluidos = new ArrayList<>();

        // Scanner para entrada de informação
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            // Menu de opções
            System.out.println("\nOpções:");
            System.out.println("(1) Listar");
            System.out.println("(2) Adicionar");
            System.out.println("(3) Remover");
            System.out.println("(4) Marcar como concluído");
            System.out.println("(5) Listar concluídos");
            System.out.println("(0) Sair");

            // Escolha da opção do usuário
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê o número digitado pelo usuário
            scanner.nextLine(); // Consumir a quebra de linha deixada após a leitura de um número

            // Ação de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    // Listar cursos e professores
                    listarCursosProfessores(cursos, professores);
                    break;
                case 2:
                    // Adicionar curso e professor
                    adicionarCursoProfessor(cursos, professores, scanner);
                    break;
                case 3:
                    // Remover curso e professor
                    removerItemLista(cursos, professores, scanner);
                    break;
                case 4:
                    // Marcar como concluído
                    marcarComoConcluido(cursos, professores, cursosConcluidos, scanner);
                    break;
                case 5:
                    // Listar cursos concluídos
                    listarCursosConcluidos(cursosConcluidos);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        // Fechando o scanner
        scanner.close();
    }

    // Função para listar cursos e professores com índices
    private static void listarCursosProfessores(ArrayList<String> cursos, ArrayList<String> professores) {
        System.out.println("\nLista de Cursos e Professores:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("Índice: " + i + ", abstracao.Curso: " + cursos.get(i) + ", abstracao.Professor: " + professores.get(i));
        }
    }

    // Função para adicionar curso e professor
    private static void adicionarCursoProfessor(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        System.out.print("Digite o nome do curso: ");
        cursos.add(scanner.nextLine());
        System.out.print("Digite o nome do professor: ");
        professores.add(scanner.nextLine());
        System.out.println("abstracao.Curso e professor adicionados com sucesso!");
    }

    // Função para remover item da lista
    private static void removerItem(ArrayList<String> cursos, ArrayList<String> professores, int indice) {
        if (indice >= 0 && indice < cursos.size()) {
            cursos.remove(indice);
            professores.remove(indice);
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Índice inválido. Nenhum item removido.");
        }
    }*/


