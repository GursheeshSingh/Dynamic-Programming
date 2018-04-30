package multi_stage_graph;

public class Graph {

    int matrix[][];

    boolean directed;

    int numberOfVertices;

    public Graph(boolean directed, int numberOfVertices) {
        this.directed = directed;
        this.numberOfVertices = numberOfVertices;
        this.matrix = new int[numberOfVertices][numberOfVertices];
    }

    public void inputGraph(){

        for (int i = 0; i < numberOfVertices; i++) {

//            System.out.println("Vertex " + i);

            if (directed){

                for (int j = 0; j < numberOfVertices; j++) {

//                    System.out.println("Vertex " + j);
                    System.out.println("Is there a edge between Vertex "
                            + i + ' ' + j);

                    System.out.println("If Yes then enter weight, else 0");

                    matrix[j][i] = matrix[i][j] = Main.scanner.nextInt();

                }

            } else {

                for (int j = i; j < numberOfVertices; j++) {

                    System.out.println("Vertex " + j);

                    System.out.println("Is there a edge between Vertex "
                            + i + ' ' + j);

                    System.out.println("If Yes then enter weight, else 0");

                    matrix[i][j] = Main.scanner.nextInt();


                }

            }

            System.out.println();

        }

    }

    private int getEdgeWeight(int sourceVertex, int endVertex){
        return matrix[sourceVertex][endVertex];
    }

}
