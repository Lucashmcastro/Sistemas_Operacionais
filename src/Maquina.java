public class Maquina extends Thread {
	String id;
	Fila item;
	
	
	public Maquina(String idMaquina,Fila fila){
		id = idMaquina;
		item = fila;
		
	}
	
	public void run() {
		Object aux;
		while ((aux = item.remover()) != null ) {
			System.out.println(id +","+ aux);			
		}	
	}
	
}

