import graphstrees.Graph

fun main(args: Array<String>) {
    val g = Graph<String>()
    g.addNode("Glenn");
    g.addNode("Doug");
    g.addNode("Mike");
    g.addNode("Denise");
    g.addNode("Jack");
    g.addNode("Bob");

    g.addEdge("Glenn", "Mike");
    g.addEdge("Glenn", "Doug");
    g.addEdge("Mike","Denise");
    g.addEdge("Mike","Doug");
    g.addEdge("Doug","Denise");
    g.addEdge("Denise","Jack");
    g.addEdge("Jack","Bob");
    g.addEdge("Bob","Denise");






//    g.printGraph();
    print("DFS: ");
    g.dfs("Glenn");
}