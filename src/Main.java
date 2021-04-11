import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		 Scanner input = new Scanner(System.in); //input para receber as informa�oes digitadas pelo usuario
		
		 System.out.println("Digite a capacidade da fila de tarefas:"); //recebendo a capacidade da fila e enviando para maquina
		 int tamFila = input.nextInt();
		 
		 Fila fila = new Fila(tamFila); //Criando nossa fila de tarefas 			 	
		
		 System.out.println("Digite o n�mero de m�quinas :");	//recebendo a quantidade de maquinas  	 
		 int contMaquinas = input.nextInt();
		 Maquina [] idMaquinas = new Maquina[contMaquinas]; // atribuindo a quantidade de espa�o a ser reservado para as maquinas
		 String [] idMachine = new String[contMaquinas];
		 
		 for (int i = 0 ; i < contMaquinas; i++) { // la�o que cria as maquinas
			 System.out.println ( "Digite o identificador da m�quina " + (i+1) + ":");
			  idMachine[i] = input.next();
			   idMaquinas[i] = new Maquina (idMachine[i],fila);// enviando por parametro o id da maquina e fila;
			   idMaquinas[i].start();		 
		 }		 
		 
		 System.out.println("Digite o n�mero de funcion�rios:");
		 int contFunc = input.nextInt();
		 Funcionario [] qtdFunc = new Funcionario[contFunc];
		 
		 for( int x = 0 ; x < contFunc; x++) { //la�o que cria os funcionarios
			 qtdFunc[x] = new Funcionario (fila,"func"+(x+1), x+1);// enviando por paramentro a fila, o arquivo txt e o id do funcionario
			 qtdFunc[x].start();
		 }	
		 
		 boolean aux = false;
		 
		 while (aux == false) {
			 if(fila.Verificar() == true && qtdFunc[contFunc-1].Verificar() == true ) {// VAI ENTRA NA CONDI��O DE A FILA ESTIVER VAZIA E OS FUNCIONARIOS FINALIZARAM.
				 for(int y=0 ; y < contMaquinas; y++) {
					 System.out.println(idMachine[y]+" FINALIZADA !");
				 }	
				 aux = true;
			 } 
		 }
		 
	}
}
