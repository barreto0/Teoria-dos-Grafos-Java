import java.util.*;

public class Grafo {
	int vertice = 0;
	int aresta = 0;

	
	List<List<Integer>> grafo = new ArrayList<List<Integer>>();

	public void inicializa(int x) {

		for (int i = 0; i < x; i++) {
			List<Integer> conteudo = new ArrayList<Integer>();
			grafo.add(conteudo);
		}
		
	}

	public void coloca(int v, int w) {
		grafo.get(v).add(w);
		grafo.get(w).add(v);

	}
	
	public void mostra() {
		for(int i = 0;i<grafo.size();i++) {
			System.out.println(i +" " +grafo.get(i));
		}
	}

}
