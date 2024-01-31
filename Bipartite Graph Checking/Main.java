package Assignment3;

public class Main {
	
	// main
	
	public static void main(String[]args) {
		Graph G=new Graph(6);
		G.add_edge(0, 2);
		G.add_edge(1, 3);
		G.add_edge(4, 2);
		G.add_edge(5, 2);
		G.add_edge(1, 5);
		
//		G.add_edge(4, 0);
//		G.add_edge(3, 5);
//		G.add_edge(0, 1);
//		G.add_edge(3, 4);
  // uncomment the above to test a non-2-colorable  graph
		
		G.print_list();
		boolean hello=G.DFS_2color(0, 1);
		if(hello)
			System.out.println("The graph is 2-colorable");
		else
			System.out.println("The graph isn't 2-colorable");
	}
	
}
