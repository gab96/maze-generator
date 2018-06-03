package Back;

public class Coord {
	private int x, y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean equals(Coord b) {
		if(x==b.getX() && y==b.getY())
			return true;
		return false;
	}

}
