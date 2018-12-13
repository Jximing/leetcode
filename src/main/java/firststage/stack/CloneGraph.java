package firststage.stack;

import java.util.*;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        UndirectedGraphNode resnode = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue= new LinkedList<>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        queue.offer(node);
        map.put(node,resnode);
        while (!queue.isEmpty()){
            //依次遍历queue里面的node，将其neighbors加入队列中，当queue为空时代表遍历完了
            UndirectedGraphNode temp = queue.poll();
            resnode = map.get(temp);
            for (UndirectedGraphNode neighbir:temp.neighbors) {
                //只将还没有遍历过的节点加入队列
                if(!map.containsKey(neighbir)){
                    queue.offer(neighbir);
                    //建立原node和新node对应关系
                    map.put(neighbir,new UndirectedGraphNode(neighbir.label));
                }
                resnode.neighbors.add(map.get(neighbir));
            }
        }
        return map.get(node);
    }
}

  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
