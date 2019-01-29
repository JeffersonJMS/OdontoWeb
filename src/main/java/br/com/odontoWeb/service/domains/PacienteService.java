package br.com.odontoWeb.service.domains;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.odontoWeb.domains.dto.DtoUpdatePaciente;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Prontuario;
import br.com.odontoWeb.exceptions.NotFoundException;
import br.com.odontoWeb.repository.PacienteRepository;

@Service
public class PacienteService {

	PacienteRepository repository;
	FuncionarioService usuarioService;

	@Autowired
	public PacienteService(PacienteRepository repository, FuncionarioService usuarioService) {
		this.usuarioService = usuarioService;
		this.repository = repository;
	}

	public List<Paciente> buscarTodosPacientes() {
		return repository.findAll();
	}

	public Paciente buscarPacientePorId(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public Paciente criarPaciente(Paciente paciente) {
		usuarioService.criarFuncionario(paciente.getLogin());
		return repository.insert(paciente);
	}

	public Paciente atualizarPaciente(DtoUpdatePaciente dto, String id) {
		Paciente pacienteTemp = repository.findById(id).orElseThrow(() -> new NotFoundException());
		pacienteTemp.getDados().setNome(dto.getNomeDados());
		pacienteTemp.getDados().setIdade(dto.getIdadeDados());
		pacienteTemp.getDados().setTelefone(dto.getTelefoneDados());
		pacienteTemp.getDados().setCpf(dto.getCpfDados());
		pacienteTemp.getDados().setRua(dto.getRuaDados());
		pacienteTemp.getDados().setNumeroCasa(dto.getNumeroCasaDados());
		pacienteTemp.getDados().setComplemento(dto.getComplementoDados());
		pacienteTemp.getDados().setCep(dto.getCepDados());
		pacienteTemp.getDados().setReferencia(dto.getReferenciaDados());
		return repository.save(pacienteTemp);
	}

	public void deletarPaciente(String id) {
		repository.findById(id).orElseThrow(() -> new NotFoundException());
		repository.deleteById(id);
	}
	
	public List<Paciente> buscarPaciente(Paciente paciente){
		ExampleMatcher macther = ExampleMatcher.matchingAll()
				.withMatcher("nome", match -> match.contains())
				.withMatcher("cpf", match -> match.contains())
				.withIgnoreCase()
				.withIgnoreNullValues();
		return repository.findAll(Example.of(paciente, macther));
	}
	
	public List<Prontuario> buscaProntuarioPorMes(String id, LocalDateTime localDateTime) {
		List<Prontuario> prontuarios = repository.findById(id).orElseThrow(() -> new NotFoundException()).getProntuarios();
		List<Prontuario> prontuTemp = new ArrayList<Prontuario>();
		for (int i = 0; i < prontuarios.size(); i++) {
			if((prontuarios.get(i).getData().getYear() == localDateTime.getYear()) && prontuarios.get(i).getData().getMonthValue() == localDateTime.getMonthValue()) {
				prontuTemp.add(prontuarios.get(i));
			}
		}
		return prontuTemp;
	}
	
	public List<Prontuario> buscaProntuarioPorAno(String id, LocalDateTime localDateTime){
		List<Prontuario> prontuarios = repository.findById(id).orElseThrow(() -> new NotFoundException()).getProntuarios();
		List<Prontuario> prontuTemp = new ArrayList<Prontuario>();
		for (int i = 0; i < prontuarios.size(); i++) {
			if(prontuarios.get(i).getData().getYear() == localDateTime.getYear()) {
				prontuTemp.add(prontuarios.get(i));
			}
		}
		return prontuTemp;
	}

	public List<Prontuario> buscarProntuariosPaciente(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException()).getProntuarios();
	}

	public PacienteRepository getRepository() {
		return repository;
	}

	public void setRepository(PacienteRepository repository) {
		this.repository = repository;
	}

}
