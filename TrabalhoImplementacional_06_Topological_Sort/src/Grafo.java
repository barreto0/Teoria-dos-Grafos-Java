import java.util.ArrayList;
import java.util.List;

public class Grafo {
	List<List<Integer>> grafo = new ArrayList<List<Integer>>();

	public void inicializa(int x) {

		for (int i = 0; i < x; i++) {
			List<Integer> conteudo = new ArrayList<Integer>();
			grafo.add(conteudo);
		}
		
	}

	public void colocaAresta(int v, int w) {
		grafo.get(v).add(w);
		//grafo.get(w).add(v);

	}
	
	public void mostra() {
		for(int i = 0;i<grafo.size();i++) {
			System.out.println(i +" " +grafo.get(i));
		}
	}
	public int tamanho() {
		return grafo.size();
	}

}
