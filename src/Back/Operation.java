package Back;

public class Operation {
	private Coord target;
	private String direction;
	
	public Operation(Coord target, String direction) {
		this.target = target;
		this.direction = direction;
	}
	
	public Coord getTarget() {
		return target;
	}
	
	public String getDirection() {
		return direction;
	}
	
}
