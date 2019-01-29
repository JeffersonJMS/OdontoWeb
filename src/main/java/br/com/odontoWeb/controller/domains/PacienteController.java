package br.com.odontoWeb.controller.domains;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.odontoWeb.domains.dto.DtoUpdatePaciente;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Prontuario;
import br.com.odontoWeb.service.domains.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/pacientes")
@Api(tags = "Controller de Paciente", description = "Ações pertencentes ao paciente")
public class PacienteController {

	PacienteService servicePaciente;

	@Autowired
	public PacienteController(PacienteService service) {
		this.servicePaciente = service;
	}
 
	@GetMapping
	@ApiOperation(value = "Busca todos os pacientes cadastrados")
	public ResponseEntity<List<Paciente>> listarPacientes() {
		return new ResponseEntity<List<Paciente>>(servicePaciente.buscarTodosPacientes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um paciente em específico pelo seu id")
	public ResponseEntity<Paciente> listarPacienteId(@PathVariable String id) {
		return new ResponseEntity<Paciente>(servicePaciente.buscarPacientePorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza os dados de um paciente com base no id")
	public ResponseEntity<Paciente> atualizarPaciente(@RequestBody DtoUpdatePaciente dto, @PathVariable String id) {
		return new ResponseEntity<Paciente>(servicePaciente.atualizarPaciente(dto, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um paciente tomando como referência seu id")
	public ResponseEntity<Paciente> deletarPaciente(@PathVariable String id) {
		servicePaciente.deletarPaciente(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}/prontuarios")
	@ApiOperation(value = "Lista todos os prontuários relacionados a um paciente em específico")
	public ResponseEntity<List<Prontuario>> buscarProntuariosPorPaciente(@PathVariable String id) {
		return new ResponseEntity<List<Prontuario>>(servicePaciente.buscarProntuariosPaciente(id), HttpStatus.OK);
	}

	@GetMapping("/search")
	@ApiOperation(value = "Busca todos os pacientes os quais correspondão aos parâmetros passados")
	public ResponseEntity<List<Paciente>> buscaPacientes(Paciente paciente){
		return new ResponseEntity<List<Paciente>>(servicePaciente.buscarPaciente(paciente), HttpStatus.OK);
	}

	@GetMapping("/{id}/prontuarios/mes")
	@ApiOperation(value = "Busca todos os prontuários de uma paciente que correspondam a data com mes e ano iguais")
	public ResponseEntity<List<Prontuario>> buscarProntuariosPorMes(@PathVariable String id, @RequestParam("data") @DateTimeFormat(iso = ISO.DATE_TIME)LocalDateTime localDateTime){
		return new ResponseEntity<List<Prontuario>>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}/prontuarios/ano")
	@ApiOperation(value = "Busca todos os prontuários de uma paciente que correspondam a data com o ano igual")
	public ResponseEntity<List<Prontuario>> buscaProntuariosPorAno(@PathVariable String id, @RequestParam("data") @DateTimeFormat(iso = ISO.DATE_TIME)LocalDateTime localDateTime){
		return new ResponseEntity<List<Prontuario>>(HttpStatus.OK);
	}
	
	public PacienteService getService() {
		return servicePaciente;
	}

	public void setService(PacienteService service) {
		this.servicePaciente = service;
	}
}
