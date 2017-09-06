package Google;

import java.util.*;

class P {
	public int x;
	public int y;

	P(int _y, int _x) { 
		x = _x; 
		y = _y; 
	}
}

public class PrepareTheBunniesEscape {

	public static void helper(int[][] minArr, int[][] visited, Queue<P> q, P p, int h, int w) {

	    if (p.x > 0 && minArr[p.y][p.x-1] > 0)
		minArr[p.y][p.x] = Math.min(minArr[p.y][p.x], minArr[p.y][p.x-1] + 1);
	    if (p.x < w-1 && minArr[p.y][p.x+1] > 0)
		minArr[p.y][p.x] = Math.min(minArr[p.y][p.x], minArr[p.y][p.x+1] + 1);
	    if (p.y > 0 && minArr[p.y-1][p.x] > 0)
		minArr[p.y][p.x] = Math.min(minArr[p.y][p.x], minArr[p.y-1][p.x] + 1);
	    if (p.y < h-1 && minArr[p.y+1][p.x] > 0)
		minArr[p.y][p.x] = Math.min(minArr[p.y][p.x], minArr[p.y+1][p.x] + 1);

	    if (p.x < w-1 && visited[p.y][p.x+1] == 0) {
	        q.add(new P(p.y, p.x + 1));
	        visited[p.y][p.x+1] = 1;        
	    }
	    if (p.x > 0 && visited[p.y][p.x-1] == 0) {
		q.add(new P(p.y, p.x - 1));
	        visited[p.y][p.x-1] = 1;
	    }
	    if (p.y < h-1 && visited[p.y + 1][p.x] == 0) {
		q.add(new P(p.y + 1, p.x));
	        visited[p.y + 1][p.x] = 1;
	    }
	    if (p.y > 0 && visited[p.y - 1][p.x] == 0) {
		q.add(new P(p.y - 1, p.x));
	        visited[p.y - 1][p.x] = 1;
	    }

	}

	public static int answer(int[][] maze) {

		int h = maze.length, w = maze[0].length;
		int min = Integer.MAX_VALUE;
		int solved;

		int[][] minArr = new int[h][w];
		int[][] visited = new int[h][w];
		int[][] minArr2 = new int[h][w];
		int[][] visited2 = new int[h][w];
		
		LinkedList<P> ones = new LinkedList<P>();
		Queue<P> q = new LinkedList<P>();
		Queue<P> q2 = new LinkedList<P>();
		
		for (int i = 0 ; i < h ; ++i) {
	        for (int j = 0 ; j < w ; ++j) {
	          if (maze[i][j] == 0) { 
	            minArr[i][j] = 201;
	            minArr2[i][j] = 201;
	          }
	        }
	      }
		
		minArr[0][0] = 1;
		visited[0][0] = 1;
		
		q.add(new P(1,0));
		q.add(new P(0,1));

		while (!q.isEmpty()) {

			P p = q.poll();

			if (maze[p.y][p.x] == 1)
				ones.add(new P(p.y,p.x));

			if (maze[p.y][p.x] != 1) {

				helper(minArr, visited, q, p, h, w);

			}
		}

		solved = minArr[h-1][w-1];
		minArr2[h-1][w-1] = 1;
		visited2[h-1][w-1] = 1;

		q2.add(new P(h-2,w-1));
		q2.add(new P(h-1,w-2));

		while (!q2.isEmpty()) {

			P p2 = q2.poll();

			visited2[p2.y][p2.x] = 1;

			if (maze[p2.y][p2.x] != 1) {

				helper(minArr2, visited2, q2, p2, h, w);

			}
		}

		if (solved>0)
			min = Math.min(min,	solved);

		for(int i = 0; i < ones.size(); i++){
			P pt = ones.get(i);
			int y = pt.y, x = pt.x;

			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			ArrayList<Integer> neighbors2 = new ArrayList<Integer>();

			if (y-1 >= 0 && minArr[y-1][x] > 0)
				neighbors.add(minArr[y-1][x]);
			if (y+1 < h && minArr[y+1][x] > 0)
				neighbors.add(minArr[y+1][x]);
			if (x-1 >= 0 && minArr[y][x-1] > 0)
				neighbors.add(minArr[y][x-1]);
			if (x+1 < w && minArr[y][x+1] > 0)
				neighbors.add(minArr[y][x+1]);

			if (y-1 >= 0 && minArr2[y-1][x] > 0)
				neighbors2.add(minArr2[y-1][x]);
			if (y+1 < h && minArr2[y+1][x] > 0)
				neighbors2.add(minArr2[y+1][x]);
			if (x-1 >= 0 && minArr2[y][x-1] > 0)
				neighbors2.add(minArr2[y][x-1]);
			if (x+1 < w && minArr2[y][x+1] > 0)
				neighbors2.add(minArr2[y][x+1]);

			Collections.sort(neighbors);
			Collections.sort(neighbors2);

			if (neighbors.size()>0 && neighbors2.size()>0) {
				min = Math.min(min, 1+neighbors.get(0)+neighbors2.get(0));
			}			

		}

		return min;
	}


	public static void main(String[] args) {
	
		
		int[][] maze = {{0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0},
				{1, 1, 0, 1, 1, 1},
				{0, 1, 0, 1, 1, 1},
				{0, 0, 0, 0, 0, 0}};

    		System.out.println("min: " + answer(maze));
	}

}


