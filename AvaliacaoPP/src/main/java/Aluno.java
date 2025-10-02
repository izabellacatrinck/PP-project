import java.util.ArrayList;
class Aluno {
    private String nome;
    private int periodo;
    private ArrayList<Curso> cursos;
    private CartaoID cartao;

    public Aluno(String nome, int periodo, CartaoID cartao) {
        this.nome = nome;
        this.periodo = periodo;
        this.cartao = cartao;
        this.cursos = new ArrayList<Curso>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public CartaoID getCartao() {
        return this.cartao;
    }

    public void setCartao(CartaoID cartao) {
        this.cartao = cartao;
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void trancarCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    public void matricularCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void desvincularCartao() {
        this.cartao = null;
    }
}