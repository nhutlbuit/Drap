package Exception;

public class TestExeption {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = null;// it is object . so it can not null
		
		try {
			if (a.equals("a")) {
				System.out.println("Non Exception");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("java.lang.NullPointerException");
		}
		

	}

}
