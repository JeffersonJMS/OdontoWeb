package br.com.odontoWeb.controller.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odontoWeb.domains.model.Usuario;
import br.com.odontoWeb.service.domains.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
@Api(tags = "Controller de Usuários", description = "Ações pertencentes ao usuário")
public class UsuarioController {

	FuncionarioService service;
	
	@Autowired
	public UsuarioController(FuncionarioService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os usuários cadastrados")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return new ResponseEntity<List<Usuario>>(service.buscarTodosFuncionarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um usuário em específico por meio do seu id")
	public ResponseEntity<Usuario> listarUsuarioID(@PathVariable String id){
		return new ResponseEntity<Usuario>(service.buscarFuncionarioPorId(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um usuário o qual os parametros de busca tenhão correspondido")
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable String id){
		service.deletarFuncionario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public FuncionarioService getService() {
		return service;
	}

	public void setService(FuncionarioService service) {
		this.service = service;
	}
	
}
