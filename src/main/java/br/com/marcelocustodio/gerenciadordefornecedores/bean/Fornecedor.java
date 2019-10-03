package br.com.marcelocustodio.gerenciadordefornecedores.bean;

public class Fornecedor {

	int id;
	String name;
	String email;
	String cnpj;
	String comment;

	public Fornecedor() {
		super();
	}

	public Fornecedor(int i, String name, String email, String cnpj, String comment) {
		super();
		this.id = i;
		this.name = name;
		this.email = email;
		this.cnpj = cnpj;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}