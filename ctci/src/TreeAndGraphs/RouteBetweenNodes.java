package TreeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhimanyunarwal on 4/8/20.
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 */

public class RouteBetweenNodes {
    class Node{
        public Node node;
        public Node[] adjacent;
    }

    boolean isRouteAvailable(Node start, Node end){
        if(start==end){
            return true;
        }
        if(start==null){
            return false;
        }
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> isVisited = new ArrayList<Node>();
        isVisited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            Node t = queue.remove();
            isVisited.add(t);
            for(Node v:t.adjacent){
                  queue.add(v);
                  isVisited.add(v);
            }
            if (isVisited.contains(end)){
                return  true;
            }
        }
        return false;
    }
}
