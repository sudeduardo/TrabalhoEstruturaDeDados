import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public ArrayList<Livro> livros = new ArrayList<Livro>();
	public ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

	public static void main(String[] args) {
		
		loop:while (true) {
			
			
			Menu();
			switch (GetInput("Escolha uma opção:")) {
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
	}

	static void RemoverLivro() {

	}

	static void ListarLivro() {

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

	static int GetInput(String txt) {
		System.out.println(txt);
		while (true) {
			try {
				
				Scanner input = new Scanner(System.in);
				int n = input.nextInt();
				return n;
			} catch (Exception ex) {
				System.out.println("Erro de Entrada, Tente outro valor:");
			}
		}
	}

}
