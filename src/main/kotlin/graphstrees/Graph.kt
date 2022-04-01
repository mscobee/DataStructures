package graphstrees

class Graph<T> {
    private val map = HashMap<T,Node<T>>();
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
    fun dfs(startingPoint : T) : String {
        return "";
    }
    fun bfs(startingPoint: T) : String {
        return "";
    }
    fun djikstras(startingPoint: T) : String {
        return "";
    }
    private class Node<T> (data: T) {
        val adjacentNodes=ArrayList<T>();
        val d = data;
        public fun getData() : T {
            return d;
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