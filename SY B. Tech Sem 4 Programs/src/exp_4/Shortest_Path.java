package exp_4;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Shortest_Path {

	static String infinitySymbol = null;

	static void infinity() {

		try {

			infinitySymbol = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException ex) {

			infinitySymbol = "?";
		}
	}

	static void shortestpath(int arr[][], int initial) {

		int n = arr.length;
		int distance[] = new int[n];
		Boolean visited_path[] = new Boolean[n];
		int shortest_path[] = new int[n];

		// Initialization
		for (int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited_path[i] = false;
		}

		System.out.println("Distance Matrix before start : ");
		print_distanceMatrix(distance);

		// Distance from source vertex to itself is 0
		distance[initial] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < n - 1; count++) {

			int min_distance = minDistanceVertex(distance, visited_path);
			visited_path[min_distance] = true;
			shortest_path[count] = min_distance;

			for (int con_var = 0; con_var < n; con_var++) {

				if (!visited_path[con_var] && arr[min_distance][con_var] != 0
						&& distance[min_distance] != Integer.MAX_VALUE
						&& distance[min_distance] + arr[min_distance][con_var] < distance[con_var]) {

					distance[con_var] = distance[min_distance] + arr[min_distance][con_var];
				}
			}
			System.out.println();
			System.out.println("Iteration : " + (count + 1));
			print_distanceMatrix(distance);
			print_route(shortest_path, count);
		}
		print_shortestPath(distance, initial, shortest_path);
	}

	static int minDistanceVertex(int distance[], Boolean visited_path[]) {

		// Initialize min distance value
		int distance_min = Integer.MAX_VALUE;
		int distanceVertex_min = -1;

		for (int control = 0; control < distance.length; control++) {
			if (visited_path[control] == false && distance[control] <= distance_min) {
				distance_min = distance[control];
				distanceVertex_min = control;
			}
		}

		return distanceVertex_min;
	}

	static void print_distanceMatrix(int distance[]) {

		int dist[] = distance;

		System.out.println();
		System.out.print("[");
		for (int cont = 0; cont < distance.length; cont++) {

			if (dist[cont] == Integer.MAX_VALUE && cont == distance.length - 1) {

				System.out.print(infinitySymbol);
			} else if (dist[cont] == Integer.MAX_VALUE) {

				System.out.print(infinitySymbol + ", ");
			} else if (cont == distance.length - 1) {

				System.out.print(dist[cont]);
			} else {

				System.out.print(dist[cont] + ", ");
			}

		}
		System.out.print("]");
		System.out.println();
	}

	static void print_shortestPath(int distance[], int initial, int shortest_path[]) {

		System.out.println();
		System.out.println("Shortest Path route : ");
		for (int control_variable = 0; control_variable < distance.length; control_variable++) {

			if (control_variable == distance.length - 1) {

				System.out.print(shortest_path[control_variable]);
				break;
			}
			System.out.print(shortest_path[control_variable] + "->");
		}
		System.out.println();
		System.out.println();
		System.out.println("Shortest Path distance");
		System.out.println(java.util.Arrays.toString(distance));
		System.out.println();
		for (int i = 0; i < distance.length; i++) {

			System.out.println("The Distance from " + initial + " to " + i + " is " + distance[i]);
		}
	}

	public static void print_route(int shortest_path[], int count) {

		for (int control_variable = 0; control_variable < count; control_variable++) {

			System.out.print(shortest_path[control_variable] + "->");
		}
		System.out.println();
	}

	public static void main(String args[]) {

		int i, j;
		int arr[][];
		// = new int[][] {
		// { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		// { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		// { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		// { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		// { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		// { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
		// { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
		// { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		// { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
		// };
		System.out.print("Enter the number of nodes in the graph : ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		arr = new int[n][];
		for (i = 0; i < arr.length; i++) {

			arr[i] = new int[arr.length];
		}
		System.out.println();
		for (i = 0; i < arr.length; i++) {

			for (j = 0; j < arr[i].length; j++) {

				System.out.print(
						"Enter the for the edge from " + i + " to " + j + " (for no connection to node enter 0) : ");
				arr[i][j] = s.nextInt();
			}
			System.out.println();
		}

		System.out.print("Enter the starting node : ");
		int start = s.nextInt();
		s.close();
		System.out.println();
		infinity();
		shortestpath(arr, start);
	}
}
