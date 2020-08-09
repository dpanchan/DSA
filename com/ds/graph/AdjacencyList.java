package com.ds.graph;
import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,5,6);
        for(int i= 0; i<adj.size();i++){
            for(int j=0; j<adj.get(i).size();j++){
                System.out.println(i + " connected with " + adj.get(i).get(j));
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int v1, int v2) {
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
    }

}
