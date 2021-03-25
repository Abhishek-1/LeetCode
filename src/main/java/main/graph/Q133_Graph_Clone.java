package main.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import main.Node;

/**
 *  Problem - 133
 *
 *  Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 */
public class Q133_Graph_Clone {

  Map<Integer, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {

    if(node == null) return null;

    Node newNode = createNode(node);
    Node result = newNode;
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();

    queue.offer(node);

    while(!queue.isEmpty()){
      Node temp = queue.remove();
      if(visited.contains(temp)) continue;
      newNode = map.get(temp.val);
      visited.add(temp);
      for(Node x: temp.neighbors){
        queue.offer(x);
        Node res = createNode(x);
        newNode.neighbors.add(res);

      }
    }

    return result;
  }

  public Node createNode(Node inp){
    if(inp == null) return null;
    else if(map.containsKey(inp.val)){
      return map.get(inp.val);
    } else {
      Node temp = new Node(inp.val, new ArrayList<>());
      map.put(inp.val, temp);
      return temp;
    }
  }

}
