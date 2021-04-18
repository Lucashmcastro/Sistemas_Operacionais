public class Fila{
	private int cont , entrada, saida;
	private Object[] buffer;
	private int capacidade = 0;
	
	public Fila (int tamCap) {
		cont = 0;
		entrada = 0;
		saida = 0;
		buffer = new Object[tamCap];
		capacidade  = tamCap;
	}
	
	public synchronized void inserir(Object item) {
		while (cont == capacidade) {
			try {
				wait();
			}
			catch(Exception e) {}
		}
	
		++cont;
		buffer[entrada] = item;
		entrada = (entrada + 1) % capacidade; // caso a fila chegue no final do buffer ele volta a 0 
		
		notify();
		
	}
	
	public synchronized Object remover() {
		Object item;
		
		while(cont == 0) {
			try{				
				wait();				
			}
			catch(Exception e) {}	
		}
		
		--cont;
		item = buffer[saida];
		saida = (saida + 1) % capacidade; 
		
		notify();
		
		return item;
		
	}
	
	public boolean Verificar() {
		if(cont == 0) {
			return  true;
		}
		
		return false;
			
	}

}
