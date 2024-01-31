package Assignment4;

public class Main {

	public static void main(String[]args) {

		Digraph G1 = new Digraph(6);
		Digraph G2 = new Digraph(6);
		Digraph G3 = new Digraph(7);

		// public EdgeD(NodeD f, NodeD t, int w) {

		NodeD A1 = new NodeD('A');
		NodeD A2 = new NodeD('A');
		NodeD A3 = new NodeD('A');

		NodeD B1 = new NodeD('B');
		NodeD B2 = new NodeD('B');
		NodeD B3 = new NodeD('B');

		NodeD C1 = new NodeD('C');
		NodeD C2 = new NodeD('C');
		NodeD C3 = new NodeD('C');

		NodeD D1 = new NodeD('D');
		NodeD D2 = new NodeD('D');
		NodeD D3 = new NodeD('D');

		NodeD E1 = new NodeD('E');
		NodeD E2 = new NodeD('E');
		NodeD E3 = new NodeD('E');

		NodeD F1 = new NodeD('F');
		NodeD F2 = new NodeD('F');
		NodeD F3 = new NodeD('F');

		NodeD G = new NodeD('G');

		A1.addEdge(B1, 2);
		A1.addEdge(E1, 2);
		A1.addEdge(F1, 1);

		B1.addEdge(C1, 4);

		C1.addEdge(D1, 5);

		D1.addEdge(C1, 10);
		D1.addEdge(B1, 1);

		E1.addEdge(A1, 1);

		F1.addEdge(E1, 11);
		
		System.out.println("Djikstra for G1(V,E): ");
		if(G1.add_node(A1)
		&& G1.add_node(B1)
		&& G1.add_node(C1)
		&& G1.add_node(D1)
		&& G1.add_node(E1)
		&& G1.add_node(F1)) {
			G1.dijkstra(A1);}
		else {
			System.out.println("Couldn't perform Dijkstra due to the presence of one or more negative edges");
		}
		System.out.println();
		

		A2.addEdge(B2, 3);
		A2.addEdge(C2, 5);
		A2.addEdge(D2, 2);
		A2.addEdge(F2, 10);

		B2.addEdge(D2, 4);

		C2.addEdge(D2, -4);

		D2.addEdge(E2, 1);

		E2.addEdge(F2, -1);

		F2.addEdge(A2, 10);

		System.out.println("Djikstra for G2(V,E): ");
		if(G2.add_node(A2)
				&& G2.add_node(B2)
				&& G2.add_node(C2)
				&& G2.add_node(D2)
				&& G2.add_node(E2)
				&& G2.add_node(F2)) {
			G2.dijkstra(A2);
			}
		else {
			System.out.println("Couldn't perform Dijkstra due to the presence of one or more negative edges");
		}
		System.out.println();

		A3.addEdge(B3, 13);
		A3.addEdge(C3, 12);

		B3.addEdge(C3, 11);
		B3.addEdge(D3, 2);

		C3.addEdge(A3, 11);
		C3.addEdge(B3, 10);
		C3.addEdge(D3, 15);

		D3.addEdge(B3, 4);
		D3.addEdge(E3, 3);
		D3.addEdge(F3, 5);

		E3.addEdge(B3, 4);

		F3.addEdge(B3, 1);
		F3.addEdge(C3, 2);

		G.addEdge(F3, 2);
		G.addEdge(B3, 3);
		G.addEdge(C3, 12);
		
		System.out.println("Djikstra for G3(V,E): ");
		if(G3.add_node(A3)
				&& G3.add_node(B3)
				&& G3.add_node(C3)
				&& G3.add_node(D3)
				&& G3.add_node(E3)
				&& G3.add_node(F3)
				&& G3.add_node(G)) {
			G3.dijkstra(A3);}
		else {
			System.out.println("Couldn't perform Dijkstra due to the presence of one or more negative edges");
		}

		

	}
}
