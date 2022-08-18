package exp_4;

public class _shortestPath {
   static void shortestpath(int arr[][], int initial) {
		   
		    int n = arr.length;	
		   	int dist[] = new int[n]; // The output array. dist[i] will hold
			// the shortest distance from src to i

			// sptSet[i] will true if vertex i is included in shortest
			// path tree or shortest distance from src to i is finalized
			Boolean sptSet[] = new Boolean[n];

			// Initialize all distances as INFINITE and stpSet[] as false
			for (int i = 0; i < n; i++) {
				dist[i] = Integer.MAX_VALUE;
				sptSet[i] = false;
			}

			// Distance of source vertex from itself is always 0
			dist[initial] = 0;

			// Find shortest path for all vertices
			for (int count = 0; count < n - 1; count++) {
				// Pick the minimum distance vertex from the set of vertices
				// not yet processed. u is always equal to src in first
				// iteration.
				int u = minDistanceVertex(dist, sptSet);

				// Mark the picked vertex as processed
				sptSet[u] = true;

				// Update dist value of the adjacent vertices of the
				// picked vertex.
				for (int v = 0; v < n; v++)

					// Update dist[v] only if is not in sptSet, there is an
					// edge from u to v, and total weight of path from src to
					// v through u is smaller than current value of dist[v]
					if (!sptSet[v] && arr[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + arr[u][v] < dist[v])
						dist[v] = dist[u] + arr[u][v];
			}
			print_shortestPath(dist,initial);
//	       boolean visited_path[] = new boolean[arr.length];
//	       int distance[] = new int[arr.length];
	//
//	       for(int i=0;i<arr.length;i++) {
	//
//	           visited_path[i] = false;
//	           distance[i] = Integer.MAX_VALUE;
//	       }
//	       
//	       distance[initial] = 0;
//	       
//	       for(int i=0;i<arr.length-1;i++) {
	//
//	            int min_distance = minDistanceVertex(distance, visited_path);
//	            visited_path[min_distance] = true;
//	            
//	            for(int j=0;j<arr.length;j++) {
	//    
//	                if(!visited_path[j] && arr[min_distance][j] != 0 && distance[min_distance] != Integer.MAX_VALUE && distance[min_distance] + arr[min_distance][i] < distance[j]) {
	//    
//	                    distance[j] = distance[min_distance] + arr[min_distance][j];
//	                }
//	            }
//	       }
	//
//	       print_shortestPath(distance, initial);
	   }

	    static int minDistanceVertex(int distance[], Boolean visited_path[]) {

	    	// Initialize min value
	    			int min = Integer.MAX_VALUE, min_index = -1;

	    			for (int v = 0; v < distance.length; v++)
	    				if (visited_path[v] == false && distance[v] <= min) {
	    					min = distance[v];
	    					min_index = v;
	    				}

	    			return min_index;
//	        int distance_min = Integer.MAX_VALUE;
//	        int distanceVertex_min = -1;
//	        
//	        for(int i=0;i<distance.length;i++) {
	//
//	            if(visited_path[i] == false && distance[i]<=distance_min) {
	//
//	                distance_min = distance[i];
//	                distanceVertex_min = i;
//	            }
//	        }
//	        return distanceVertex_min;
	    }    
	   
	    static void print_shortestPath(int dist[], int initial) {

	    	System.out.println("Vertex \t\t Distance from Source");
			for (int i = 0; i < dist.length; i++)
				System.out.println(i + " \t\t " + dist[i]);
	    	
//	         System.out.println(java.util.Arrays.toString(distance));    
//	        for(int i=0;i<distance.length;i++) {
	//
//	            System.out.println("The Distance from "+initial+" to "+i+" is "+distance[i]);
//	        } 
	    }

	    public static void main(String args[]) {

//	        int i, j;
			int arr[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
				{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
//	        System.out.print("Enter the number of nodes in the graph : ");
//	        Scanner s = new Scanner(System.in);
//	        int n = s.nextInt();
//	        arr = new int[n][];
//	        for(i=0;i<arr.length;i++) {
	//
//	            arr[i] = new int[arr.length];
//	        }
//	        for(i=0;i<arr.length;i++) {
	//
//	            for(j=0;j<arr[i].length;j++) {
	//
//	                System.out.print("Enter the for the edge from "+i+" to "+j+" (for no connection to node enter 0) : ");
//	                arr[i][j] = s.nextInt();
//	            }
//	       }
	//
//	        System.out.print("Enter the starting node : ");
//	        int start = s.nextInt();
//	        s.close();
	        shortestpath(arr, 0);
	    }
	
}
