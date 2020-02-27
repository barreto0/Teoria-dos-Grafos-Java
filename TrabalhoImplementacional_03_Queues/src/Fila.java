
public class Fila {
	
	int tam = 10;
	int fila[] = new int[tam];
	
	public void FilaInit() {
		for(int i = 0; i<10;i++) {
			fila[i] = -1;
		}
	}
	
	public void FilaColoca(int vertices[]) {
		
	
	
	for(int i = 0;i<fila.length;i++) {
		if(fila[i] == -1) {
			fila[i] = vertices[i];
			
		}
	}
	

	
	}
	
	public void printFila() {
		for(int i = 0;i<fila.length;i++) {
			System.out.print(fila[i]);

		}
	}
	
	
	

}
