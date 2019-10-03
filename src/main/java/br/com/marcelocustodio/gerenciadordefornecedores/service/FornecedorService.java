 package br.com.marcelocustodio.gerenciadordefornecedores.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.marcelocustodio.gerenciadordefornecedores.bean.Fornecedor;


public class FornecedorService {

	static HashMap<Integer,Fornecedor> fornecedorIdMap=getFornecedorIdMap();


	public FornecedorService() {
		super();

		if(fornecedorIdMap==null)
		{
			fornecedorIdMap=new HashMap<Integer,Fornecedor>();
			
			// Criando alguns objetos como 
			/*Fornecedor usera=new Fornecedor(1, "Ashen", "email1@email.com", "0001", "comment 1");
			Fornecedor userb=new Fornecedor(4, "John", "email2@email.com", "0002", "comment 2");
			Fornecedor userc=new Fornecedor(3, "Jack", "email3@email.com", "0003", "comment 3");
			Fornecedor userd=new Fornecedor(2, "shane", "email4@email.com", "0004", "comment 4");


			fornecedorIdMap.put(1,usera);
			fornecedorIdMap.put(4,userb);
			fornecedorIdMap.put(3,userc);
			fornecedorIdMap.put(2,userd);
			*/
		}
	}

	public List<Fornecedor> listarTodosFornecedores()
	{
		List<Fornecedor> listaDeFornecedores = new ArrayList<Fornecedor>(fornecedorIdMap.values());
		return listaDeFornecedores;
	}

	public Fornecedor exibirFornecedor(int id) throws Exception
	{
		Fornecedor fornecedor= fornecedorIdMap.get(id);

		if(fornecedor == null)
		{
			throw new Exception("fornecedor com id " + id + " não encontrado.");
		}
		return fornecedor;
	}
	
	public Fornecedor adicionarFornecedor(Fornecedor fornecedor)
	{
		fornecedor.setId( getMaxId() + 1 );
		fornecedorIdMap.put(fornecedor.getId(), fornecedor);
		return fornecedor;
	}

	public Fornecedor atualizarFornecedor(Fornecedor fornecedor)
	{
		if(fornecedor.getId()<=0)
			return null;
		fornecedorIdMap.put(fornecedor.getId(), fornecedor);
		return fornecedor;

	}
	public void excluirFornecedor(int id)
	{
		fornecedorIdMap.remove(id);
	}

	public static HashMap<Integer, Fornecedor> getFornecedorIdMap() {
		return fornecedorIdMap;
	}

	
	public static int getMaxId() {
		int max=0;
		for (int id:fornecedorIdMap.keySet()) {
			if(max<=id) {
				max=id;
			}
		}
		return max;
	}
	
}
