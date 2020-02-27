
public class Grafo {
	int v  = 6;
	int w = 6;
	int[][] grafo = new int[v][w];
	int [] vertices = new int[v];
	int count = 0;

	public int retornaVertice (int posicao) {
		return grafo[posicao][posicao];
		
		
	}
	
	
	
	public void inicializa() {
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < w;j++) {
				grafo[i][j] = 0;
					
			}
		}
	}
	
	public void coloca(int linha,int coluna) {
	
			grafo[linha-1][coluna-1] = 1;
			grafo[coluna-1][linha-1] = 1;
			
			if(vertices[count] != linha) {
				vertices[count] = linha;
				count++;
			}else if(vertices[count]!= coluna) {
				vertices[count] = coluna;
				count++;
			}
			
			
	}
	
	public void imprime() {
		/*
		 * for(int i = 0; i<v; i++) { for(int j = 0; j<w;j++) {
		 * System.out.print(grafo[i][j]+" "); } System.out.println(" "); }
		 */
		for(int i = 0;i<v;i++) {
			System.out.println(vertices[i]);
		}
	}
}
