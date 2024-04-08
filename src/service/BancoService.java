package service;

import java.util.ArrayList;

import java.util.List;


import enuns.TipoConta;
import enuns.TipoOperacaoBancaria;
import factory.OperacaoBancariaFactory;
import model.Cliente;
import model.ClientePF;
import model.ClientePJ;
import model.Conta;
import model.ContaInvestimento;
import model.ContaPoupanca;
import serviceOpercao.OperacaoBancaria;
import service.ValidacaoService;

public class BancoService {
	
	OperacaoBancariaFactory operacaoBancariaFactory = new OperacaoBancariaFactory();
	ClienteService clienteService = new ClienteService();
	
	public void investir(Cliente cliente, double valor) {
		if (!ValidacaoService.validarCliente(cliente)) return;
		if (!ValidacaoService.validarValor(valor)) return;
		
  		ContaInvestimento contaInvestimento =  clienteService.recuperarContaInvestimento(cliente);

  		OperacaoBancaria op = operacaoBancariaFactory.getContaOperacoes(contaInvestimento, TipoOperacaoBancaria.Deposito);
 		try {
			op.realizarOperacao(contaInvestimento, valor);
		} catch (Exception e) {
		    System.out.println("Não foi possível efeturar o invertimento na conta: "+
		    		           contaInvestimento.getNumero()+ ":"+e.getMessage());
		}	 
	}
		
	public void sacar(Conta conta, double valor) {
		if (!ValidacaoService.validarConta(conta)) return;
		if (!ValidacaoService.validarValor(valor)) return;
		
		OperacaoBancaria op = operacaoBancariaFactory.getContaOperacoes(conta, TipoOperacaoBancaria.Saque);
		try {
			op.realizarOperacao(conta, valor);
		} catch (Exception e) {
		    System.out.println("Não foi possível efeturar o saque na conta ( "+conta.getNumero()+ ") : "+ e.getMessage());
		}		
	}

	public void depositar(Conta conta, double valor) {
		if (!ValidacaoService.validarConta(conta)) return;
		if (!ValidacaoService.validarValor(valor)) return;
		
		OperacaoBancaria op = operacaoBancariaFactory.getContaOperacoes(conta, TipoOperacaoBancaria.Deposito);
		try {
			op.realizarOperacao(conta, valor);
		} catch (Exception e) {
		    System.out.println("Não foi possível efeturar o depósito na conta: "+conta.getNumero()+ ":"+e.getMessage());
		}		
	}
	
	public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
		if (!ValidacaoService.validarConta(contaOrigem)) return;
		if (!ValidacaoService.validarConta(contaDestino)) return;
		if (!ValidacaoService.validarValor(valor)) return;
				
		OperacaoBancaria operacaoOrigem = operacaoBancariaFactory.getContaOperacoes(contaOrigem, TipoOperacaoBancaria.Saque);
		OperacaoBancaria operacaoDestino = operacaoBancariaFactory.getContaOperacoes(contaOrigem, TipoOperacaoBancaria.Deposito);
 	    try {
			operacaoOrigem.realizarOperacao(contaOrigem, valor);
		} catch (Exception e) {
		    System.out.println("Não foi possível efeturar o saque na conta: "+contaOrigem.getNumero()+ ":"+e.getMessage());
		    return;
		}
 	    
		try {
			operacaoDestino.realizarOperacao(contaDestino, valor);
		} catch (Exception e) {
		    System.out.println("Não foi possível efeturar o deposito na conta: "+contaDestino.getNumero()+ ":"+e.getMessage());
		}
	}
	
	
	
}
