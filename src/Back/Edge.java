package Back;

public class Edge {
	private Coord start, end;
	private int weight;
	
	public Edge(Coord start, Coord end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public Coord getStart() {
		return start;
	}

	public Coord getEnd() {
		return end;
	}

	public int getWeight() {
		return weight;
	}
	
	public boolean startsAt(Coord c) {
		if(start.equals(c))
			return true;
		return false;
	}
	
	public boolean endsAt(Coord c) {
		if(end.equals(c))
			return true;
		return false;
	}
	
	public int compareTo(Edge b) {
		return getWeight()<b.getWeight() ? -1 : getWeight()>b.getWeight() ? 1 : 0;
	}
	
}
