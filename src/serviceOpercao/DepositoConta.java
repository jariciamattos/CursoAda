package serviceOpercao;

import model.Conta;

public class DepositoConta implements OperacaoBancaria<Conta> {
	
	@Override
	public void realizarOperacao(Conta conta, double valor) {
		conta.deposito(valor);			
	}

}
