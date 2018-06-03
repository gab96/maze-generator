package Back;

public class Cell {
	private boolean north, south, east, west;
	
	public Cell(boolean north, boolean south, boolean east, boolean west) {
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public boolean isNorth() {
		return north;
	}

	public boolean isSouth() {
		return south;
	}

	public boolean isEast() {
		return east;
	}

	public boolean isWest() {
		return west;
	}
	
}
