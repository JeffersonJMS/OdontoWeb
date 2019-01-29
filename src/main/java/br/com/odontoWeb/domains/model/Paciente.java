package br.com.odontoWeb.domains.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Paciente {

	@Id
	private String id;
	
	@Valid
	private Dados dados;
	
	@Valid
	@DBRef
	private List<Prontuario> prontuarios = new ArrayList<Prontuario>();
	
	@Valid
	@DBRef
	private Login login;
}
