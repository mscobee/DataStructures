import graphstrees.Graph

fun main(args: Array<String>) {
    val g = Graph<String>()
    g.addNode("Glenn");
    g.addNode("Denise");
    g.addNode("Bob");

    g.addEdge("Glenn", "Denise");
    g.addEdge("Denise", "Bob");

    g.printGraph();
}