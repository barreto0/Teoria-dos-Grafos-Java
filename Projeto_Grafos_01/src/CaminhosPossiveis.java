import java.util.Iterator;

public class CaminhosPossiveis {
	 public int contaCaminhoRecursivo(Grafo grafo, int partida, int chegada, int count, boolean visit[]) {
			//int count = 0;
			//int[] visit = new int[grafo.tamanho()];
			//for(int i = 0; i<visit.length;i++) {
				//visit[i] = -1;
			//}
		 //DFS
			visit[partida] = true;
			
			if(partida == chegada) {
				count++;
				
			}else {
				Iterator<Integer> i = grafo.grafo.get(partida).listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(!visit[n]) {
						count = contaCaminhoRecursivo(grafo, n, chegada, count, visit);
					}
				}

			}
			visit[partida] = false;
			return count;
		 
	 }
	 public int contaCaminho(Grafo grafo, int partida, int chegada) {
			int count = 0;
			boolean visit[] = new boolean[grafo.tamanho()];
			count = contaCaminhoRecursivo(grafo, partida, chegada, count, visit);
			return count;

	 }
	 //Fim DFS
}
