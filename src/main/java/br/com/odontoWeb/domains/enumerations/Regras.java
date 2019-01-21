package br.com.odontoWeb.domains.enumerations;

public enum Regras {
	
	ADMIN(0) {
		
		@Override
		public boolean isAdmin() {
			return this.getPoder() == 0;
		}
		
	},
	PACIENTE(1){
		
		@Override
		public boolean isPaciente() {
			return this.getPoder() == 1;
		}
		
	}, FUNCIONARIO(2){
		
		@Override
		public boolean isFuncionario() {
			return this.getPoder() == 2;
		}
		
	};

	private final int poder;

	Regras(int escolha) {
		this.poder = escolha;
	}

	public int getPoder() {
		return poder;
	}

	public boolean isAdmin() {
		return false;
	}

	public boolean isPaciente() {
		return false;
	}

	public boolean isFuncionario() {
		return false;
	}
}
