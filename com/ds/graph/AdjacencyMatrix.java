package com.ds.graph;
import java.util.Arrays;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int vertices = 5;
        var m = new int[vertices][vertices];

        addEdgeMatrix(m, 0, 4);
        addEdgeMatrix(m, 2, 4);
        addEdgeMatrix(m, 3, 4);
        addEdgeMatrix(m, 4, 1);

        printMatrix(m);
    }

    private static void addEdgeMatrix(int[][] m, int i, int j) {
        m[i][j] = 1;
        m[j][i] = 1;
    }

    private static void printMatrix(int[][] adj) {
        for (int i = 0; i < adj.length; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }
    }


}
