import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Funcionario extends Thread {
	Fila fila;
	String [] tarefas = new String [20];
	int cont = 0;
	int id = 0;
	boolean end;
	
	
	public Funcionario(Fila buffe, String txt, int x) { // recebendo o txt com as tarefas
		fila = buffe;
		id = x ;
		
		File dir = new File("src/txt");
		File arq = new File(dir, txt);
	    
	    try {
	        FileReader fileReader = new FileReader(arq); //Indicamos o arquivo que será lido
	        BufferedReader bufferedReader = new BufferedReader(fileReader); //Criamos o objeto bufferReader 	        
	        String linha = " ";
	        
	        while ( ( linha = bufferedReader.readLine() ) != null) {  //Fazemos um loop linha a linha no arquivo,
	        	tarefas [cont] = linha;
	        	++cont;	   
	        }
	        
	        fileReader.close(); //liberamos o fluxo dos objetos ou fechamos o arquivo
	        bufferedReader.close();
	        
	        } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void run() { // 
		for (int i = 0 ; i < cont; i++) {
			fila.inserir(tarefas[i]);
		}
		
		System.out.println("FUNCIONARIO "+id+" FINALIZADO !");
		end = true;
	}
	
	public boolean Verificar() {
		if (end == true) {
			return true;
		}
		return false;		
	}
}
