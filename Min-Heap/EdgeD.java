package Assignment4;

public class EdgeD {
	
	private NodeD from;
	private NodeD to;
	private int weight;
	
	public EdgeD(NodeD f, NodeD t, int w) {
		from=f;
		to=t;
		weight=w;
	}
	
	public NodeD getFrom() {
		return from;
	}
	public void setFrom(NodeD from) {
		this.from = from;
	}
	public NodeD getTo() {
		return to;
	}
	public void setTo(NodeD to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
