package validacao;

public class ValidaValor implements ValidaInterface<Double> {

	@Override
	public void validar(Double valor) throws Exception {
		if (valor == null) {
			throw new RuntimeException("Valor nulo");
		}
		if (valor<0) {
			throw new RuntimeException("Valor inválido");
		}
	}
}
