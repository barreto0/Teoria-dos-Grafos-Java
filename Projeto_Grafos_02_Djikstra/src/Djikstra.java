import java.util.*; 
public class Djikstra {

	int V; 
	List<List<Node>> grafo; 
	double distancia[]; 
	Set<Integer> visitado; 
	PriorityQueue<Node> filaPrioridade; 

	public Djikstra(int V)  { 
		this.V = V; 
		distancia = new double[V]; 
		visitado = new HashSet<Integer>(); 
		filaPrioridade = new PriorityQueue<Node>(V, new Node()); 
	} 

	public void dijkstra(List<List<Node> > grafo, int origem) { 
		this.grafo = grafo; 

		for (int i = 0; i < V; i++) 
			distancia[i] = Integer.MAX_VALUE; 


		filaPrioridade.add(new Node(origem, 0)); 


		distancia[origem] = 0; 
		while (visitado.size() != V) { 


			int u = filaPrioridade.remove().node; 


			visitado.add(u); 

			vizinhos(u); 
		} 
	} 


	private void vizinhos(int vizin) { 
		double distAresta = -1; 
		double novaDist = -1; 


		for (int i = 0; i < grafo.get(vizin).size(); i++) { 
			Node v = grafo.get(vizin).get(i); 


			if (!visitado.contains(v.node)) { 
				distAresta = v.peso; 
				novaDist = distancia[vizin] + distAresta; 


				if (novaDist < distancia[v.node]) {
					distancia[v.node] = novaDist; 


					filaPrioridade.add(new Node(v.node, distancia[v.node])); 
				}
			} 
		} 
	} 

}
