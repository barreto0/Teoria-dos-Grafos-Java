import java.util.*;


public class Main {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();
		grafo.inicializa(7);
		grafo.coloca(1,2);
		grafo.coloca(1,3);
		grafo.coloca(2,4);
		grafo.coloca(3,4);
		grafo.coloca(4,5);
		grafo.coloca(5,6);
		grafo.mostra();
	}

}
