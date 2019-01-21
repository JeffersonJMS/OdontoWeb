package br.com.odontoWeb.service.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Prontuario;
import br.com.odontoWeb.exceptions.NotFoundException;
import br.com.odontoWeb.repository.PacienteRepository;
import br.com.odontoWeb.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

	ProntuarioRepository repositoryProntuario;
	PacienteRepository repositoryPaciente;

	@Autowired
	public ProntuarioService(ProntuarioRepository repositoryProntuario, PacienteRepository repositoryPaciente) {
		this.repositoryProntuario = repositoryProntuario;
		this.repositoryPaciente = repositoryPaciente;
	}

	public Prontuario criarProntuario(Prontuario prontuario) {
		Paciente pacienteTemp = repositoryPaciente.findById(prontuario.getPacienteId()).orElseThrow(() -> new NotFoundException());
		pacienteTemp.getProntuarios().add(prontuario);
		 repositoryProntuario.insert(prontuario);
		repositoryPaciente.save(pacienteTemp);
		return prontuario;
	}
	
	public List<Prontuario> buscaPorParam(Prontuario prontuario){
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withMatcher("exame", match -> match.contains())
				.withMatcher("diagPre", match -> match.contains())
				.withMatcher("diagPos", match -> match.contains())
				.withIgnoreCase()
				.withIgnoreNullValues();
		return repositoryProntuario.findAll(Example.of(prontuario,matcher));
	}
 
	public ProntuarioRepository getRepositoryProntuario() {
		return repositoryProntuario;
	}

	public void setRepositoryProntuario(ProntuarioRepository repositoryProntuario) {
		this.repositoryProntuario = repositoryProntuario;
	}

	public PacienteRepository getRepositoryPaciente() {
		return repositoryPaciente;
	}

	public void setRepositoryPaciente(PacienteRepository repositoryPaciente) {
		this.repositoryPaciente = repositoryPaciente;
	}

}
