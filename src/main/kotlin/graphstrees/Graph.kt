package graphstrees

class Graph<T> {
    private val map = HashMap<T,Node<T>>();
    private val visitedNodes = HashSet<T>();
    fun addNode(data: T) {
        map[data] = Node(data);
    }
    fun addEdge(n1:T, n2:T){
        map[n1]?.addEdge(n2);
        map[n2]?.addEdge(n1);
    }
    fun printGraph(){
        for ((key,value) in map.entries){
            print("Key: $key \t Adjacent Nodes: ");
            value.printAdjacent();
        }
    }
    fun dfs(currentNodeKey : T) {
        if (map[currentNodeKey] == null) {
            println("Given node of $currentNodeKey does not exist.");
        }
        visitedNodes.add(currentNodeKey);
        print("$currentNodeKey ");
        for(k in map[currentNodeKey]?.getList()!!) {
            // prevent cycle using the hashset
            if(!visitedNodes.contains(k)) {
                dfs(k);
            }
        }
    }
    fun bfs(startingPoint: T) {
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