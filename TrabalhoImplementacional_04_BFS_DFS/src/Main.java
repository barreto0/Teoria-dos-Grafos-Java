
public class Main {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();
		BFS bfs = new BFS();
		DFS dfs = new DFS();
		grafo.inicializa(6);
		
		  grafo.colocaAresta(0,2); 
		  grafo.colocaAresta(0,3); 
		  grafo.colocaAresta(0,4);
		  grafo.colocaAresta(1,2); 
		  grafo.colocaAresta(1,4); 
		  grafo.colocaAresta(2,4);
		  grafo.colocaAresta(3,4); 
		  grafo.colocaAresta(3,5); 
		  grafo.colocaAresta(4,5);
		  grafo.colocaAresta(5,1);

		  
		 
		
		/*
		 * grafo.colocaAresta(0,1); grafo.colocaAresta(0,2); grafo.colocaAresta(0,5);
		 * grafo.colocaAresta(2,1); grafo.colocaAresta(2,3); grafo.colocaAresta(2,4);
		 * grafo.colocaAresta(3,4); grafo.colocaAresta(3,5);
		 */
		
		grafo.mostra();
		bfs.bfs(grafo, 0);
		dfs.dfs(grafo);

		
		
		
	}

}
