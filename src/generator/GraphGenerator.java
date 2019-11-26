package generator;

import java.util.Random;

import components.Edge;
import components.Graph;

/**
 * 
 * @author CJ
 *
 */
public class GraphGenerator{
	Graph graph;
	int numberOfVertices;
	
	public GraphGenerator(int vertices){
		graph = new Graph(vertices);
		numberOfVertices = vertices;
	}
   
	private void connectedGraph() {
		Random rand = new Random();
		int weight=0;
		for(int i=0;i<numberOfVertices-1;i++) {
			weight = rand.nextInt(numberOfVertices*2) + 1;
			graph.addEdge(i, i+1, weight);
		}
		graph.addEdge(0,numberOfVertices-1,rand.nextInt(numberOfVertices*2) + 1); //connect first and last node
	}
	
	private Graph graphGenerator(int degree) {
		Random rand = new Random();
		graph = new Graph(numberOfVertices);
		int numberOfEdge = numberOfVertices;
		
		connectedGraph(); // creates a cycle with all vertices
		
		while (numberOfEdge < (numberOfVertices * degree) / 2 ) { // terminates after all edges are formed
			int i = rand.nextInt(numberOfVertices);
			int j = rand.nextInt(numberOfVertices);
			int weight = rand.nextInt(numberOfVertices*2) + 1;
			if (i != j) {
				Edge edge = new Edge(i ,j, weight);
				if (!graph.exists(graph.adj[i],edge)) { 
					numberOfEdge++;
				}
			}
		}
		return graph;
	}
	
	public Graph denseGraphGenerator(int percentage) {
		int degree = (percentage * numberOfVertices) / 100; // int will approximate the percentage
		if(degree<1) {degree=1;}//minimum degree to be 1
		return graphGenerator(degree);
	}
	
	public Graph sparseGraphGenerator(int degree) {
		return graphGenerator(degree);
	}
	
}
