import java.util.List;

class Main {
  public static void main(String[] args) {
    String[] vertices = {      
      "Liberal Arts", //0
      "Student Services", //1 
      "Health Careers & Sciences", //2
      "Health Technologies Center", //3
      "Recreation Center", //4
      "Technology Learning Center", //5
      "Business & Technology", //6
      "Theatre" //7
    };

    int[][] edges = {
      {6,7}, //Business & Technology to Theatre
      {6,1}, //Business & Technology to Student Services
      {0,1}, //Liberal Arts to Student Services
      {0,7}, //Liberal Arts to Theatre
      {7,0}, //Theatre to Liberal Arts
      {7,6}, //Theatre to Business & Technology
      {1,0}, //Student Services to Liberal Arts
      {1,5}, //Student Services to Technology Learning Center
      {1,2}, //Student Services to Health Careers & Sciences
      {1,6}, //Student Services to Business & Technology
      {1,4}, //Student Services to Recreation Center
      {5,1}, //Technology Learning Center to Student Services
      {2,3}, //Health Careers & Sciences to Health Technologies Center
      {2,1}, //Health Careers & Sciences to Student Services
      {2,4}, //Health Careers & Sciences to Recreation Center
      {3,2}, //Health Technologies Center to Health Careers & Sciences
      {4,1}, //Recreation Center to Student Services
      {4,2}, //Recreation Center to Health Careers & Sciences
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!
   
    printPath(dfs, graph, "Health Technologies Center");
    printPath(dfs, graph, "Student Services");
    printPath(dfs, graph, "Recreation Center");

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

          dfs.printTree();
  }

  private static void printPath(UnweightedGraph<String>.SearchTree dfs, Graph<String> graph, String destination) {
    int destinationIndex = graph.getIndex(destination);
    if (destinationIndex != -1) {
        dfs.printPath(destinationIndex);
       System.out.println();
    }
  }
  
}
