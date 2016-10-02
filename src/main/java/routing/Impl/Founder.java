package routing.Impl;

import Mesh.Mesh;

import java.util.*;

/**
 * Created by Павел on 19.09.2016.
 */
public class Founder {
    private Map<Mesh, Boolean> usedNodes = new HashMap<Mesh, Boolean>();
    private List<Mesh> allMesh = new ArrayList<Mesh>();
    private int countOfNodes = 0;
    private boolean flagOfEnd = false;

    public Founder() {
    }

    public List<Mesh> TakeRouteFromStartToEndNodes (Map<Mesh, Map<Mesh, String>> graph, Mesh startNode, Mesh endNode) {
        if (!graph.containsKey(startNode) || !graph.containsKey(endNode)) return null;
        for (Mesh nodes : graph.keySet()) usedNodes.put(nodes, false);
        List<Mesh> way = FoundWay(startNode, graph, endNode);
        //if (!way.get(way.size() - 1).equals(endNode)) return null;
        return way;
    }

    private List<Mesh> FoundWay(Mesh node, Map<Mesh, Map<Mesh, String>> graph, Mesh endNode) {
        usedNodes.put(node, true);//in this node
        if (!allMesh.contains(node)) {
            allMesh.add(node);//add this node
            ++countOfNodes;
        }
        Mesh newNode = TakeNextNode(graph.get(node)); //new node is next
        if (NearNode(node, endNode) == true) { //found end node near this node
            allMesh.add(endNode); //add end node
            //countOfNodes++;
            flagOfEnd = true;
            return allMesh; //and exit
        }
        else if (newNode != null) allMesh.addAll(FoundWay(newNode, graph, endNode)); //if not end, than go deeper
        else { //or we in wrong way, well...
            allMesh.remove(allMesh.size() - 1); //delete last node
            allMesh.addAll(FoundWay(allMesh.get(allMesh.size() - 1), graph, endNode)); //and go another way with last node
        }
        if (flagOfEnd == true) {
            while (allMesh.size() != countOfNodes) allMesh.remove(allMesh.size() - 1);
        }
        return allMesh; //return all ways
    }

    private boolean NearNode(Mesh node, Mesh endNode) { //for easy read
        if (    node.getSquareI()
                - endNode.getSquareI() >= -1
                &&
                node.getSquareI()
                - endNode.getSquareI() <= 1
                &&
                node.getSquareJ()
                - endNode.getSquareJ() >= -1
                &&
                node.getSquareJ()
                - endNode.getSquareJ() <= 1) return true;
        return false;
    }

    private Mesh TakeNextNode(Map<Mesh, String> graphLine) {
        int maxDevices = 0;
        double minDespersion = 1.0;
        Mesh takedNode = null;
        for (Mesh nextNode : graphLine.keySet()) {
            String[] tokens = graphLine.get(nextNode).split("[_]");
            if ((Integer.valueOf(tokens[0]) > maxDevices
                    || (Integer.valueOf(tokens[0]) == maxDevices
                    && Double.valueOf(tokens[1]) < minDespersion))
                    && usedNodes.get(nextNode) == false ) {
                takedNode = nextNode;
                maxDevices = Integer.valueOf(tokens[0]);
                minDespersion = Double.valueOf(tokens[1]);
                if (Integer.valueOf(tokens[0]) > maxDevices) minDespersion = 1.0;
            }
        }
        return takedNode;
    }

    public Map<Integer, Map<Mesh, Map<Mesh, String>>> TakeStructOfGraph (List<Mesh> singleWeek) {

        Map<Integer, Map<Mesh, Map<Mesh, String>>> structOfGraph = new HashMap<Integer, Map<Mesh, Map <Mesh, String>>>(288);
        for (Mesh singleMesh_i : singleWeek) { //graph {timeZone , {node, {nearNode, "devCount_Despersion"}}}
            Map<Mesh, Map<Mesh, String>> structOfWays = new HashMap<Mesh, Map<Mesh, String>>();
            if (!structOfGraph.containsKey(singleMesh_i.getTimeZone())) structOfGraph.put(singleMesh_i.getTimeZone(), structOfWays);
            structOfWays = structOfGraph.get(singleMesh_i.getTimeZone());
            for (Mesh singleMesh_j : singleWeek)
                if (singleMesh_i != singleMesh_j
                        && singleMesh_i.getTimeZone() == singleMesh_j.getTimeZone()
                        && singleMesh_i.getSquareI()
                        - singleMesh_j.getSquareI()
                        <= 1L
                        && singleMesh_i.getSquareI()
                        - singleMesh_j.getSquareI()
                        >= -1L
                        && singleMesh_i.getSquareJ()
                        - singleMesh_j.getSquareJ()
                        <= 1L
                        && singleMesh_i.getSquareJ()
                        - singleMesh_j.getSquareJ()
                        >= -1L ) {
                    Map<Mesh, String> helpMesh = new HashMap<Mesh, String>();
                    helpMesh.clear();
                    helpMesh.put(singleMesh_j, String.valueOf(singleMesh_j.getDevCount())
                            + "_" + String.valueOf(singleMesh_j.getDespersion()));
                    if (structOfWays.isEmpty() || !structOfWays.containsKey(singleMesh_i)) structOfWays.put(singleMesh_i, helpMesh);
                    else if (structOfWays.containsKey(singleMesh_i))
                        structOfWays.get(singleMesh_i).put(singleMesh_j, String.valueOf(singleMesh_j.getDevCount())
                            + "_" + String.valueOf(singleMesh_j.getDespersion()));
                }
            structOfGraph.put(singleMesh_i.getTimeZone(), structOfWays);
        }

        return structOfGraph;
    }
}
