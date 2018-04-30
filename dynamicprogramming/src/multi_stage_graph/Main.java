package multi_stage_graph;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MultiStageGraph multiStageGraph = new MultiStageGraph(true,4,3);
        multiStageGraph.inputGraph();

        multiStageGraph.output();
    }

}
