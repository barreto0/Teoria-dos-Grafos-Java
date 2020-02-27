import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		// List of graph edges as per above diagram
				List<Aresta> edges = Arrays.asList(
						// (x, y, w) -> edge from x to y having weight w
						new Aresta( 0, 1, -1 ), 
						new Aresta( 0, 2, 4 ),
						new Aresta( 1, 2, 3 ), 
						new Aresta( 1, 3, 2 ),
						new Aresta( 1, 4, 2 ), 
						new Aresta( 3, 2, 5 ),
						new Aresta( 3, 1, 1 ), 
						new Aresta( 4, 3, -3 )
				);

				// Number of vertices in the graph
				int numVertices = 5;

				// let source be vertex 0
				int partida = 0;

				// run Bellman Ford Algorithm from given source
				BellmanFord b = new BellmanFord();
				b.bellmanFord(edges, partida, numVertices);
			}
	}


