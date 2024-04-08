package model;

import enuns.TipoConta;

public class ContaPoupanca extends Conta implements ContaSemRendimento {

	public ContaPoupanca(Integer numero, Cliente cliente) {
		super(numero, cliente);
		this.tipoConta = TipoConta.Poupanca;
	    cliente.listaContas.add(this);
	}

}
