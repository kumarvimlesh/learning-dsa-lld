package com.java.learning.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DetectCycle {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "B");

        System.out.println("Cycle : ");
        List<String> path = new ArrayList<>();
        detectCycle(path, graph);

        System.out.println("\nPath : ");
        List<List<String>> paths = new ArrayList<>();
        findPaths("A", "D", paths, graph);
    }

    private static void findPaths(String start, String end, List<List<String>> paths, Graph<String> graph) {
        System.out.println("Using DFS : ");
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        dfs(start, end, path, visited, paths, graph);
        paths.forEach(pa -> System.out.println(pa));

        System.out.println("Using BFS : ");
        paths = new ArrayList<>();
        visited = new HashSet<>();
        path = new ArrayList<>();
        bfs(start, end, path, visited, paths, graph);
        paths.forEach(pa -> System.out.println(pa));

    }

    private static void bfs(String node, String end, List<String> path, Set<String> visited, List<List<String>> paths, Graph<String> graph) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        path.add(node);
        while (!queue.isEmpty()){
            String curr = queue.poll();
            for(String nei: graph.getAdjacencyList(curr)){
                if (nei.equals(end)){
                    path.add(nei);
                    paths.add(new ArrayList<>(path));
                    path.remove(nei);
                    return;
                }
                else{
                    queue.offer(nei);
                    visited.add(nei);
                    path.add(nei);
                }
            }
        }
    }

    private static void dfs(String node, String end, List<String> path, Set<String> visited, List<List<String>> paths, Graph<String> graph) {
        visited.add(node);
        path.add(node);
        if (node.equals(end)){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(String nei: graph.getAdjacencyList(node)){
            if (!visited.contains(nei)){
                dfs(nei, end, path, visited, paths, graph);
            }
        }
        path.remove(node);
        visited.remove(node);
    }

    private static void detectCycle(List<String> cycle, Graph<String> graph) {
        String node = graph.getVertexes().stream().findAny().get();

        System.out.println("Using DFS : ");
        Set<String> visited = new HashSet<>();
        dfs(node, cycle, visited, graph);
        visited.forEach(el -> System.out.print(el + " -> "));
        System.out.println(cycle.get(0));


        System.out.println("Using BFS : ");
        cycle = new ArrayList<>();
        visited = new HashSet<>();
        bfs(node, cycle, visited, graph);
        visited.forEach(el -> System.out.print(el + " -> "));
        System.out.println(cycle.get(0));
    }

    private static void bfs(String node, List<String> cycle, Set<String> visited, Graph<String> graph) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        cycle.add(node);
        while (!queue.isEmpty()){
            String curr = queue.poll();
            for(String nei: graph.getAdjacencyList(curr)){
                if (visited.contains(nei)){
                    cycle.add(nei);
                    return;
                }
                else{
                    queue.offer(nei);
                    visited.add(nei);
                }
            }
        }
    }

    private static void dfs(String node, List<String> cycle, Set<String> visited, Graph<String> graph) {
        visited.add(node);
        cycle.add(node);
        for(String nei: graph.getAdjacencyList(node)){
            if (visited.contains(nei)){
                cycle.add(nei);
                return;
            }
            else{
                dfs(nei, cycle, visited, graph);
            }
        }
    }
}
