package components;

import java.util.ArrayList;

public class Graph {

	private int vertices;
	private int edges;
	public ArrayList<Edge>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		this.edges = 0;
		adj = (ArrayList<Edge>[])new ArrayList[vertices];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new ArrayList<Edge>();
		}
	}

	public ArrayList<Edge>[] getAdj() {
		return adj;
	}

	public int vertices() {
		return vertices;
	}

	public int edges() {
		return edges;
	}

	/**
	 * Adds undirected edge to the graph
	 * @param start
	 * @param end
	 * @param weight
	 */
	public void addEdge(int start, int end, int weight) {
		Edge edge = new Edge(start, end, weight);
		adj[start].add(edge);
		edge = new Edge(end, start, weight);
		adj[end].add(edge);
		edges += 2; //actual edge count is edges/2
	}

	/**
	 * Checks if the edge exists in the graph
	 * @param adj
	 * @param e
	 * @return
	 */
	public boolean exists(ArrayList<Edge> adj, Edge e) {
		for(Edge edge : adj) {
			if(edge.getStart() == e.getStart() && edge.getEnd() == e.getEnd()) {
				return true;
			}else if(edge.getStart() == e.getEnd() && edge.getEnd() == e.getStart()) {
				return true;
			}
		}
		return false;
	}

}
