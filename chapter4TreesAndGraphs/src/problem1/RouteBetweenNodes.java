package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhimanyunarwal on 3/4/17.
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 */

public class RouteBetweenNodes {

    class Node{
        public Node node;
        public Node[] adjacent;

    }

    public static boolean isReachable(Node root, Node dest){
      if(root==dest){
        return true;
      }
      if (root==null){
        return false;
      }
      Queue<Node> queue = new LinkedList<Node>();
      List<Node> visited = new ArrayList<Node>();
      visited.add(root);
      queue.add(root);
      while(!(queue.isEmpty())){
        Node temp = queue.remove();
        visited.add(temp);
        for(Node n : temp.adjacent)
        if(!(visited.contains(n))){
          visited.add(n);
          queue.add(n);
        }
      }
      if(visited.contains(dest)){
          return true;
      }
      else{
          return false;
      }
    }

}
