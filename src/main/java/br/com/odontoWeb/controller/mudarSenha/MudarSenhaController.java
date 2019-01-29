package br.com.odontoWeb.controller.mudarSenha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odontoWeb.domains.dto.DtoMudarSenha;
import br.com.odontoWeb.domains.model.Login;
import br.com.odontoWeb.service.domains.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mudar-senha")
@Api(tags = "Controller para a mudança de senha")
public class MudarSenhaController {

	FuncionarioService serviceFuncionario;

	@Autowired
	public MudarSenhaController(FuncionarioService serviceFuncionario) {
		this.serviceFuncionario = serviceFuncionario;
	}

	@PatchMapping("/{id}")
	@ApiOperation(value = "Modificar a senha de um usuário presente no sistema")
	public ResponseEntity<Login> modificarSenha(@PathVariable String id, @RequestBody DtoMudarSenha dto) {
		return new ResponseEntity<Login>(serviceFuncionario.modificarSenha(id, dto), HttpStatus.OK);
	}

	public FuncionarioService getServiceFuncionario() {
		return serviceFuncionario;
	}

	public void setServiceFuncionario(FuncionarioService serviceFuncionario) {
		this.serviceFuncionario = serviceFuncionario;
	}
	
}