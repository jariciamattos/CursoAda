package serviceOpercao;

import model.ContaInvestimento;

public class DepositoInvertimento implements OperacaoBancaria<ContaInvestimento> {

	@Override
	public void realizarOperacao(ContaInvestimento conta, double valor) {		
		double valorComRendimento = valor * conta.getCliente().getTaxaInvestimento();
		
		valorComRendimento = valorComRendimento * 100;
		valorComRendimento = Math.round(valorComRendimento);
		valorComRendimento = valorComRendimento / 100;

        conta.deposito(valorComRendimento);    		
	}

}
