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

import br.com.odontoWeb.domains.model.Login;
import br.com.odontoWeb.service.domains.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/logins")
@Api(tags = "Controller de Logins", description = "Ações pertencentes ao logins de pacientes,funcionários e ADMIN")
public class LoginController {

	FuncionarioService serviceFuncionario;
	
	@Autowired
	public LoginController(FuncionarioService serviceFuncionario) {
		this.serviceFuncionario = serviceFuncionario;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os usuários cadastrados")
	public ResponseEntity<List<Login>> listarUsuarios(){
		return new ResponseEntity<List<Login>>(serviceFuncionario.buscarTodosFuncionarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um usuário em específico por meio do seu id")
	public ResponseEntity<Login> listarUsuarioID(@PathVariable String id){
		return new ResponseEntity<Login>(serviceFuncionario.buscarFuncionarioPorId(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um usuário o qual os parametros de busca tenhão correspondido")
	public ResponseEntity<Login> deletarUsuario(@PathVariable String id){
		serviceFuncionario.deletarFuncionario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public FuncionarioService getService() {
		return serviceFuncionario;
	}

	public void setService(FuncionarioService serviceFuncionario) {
		this.serviceFuncionario = serviceFuncionario;
	}
	
}
