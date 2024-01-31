package Assignment4;

import java.util.ArrayList;


public class Digraph {
	// undirected graph using adjacency lists

	private int nb_of_vertices;
	private ArrayList <NodeD> adj_list = new ArrayList <NodeD>();

	public Digraph(int a) {
		nb_of_vertices=a;
	}

	public int getNb_of_vertices() {
		return nb_of_vertices;
	}

	public void setNb_of_vertices(int nb_of_vertices) {
		this.nb_of_vertices = nb_of_vertices;
	}

	public ArrayList<NodeD> getAdj_list() {
		return adj_list;
	}

	public void setAdj_list(ArrayList<NodeD> adj_list) {
		this.adj_list = adj_list;
	}


	public boolean add_node(NodeD to_add) {
		
		if(to_add.isHas_negative_edge())
			return false;
		adj_list.add(to_add);
		return true;
	}

	public void dijkstra(NodeD source) {

		// Initialization for nodes already done when they were added
		// distance to source was initialized to infinity and parent to null

		// create min heap to store my nodes and keep track of which nodes are in V-S

		NodeD [] setV_S = new NodeD[nb_of_vertices];
		int index_source = adj_list.indexOf(source);

		// place the source at 0 in the heap for ease of manipulation
		setV_S[0]=adj_list.get(index_source);
		setV_S[0].setDistance(0);
		setV_S[0].setParent(source);
		source.setBelong_to_S(true);

		int k=1;
		for(int i=0;i<nb_of_vertices;i++) {

			if(!adj_list.get(i).equals(source)) {
				setV_S[k]=adj_list.get(i);
				k++;
			}
		}

		// initializing the source

		MinHeap m=new MinHeap(nb_of_vertices);

		for(int i=0; i<adj_list.get(index_source).getEdges_out().size();i++) { //O(degree of source)
			NodeD child=adj_list.get(index_source).getEdges_out().get(i).getTo();
			child.setParent(source);
			child.setDistance(adj_list.get(index_source).getEdges_out().get(i).getWeight());
		}

		// Grow s

		m.setNodes(setV_S);
		m.inPlaceHeapSortIncreasing();

		for (int i=0;i<nb_of_vertices;i++) {  //2vlgv --> O(vlgv)

			NodeD u = m.delete_min(); // vlgv vertex closest to s, u doesn't belong to V-S anymore
			u.setBelong_to_S(true);

			// ~relaxing~ edges :)
			for (int j=0;j<u.getEdges_out().size();j++) {

				NodeD v= u.getEdges_out().get(j).getTo();
				if(!v.isBelong_to_S()) {

					int weight_u_v= u.getEdges_out().get(j).getWeight();

					if(u.getDistance()+weight_u_v<v.getDistance()) {
						v.setDistance(u.getDistance()+weight_u_v);
						v.setParent(u);
						m.swim(setV_S, v); // O(lgv)
					}
				}
			}
		}


		// print shortest path tree starting at A

		System.out.println("Shortest path tree starting at A: \n"
				+ "A is the source");

		for(int l=0;l<nb_of_vertices;l++) {

			NodeD node=adj_list.get(l);

			if (node.getParent()==node || node.getParent()==null)
				continue;
			else {
				System.out.println(""+ node.getParent().getName()+"----->"+node.getName());
			}
		}

		System.out.println();

		// shortest path from A to every vertex in the graph:
		// start from the end



		for(int i=0; i<nb_of_vertices;i++) {

			NodeD current = adj_list.get(i);
			int distance=0;
			System.out.println("The shortest path from A to vertex "+current.getName()+" is:");

			boolean no_path=false;
			while(current.getName()!=source.getName()) {

				NodeD parent=current.getParent();
				if(parent!=null) {
					int index_current=-1;

					for(int p=0;p<parent.getEdges_out().size();p++) {
						if(parent.getEdges_out().get(p).getTo().equals(current)) {
							index_current=p;
						}


					}
					distance+=parent.getEdges_out().get(index_current).getWeight();
				}
				else {
					no_path=true;
					// this boolean signifies that there is no path from A to this node 
					// since it has no parent and it is not the source
					break;
				}
				current=parent;
			}

			if(no_path) {
				System.out.println("No path from A to it");
				no_path=false;
			}
			else
				System.out.println(""+distance);
		}


	}


}



