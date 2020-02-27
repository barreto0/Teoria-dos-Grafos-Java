
public class Main {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		grafo.inicializa(13);
		
		  grafo.colocaAresta(0,1); 
		  grafo.colocaAresta(0,5); 
		  grafo.colocaAresta(0,6);
		  grafo.colocaAresta(2,0); 
		  grafo.colocaAresta(2,3); 
		  grafo.colocaAresta(2,4);
		  grafo.colocaAresta(3,5); 
		  grafo.colocaAresta(5,4); 
		  grafo.colocaAresta(6,4);
		  grafo.colocaAresta(6,9);
		  grafo.colocaAresta(9,11);
		  grafo.colocaAresta(9,12);
		  grafo.colocaAresta(9,10);
		  grafo.colocaAresta(11,12);
		  grafo.colocaAresta(8,7);
		  grafo.colocaAresta(7,6);
		grafo.mostra();
		
		OrdTopologica ord = new OrdTopologica();
		ord.ordenacaoTopologica(grafo);
		
		
	}

}
