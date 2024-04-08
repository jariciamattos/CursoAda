package serviceOpercao;

import model.Conta;

public class Saque implements OperacaoBancaria<Conta> {

	@Override
	public void realizarOperacao(Conta conta, double valor) throws Exception{
		if (conta.consultaSaldo() >= valor) {
			 conta.saque(valor);
		} else {
			throw new RuntimeException("Saldo Insuficiente");			
		}						
		
	}

}
