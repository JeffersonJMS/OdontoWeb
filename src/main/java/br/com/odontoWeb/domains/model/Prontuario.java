package br.com.odontoWeb.domains.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Prontuario {

	@Id
	private String id;
	
	@NotBlank(message = "{pron.notblank}")
	private String pacienteId;
	
	@NotBlank(message = "{pron.notblank}")
	private String avPrevio;
	
	@NotBlank(message = "{pron.notblank}")
	private String exame;
	
	@NotBlank(message = "{pron.notblank}")
	private String diagPre;
	
	@NotBlank(message = "{pron.notblank}")
	private String diagPos;
	
	@NotBlank(message = "{pron.notblank}")
	private String tratEfetuados;
	
	@NotNull(message = "{pron.notNull.date}")
	private LocalDateTime data;

}
