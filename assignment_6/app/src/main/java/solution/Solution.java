package solution;
        
import graph.Vertex;
import java.util.Stack;

public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        this.sStart = start;
        this.sEnd = end;
        stackVer = stackerHelper(start,end);
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        length = stackVer.indexOf(sStart);
        System.out.println("Length: " + length);
        return length;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        Vertex safe = (Vertex) stackVer.pop();
        if((!stackVer.isEmpty() &&(stackVer.peek()!=null))){
            stackVer.push(safe);
            return true;
        }
        else{
            stackVer.push(safe);
            return false;
        }
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        if(hasNext()){
            stackVer.pop();
            return (Vertex) stackVer.peek();
        }
        else{
            return sStart;
        }
    }
    
    public Stack stackerHelper(Vertex start, Vertex end){
        helper.push(end);
        while (end.getPredecessor() != null){
            helper.push(end.getPredecessor());
            end = end.getPredecessor();
        }
        helper.push(start);
        return helper;
    }
    
    private Vertex sStart;
    private Vertex sEnd;
    public int length = 0;
    private Stack stackVer = new Stack();
    private Stack helper = new Stack();
}
