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
@RequestMapping("/pac/cadastro")
@Api(tags = "Controller de cadastro de pacientes", description = "Cadastra futuros Pacientes no sistema")
public class PacCadastroController {
	
	CadastroService serviceCadastro;
	
	@Autowired
	public PacCadastroController(CadastroService service) {
		this.serviceCadastro = service;
	}

	@PostMapping
	@ApiOperation(value = "Recebe objeto DTO para ser utilizado para cadastro de um Paciente")
	public ResponseEntity<DtoCadastro> cadastrarPac(@RequestBody DtoCadastro dto){
		dto.setUsuarioRegra(Regras.PACIENTE);
		return new ResponseEntity<DtoCadastro>(serviceCadastro.cadastrar(dto), HttpStatus.CREATED);
	}

	public CadastroService getService() {
		return serviceCadastro;
	}

	public void setService(CadastroService service) {
		this.serviceCadastro = service;
	}
	
}