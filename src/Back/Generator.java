package Back;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Generator {
	
	public static void main(String[] args) {
		Generator g = new Generator();
		/*Maze m = g.createMaze(3, 3);
		ArrayList<Operation> log = m.getLog();*/
		for(int i=1; i<100; i++) {
			long time = System.currentTimeMillis();
			g.createMaze(i, i);
			long time2 = System.currentTimeMillis()-time;
			System.out.println("dimension: "+i+"x"+i+", time: "+time2);
		}
	}
	
	public Maze createMaze(int r, int c) {
		ArrayList<Edge> edges = randEdges(r, c);
		return prim(edges, r, c);
	}
	
	private ArrayList<Edge> randEdges(int r, int c){
		Random rand = new Random();
		ArrayList<Edge> ar = new ArrayList<Edge>();
		for(int x=0; x<r; x++) {
			for(int y=0; y<c; y++) {
				Coord start = new Coord(x, y);
				if(x-1>=0) {
					ar.add(new Edge(start, new Coord(x-1, y), rand.nextInt(256)));
					//System.out.println("from "+x+":"+y+" to "+(x-1)+":"+y);
				} if(x+1<r) {
					ar.add(new Edge(start, new Coord(x+1, y), rand.nextInt(256)));
					//System.out.println("from "+x+":"+y+" to "+(x+1)+":"+y);
				} if(y-1>=0) {
					ar.add(new Edge(start, new Coord(x, y-1), rand.nextInt(256)));
					//System.out.println("from "+x+":"+y+" to "+x+":"+(y-1));
				} if(y+1<c) {
					ar.add(new Edge(start, new Coord(x, y+1), rand.nextInt(256)));
					//System.out.println("from "+x+":"+y+" to "+x+":"+(y+1));
				}
			}
		}
		return ar;
	}
	
	private Maze prim(ArrayList<Edge> ar, int r, int c) {
		Maze m = new Maze(r, c);
		ArrayList<Coord> tree = new ArrayList<Coord>();
		tree.add(new Coord(0, 0));
		ArrayList<Edge> valid = new ArrayList<Edge>();
		while(tree.size()<r*c) {
			Edge next = select(valid, tree, ar);
			tree.add(next.getEnd());
			m.addLink(next.getStart(), next.getEnd());
			valid.remove(0);
		}
		return m;
	}
	
	private Edge select(ArrayList<Edge> valid, ArrayList<Coord> tree, ArrayList<Edge> list) {
		Coord node = tree.get(tree.size()-1);
		for(Iterator<Edge> it = list.iterator(); it.hasNext();) {
			Edge curr = it.next();
			if(curr.startsAt(node)) {
				valid.add(curr);
				it.remove();
			}
		}
		for(Iterator<Edge> it = valid.iterator(); it.hasNext();) {
			Edge v = it.next();
			for(Coord c : tree)
				if(v.endsAt(c))
					it.remove();
		}
		valid.sort((a, b) -> a.compareTo(b));
		return valid.get(0);
	}

}
