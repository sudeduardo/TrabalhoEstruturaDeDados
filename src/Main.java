import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Livro> livros = new ArrayList<Livro>();
	static ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

	public static void main(String[] args) {
		seeds();
		loop: while (true) {

			Menu();
			switch (GetInputNumber("Escolha uma opção:")) {
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
				System.out.println("Opção Invalida, Tente Novamente!");
				Menu();
				break;
			}
		}

	}

	static void Menu() {
		System.out.println("***************************************************");
		System.out.println("* Bem vido ao novo Sistema da Biblioteca da Unasp *");
		System.out.println("***************************************************");
		System.out.println("*                     Opções                      *");
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
	// Funções Livros

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
				System.out.println("ISBN já cadastrado tente outro valor!");
			}
		}

		if (GetYesOrNo("Confirmar Cadastro deste Livro?\n" + l)) {
			livros.add(l);
			System.out.println("Livro Cadastrado com sucesso!");
		} else {
			System.out.println("Operação Cancelada!");
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
				if (GetYesOrNo("Confirmar Exclusão deste Livro?\n" + livroDelete)) {
					livros.remove(livroDelete);
					print("Exclusão feita com sucesso");
				} else {
					print("Exclusão cancelada");
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

	}

	// Função de Alunos

	static void CadastrarAluno() {

	}

	static void RemoverAluno() {

	}

	static void ListarAluno() {

	}

	static void EditarAluno() {

	}

	// Função Emprestimos

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
				return s;
			} catch (Exception ex) {
				System.out.println("Erro de Entrada, Tente outro valor!");
			}
		}
	}

	static boolean GetYesOrNo(String txt) {
		System.out.println(txt);
		while (true) {
			System.out.println("(s)im ou (n)ão");
			try {
				Scanner input = new Scanner(System.in);
				String s = input.nextLine();
				if (s.toLowerCase().equals("s") || s.toLowerCase().equals("sim")) {
					return true;
				} else if (s.toLowerCase().equals("n") || s.toLowerCase().equals("nao")
						|| s.toLowerCase().equals("não")) {
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
