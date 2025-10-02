import java.util.ArrayList;
class Curso {
    private String nome;
    private String coordenador;
    private String descricao;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Curso(String nome, String coordenador, String descricao, Professor professor) {
        this.nome = nome;
        this.coordenador = coordenador;
        this.descricao = descricao;
        this.professor = professor;
        this.alunos = new ArrayList<Aluno>();
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
        aluno.trancarCurso(this);
    }

    public void atualizarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
}