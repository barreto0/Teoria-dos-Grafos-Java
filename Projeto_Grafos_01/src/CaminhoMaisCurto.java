import java.util.*;


public class CaminhoMaisCurto {

	public void melhorCaminho(Grafo grafo, int partida, int chegada) {
		
		Queue<Integer> fila =  new LinkedList<>();
		int count = 0;
		int[] visit = new int[grafo.tamanho()];
		int[] pai = new int[grafo.tamanho()];
		List<Integer> caminho = new ArrayList<Integer>();
		List<Integer> retrocede = new ArrayList<Integer>();
		
				
		for(int i = 0; i<visit.length;i++) {
			visit[i] = -1;
		}
		
		visit[partida] = count++;
		pai[partida] = partida;
		fila.add(partida);
		//BFS
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
		//Fim BFS
		
		//System.out.println("Caminho percorrido pelo algoritmo: "+caminho);
		//System.out.print("Vetor Pai: ");				
		//for(int i = 0;i<pai.length;i++) {
			//System.out.print(pai[i]+" ");

		//}
		
		if(partida != chegada) {
			retrocede.add(chegada);
			retrocede.add(1, pai[chegada]);
			for(int i = 2;i<pai.length;i++) {
				if(retrocede.get(1).equals(partida)) {
					break;
				}
				retrocede.add(i, pai[retrocede.get(i-1)]);
				if(retrocede.contains(partida)) {
					break;
				}
				
			}
		}else {
			System.out.println("Nó de destino é igual ao de partida");
		}
			
			
		Collections.reverse(retrocede);
		if(partida == chegada) {
			System.out.println("Não há melhor caminho pois você já escapou!");
		}else {
			System.out.println("O Melhor caminho é: "+retrocede);

		}
		
	}
	
	
}
