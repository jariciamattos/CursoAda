package model;

public class ClientePJ extends Cliente{

	public ClientePJ(String CNPJ, String nome, Integer numeroContaCorrente) {
		super(CNPJ, nome, numeroContaCorrente);
		this.taxaRentabilidadeInvestimento = 1.02;
	}

	public String getCNPJ() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Cliente CNPJ= " + id +
				"\n Nome=" + nome +
				"\n Data Cadastro= " + dataCadastro +
				"\n Status=" + status +
				"\n Taxa de Rentabilidade em Investimento =" + taxaRentabilidadeInvestimento +
				"\n Contas =" + listaContas ;
	}
}
