package br.com.odontoWeb.domains.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoUpdatePaciente implements Serializable{

	private static final long serialVersionUID = -4085247227193174781L;

	private String nomeDados;
	
	private byte idadeDados;
	
	private int telefoneDados;
	
	private String cpfDados;
	
	private String ruaDados;
	
	private int numeroCasaDados;
	
	private String complementoDados;
	
	private int cepDados;
	
	private String referenciaDados;
}
