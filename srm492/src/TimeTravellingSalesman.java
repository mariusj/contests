import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class TimeTravellingSalesman {
	
	private static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	private static class Node {
		List<Edge> edges = new ArrayList<Edge>();
		
		void addEdge(int to, int cost) {
			edges.add(new Edge(to, cost));
		}
	}
	
	private static class Graph {
		int n;
		Node[] nodes;

		public Graph(int n) {
			this.n = n;
			nodes = new Node[n];
			for (int i=0; i<n; i++) {
				nodes[i] = new Node();
			}
		}

		public long minSpanningTree() {
			long cost = 0;
			int visCount = 0;
			boolean visited[] = new boolean[n];
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.add(new Edge(0, 0));
			while (!pq.isEmpty()) {
				Edge min = pq.poll();
				if (!visited[min.to]) {
					for (Edge e : nodes[min.to].edges) {
						pq.add(e);
					}
					visited[min.to] = true;
					visCount++;
					cost += min.cost;
				}
			}
			if (visCount != n)
				return -1;
			return cost;
		}
		
	}
	
	public long determineCost(int N, String[] roads) {
		Graph g = new Graph(N);
		
		StringBuilder s = new StringBuilder(N * 6);
		for (String r : roads)
			s.append(r);
		String[] roads2 = s.toString().split(" ");
		for (String r : roads2) {
			String[] road = r.split(",");
			int a = Integer.parseInt(road[0]);
			int b = Integer.parseInt(road[1]);
			int cost = Integer.parseInt(road[2]);
			g.nodes[a].addEdge(b, cost);
			g.nodes[b].addEdge(a, cost);
		}
		
		return g.minSpanningTree();
	}

	public static void main(String[] args) {
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;

		time = System.currentTimeMillis();
		answer = new TimeTravellingSalesman().determineCost(3,
				new String[] { "0,1,1 0,2,1 1,2,2" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TimeTravellingSalesman().determineCost(6,
				new String[] { "0,1,2 1,4,2 4,3,3 2,4,4 0,5,3" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 14L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TimeTravellingSalesman().determineCost(3,
				new String[] { "0,2,2" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TimeTravellingSalesman().determineCost(4, new String[] {
				"1,0", ",10", "0 2,1", ",584 3,2", ",754" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1438L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}
}
