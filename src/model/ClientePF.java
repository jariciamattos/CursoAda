package model;

public class ClientePF extends Cliente{

	public ClientePF(String CPF, String nome, Integer numeroContaCorrente) {	
    	super(CPF, nome, numeroContaCorrente);
    	this.taxaRentabilidadeInvestimento = 1.01;
	}
	
	public String getCPF() {
		return id;
	}

	@Override
	public String toString() {
		return "Cliente CPF= " + id +
				"\n Nome=" + nome +
				"\n Data Cadastro= " + dataCadastro +
				"\n Status=" + status +
				"\n Taxa de Rentabilidade em Investimento =" + taxaRentabilidadeInvestimento +
				"\n Contas =" + listaContas 
				+"\n\n";
	}
	
	
}
