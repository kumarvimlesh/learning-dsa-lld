package com.java.learning.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private Map<T, List<T>> adj;
    public Graph(){
        adj = new HashMap<>();
    }

    public void addEdge(T source, T dest){
        adj.computeIfAbsent(source, k -> new ArrayList<>());
        adj.get(source).add(dest);

    }

    public Set<T> getVertexes(){
        return adj.keySet();
    }

    public List<T> getAdjacencyList(T v){
        if (adj.containsKey(v)) return adj.get(v);
        else return new ArrayList<>();
    }
}
