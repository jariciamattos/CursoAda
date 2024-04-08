package validacao;

import model.Conta;

public class ValidaContaNull implements ValidaInterface<Conta>{
	@Override
	public void validar(Conta conta) throws Exception{
		if (conta == null) {
			throw new RuntimeException("Conta nulo");		
		}		
	}

}
