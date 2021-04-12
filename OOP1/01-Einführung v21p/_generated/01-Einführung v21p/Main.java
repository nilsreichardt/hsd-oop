/**<br>
 * Das ist hier ein Text :=)<br>
 <br>*/
class Main {
	public static void main(String[] args) {
    	System.out.println(fakultaet(5));
    }
    
    public static int fakultaet(int n) {
    	if(n == 1) return n;
        return n * fakultaet(n - 1);
    }
}