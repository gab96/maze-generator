package Back;

import java.util.ArrayList;

public class Maze {
	private Cell matrix[][];
	private ArrayList<Operation> log;
	
	public Maze(int r, int c) {
		matrix = new Cell[r][c];
		log = new ArrayList<Operation>();
	}
	
	public void addLink(Coord a, Coord b) {
		int dirx = a.getX()-b.getX();
		int diry = a.getY()-b.getY();
		
		if(matrix[a.getX()][a.getY()] == null)
			matrix[a.getX()][a.getY()] = new Cell(false, false, false, false);
		if(matrix[b.getX()][b.getY()] == null)
			matrix[b.getX()][b.getY()] = new Cell(false, false, false, false);
		
		if(dirx == 1) {
			matrix[a.getX()][a.getY()].setWest(true);
			matrix[b.getX()][b.getY()].setEast(true);
			log.add(new Operation(a, "West"));
			log.add(new Operation(b, "East"));
		} else if(dirx == -1) {
			matrix[a.getX()][a.getY()].setEast(true);
			matrix[b.getX()][b.getY()].setWest(true);
			log.add(new Operation(a, "East"));
			log.add(new Operation(b, "West"));
		} else if(diry == 1) {
			matrix[a.getX()][a.getY()].setNorth(true);
			matrix[b.getX()][b.getY()].setSouth(true);
			log.add(new Operation(a, "North"));
			log.add(new Operation(b, "South"));
		} else if(diry == -1) {
			matrix[a.getX()][a.getY()].setSouth(true);
			matrix[b.getX()][b.getY()].setNorth(true);
			log.add(new Operation(a, "South"));
			log.add(new Operation(b, "North"));
		}
	}
	
	public Cell getCell(int x, int y) {
		return matrix[x][y];
	}
	
	public ArrayList<Operation> getLog(){
		return log;
	}
	
}
