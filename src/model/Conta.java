package model;

import java.time.LocalDateTime;

import enuns.TipoConta;


public abstract class Conta {
	
	private Integer numero;
	private double saldo;
	private LocalDateTime dataCriacao;	
	private Cliente cliente;
	protected TipoConta tipoConta;
	
	public Conta(Integer numero, Cliente cliente) {
		this.numero = numero;
		this.saldo = 0.0;
		this.dataCriacao = LocalDateTime.now();
		this.setCliente(cliente);
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
		
	public void saque(double valor) {
		if (valor <= saldo) {
			saldo -= valor;
		}
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}

	public double consultaSaldo() {
		return saldo;
	}
	
	
	public void transferencia(Conta contaDestino, double valor) {
		   this.saque(valor);	
		   contaDestino.deposito(valor);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	@Override
	public String toString() {
		return "Conta "+tipoConta+ ": " + numero +
			   "\n saldo=" + saldo + 
			   "\n dataCriacao=" + dataCriacao + 
			   "\n cliente=" + cliente.nome;
	}

}
