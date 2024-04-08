package model;

import enuns.TipoConta;

public class ContaInvestimento extends Conta{
	
    public ContaInvestimento(Integer numero, Cliente cliente) {
		super(numero, cliente);
		this.tipoConta = TipoConta.Inverstimento;
		cliente.listaContas.add(this);
	}

}
