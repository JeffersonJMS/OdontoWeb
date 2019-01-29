package br.com.odontoWeb.controller.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odontoWeb.domains.dto.DtoCadastro;
import br.com.odontoWeb.domains.enumerations.Regras;
import br.com.odontoWeb.service.cadastro.CadastroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/cadastro/funcionario")
@Api(tags = "Controller de cadastro de funcionários", description = "Cadastra futuros funcionários no sistema")
public class FunCadastroController {

	CadastroService serviceCadastro;
	
	@Autowired
	public FunCadastroController(CadastroService service) {
		this.serviceCadastro = service;
	}

	@PostMapping
	@ApiOperation(value = "Recebe Objeto DTO para ser utilizado para cadastro de um funcionário")
	public ResponseEntity<DtoCadastro> cadastrarFunc(@RequestBody DtoCadastro dto){
		dto.setLoginRegra(Regras.FUNCIONARIO);
		return new ResponseEntity<DtoCadastro>(serviceCadastro.cadastrar(dto), HttpStatus.CREATED);
	}

	public CadastroService getService() {
		return serviceCadastro;
	}

	public void setService(CadastroService service) {
		this.serviceCadastro = service;
	}
	
}