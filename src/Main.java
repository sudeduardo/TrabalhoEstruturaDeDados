import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class Main {

	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Livro> livros = new ArrayList<Livro>();
	static ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

	public static void main(String[] args) {
		seeds();
		loop: while (true) {

			Menu();
			switch (GetInputNumber("Escolha uma op��o:")) {
			case 0:
				break loop;
			case 1:
				CadastrarLivro();
				break;
			case 2:
				RemoverLivro();
				break;
			case 3:
				ListarLivro();
				break;
			case 4:
				EditarLivro();
				break;
			case 5:
				CadastrarAluno();
				break;
			case 6:
				RemoverAluno();
				break;
			case 7:
				ListarAluno();
				break;
			case 8:
				EditarAluno();
				break;
			case 9:
				EmprestarLivro();
				break;
			case 10:
				DevolverLivroEmprestado();
				break;
			case 11:
				ListarLivroEmprestado();
				break;
			case 12:
				ListarEmprestimoDeUmAluno();
				break;
			case 13:
				DeletarUmEmprestimo();
				break;
			default:
				System.out.println("Op��o Invalida, Tente Novamente!");
				Menu();
				break;
			}
		}

	}

	static void Menu() {
		System.out.println("***************************************************");
		System.out.println("* Bem vido ao novo Sistema da Biblioteca da Unasp *");
		System.out.println("***************************************************");
		System.out.println("*                     Op��es                      *");
		System.out.println("***************************************************");
		System.out.println("* 0 - Sair                                        *");
		System.out.println("***************************************************");
		System.out.println("*                     Livros                      *");
		System.out.println("***************************************************");
		System.out.println("* 1 - Cadastrar Livro                             *");
		System.out.println("* 2 - Remover Livro                               *");
		System.out.println("* 3 - Listar Livro                                *");
		System.out.println("* 4 - Editar Livro                                *");
		System.out.println("***************************************************");
		System.out.println("*                     Aluno                       *");
		System.out.println("***************************************************");
		System.out.println("* 5 - Cadastrar Aluno                             *");
		System.out.println("* 6 - Remover Aluno                               *");
		System.out.println("* 7 - Listar Aluno                                *");
		System.out.println("* 8 - Editar Aluno                                *");
		System.out.println("***************************************************");
		System.out.println("*                  Emprestimo                     *");
		System.out.println("***************************************************");
		System.out.println("* 9 - Emprestar Livro                             *");
		System.out.println("* 10- Devolver Livro                              *");
		System.out.println("* 11- Listar Emprestimo                           *");
		System.out.println("* 12- Listar Emprestimo Atrasado                  *");
		System.out.println("* 12- Listar Emprestimo de Um Aluno               *");
		System.out.println("* 13- Deletar um Emprestimo                       *");
		System.out.println("***************************************************");
	}
	// Fun��es Livros

	static void CadastrarLivro() {
		Livro l = new Livro();
		System.out.println("Cadastrando Livro");
		l.setTitulo(GetInputText("Qual o titulo do Livro?"));
		l.setEditora(GetInputText("Qual a Editora do Livro?"));
		l.setAno(GetInputText("Qual o o ano do Livro?"));

		while (true) {
			String iSBN = GetInputText("Qual o ISBN do Livro?");
			if (l.checkISBN(iSBN, livros)) {
				l.setISBN(iSBN);
				break;
			} else {
				System.out.println("ISBN j� cadastrado tente outro valor!");
			}
		}

		if (GetYesOrNo("Confirmar Cadastro deste Livro?\n" + l)) {
			livros.add(l);
			System.out.println("Livro Cadastrado com sucesso!");
		} else {
			System.out.println("Opera��o Cancelada!");
		}
		Wait();
	}

	static void RemoverLivro() {
		print("Remover livros");

		while (true) {
			for (Livro livro : livros) {
				System.out.println(livro);
			}

			int id = GetInputNumber("Digite o ID do livro que ira ser excluido:");

			Livro livroDelete = null;
			for (Livro livro : livros) {
				if (livro.getId() == id) {
					livroDelete = livro;
					break;
				}
			}

			if (livroDelete != null) {
				if (GetYesOrNo("Confirmar Exclus�o deste Livro?\n" + livroDelete)) {
					livros.remove(livroDelete);
					print("Exclus�o feita com sucesso");
				} else {
					print("Exclus�o cancelada");
				}
				break;
			}
		}
		Wait();

	}

	static void ListarLivro() {
		System.out.println("Listando Livros:");
		for (Livro livro : livros) {
			System.out.println(livro);
		}
		Wait();

	}

	static void EditarLivro() {
		print("Editar livros");

		while (true) {
			for (Livro livro : livros) {
				System.out.println(livro);
			}

			int id = GetInputNumber("Digite o ID do livro que ira ser editado:");

			Livro livroEdit = null;
			for (Livro livro : livros) {
				if (livro.getId() == id) {
					livroEdit = livro;
					break;
				}
			}

			if (livroEdit != null) {
				
				String ano = GetInputText("Ano de Livro: ["+livroEdit.getAno()+"] ");
				String editora = GetInputText("Editora do Livro: ["+livroEdit.getEditora()+"] ");
				String iSBN = "";
				
				while (true) {
					 iSBN = GetInputText("ISBN do Livro: ["+livroEdit.getISBN()+"]");
					if (livroEdit.checkISBN(iSBN, livros)) {
						break;
					} else {
						System.out.println("ISBN j� cadastrado tente outro valor!");
					}
				}
				
				String titulo = GetInputText("Titulo do Livro: ["+livroEdit.getTitulo()+"] ");
		
				
				if (GetYesOrNo("Confirma altera��es neste Livro")) {
					livroEdit.setAno(ano);
					livroEdit.setEditora(editora);
					livroEdit.setISBN(iSBN);
					livroEdit.setTitulo(titulo);
					print("Atualiza��o feita com sucesso!");
					print(livroEdit);
				} else {
					print("Altera��o cancelada");
				}
				break;
			}
		}
		
		Wait();
	}

	// Fun��o de Alunos

	static void CadastrarAluno() {
		Aluno a = new Aluno();
		System.out.println("Cadastrando Aluno");
		a.setNome(GetInputText("Qual o Nome do Aluno?"));
		
		while (true) {
			String email = GetInputText("Qual o Email do aluno?");
			
			if (isEmailValid(email)) {
				a.setEmail(email);
				break;
			} else {
				System.out.println("Email inv�lido, tente novamente!");
			}
		}
		
		a.setCurso(GetInputText("Qual o Curso do aluno?"));
		
		while (true) {
			int RA = GetInputNumber("Qual o RA do Aluno?");
			if (a.checkRA(RA, alunos)) {
				a.setRA(RA);
				break;
			} else {
				System.out.println("RA j� cadastrado, tente outro valor!");
			}
		}
		
		
		
		if (GetYesOrNo("Confirmar Cadastro deste Aluno?\n" + a)) {
			alunos.add(a);
			System.out.println("Aluno Cadastrado com sucesso!");
		} else {
			System.out.println("Opera��o Cancelada!");
		}
		Wait();
	}

	static void RemoverAluno() {
		print("Remover Alunos");

		while (true) {
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}

			int id = GetInputNumber("Digite o ID do Aluno que ira ser excluido:");

			Aluno alunoDelete = null;
			for (Aluno aluno : alunos) {
				if (aluno.getId() == id) {
					alunoDelete = aluno;
					break;
				}
			}

			if (alunoDelete != null) {
				if (GetYesOrNo("Confirmar Exclus�o deste Aluno?\n" + alunoDelete)) {
					alunos.remove(alunoDelete);
					print("Exclus�o feita com sucesso");
				} else {
					print("Exclus�o cancelada");
				}
				break;
			}
		}
		Wait();
	}

	static void ListarAluno() {
		print("Listando Alunos:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
		Wait();
	}

	static void EditarAluno() {
		print("Editar Aluno");

		while (true) {
			for (Aluno aluno : alunos) {
				print(aluno);
			}

			int id = GetInputNumber("Digite o ID do Aluno que ira ser editado:");

			Aluno alunoEdit = null;
			for (Aluno aluno : alunos) {
				if (aluno.getId() == id) {
					alunoEdit = aluno;
					break;
				}
			}

			if (alunoEdit != null) {
				
				String curso = GetInputText("Curso do Aluno: ["+alunoEdit.getCurso()+"])");
				
				String email =  "";				
				while (true) {
					email = GetInputText("Email do Aluno: ["+alunoEdit.getEmail()+"])");
					
					if (isEmailValid(email)) {
						break;
					} else {
						System.out.println("Email inv�lido, tente novamente!");
					}
				}
				
				
				String nome =  GetInputText("Nome do Aluno: ["+alunoEdit.getNome()+"])");
				
				
				
				
				int ra = 0;
				
				while (true) {
					ra = GetInputNumber("RA do Livro: ["+alunoEdit.getRA()+"]");
					if (alunoEdit.checkRA(ra, alunos)) {
						break;
					} else {
						System.out.println("RA j� cadastrado, tente outro valor!");
					}
				}
				
				
				if (GetYesOrNo("Confirma altera��es neste Aluno")) {
					alunoEdit.setCurso(curso);
					alunoEdit.setEmail(email);
					alunoEdit.setNome(nome);
					alunoEdit.setRA(ra);
					print("Atualiza��o feita com sucesso!");
					print(alunoEdit);
				} else {
					print("Altera��o cancelada");
				}
				break;
			}
		}
		
		Wait();
	}

	// Fun��o Emprestimos

	static void EmprestarLivro() {

	}

	static void DevolverLivroEmprestado() {

	}

	static void ListarLivroEmprestado() {

	}

	static void ListarEmprestimoDeUmAluno() {

	}

	static void DeletarUmEmprestimo() {

	}

	static int GetInputNumber(String txt) {
		System.out.println(txt);
		while (true) {
			try {

				Scanner input = new Scanner(System.in);
				int n = input.nextInt();
				return n;
			} catch (Exception ex) {
				System.out.println("Erro de Entrada, Tente outro valor!");
			}
		}
	}

	static String GetInputText(String txt) {
		System.out.println(txt);
		while (true) {
			try {

				Scanner input = new Scanner(System.in);
				String s = input.nextLine();
				if(!s.trim().equals("")) {
					return s;
				}
			} catch (Exception ex) {
				System.out.println("Erro de Entrada, Tente outro valor!");
			}
		}
	}

	static boolean GetYesOrNo(String txt) {
		System.out.println(txt);
		while (true) {
			System.out.println("(s)im ou (n)�o");
			try {
				Scanner input = new Scanner(System.in);
				String s = input.nextLine();
				if (s.toLowerCase().equals("s") || s.toLowerCase().equals("sim")) {
					return true;
				} else if (s.toLowerCase().equals("n") || s.toLowerCase().equals("nao")
						|| s.toLowerCase().equals("n�o")) {
					return false;
				}
			} catch (Exception ex) {
				System.out.println("Erro de Entrada, Tente outro valor:");
			}
		}
	}

	static void Wait() {
		System.out.println("Tecle para coninuar...");
		Scanner input = new Scanner(System.in);
		input.nextLine();

	}

	static void print(String txt) {
		System.out.println(txt);
	}
	
	static void print(Object obj) {
		System.out.println(obj);
	}

	static boolean isEmailValid(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	
	static void seeds() {

		for (int i = 0; i < 9; i++) {
			Livro l = new Livro();
			l.setTitulo("Livro " + i);
			l.setISBN("INSB " + i);
			l.setEditora("Editora " + i);
			l.setAno("200 " + i);
			livros.add(l);

			Aluno a = new Aluno();
			a.setCurso("Curso " + i);
			a.setEmail("email@email" + i + ".com");
			a.setNome("Nome " + i);
			a.setRA(i);
			alunos.add(a);

		}
	}
}
