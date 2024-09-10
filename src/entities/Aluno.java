package entities;


import java.util.UUID;

public class Aluno {

	
	private UUID id;
	private String nome;
	private Integer matricula; 
	private String cpf;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(UUID id, String nome, Integer matricula, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	

}
