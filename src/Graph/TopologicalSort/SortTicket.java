package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yizhao on 6/30/15.
 */
public class SortTicket {
    public static void main(String[] args) {
        List<Ticket1> test = new ArrayList<Ticket1>();
        test.add( new Ticket1("AUS" , "SFO" ));
        test.add( new Ticket1("LAX" , "SEA" ));
        test.add( new Ticket1("SJC" , "LAX" ));
        test.add( new Ticket1("SEA" , "AUS" ));

        List<Ticket1> res = sortTicket1(test);

        // SJC -> LAX
        // LAX -> SEA
        // SEA -> AUS
        // AUS -> SFO
        for (Ticket1 t : res) {
            if (t.dest != null)
                System. out.println(t.source + "->" + t.dest );
        }
    }

    public static List<Ticket1> sortTicket1(List<Ticket1> input) {
        HashMap<String, Integer> indegree = new HashMap<String, Integer>();
        HashMap<String, String> map = new HashMap<String, String>();
        for (Ticket1 t : input) {
            map.put(t. source, t. dest);
            indegree.put(t. source, 0);
            indegree.put(t. dest, 0);
        }

        for (Ticket1 t : input) {
            indegree.put(t. dest, indegree.get(t. dest) + 1);
        }
        String start = null;
        for (String s : indegree.keySet()) {
            if (indegree.get(s) == 0) {
                start = s;
                break;
            }
        }
        List<Ticket1> res = new ArrayList<Ticket1>();
        while (start != null) {
            res.add( new Ticket1(start, map.get(start)));
            start = map.get(start);
        }
        return res;
    }
}

class Ticket1{
    String source;
    String dest;

    public Ticket1(String source, String dest){
        this.source = source;
        this.dest = dest;
    }
}