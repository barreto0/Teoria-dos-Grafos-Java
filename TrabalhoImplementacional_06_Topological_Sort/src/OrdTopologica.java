import java.util.Iterator;
import java.util.Stack;

public class OrdTopologica {
	void ordenacaoTopologicaRec(int k, boolean passouAQ[], Stack pilha, Grafo grafo) { 
		passouAQ[k] = true; 
		Iterator<Integer> i = grafo.grafo.get(k).listIterator();	
		while (i.hasNext()) { 
			int n = i.next();  
			if (!passouAQ[n]){
				ordenacaoTopologicaRec(n, passouAQ, pilha, grafo); 
			}
		} 
		pilha.push(k); 
	} 

	void ordenacaoTopologica(Grafo grafo){ 
		Stack pilha = new Stack(); 
		boolean passouAQ[] = new boolean[grafo.tamanho()]; 
		for (int i = 0; i < grafo.tamanho(); i++) { 
			passouAQ[i] = false; 
		}
		for (int i = 0; i < grafo.tamanho(); i++) { 
			if (passouAQ[i] == false) 
				ordenacaoTopologicaRec(i, passouAQ, pilha,grafo); 
		}
		while (pilha.empty()==false) { 
			System.out.print(pilha.pop() + " "); 
		}
	} 

}
