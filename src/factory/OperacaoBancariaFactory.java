package factory;

import enuns.TipoOperacaoBancaria;
import model.ClientePJ;
import model.Conta;
import model.ContaInvestimento;
import serviceOpercao.DepositoConta;
import serviceOpercao.DepositoInvertimento;
import serviceOpercao.OperacaoBancaria;
import serviceOpercao.Saque;
import serviceOpercao.SaquePJ;

public class OperacaoBancariaFactory {
	
	public OperacaoBancaria getContaOperacoes(Conta conta, TipoOperacaoBancaria tipo) {
		if (tipo == TipoOperacaoBancaria.Deposito) {
			if (conta instanceof ContaInvestimento) { return new DepositoInvertimento();}
			
			return new DepositoConta();
		} else if (tipo == TipoOperacaoBancaria.Saque) {
			if (conta.getCliente() instanceof ClientePJ) { return new SaquePJ();}
			
			return new Saque();
		}
		
		return null;
		
	}

}
