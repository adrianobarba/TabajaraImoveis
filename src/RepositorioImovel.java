public class RepositorioImovel {

	private Imoveis[] imoveis;
	private int indice;

	public RepositorioImovel(int tamanho) {
		imoveis = new Imoveis[1000];
		indice = 0;

	}

	private int procurarIndice(String numero) {
		int i = 0;
		boolean achou;
		for (achou = false; !achou && i < indice;) {
			if (imoveis[i].getCodigo().equals(numero)) {
				achou = true;
			} else {
				i++;
			}
		}
		if (!achou)
			i = -1;
		return i;
	}

	public Imoveis procurar(String numero) {
		Imoveis m = null;
		int i = procurarIndice(numero);
		if (i == -1) {
			return null;
		} else {
			m = imoveis[i];
			return m;
		}
	}

	public void inserir(Imoveis m) {
		if (indice < imoveis.length) {
			if (m != null) {
				if (procurar(m.getCodigo()) == null) {
					imoveis[indice] = m;
					indice = indice + 1;
				}
			} else {
				System.out.println("Conta inválida");
			}
		} else
			System.out.println("Repositório cheio");
	}

	public boolean atualizar(Imoveis m) {
		int i = procurarIndice(m.getCodigo());
		if (i != -1) {
			imoveis[i] = m;
			return true;
		} else {
			return false;
		}

	}

	public boolean remover(String numero) {

		int i = procurarIndice(numero);
		if (i != -1) {
			indice = indice - 1;
			imoveis[i] = imoveis[indice];
			imoveis[indice] = null;
			return true;
		} else {
			return false;
		}
	}

	public boolean existe(String numero) {
		int i = procurarIndice(numero);
		return i != -1;
	}
}

