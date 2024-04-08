package serviceOpercao;

import model.Conta;
import java.lang.Math;


public class SaquePJ extends Saque {
	
	static final Double taxaServico = 1.005;
	
	@Override
	public void realizarOperacao(Conta conta, double valor) throws Exception {
		double valorSaque =  (valor * taxaServico);
		valorSaque = valorSaque * 100;
		valorSaque = Math.round(valorSaque);
		valorSaque = valorSaque / 100;

		super.realizarOperacao(conta, valorSaque); 		
	}

}
