import java.util.ArrayList;

public class Livro {

	private int id;

	private String Titulo;
	
	private String ISBN;

	@Override
	public String toString() {
		return "Livro [id=" + id + ", Titulo=" + Titulo + ", ISBN=" + ISBN + ", Editora=" + Editora + ", Ano=" + Ano
				+ "]";
	}

	public boolean equals(Livro l) {
		return this.id == l.id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	private String Editora;

	private String Ano;

	private static int count = 0;

	public Livro() {
		id = ++count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getEditora() {
		return Editora;
	}

	public void setEditora(String editora) {
		Editora = editora;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public boolean checkISBN(String ISBN, ArrayList<Livro> livros) {

		for (Livro livro : livros) {
			if (livro.getISBN().equals(ISBN)) {
				return false;
			}
		}

		return true;
	}

}
