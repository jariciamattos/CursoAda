package model;

import java.lang.Integer;

import enuns.TipoConta;

public class ContaCorrente extends Conta implements ContaSemRendimento{
	public ContaCorrente(Integer numero, Cliente cliente) {
		super(numero, cliente);
		this.tipoConta = TipoConta.Corrente;	
	}
}
