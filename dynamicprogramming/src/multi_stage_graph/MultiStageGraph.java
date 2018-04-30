package multi_stage_graph;

public class MultiStageGraph extends Graph{

    private int numberOfStages;

    private int vertexStages[];
    private int[] costs;
    private int[] destinations;

    public MultiStageGraph(boolean directed, int numberOfVertices,int numberOfStages) {
        super(directed, numberOfVertices);

        vertexStages = new int[numberOfVertices];
        costs = new int[numberOfVertices];
        destinations = new int[numberOfVertices];
        this.numberOfStages = numberOfStages;

        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            costs[vertex] = 0;
        }

    }

    @Override
    public void inputGraph() {
        for (int i = 0; i < numberOfVertices; i++) {

            do {

                System.out.print("Enter Vertex " + i + " stage number: ");

                vertexStages[i] = Main.scanner.nextInt();

            } while (vertexStages[i] > numberOfStages); //Again if Wrong

            if (directed){

                for (int j = 0; j < numberOfVertices; j++) {

                    System.out.println("Is there a edge between Vertex " + i + ' ' + j);

                    System.out.println("If Yes then enter weight, else 0");

                    matrix[j][i] = matrix[i][j] = Main.scanner.nextInt();

                }

            } else {

                for (int j = i; j < numberOfVertices; j++) {

                    System.out.println("Vertex " + j);

                    System.out.println("Is there a edge between Vertex " + i + ' ' + j);

                    System.out.println("If Yes then enter weight, else 0");

                    matrix[i][j] = Main.scanner.nextInt();

                }

            }

            System.out.println();

        }

    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public void output(){

        for (int stage = 1; stage <= numberOfStages; stage++) {

            System.out.println("------------ STAGE " + stage + " ---------------");

            for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                if ( vertexStages[vertex] == stage ){

                    System.out.println("Vertex " + vertex);

                }
            }

        }

    }

}
