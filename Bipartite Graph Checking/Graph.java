package Assignment3;

import java.util.Vector;

public class Graph {
	// undirected graph using adjacency lists

	private int nb_of_vertices;
	private Vector <Vector<Integer>> list = new Vector <Vector<Integer>>(nb_of_vertices);
	// a vector of vectors containing integers

	// to be used in DFS
	boolean isVisited[];
	int colors[];
	Stack S=new Stack();
	int color=1;
	int to_check;
	int k;

	public Graph(int a) {
		nb_of_vertices=a;

		for (int i = 0; i < nb_of_vertices; i++) 
			list.add(new Vector<Integer>()); 

		isVisited=new boolean[nb_of_vertices];	
		colors=new int[nb_of_vertices]; 
	}

	public void add_edge(int vertex1, int vertex2) {
		list.get(vertex1).add(vertex2);
		list.get(vertex2).add(vertex1);
	}

	public void print_list() {

		for (int i = 0; i < list.size(); i++) { 
			System.out.println("List of vertices connected to vertex " + i); 

			for (int j = 0; j < list.get(i).size(); j++) 
				System.out.println(" "+list.get(i).get(j)); 

		} 
	}

	public boolean DFS_2color(int a, int color) {
		// a is the vertex number to start with

		if(!isVisited[a]) {
			S.push(a);
			isVisited[a]=true;
			colors[a]=color;
	
		}
		if(!S.isEmpty()) {	
			k=S.pop();
			
			if (color==1)
				color=2;
			else color=1;
			
			for(int i=0;i<list.get(k).size();i++) {
				if(!isVisited[list.get(k).get(i)]) {
					DFS_2color(list.get(k).get(i), color);
				}
			}
		}
		
		for(int i=0;i<list.get(a).size();i++) {
			if(colors[a]!=0) {
				if(colors[a]==colors[list.get(a).get(i)])
					return false;
			}
		}
		return true;
	}
}
// ignore the below please
//	public void BFS(int a) {
//		// a is the vertex number to start with
//
//		Stack S=new Stack();
//		boolean isVisited[]=new boolean[nb_of_vertices];
//
//		S.push(a);
//		isVisited[a]=true;
//
//		while(!S.isEmpty()) {
//			int k=S.pop();
//
//			if(!isVisited[k]) {
//				isVisited[k]=true;
//
//				for(int i=0;i<list.get(k).size();i++) {
//
//					if(!isVisited[list.get(k).get(i)]) { 
//						isVisited[list.get(k).get(i)]=true;
//						S.push(list.get(k).get(i));
//					}
//				}
//			}
//		}
//	}








