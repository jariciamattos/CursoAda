package service;

import java.util.ArrayList;
import java.util.List;

import enuns.TipoConta;
import model.Cliente;
import model.ClientePF;
import model.ClientePJ;
import model.Conta;
import model.ContaInvestimento;
import model.ContaPoupanca;

public class ClienteService {
	
	List<Cliente> Clientes = new ArrayList<Cliente>();
	List<Conta> Contas = new ArrayList<Conta>();
	Integer contaNumero = 0; 

	public ClientePF novoClientePF(String CPF, String nome) {		
		Integer proxNumeroConta = getProximoNumeroConta();
		ClientePF cliente =  new ClientePF(CPF, nome, proxNumeroConta);
		ClientePF clienteCadastrado = (ClientePF) buscaClienteCadastrado(cliente);
		if (clienteCadastrado != null ) {
			System.out.println(" ** Cliente já cadastrado ** ");
			return clienteCadastrado;
		}
		Clientes.add(cliente);
		Contas.add(cliente.getContaPorNumero(proxNumeroConta));
		return cliente;
	};
	
	public ClientePJ novoClientePJ(String CNPJ, String nome) {
		Integer proxNumeroConta = getProximoNumeroConta();
		ClientePJ cliente =  new ClientePJ(CNPJ, nome, proxNumeroConta);
		ClientePJ clienteCadastrado = (ClientePJ) buscaClienteCadastrado(cliente);
		if (clienteCadastrado != null ) {
			System.out.println(" ** Cliente já cadastrado ** ");
			return clienteCadastrado;
		}
		Clientes.add(cliente);
		Contas.add(cliente.getContaPorNumero(proxNumeroConta));
		return cliente;		
	};

	public void abrirContaPoupanca(ClientePF cliente) {
  		 ContaPoupanca contaPoupanca = (ContaPoupanca) cliente.getContaPorTipo(TipoConta.Poupanca);
  		 if (contaPoupanca ==  null) { contaPoupanca = new ContaPoupanca(getProximoNumeroConta(), cliente);
 		     Contas.add(contaPoupanca);
  		 }else {
  			 System.out.println("Cliente já possui conta poupança: "+contaPoupanca.getNumero());
  		 }
	}
	
	public ContaInvestimento recuperarContaInvestimento(Cliente cliente) {
 		 ContaInvestimento contaInvestimento = (ContaInvestimento) cliente.getContaPorTipo(TipoConta.Inverstimento);
 		 if (contaInvestimento ==  null) { contaInvestimento = new ContaInvestimento(getProximoNumeroConta(), cliente);
		     Contas.add(contaInvestimento);
 		 } return contaInvestimento;
	}
	
	private Integer getProximoNumeroConta() {
		contaNumero  += 1;
		return contaNumero;		
	}
	
	private Cliente buscaClienteCadastrado(Cliente cliente) {
		for(Cliente c:Clientes) {
			if ((c.equals(cliente))){
				return c;
			}
		}
		return null;		
	}


}
