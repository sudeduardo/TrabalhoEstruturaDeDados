import java.text.DateFormat;

public class Emprestimo {
 	
	public Emprestimo() {
		  id = ++count;
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Aluno aluno;
	
	private Livro livro;
	
	private int qtdDias;
	
	private DateFormat  dataEmprestimo;
	
	private int id; 
	
	private static int count = 0;
}
