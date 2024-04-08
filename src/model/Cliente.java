package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import enuns.StatusClienteEnum;
import enuns.TipoConta;

public abstract class Cliente {
	
	protected String id;
	public String nome;
	protected Date dataCadastro;
	protected StatusClienteEnum status; 
	public List<Conta> listaContas =  new ArrayList<Conta>();
	protected double taxaRentabilidadeInvestimento;
    
	public Cliente(String id, String nome, Integer numeroContaCorrente) {
		this.id = id;
		this.nome = nome;
		this.dataCadastro = new Date();
		this.status = StatusClienteEnum.Ativo;	
		listaContas.add(new ContaCorrente(numeroContaCorrente, this));
	}
	
	public StatusClienteEnum getStatus() {
		return status;
	}
	
	public Conta getContaPorNumero(Integer numero) {
		//Conta contaLocalizada = (Conta) listaContas.stream().filter(conta-> conta.getNumero().equals(numero));
		for(Conta conta:listaContas) {
			if (conta.getNumero().equals(numero)){
				return conta;
			}
		}
		return null;		
	}
	
	public Conta getContaPorTipo(TipoConta tipo) {
//		Conta contaLocalizada = (Conta) listaContas.stream().filter(conta-> conta.getTipoConta().equals(tipo));
		for(Conta conta:listaContas) {
			if (conta.getTipoConta().equals(tipo)){
				return conta;
			}
		}
		return null;		
	}

	public String getId() {
		return this.id;
	}

	public double getTaxaInvestimento() {
		return this.taxaRentabilidadeInvestimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
