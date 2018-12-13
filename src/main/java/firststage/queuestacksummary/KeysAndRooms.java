package firststage.queuestacksummary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int rs = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<rooms.get(0).size();i++){
            queue.offer(rooms.get(0).get(i));
        }
        rooms.set(0,null);
        while (!queue.isEmpty()){
            int _t = queue.poll();
            if(rooms.get(_t)!=null){
                for (int i=0;i<rooms.get(_t).size();i++){
                    queue.offer(rooms.get(_t).get(i));
                }
                rooms.set(_t,null);
            }
        }
        for (int i =0;i<rs;i++){
            if(rooms.get(i)!=null){
                return false;
            }
        }
        return true;
    }
}
