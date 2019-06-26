
public class TestIf {

	public static void main(String[] args) {
		int bal = 100000;
		boolean withdraw;
		
		if (bal < 0)
			withdraw = false;
		else
			withdraw = true;
		
		System.out.println("Can I withdraw money?: " + withdraw);

	}

}
