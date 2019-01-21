package br.com.odontoWeb.domains.factory;

import br.com.odontoWeb.domains.dto.DtoCadastro;
import br.com.odontoWeb.domains.model.Dados;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Usuario;

public class FactoryCadastro {
	
	public static Paciente dtoParaPaciente(DtoCadastro dto) {

		Dados dados = new Dados();
		dados.setNome(dto.getPacienteNome());
		dados.setIdade(dto.getPacienteIdade());
		dados.setTelefone(dto.getPacienteTelefone());
		dados.setCpf(dto.getPacienteCpf());
		dados.setRua(dto.getPacienteRua());
		dados.setNumero(dto.getPacienteNumero());
		dados.setComplemento(dto.getPacienteComplemento());
		dados.setCep(dto.getPacienteCep());
		dados.setReferencia(dto.getPacienteReferencia());
		
		Usuario usuario = new Usuario();
		usuario.setLogin(dto.getUsuarioLogin());
		usuario.setSenha(dto.getUsuarioSenha());
		usuario.setRegra(dto.getUsuarioRegra());
		
		Paciente paciente = new Paciente();
		paciente.setDados(dados);
		paciente.setUsuario(usuario);
		
		return paciente;
	}

	public static Usuario dtoParaUsuario(DtoCadastro dto) {
		Usuario usuario = new Usuario();
		usuario.setLogin(dto.getUsuarioLogin());
		usuario.setSenha(dto.getUsuarioSenha());
		usuario.setRegra(dto.getUsuarioRegra());
		return usuario;
	}
	
	public static DtoCadastro usuarioParaDto(Usuario usuario) {
		DtoCadastro dto = new DtoCadastro();
		dto.setUsuarioLogin(usuario.getLogin());
		dto.setUsuarioSenha(usuario.getSenha());
		dto.setUsuarioRegra(usuario.getRegra());
		return dto;
	}
	
	public static DtoCadastro pacienteParaDto(Paciente paciente) {
		DtoCadastro dto = new DtoCadastro();
		dto.setPacienteNome(paciente.getDados().getNome());
		dto.setPacienteIdade(paciente.getDados().getIdade());
		dto.setPacienteTelefone(paciente.getDados().getTelefone());
		dto.setPacienteCpf(paciente.getDados().getCpf());
		dto.setPacienteRua(paciente.getDados().getRua());
		dto.setPacienteNumero(paciente.getDados().getNumero());
		dto.setPacienteComplemento(paciente.getDados().getComplemento());
		dto.setPacienteCep(paciente.getDados().getCep());
		dto.setPacienteReferencia(paciente.getDados().getReferencia());
		return dto;
	}
}
