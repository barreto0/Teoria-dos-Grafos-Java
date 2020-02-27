import java.util.*;

public class BellmanFord {
	// Recursive Function to print path of given vertex v from source vertex
		static void printPath(int parent[], int v)
		{
			if (v < 0)
				return;

			printPath(parent, parent[v]);
			System.out.print(v + " ");
		}

	// Function to run Bellman Ford Algorithm from given source
		public static void bellmanFord(List<Aresta> edges, int source, int numVertices) {

			// get number of edges present in the graph
			int E = edges.size();

			// distance[] and parent[] stores shortest-path
			// (least cost/path) information
			int distance[] = new int[numVertices];
			int parent[] = new int[numVertices];

			// initialize distance[] and parent[]. Initially all
			// vertices except source vertex have a weight of
			// infinity and a no parent
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[source] = 0;
			
			Arrays.fill(parent, -1);

			int k = numVertices;

			// Relaxation step (run V -1 times)
			while (--k > 0)
			{
				for (int j = 0; j < E; j++)
				{
					// edge from u to v having weight w
					int u = edges.get(j).v;
					int v = edges.get(j).w;
					int w = edges.get(j).peso;

					// if the distance to the destination v can be
					// shortened by taking the edge u-> v
					if (distance[u] != Integer.MAX_VALUE && (distance[u] + w < distance[v]))
					{
						// update distance to the new lower value
						distance[v] = distance[u] + w;

						// set v's parent as u
						parent[v] = u;
						System.out.println();
						for(int i =0;i<numVertices;i++) {
							System.out.print(" "+distance[i]);
						}				
					}
				}
			}

			// run relaxation step once more for Nth time to
			// check for negative-weight cycles
			for (int i = 0; i < E; i++)
			{
				// edge from u to v having weight w
				int u = edges.get(i).v;
				int v = edges.get(i).w;
				int w = edges.get(i).peso;

				// if the distance to the destination u can be
				// shortened by taking the edge u-> v
				if (distance[u] != Integer.MAX_VALUE &&
					(distance[u] + w < distance[v]))
				{
					System.out.println("Negative Weight Cycle Found!!");
					return;
				}
			}

			for (int i = 0; i < numVertices; i++)
			{
				System.out.print("Distance of vertex " + i + " from the " +
						"source is " + distance[i] + ". It's path is [ ");

				printPath(parent, i);
				System.out.println("]");
			}
			for(int i =0;i<numVertices;i++) {
				System.out.print(" "+distance[i]);
			}
		}

}
