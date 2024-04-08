package serviceOpercao;

import model.Conta;

@FunctionalInterface
public interface OperacaoBancaria<C extends Conta> {
 
	void realizarOperacao(C conta, double valor) throws Exception;
}
