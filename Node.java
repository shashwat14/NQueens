
public class Node {
	public int[] state;
	public Node parent;
	public int size;
	public int level;
	
	public Node(int[] state){
		this.state  = state;
	}
	
	public Node(){

	}
	
	public String toString(){
		return state.toString();
	}
	
	
}
