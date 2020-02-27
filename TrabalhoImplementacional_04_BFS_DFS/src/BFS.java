import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public void bfs(Grafo grafo, int partida) {
		
		Queue<Integer> fila =  new LinkedList<>();
		int count = 0;
		int[] visit = new int[grafo.tamanho()];
		int[] pai = new int[grafo.tamanho()];
		List<Integer> caminho = new ArrayList<Integer>();
		
				
		for(int i = 0; i<visit.length;i++) {
			visit[i] = -1;
		}
		
		visit[partida] = count++;
		pai[partida] = partida;
		fila.add(partida);
		while(!fila.isEmpty()) {
			
			int v = fila.poll();
			
			Iterator<Integer> i = grafo.grafo.get(v).listIterator(); 
						
			caminho.add(v);
						
				
            while (i.hasNext())  {
                int n = i.next();
                
                 if (visit[n]==-1){
                      visit[n] = count++; 
	                  pai[n] = v;
	                  fila.add(n);       
                     }
            }        			
		}
		//System.out.println("A ordem de visitação do BFS é: "+caminho);
		/*
		 * for(int i = 0;i<visit.length;i++) { System.out.println(visit[i]); }
		 */
		
		System.out.println("A ordem de visitação do BFS é: "+Arrays.toString(visit));
	}
}
