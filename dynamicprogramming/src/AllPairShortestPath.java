import multi_stage_graph.Graph;

public class AllPairShortestPath {

    private static Graph graph;

    private static final int NUMBER_OF_VERTICES = 4;
    private static final int INF = 35565;

    public static void main(String[] args) {

        graph = new Graph(true, NUMBER_OF_VERTICES);
        graph.matrix = new int[][]{
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        for (int intermediateVertex = 0; intermediateVertex < NUMBER_OF_VERTICES; intermediateVertex++) {

            for (int sourceVertex = 0; sourceVertex < NUMBER_OF_VERTICES; sourceVertex++) {
                for (int destinationVertex = 0; destinationVertex < NUMBER_OF_VERTICES; destinationVertex++) {

                    graph.matrix[sourceVertex][destinationVertex] = Math.min(
                            graph.matrix[sourceVertex][destinationVertex],
                            graph.matrix[sourceVertex][intermediateVertex] + graph.matrix[intermediateVertex][destinationVertex]
                            );

                }


            }
            
        }

        Printing.print2DArray(graph.matrix);

    }

}
