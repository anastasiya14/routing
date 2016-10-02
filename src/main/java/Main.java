import Mesh.*;
import routing.Impl.Founder;
import routing.Impl.JSONtoDataImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created: 28.03.16 14:38
 *
 * @author Ivanov Paul
 */
public class Main {
    private static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws Exception {
        JSONtoDataImpl jsoNtoData = new JSONtoDataImpl();

        List<String> allWeekDays = new ArrayList<String>();
        for (int i = 0; i < 7; i++)
            allWeekDays.add("mesh_" + i);

        Founder single = new Founder();
        Map<Integer, Map<Integer, Map<Mesh, Map<Mesh, String>>>> allGraphs =
                new HashMap<Integer, Map<Integer, Map<Mesh, Map<Mesh, String>>>>();

        int i = 0;
        for (String singleWeekDay : allWeekDays) {
            //Map<день недели, Map<Mesh, Map<Mesh, String>>>
            Map<Integer, Map<Mesh, Map<Mesh, String>>> rout = allGraphs.put(i++, single.TakeStructOfGraph(jsoNtoData.jsonToData(singleWeekDay)));
            //System.out.println("--------------------------------------------");
            System.out.println(allGraphs);
        }

        //for output use some of this:
        List<Mesh> way = new ArrayList<Mesh>();
       // way = single.TakeRouteFromStartToEndNodes(allGraphs.get(1).get(5), startNode, endNode);

    }
}