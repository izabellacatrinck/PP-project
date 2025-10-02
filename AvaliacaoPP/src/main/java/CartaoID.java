class CartaoID {
    private int numero;
    private Aluno aluno;
    private String departamento;
    private int ano;
    private int validade;

    public CartaoID(int numero, Aluno aluno, String departamento, int ano, int validade) {
        this.numero = numero;
        this.aluno = aluno;
        this.departamento = departamento;
        this.ano = ano;
        this.validade = validade;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getValidade() {
        return this.validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }
}