<!DOCTYPE html>
<html lang="en">
<head>
<title>CRUD RESTful AngularJS-Jersey CRUD para gerenciamento de fornecedores</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>


<script type="text/javascript">
	var app = angular.module("fornecedorManagement", []);

	app.controller("fornecedorController", function($scope, $http) {

		$scope.listaDeFornecedores = [];

		$scope.formulario = {
			id : -1,
			name : "",
			email : "",
			cnpj : "",
			comment : ""
		};

		_carregarDadosNaTabela();

		$scope.salvarFornecedor = function() {

			var method = "";
			var url = "";
			if ($scope.formulario.id == -1) {
				// Id não existe criar novo fornecedor
				method = "POST";
				url = 'api/crud';
			} else {
				// Id é presente então atualiza
				method = "PUT";
				url = 'api/crud';
			}

			$http({
				method : method,
				url : url,
				data : angular.toJson($scope.formulario),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(_success, _error);
		};

		$scope.excluirFornecedor = function(fornecedor) {
			$http({
				method : 'DELETE',
				url : 'api/crud/' + fornecedor.id
			}).then(_success, _error);
		};

		$scope.editarFornecedor = function(fornecedor) {

			$scope.formulario.name = fornecedor.name;
			$scope.formulario.email = fornecedor.email;
			$scope.formulario.cnpj = fornecedor.cnpj;
			$scope.formulario.comment = fornecedor.comment;
			$scope.formulario.id = fornecedor.id;
		};

		function _carregarDadosNaTabela() {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/gerenciadordefornecedores/api/crud'
			}).then(function successCallback(response) {
				$scope.listaDeFornecedores = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		function _success(response) {
			_carregarDadosNaTabela();
			_limparCamposDoFormulario()
		}

		function _error(response) {
			console.log(response.statusText);
		}

		function _limparCamposDoFormulario() {
			$scope.formulario.id = -1;
			$scope.formulario.name = "";
			$scope.formulario.email = "";
			$scope.formulario.cnpj = "";
			$scope.formulario.comment = "";

		}
		;

	});
</script>


</head>
<body>

	<div class="container" ng-app="fornecedorManagement"
		ng-controller="fornecedorController">
		
		<h1>CRUD RESTful AngularJS-Jersey para gerenciamento de fornecedores</h1>
		
		<h2>Formulario</h2>
		<form ng-submit="salvarFornecedor()">
			<div class="form-group">
				<label for="name">Name:</label> 
			    <input type="text" class="form-control" id="name" placeholder="Informe o nome" name="name" ng-model="formulario.name">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="text" class="form-control" id="email" placeholder="Informe o email" name="email" ng-model="formulario.email">
			</div>
			<div class="form-group">
				<label for="cnpj">CNPJ:</label> 
				<input type="text" class="form-control" id="cnpj" placeholder="Informe o CNPJ" name="cnpj" ng-model="formulario.cnpj">
			</div>
			<div class="form-group">
				<label for="email">Comment:</label> 
				<input type="text" class="form-control" id="comment" placeholder="Informe um comentario" name="comment" ng-model="formulario.comment">
			</div>

			<button type="submit" class="btn btn-default">Salvar</button>
		</form>

		<h2>Lista de Fornecedores</h2>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>CNPJ</th>
					<th>Comment</th>
					<th>ACAO</th>
				</tr>	
			</thead>
			<tbody>
				<tr ng-repeat="fornecedor in listaDeFornecedores">

					<td>{{fornecedor.name}}</td>
					<td>{{fornecedor.email}}</td>
					<td>{{fornecedor.cnpj}}</td>
					<td>{{fornecedor.comment}}</td>

					<td>
						<a ng-click="editarFornecedor(fornecedor)">Editar</a> | 
						<a ng-click="excluirFornecedor(fornecedor)">Excluir</a>
					</td>
					
				</tr>
			</tbody>
		</table>

	</div>

</body>
</html>
