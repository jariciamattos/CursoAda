package service;

import model.Cliente;
import model.Conta;

public class ValidacaoService {
	
    public static boolean validarCliente(Cliente cliente) {
    	if (cliente == null) {
    		System.out.println("Cliente nulo");
    		return false;
		}		
    	return true;
    }
    
    public static boolean validarConta(Conta conta) {
    	if (conta == null) {
    		System.out.println("Conta nula");	
    		return false;
		}	
    	return true;
    }

    public static boolean validarValor(double valor) {
		if (valor<0) {
			System.out.println("Valor inválido :" + valor);
			return false;
		}		
		return true;    	
    }
    


}
