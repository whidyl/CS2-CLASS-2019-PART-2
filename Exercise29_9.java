package c29;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 29.9:
 * (Find a minimum spanning tree) Write a program that reads a connected graph
 * from a file and displays its minimum spanning tree. The first line in the file
 * contains a number that indicates the number of vertices (n). The vertices are
 * labeled as 0, 1, . . . , n−1. Each subsequent line describes the edges in the form
 * of u1, v1, w1 | u2, v2, w2 | . . . . Each triplet in this form describes an edge
 * and its weight.
 */
public class Exercise29_9 {
    public static void main(String[] args) throws IOException {
        File graphFile = new File("WeightedGraph.txt");
        WeightedGraph generatedGraph = fileToGraph(graphFile);
        WeightedGraph.MST minimumSpanningTree = generatedGraph.getMinimumSpanningTree(0);

        System.out.println("The number of vertices is " + minimumSpanningTree.getNumberOfVerticesFound());
        generatedGraph.printWeightedEdges();
        System.out.println("Total Weight in MST is " + minimumSpanningTree.getTotalWeight());
        minimumSpanningTree.printTree();
    }

    public static WeightedGraph fileToGraph(File graphFile) throws IOException {
        BufferedReader graphBufferedReader = new BufferedReader(new FileReader(graphFile));

        // first line has num vertices
        String currentLine = graphBufferedReader.readLine();
        int numVertices = Integer.parseInt(currentLine);

        // rest of file lines has edge data ; extract each edge string
        ArrayList<String> edgeStrings = new ArrayList<>();
        while ((currentLine = graphBufferedReader.readLine()) != null) {
            edgeStrings.addAll(Arrays.asList(currentLine.split("\\|"))); // contains all individual edge strings
        }

        // now, convert each edge string to an arrayList of 3 integers
        ArrayList<int[]> edges = new ArrayList<>();
        for (String edgeString : edgeStrings) {
            int[] edge = new int[3];
            String[] edgeElements = edgeString.split(",");
            for (int i = 0; i < 3; i++) {
                edgeElements[i] = edgeElements[i].trim();
                edge[i] = Integer.parseInt(edgeElements[i]);
            }
            edges.add(edge);
        }

        // convert edges from ArrayList<int[]> to int[][]
        int[][] edgesAsArray = new int[edges.size()][3];
        for (int i = 0; i < edges.size(); i++) {
            edgesAsArray[i] = edges.get(i);
        }

        return new WeightedGraph(edgesAsArray, numVertices);
    }
}
