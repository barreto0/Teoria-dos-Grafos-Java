import java.util.*; 

class Node implements Comparator<Node> { 
     int node; 
     double peso; 
  
    public Node() 
    { 
    } 
  
    public Node(int node, double peso) 
    { 
        this.node = node; 
        this.peso = peso; 
    } 
    
    @Override
    public String toString() {
         return ("|"+node+"  "+peso+"kms"+"|");
    }
  
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.peso < node2.peso) 
            return -1; 
        if (node1.peso > node2.peso) 
            return 1; 
        return 0; 
    } 
} 