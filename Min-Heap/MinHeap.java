package Assignment4;


public class MinHeap {

	private NodeD nodes[];
	private int num_elements;

	public MinHeap(int nb_vertices) {// O(1)
		setNodes(new NodeD[nb_vertices]);
		num_elements=nb_vertices;
	}

	public NodeD[] getNodes() {
		return nodes;
	}

	public void setNodes(NodeD nodes[]) {
		this.nodes = nodes;
	}

	public int indexOf(NodeD hi) {// O(N)
		for (int i=1; i<nodes.length;i++) {
			if(nodes[i]==hi) {
				return i;
			}
		}
		return -1;
	}


	public void swap(NodeD [] array,int from, int to) { // O(1)
		NodeD temp = array[from];
		array[from]=array[to];
		array[to]=temp;
	}

	public void swim(NodeD[] array,NodeD to_swim) { // O(lgn)

		int index= indexOf(to_swim);
		while((index/2)!=0 && (array[index].getDistance())<array[index/2].getDistance()) {
			swap(array,index,index/2);
			index=index/2;
		}
	}

	public void sink(NodeD [] array,NodeD to_sink, int num_elements) { // O(lgn)

		int index= indexOf(to_sink);
		while(index >=0 && (2*index<num_elements || 2*index+1<num_elements)) {

			if(2*index+1>=num_elements) {
				if(array[index].getDistance()>array[2*index].getDistance()) {
					swap(array,index,2*index);
					index=2*index;
				}
				else {
					return;
				}

			}
			else {

				if(array[index].getDistance()>=array[2*index].getDistance() || array[index].getDistance()>=array[2*index+1].getDistance()) {

					if (array[2*index].getDistance()<array[2*index+1].getDistance()) {
						swap(array,index,2*index);
						index=2*index;
					}
					else {
						swap(array,index,2*index+1);
						index=2*index+1;
					}
				}
				else return;

			}
		}}

	public NodeD delete_min() {  // O(lgn)

		NodeD delete=nodes[1];
		swap(nodes,1,num_elements-1);
		num_elements--;
		sink(nodes,nodes[1],num_elements);
		return delete;

	}

	public void inPlaceHeapSortIncreasing() { // O(nlgn)

		NodeD temp[]= new NodeD[nodes.length];
		int N=num_elements;;
		
		for (int i=1;i<num_elements;i++)
			temp[i]=nodes[i];

		while(N>1) { 
			swap(temp,1,N-1);
			N--;
			sink(temp,temp[1],N);
		}


	}



}
