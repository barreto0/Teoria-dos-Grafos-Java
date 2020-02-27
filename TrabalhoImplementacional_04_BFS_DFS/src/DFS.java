import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DFS {
	List<Integer> caminho = new ArrayList<Integer>();
	//List<Integer> caminho2 = new ArrayList<Integer>();
	int[] caminho2 = new int[6];
	int count = 0;
	
	public void dfsRec(Grafo grafo, int partida,boolean visitado[]) { 
			visitado[partida] = true; 
	        caminho2[partida] = count++;
	        
	        caminho.add(partida);
	        
	  
	        Iterator<Integer> i = grafo.grafo.get(partida).listIterator();	    
	        while (i.hasNext()){ 
	        	
	            int n = i.next(); 
	            
	            if (!visitado[n]) 
	            	
			     dfsRec(grafo, n, visitado); 
	        } 
	    } 
	 
	public void dfs(Grafo grafo) { 
	        
	        boolean visitado[] = new boolean[grafo.tamanho()]; 
	        
	        for(int i = 0;i<grafo.tamanho();i++) {
	        	if(!visitado[i]) {
	    	        dfsRec(grafo, i, visitado); 

	        	}
	        }
	       // System.out.println("A ordem de visitação do DFS é: "+caminho);
	        System.out.println("A ordem de visitação do DFS é: "+Arrays.toString(caminho2));

	    } 

}
