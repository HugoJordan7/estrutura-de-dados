package atividade03;

public class Main {
	
	private static BST_IF bst;
	private static final long basecpf = 99977733311100L;

	public static void main(String[] args) {
		//Main para a implementação 4
		try {
			testIsComplete1();
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void testIsComplete1(){
		bst = new BST();
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		boolean result = bst.isComplete();
		System.out.println(result);
	}

}