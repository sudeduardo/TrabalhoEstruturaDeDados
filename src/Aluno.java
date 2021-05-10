
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
}
