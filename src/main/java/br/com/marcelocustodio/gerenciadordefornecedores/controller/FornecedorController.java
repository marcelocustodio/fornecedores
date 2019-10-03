package br.com.marcelocustodio.gerenciadordefornecedores.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.marcelocustodio.gerenciadordefornecedores.bean.Fornecedor;
import br.com.marcelocustodio.gerenciadordefornecedores.service.FornecedorService;

@Path("/crud")
public class FornecedorController {

	FornecedorService fornecedorService = new FornecedorService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fornecedor> listarTodosFornecedores() {

		List<Fornecedor> listaDeFornecedores = fornecedorService.listarTodosFornecedores();
		return listaDeFornecedores;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fornecedor exibirFornecedor(@PathParam("id") int id) throws Exception {
		return fornecedorService.exibirFornecedor(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Fornecedor adicionarFornecedor(Fornecedor user) {
		System.out.println("[Back-end] Adicionando " + user.getName());
		return fornecedorService.adicionarFornecedor(user);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Fornecedor atualizarFornecedor(Fornecedor user) {
		return fornecedorService.atualizarFornecedor(user);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirFornecedor(@PathParam("id") int id) {
		fornecedorService.excluirFornecedor(id);

	}

}
