import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    static ArrayList<Curso> cursos = new ArrayList<Curso>();
    static ArrayList<Professor> professores = new ArrayList<Professor>();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Cadastrar Curso para Aluno");
            System.out.println("5. Listar Cursos por Professor");
            System.out.println("6. Listar Cursos de um Aluno por CartaoID");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    cadastrarCursoParaAluno();
                    break;
                case 5:
                    listarCursosPorProfessor();
                    break;
                case 6:
                    listarCursosDeAlunoPorCartaoID();
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void cadastrarAluno() {
        System.out.println("Cadastro de Aluno:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Período: ");
        int periodo = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Número do Cartão ID: ");
        int numeroCartao = scanner.nextInt();
        scanner.nextLine(); 
        for (Aluno aluno : alunos) {
            if (aluno.getCartao().getNumero() == numeroCartao) {
                System.out.println("ID já existente");
                return;
            }
        }
        System.out.print("Departamento: ");
        String departamentoCartao = scanner.nextLine();
        System.out.print("Ano de emissão: ");
        int anoCartao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ano de vencimento do cartão: ");
        int validadeCartao = scanner.nextInt();
        scanner.nextLine();

        CartaoID cartaoID = new CartaoID(numeroCartao, null, departamentoCartao, anoCartao, validadeCartao);
        Aluno aluno = new Aluno(nome, periodo, cartaoID);
        cartaoID.setAluno(aluno);
        alunos.add(aluno);
    }
    

    public static void cadastrarProfessor() {
        System.out.println("Cadastro de professor:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("ID do funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        Professor professor = new Professor(nome, idFuncionario, email, departamento);
        professores.add(professor);
    }

    public static void cadastrarCurso() {
        System.out.println("Cadastro de curso:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        for (Curso cursoExistente : cursos) {
            if (cursoExistente.getNome().equalsIgnoreCase(nome)) {
                System.out.println(" erro: curso já cadastrado");
                return;
            }
        }
        System.out.print("Coordenador: ");
        String coordenador = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Professor: ");
        String nomeProfessor = scanner.nextLine();

        Professor professor = buscarProfessorPorNome(nomeProfessor);
        if (professor != null) {
            Curso curso = new Curso(nome, coordenador, descricao, professor);
            cursos.add(curso);
            professor.addCurso(curso);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public static void cadastrarCursoParaAluno() {
        System.out.println("Cadastro de curso para aluno:");
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();
        Curso curso = buscarCursoPorNome(nomeCurso);
        if (curso != null) {
            System.out.print("Nome do aluno: ");
            String nomeAluno = scanner.nextLine();
            Aluno aluno = buscarAlunoPorNome(nomeAluno);
            if (aluno != null) {
                aluno.matricularCurso(curso);
                System.out.println("Curso cadastrado para o aluno com sucesso");
            } else {
                System.out.println("Aluno não encontrado");
            }
        } else {
            System.out.println("Curso não encontrado");
        }
    }

    public static void listarCursosPorProfessor() {
        System.out.println("Listar cursos por professor:");
        System.out.print("Nome do professor: ");
        String nomeProfessor = scanner.nextLine();
        Professor professor = buscarProfessorPorNome(nomeProfessor);
        if (professor != null) {
            ArrayList<Curso> cursosDoProfessor = professor.getCursos();
            for (Curso curso : cursosDoProfessor) {
                System.out.println(curso.getNome());
            }
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public static void listarCursosDeAlunoPorCartaoID() {
        System.out.println("Listar cursos de um aluno por CartãoID:");
        System.out.print("Número do cartão: ");
        int numeroCartao = scanner.nextInt();
        scanner.nextLine(); 

        CartaoID cartaoID = buscarCartaoPorNumero(numeroCartao);
        if (cartaoID != null) {
            Aluno aluno = cartaoID.getAluno();
            ArrayList<Curso> cursosDoAluno = aluno.getCursos();
            for (Curso curso : cursosDoAluno) {
                System.out.println(curso.getNome());
            }
        } else {
            System.out.println("Cartão de identificação não encontrado");
        }
    }
    public static Professor buscarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }
    public static Aluno buscarAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
    public static CartaoID buscarCartaoPorNumero(int numeroCartao) {
        for (Aluno aluno : alunos) {
            if (aluno.getCartao().getNumero() == numeroCartao) {
                return aluno.getCartao();
            }
        }
        return null;
    }
    public static Curso buscarCursoPorNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
                }
            }
            return null;
        }
}
