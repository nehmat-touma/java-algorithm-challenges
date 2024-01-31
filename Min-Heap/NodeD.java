package Assignment4;

import java.util.ArrayList;

public class NodeD {
	
	private char name;
	private NodeD parent;
	private int distance; // distance from source to the node
	private ArrayList<EdgeD> edges_out = new ArrayList<EdgeD>(); // stores edges out of the NodeD
	private boolean belong_to_S; //automatically initalized to false
	private boolean has_negative_edge;

	public NodeD(char n) {
		name=n;
		parent=null;
		distance=Integer.MAX_VALUE;
		has_negative_edge=false;
	}
	
	public void addEdge(NodeD to, int weight) {
		// the weight here is the original values on the graph, it won't change

		EdgeD to_add= new EdgeD(this,to,weight);
		
		if(weight<0)
			has_negative_edge=true;
		// to be used to assess if the graph has negative weight edges
		
		edges_out.add(to_add);
	}
	
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public NodeD getParent() {
		return parent;
	}
	public void setParent(NodeD parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public ArrayList<EdgeD> getEdges_out() {
		return edges_out;
	}
	public void setEdges_out(ArrayList<EdgeD> edges_out) {
		this.edges_out = edges_out;
	}

	public boolean isBelong_to_S() {
		return belong_to_S;
	}

	public void setBelong_to_S(boolean belong_to_S) {
		this.belong_to_S = belong_to_S;
	}
	public boolean isHas_negative_edge() {
		return has_negative_edge;
	}

	public void setHas_negative_edge(boolean has_negative_edge) {
		this.has_negative_edge = has_negative_edge;
	}

}
