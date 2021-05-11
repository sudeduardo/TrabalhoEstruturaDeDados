import java.util.ArrayList;

public class Aluno {

	private int id;
	private int RA;
	

	private String Nome;
	private String Curso;
	private String Email;

	private static int count = 0;

	public Aluno() {
		id = ++count;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", RA=" + RA + ", Nome=" + Nome + ", Curso=" + Curso + ", Email=" + Email + "]";
	}

	public boolean equals(Aluno a) {
		return this.id == a.id;
	}

	public int getRA() {
		return RA;
	}

	public void setRA(int rA) {
		RA = rA;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean checkRA(int ra, ArrayList<Aluno> alunos) {
		for (Aluno aluno : alunos) {
			if (aluno.getRA() == ra) {
				return false;
			}
		}
		return true;
	}
}
