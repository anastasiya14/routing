import Mesh.*;
import org.junit.Test;
import routing.Impl.Founder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Павел on 25.09.2016.
 */
public class Tests {

    @Test
    public void testTakeRoute() {
       /* Mesh mesh1, mesh2, mesh3, mesh4, mesh5, mesh6, mesh7;
        Map<String, Long> i1 = new HashMap<String, Long>(), i2, j1, j2, j3, j4;
        i2 = new HashMap<String, Long>();
        j1 = new HashMap<String, Long>();
        j2 = new HashMap<String, Long>();
        j3 = new HashMap<String, Long>();
        j4 = new HashMap<String, Long>();
        i1.put("a", 0L);
        i2.put("f", 1L);
        j1.put("b", 0L);
        j2.put("c", 1L);
        j3.put("d", 2L);
        j4.put("g", 3L);

        mesh1 = new Mesh(null, i1, j1, 0, 0, 2, 0.0, null);
        mesh2 = new Mesh(null, i1, j2, 0, 0, 3, 0.0, null);
        mesh3 = new Mesh(null, i1, j3, 0, 0, 6, 0.0, null);
        mesh4 = new Mesh(null, i1, j4, 0, 0, 5, 0.0, null);
        mesh5 = new Mesh(null, i2, j1, 0, 0, 1, 0.0, null);
        mesh6 = new Mesh(null, i2, j2, 0, 0, 3, 0.1, null);
        mesh7 = new Mesh(null, i2, j3, 0, 0, 2, 0.0, null);
        List<Mesh> allMesh = new ArrayList<Mesh>();
        allMesh.add(mesh1);
        allMesh.add(mesh2);
        allMesh.add(mesh3);
        allMesh.add(mesh4);
        allMesh.add(mesh5);
        allMesh.add(mesh6);
        allMesh.add(mesh7);

        Founder graph = new Founder();

        //List<Mesh> way54 = graph.TakeRouteFromStartToEndNodes(graph.TakeStructOfGraph(allMesh).get(0), mesh5, mesh4);
        List<Mesh> way75 = graph.TakeRouteFromStartToEndNodes(graph.TakeStructOfGraph(allMesh).get(0), mesh7, mesh5);

        System.out.println(way75);
        //System.out.println(way75.toString() + "\n\n");
        //54
        /*assertTrue("Fail in 5-2-3-4 with 5", way54.get(0).equals(mesh5));
        assertTrue("Fail in 5-2-3-4 with 2", way54.get(1).equals(mesh2));
        assertTrue("Fail in 5-2-3-4 with 3", way54.get(2).equals(mesh3));
        assertTrue("Fail in 5-2-3-4 with 4", way54.get(3).equals(mesh4));
        assertFalse("Fail in 5-2-3-4 with 1", way54.contains(mesh1));
        assertFalse("Fail in 5-2-3-4 with 6", way54.contains(mesh6));
        assertFalse("Fail in 5-2-3-4 with 7", way54.contains(mesh7));*/

        //75
        //assertTrue("Fail in 7-3-2-5 with 7", way75.get(0).equals(mesh7));
        /*assertTrue("Fail in 7-3-2-5 with 3", way75.get(0).equals(mesh3));
        assertTrue("Fail in 7-3-2-5 with 2", way75.get(0).equals(mesh2));
        assertTrue("Fail in 7-3-2-5 with 5", way75.get(0).equals(mesh5));
        assertFalse("Fail in 7-3-2-5 with 1", way75.contains(mesh1));
        assertFalse("Fail in 7-3-2-5 with 4", way75.contains(mesh4));
        assertFalse("Fail in 7-3-2-5 with 6", way75.contains(mesh6));*/


    }

    @Test
    public void testTakeStructOfGraph() {
        /*nSquare = new HashMap<String, Long>();
        squareI = new HashMap<String, Long>();
        squareJ = new HashMap<String, Long>();
        int timeZone;
        int weekDay;
        int devCount;
        double despersion;
        devices = new ArrayList<Devices>();*/

        Mesh mesh1, mesh2, mesh3, mesh4, mesh5, mesh6;
        Map<String, Long> i1 = new HashMap<String, Long>(), i2, j1, j2, j3, j4;
        i2 = new HashMap<String, Long>();
        j1 = new HashMap<String, Long>();
        j2 = new HashMap<String, Long>();
        j3 = new HashMap<String, Long>();
        i1.put("a", 0L);
        i2.put("f", 1L);
        j1.put("b", 0L);
        j2.put("c", 1L);
        j3.put("d", 2L);

       /* mesh1 = new Mesh(null, i1, j1, 0, 0, 1, 0.0, null);
        mesh2 = new Mesh(null, i1, j2, 0, 0, 3, 0.0, null);
        mesh3 = new Mesh(null, i1, j3, 0, 0, 2, 0.0, null);
        mesh4 = new Mesh(null, i2, j1, 0, 0, 2, 0.0, null);
        mesh5 = new Mesh(null, i2, j2, 0, 0, 4, 0.0, null);
        mesh6 = new Mesh(null, i2, j3, 0, 0, 1, 0.0, null);
        List<Mesh> allMesh = new ArrayList<Mesh>();
        allMesh.add(mesh1);
        allMesh.add(mesh2);
        allMesh.add(mesh3);
        allMesh.add(mesh4);
        allMesh.add(mesh5);
        allMesh.add(mesh6);

        Founder graph = new Founder();

        //needed nodes
        for (Mesh each : allMesh)
            assertTrue("Fail construct graph", graph.TakeStructOfGraph(allMesh).get(0).containsKey(each));

        //routes
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh1).containsKey(mesh2));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh1).containsKey(mesh4));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh1).containsKey(mesh5));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh2).containsKey(mesh1));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh2).containsKey(mesh3));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh2).containsKey(mesh4));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh2).containsKey(mesh5));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh2).containsKey(mesh6));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh3).containsKey(mesh2));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh3).containsKey(mesh5));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh3).containsKey(mesh6));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh4).containsKey(mesh1));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh4).containsKey(mesh2));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh4).containsKey(mesh5));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh5).containsKey(mesh1));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh5).containsKey(mesh2));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh5).containsKey(mesh3));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh5).containsKey(mesh4));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh5).containsKey(mesh6));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh6).containsKey(mesh2));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh6).containsKey(mesh3));
        assertTrue("Not true ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh6).containsKey(mesh5));

        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh1).containsKey(mesh3));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh1).containsKey(mesh6));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh3).containsKey(mesh1));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh3).containsKey(mesh4));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh4).containsKey(mesh3));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh4).containsKey(mesh6));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh6).containsKey(mesh1));
        assertFalse("Not False ok", graph.TakeStructOfGraph(allMesh).get(0).get(mesh6).containsKey(mesh4));*/
    }
}
