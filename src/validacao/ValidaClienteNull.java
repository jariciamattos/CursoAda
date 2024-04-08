package validacao;

import model.Cliente;

public class ValidaClienteNull implements ValidaInterface<Cliente> {

	@Override
	public  void validar(Cliente cliente) throws Exception{
		if (cliente == null) {
			throw new RuntimeException("Cliente nulo");		
		}		
	}

}
