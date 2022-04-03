package graphstrees

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph<T> {
    private val map = HashMap<T,Node<T>>();
    private val visitedNodes = HashSet<T>();
    private val q: Deque<T> = LinkedList<T>();
    fun addNode(data: T) {
        map[data] = Node(data);
    }
    fun addEdge(n1:T, n2:T){
        map[n1]?.addEdge(n2);
        map[n2]?.addEdge(n1);
    }
    fun dfs(currentNodeKey: T) {
        visitedNodes.clear();
        dfsrec(currentNodeKey);
    }
    private fun dfsrec(currentNodeKey : T) {
        if (map[currentNodeKey] == null) {
            println("Given node of $currentNodeKey does not exist.");
        }
        visitedNodes.add(currentNodeKey);
        print("$currentNodeKey ");
        for(k in map[currentNodeKey]?.getList()!!) {
            // prevent cycle using the hashset
            if(!visitedNodes.contains(k)) {
                dfsrec(k);
            }
        }
    }
    fun bfs(currentNodeKey: T) {
        var current: T
        visitedNodes.clear();
        val nodesToVisit: Queue<T> = LinkedList<T>()
        nodesToVisit.add(currentNodeKey)
        visitedNodes.add(currentNodeKey)

        while(!nodesToVisit.isEmpty()) {
            current = nodesToVisit.remove()
            println(current)

            for(node in map[current]?.getList()!!) {
                if(!visitedNodes.contains(node)) {
                    visitedNodes.add(node)
                    nodesToVisit.add(node)
                }
            }
        }

    }
    fun djikstras(startingPoint: T){
    }
    private class Node<T> (data: T) {
        private val adjacentNodes=ArrayList<T>();
        private val d = data;
        public fun getData() : T {
            return d;
        }
        public fun getList() : ArrayList<T> {
            return adjacentNodes;
        }
        public fun addEdge(t: T) {
            adjacentNodes.add(t);
        }
        public fun printAdjacent() {
            for (str in adjacentNodes) {
                print("$str ");
            }
            println();
        }
    }
}