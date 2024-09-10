package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void inserir(Aluno aluno) {

		try {
			var connection = ConnectionFactory.getConnetion();
			var statement = connection
					.prepareStatement("INSERT INTO aluno(id, nome, matricula, cpf) VALUES(?,?,?,?)");
			statement.setObject(1, aluno.getId());
			statement.setObject(2, aluno.getNome());
			statement.setObject(3, aluno.getMatricula());
			statement.setObject(4, aluno.getCpf());
			statement.execute();

			connection.close();

			System.out.println("\nCADASTRADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nFalha ao inserir o produto");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnetion();

			var statement = connection.prepareStatement("UPDATE aluno SET nome=?, matricula=?, cpf=? WHERE id=?");
			statement.setObject(1, aluno.getNome());
			statement.setObject(2, aluno.getMatricula());
			statement.setObject(3, aluno.getCpf());
			statement.setObject(4, aluno.getId());
			statement.execute();

			connection.close();

			System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO.");

		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar o produto");
			System.out.println(e.getMessage());
		}

	}

	public void excluir(UUID id) {

		try {

			var connection = ConnectionFactory.getConnetion();

			var statement = connection.prepareStatement("DELETE FROM aluno WHERE id=?");
			statement.setObject(1, id);
			statement.execute();

			connection.close();
			System.out.println("\nCADASTRO DO ALUNO EXCLUÍDO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nFalha ao excluir o cadastro do aluno");
			System.out.println(e.getMessage());
		}
	}

	public List<Aluno> consultar() {

		var lista = new ArrayList<Aluno>();

		try {

			var connection = ConnectionFactory.getConnetion();

			var statement = connection
					.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno ORDER BY nome ");
			var result = statement.executeQuery();

			while (result.next()) {

				var aluno = new Aluno();
				aluno.setId(UUID.fromString(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setCpf(result.getString("cpf"));

				lista.add(aluno);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println("\nFalha ao consultar o cadastro do aluno");
			System.out.println(e.getMessage());
		}

		return lista;
	}

	public Aluno obterPorId(UUID id) {

		
		Aluno aluno = null;

		try {

			
			var connection = ConnectionFactory.getConnetion();

			
			var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno WHERE id=?");
			statement.setObject(1, id);
			var result = statement.executeQuery();

			if (result.next()) {

				aluno = new Aluno();

				aluno.setId(UUID.fromString(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setCpf(result.getString("cpf"));
			}

			connection.close();
			
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar cadastro do aluno por id.");
			System.out.println(e.getMessage());
		}

		
		return aluno;
	}

public Aluno obterPorCpf(String cpf) {

		
		Aluno aluno = null;

		try {

			
			var connection = ConnectionFactory.getConnetion();

			
			var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno WHERE cpf=?");
			statement.setObject(1, cpf);
			var result = statement.executeQuery();

			if (result.next()) {

				aluno = new Aluno();

				aluno.setId(UUID.fromString(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setCpf(result.getString("cpf"));
			}

			connection.close();
			
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar cadastro do aluno por id.");
			System.out.println(e.getMessage());
		}

		
		return aluno;
	}
}
