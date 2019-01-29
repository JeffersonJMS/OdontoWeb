package br.com.odontoWeb.domains.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dados {
	
	@NotBlank(message = "{dados.nome.notblank}")
	@Size(min = 4, max = 30, message = "{dados.nome.size}")
	private String nome;
	
	@NotNull(message = "{dados.idade.notnull}")
	@Positive(message = "{dados.idade.positive}")
	private byte idade;
	
	@NotNull(message = "{dados.telefone.notnull}")
	@Positive(message = "{dados.telefone.positive}")
	private int telefone;

	@Indexed(unique = true)
	@NotNull(message  = "{dados.cpf.notnull}")
	@Size(min = 11, max = 11, message = "{dados.cpf.size}")
	/*@CPF(message = "{dados.cpf.cpf}")*/
	private String cpf;
	
	@NotBlank(message = "{dados.rua.notblank}")
	private String rua;
	
	@NotNull(message  = "{dados.numero.notnull}")
	@Positive(message = "{dados.numero.positive}")
	private int numeroCasa;
	
	private String complemento;
	
	@NotNull(message = "{dados.cep.notnull}")
	@Positive(message = "{dados.cep}")
	@Size(min = 8, max = 8, message = "{dados.cep.size}")
	private int cep;
	
	private String referencia;
		
}
