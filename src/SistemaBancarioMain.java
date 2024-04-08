import java.util.ArrayList;
import java.util.List;

import enuns.TipoConta;
import model.Cliente;
import model.ClientePF;
import model.ClientePJ;
import model.ContaCorrente;
import service.BancoService;
import service.ClienteService;

import java.util.Collections ;

public class SistemaBancarioMain {

	public static void main(String[] args) {
		
		BancoService bancoService = new BancoService();
		ClienteService clienteService = new ClienteService();
		
		ClientePF clientePF1 = clienteService.novoClientePF("012.345.678-90", "Jaricia");
		ClientePJ clientePJ1 = clienteService.novoClientePJ("01.234.567/0001-01", "Restaurante Hoje");
//		ClientePF clientePF2 = clienteService.novoClientePF("012.345.678-90", "outra Jaricia");
//		ClientePJ clientePJ2 = clienteService.novoClientePJ("01.234.567/0001-01", "Outro Restaurante");
		
		clienteService.abrirContaPoupanca(clientePF1);
//		clienteService.abrirContaPoupanca(clientePF1);
		bancoService.depositar(clientePF1.getContaPorTipo(TipoConta.Corrente), 100);
		bancoService.depositar(clientePF1.getContaPorTipo(TipoConta.Poupanca), 500);
		
		bancoService.transferir(clientePF1.getContaPorTipo(TipoConta.Poupanca),
				                clientePJ1.getContaPorTipo(TipoConta.Corrente), 200);

		bancoService.investir(clientePJ1, 1000);
		bancoService.investir(clientePF1, 1000);
		
	/*	System.out.println(clientePF1.getContaPorTipo(TipoConta.Corrente).toString());
		System.out.println(clientePJ1.getContaPorTipo(TipoConta.Corrente).toString());
		System.out.println("================= \n =======================");
*/
		bancoService.sacar(clientePJ1.getContaPorTipo(TipoConta.Corrente), 20);
		bancoService.sacar(clientePF1.getContaPorTipo(TipoConta.Corrente), 20);
		
		System.out.println(clientePJ1.getContaPorTipo(TipoConta.Inverstimento).toString());
		
		bancoService.transferir(clientePJ1.getContaPorTipo(TipoConta.Inverstimento),
                                clientePF1.getContaPorTipo(TipoConta.Inverstimento), 1000);
		
		System.out.println(clientePJ1.getContaPorTipo(TipoConta.Inverstimento).toString());
        
		//System.out.println(clientePF1.toString());
		//System.out.println(clientePJ1.toString());
		
	}

}
