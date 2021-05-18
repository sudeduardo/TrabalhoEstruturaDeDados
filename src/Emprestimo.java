import java.time.LocalDate;
import java.time.Period;

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

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean esta_atrasado() {
		LocalDate t = (dataDevolucao == null) ?  LocalDate.now() : dataDevolucao;
		Period period = Period.between(t,this.dataEmprestimo);
		return (Math.abs(period.getDays()) > qtdDias);
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + " ,aluno=" + ((aluno != null) ? aluno.getNome(): "") + ", livro=" +  ((livro != null) ? livro.getTitulo(): "") + ", qtdDias=" + qtdDias + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", atrasado="+esta_atrasado()+"]";
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	private Aluno aluno;
	
	private Livro livro;
	
	private int qtdDias;
	
	private LocalDate  dataEmprestimo;
	
	private LocalDate  dataDevolucao;
	
	private int id; 
	
	private static int count = 0;
}
