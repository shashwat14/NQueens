import java.util.Scanner;


public class Backtracking {
	static int counter = 0;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		int size = Integer.parseInt(number);
		in.close();
		
		
		int[] startState = new int[size];
		
		Node startNode = new Node(startState);
		startNode.level = -1;
		backtracking(startNode,size);
		
		System.out.println(counter);
		
	}

	private static void backtracking(Node node, int size) {
		// TODO Auto-generated method stub
		//showState(node.state,size);
		if(constrainSatisfied(node,size)){
			if (isLeafNode(node,size)){
				//System.out.println(5);
				if (isGoalNode(node,size)){
					//System.out.println(6);
					//showState(node.state,size);
					counter++;
				}
			}
			else{
				Node[] childNodes = getChildNodes(node,size);
				for(int i = 0; i<size; i++){
					//System.out.println(i);
					backtracking(childNodes[i],size);
				}
			}
		}
	}

	private static boolean constrainSatisfied(Node node, int size) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int level = node.level;
		for(int i = 0; i < level; i++ ){
			for(int j = i+1; j < level; j++){
				if ((node.state[i] == node.state[j]) || Math.abs(node.state[i]-node.state[j]) == Math.abs(i-j))
					flag = false;
				
			}
		}
		return flag;
	}

	private static void showState(int[] state, int size) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for(int i = 0; i<size; i++){
			System.out.print(state[i]);
			System.out.print(",");
		}
		System.out.println("]");
		
	}

	
	private static Node[] getChildNodes(Node node,int size) {
		// TODO Auto-generated method stub
		int level = node.level;
		level++;
		Node[] childNodes = new Node[size];
		for(int i = 0; i<size; i++){
			Node childNode = new Node();
			int[] state = node.state.clone();
			state[level] = i+1;
			childNode.state = state;
			childNode.level = level;
			childNodes[i]  = childNode;	
		}
		return childNodes;
	}

	private static boolean isGoalNode(Node node, int size) {
		// TODO Auto-generated method stub
		boolean flag = true;
		for(int i = 0; i < size; i++ ){
			for(int j = i+1; j < size; j++){
				if ((node.state[i] == node.state[j]) || Math.abs(node.state[i]-node.state[j]) == Math.abs(i-j))
					flag = false;
				
			}
		}
		return flag;
	}

	private static boolean isLeafNode(Node node, int size) {
		// TODO Auto-generated method stub
		if(node.level == (size-1))
			return true;
		else
			return false;
	}
}
