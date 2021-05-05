import java.text.DateFormat;

public class Emprestimo {

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public DateFormat getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(DateFormat dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	private Aluno aluno;
	
	private Livro livro;
	
	private int qtdDias;
	
	private DateFormat  dataEmprestimo;
}
