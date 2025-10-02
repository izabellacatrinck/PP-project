import java.util.ArrayList;
class Professor {
    private String nome;
    private String departamento;
    private int idFuncionario;
    private String email;
    private ArrayList<Curso> cursos;

    public Professor(String nome, int idFuncionario, String email, String departamento) {
        this.nome = nome;
        this.idFuncionario = idFuncionario;
        this.email = email;
        this.departamento = departamento;
        this.cursos = new ArrayList<Curso>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public void addCurso(Curso curso) {
        this.cursos.add(curso);
        curso.setProfessor(this);
    }

    public void removerCurso(Curso curso) {
        this.cursos.remove(curso);
        curso.setProfessor(null);
    }
}