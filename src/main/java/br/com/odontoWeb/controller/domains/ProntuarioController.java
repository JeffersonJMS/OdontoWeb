package br.com.odontoWeb.controller.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.odontoWeb.domains.model.Prontuario;
import br.com.odontoWeb.service.domains.ProntuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/prontuarios")
@Api(tags = "Controller de Prontuários", description = "Ações pertencentes ao prontuário")
public class ProntuarioController {

	ProntuarioService serviceProntuario;

	@Autowired
	public ProntuarioController(ProntuarioService service) {
		this.serviceProntuario = service;
	}

	@PostMapping
	@ApiOperation(value = "Relaciona um prontuário a um paciente em específico")
	public ResponseEntity<Prontuario> criarProntuario(@RequestBody Prontuario prontuario) {
		return new ResponseEntity<Prontuario>(serviceProntuario.criarProntuario(prontuario), HttpStatus.CREATED);
	}

	@GetMapping("/search")
	@ApiOperation(value = "Busca prontuários os quais correspondam a um parametro de busca")
	public ResponseEntity<List<Prontuario>> buscarProntuariosPorParam(Prontuario prontuario){
		return new ResponseEntity<List<Prontuario>>(serviceProntuario.buscaPorParam(prontuario), HttpStatus.OK);
	}
	
	public ProntuarioService getServiceProntuario() {
		return serviceProntuario;
	}

	public void setServiceProntuario(ProntuarioService serviceProntuario) {
		this.serviceProntuario = serviceProntuario;
	}

}