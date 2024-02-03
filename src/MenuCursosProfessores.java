import java.util.ArrayList;
import java.util.Scanner;

public class MenuCursosProfessores {

    public static void main(String[] args) {
        // ArrayLists para armazenar 'cursos', 'professores' e 'cursosConcluidos'

        ArrayList<String> cursos = new ArrayList<>();
        ArrayList<String> professores = new ArrayList<>();
        ArrayList<String> cursosConcluidos = new ArrayList<>();

        // Scanner para entrada de informação
        Scanner scanner = new Scanner(System.in);

        int opcao =-1; // Inicializando a variável
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
            if (scanner.hasNextInt()) {
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
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }

        } while (opcao != 0);

        // Fechando o scanner
        scanner.close();
    }

    // Função para listar cursos e professores com índices
    private static void listarCursosProfessores(ArrayList<String> cursos, ArrayList<String> professores) {
        System.out.println("\nLista de Cursos e Professores:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("Índice: " + i + ", Curso: " + cursos.get(i) + ", Professor: " + professores.get(i));
        }
    }

    // Função para adicionar curso e professor
    private static void adicionarCursoProfessor(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        System.out.print("Digite o nome do curso: ");
        cursos.add(scanner.nextLine());
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        professores.add(nome);
        System.out.println("Curso e professor adicionados com sucesso!");
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

    // Função para listar, pedir o índice e remover item da lista
    private static void removerItemLista(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        // Listar cursos e professores com índices
        listarCursosProfessores(cursos, professores);

        // Pedir ao usuário que escolha um item da lista
        int indiceEscolhido = listarPedirIndice(cursos, professores, scanner);

        // Remover curso e professor
        removerItem(cursos, professores, indiceEscolhido);
    }

    // Função para marcar curso como concluído
    private static void marcarComoConcluido(ArrayList<String> cursos, ArrayList<String> professores, ArrayList<String> cursosConcluidos, Scanner scanner) {
        // Verificar se há cursos disponíveis para conclusão
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos disponíveis para conclusão.");
            return;
        }

        // Listar cursos disponíveis para conclusão
        listarCursosProfessores(cursos, professores);

        // Pedir ao usuário que escolha um curso
        int indiceEscolhido = listarPedirIndice(cursos, professores, scanner);

        // Verificar se o índice é válido
        if (indiceEscolhido >= 0 && indiceEscolhido < cursos.size()) {
            // Adicionar curso à lista de concluídos
            cursosConcluidos.add(cursos.get(indiceEscolhido));

            // Remover curso da lista de cursos
            removerItem(cursos, professores, indiceEscolhido);

            System.out.println("Curso marcado como concluído.");
        } else {
            System.out.println("Índice inválido. Tente novamente.");
        }
    }


    // Função para listar cursos concluídos
    private static void listarCursosConcluidos(ArrayList<String> cursosConcluidos) {
        System.out.println("\nCursos Concluídos:");
        for (int i = 0; i < cursosConcluidos.size(); i++) {
            System.out.println("Índice: " + i + ", Curso: " + cursosConcluidos.get(i));
        }
    }

    // Função para listar e pedir o índice
    private static int listarPedirIndice(ArrayList<String> cursos, ArrayList<String> professores, Scanner scanner) {
        System.out.print("Escolha o índice do item: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha deixada após a leitura de um número
        return indice;
    }
}
