package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {
	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAluno() {

		try {

			System.out.println("NOME DO ALUNO......:");
			var nome = scanner.nextLine();

			System.out.println("MATRICULA DO ALUNO.:");
			var matricula = scanner.nextLine();

			System.out.println("CPF DO ALUNO.......:");
			var cpf = scanner.nextLine();

			var aluno = new Aluno(UUID.randomUUID(), nome, Integer.parseInt(matricula), cpf);

			var alunoRepository = new AlunoRepository();
			alunoRepository.inserir(aluno);

		} catch (Exception e) {
			System.out.println("\n Falha ao cadastrar Aluno!");
			System.out.println(e.getMessage());
		}

	}

	public void atualizarAluno() {

		try {
			System.out.println("\nATUALIZAÇÃO DO CADASTRO DOS ALUNOS:\n");

			System.out.println("INFORME O ID DO ALUNO.:");
			var id = UUID.fromString(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID........: " + aluno.getId());
				System.out.println("NOME......: " + aluno.getNome());
				System.out.println("MATRICULA.: " + aluno.getMatricula());
				System.out.println("CPF.......: " + aluno.getCpf());
				System.out.println("");

				System.out.println("ALTERE O NOME......: ");
				aluno.setNome(scanner.nextLine());
				
				System.out.println("ALTERE A MATRICULA.: ");
				aluno.setMatricula(Integer.parseInt(scanner.nextLine()));

				System.out.print("ALTERE O CPF.........: ");
				aluno.setCpf(scanner.nextLine());

				alunoRepository.atualizar(aluno);

			} else {
				System.out.println("\nCadastro do aluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar o produto!");
			System.out.println(e.getMessage());
		}
	}

	public void excluirAluno() {

		try {
			System.out.println("\nEXCLUSÂO DO CADASTRO DE ALUNOS:\n");

			System.out.println("INFORME O ID DO ALUNO.:");
			var id = UUID.fromString(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID........: " + aluno.getId());
				System.out.println("NOME......: " + aluno.getNome());
				System.out.println("MATRICULA.: " + aluno.getMatricula());
				System.out.println("CPF.......: " + aluno.getCpf());
				System.out.println("");

				alunoRepository.excluir(aluno.getId());

			} else {
				System.out.println("\nCadastro do aluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao excluir o cadastro do aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void consultarAluno() {

		try {

			System.out.println("\nCONSULTA DE CADASTRO DE ALUNOS\n");

			
			var alunoRepository = new AlunoRepository();
			var lista = alunoRepository.consultar();

		
			for (Aluno aluno : lista) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID........: " + aluno.getId());
				System.out.println("NOME......: " + aluno.getNome());
				System.out.println("MATRICULA.: " + aluno.getMatricula());
				System.out.println("CPF.......: " + aluno.getCpf());
				System.out.println("");

			}
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar o cadastro dos alunos");
			System.out.println(e.getMessage());
		}
	}
	
	public void consultarAlunoCpf() {

		try {
			System.out.println("\nCONSULTA CADASTRO DOS ALUNOS:\n");

			System.out.println("INFORME O CPF DO ALUNO.:");
			var cpf = scanner.nextLine();

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorCpf(cpf);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID........: " + aluno.getId());
				System.out.println("NOME......: " + aluno.getNome());
				System.out.println("MATRICULA.: " + aluno.getMatricula());
				System.out.println("CPF.......: " + aluno.getCpf());
				System.out.println("");

				
			} else {
				System.out.println("\nCadastro do aluno não encontrado. Verifique o CPF informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar o produto!");
			System.out.println(e.getMessage());
		}
	}
}