package solution;

import graph.Vertex;
import problem.Mover;
import problem.Problem;
import problem.State;
import java.util.LinkedList;
import java.util.List;


/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        deque = new LinkedList();
        super.setQueue(deque); 
        if(bfs==true){
            super.getStatistics().setHeader("bfs stats ");
        }
        else {
            super.getStatistics().setHeader("dfs stats ");
        }
        this.bfs = bfs;

    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
	        if(bfs == true){
            deque.addLast(v);
        }
        else{
            deque.addFirst(v);
    }
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name ∈ moveNames do
             child = mover.doMove(name, u)
             if child ≠ null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
	       children = new LinkedList();
               Mover mover;
               mover = getProblem().getMover();
//        children.clear();
        for(String name: mover.getMoveNames()){
            child = new Vertex(mover.doMove(name, (State)u.getData()));
           if ((child.getData() != null) && (!occursOnPath(child, u))){
               //System.out.println("if Size: " + children.size()+ " which are: "+ child.getData());
               child.setDistance(u.getDistance()+1);
               child.setPredecessor(u);
               children.add(child);
               
           }
        }
        //System.out.println("size"+ children.size());
        return children;
    }


    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        
        Vertex an = ancestor;
          
        while ((!an.equals(v)) && (an != null)){  
         
             an = an.getPredecessor();
             if(an==null) return false;
    }
    if(an.equals(v)){
        //System.out.println("Same if: "+ an.equals(v));
                return true;
    }
    return false;
}

    //private static Deque<Vertex> deque;
    private LinkedList<Vertex> deque;
    private boolean bfs;
    private String statHeader;
    private List<Vertex> children;
    //private Mover mover;
    private Vertex child;
}
