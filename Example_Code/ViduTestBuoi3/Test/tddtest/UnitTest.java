package tddtest;

public abstract class UnitTest {

	public abstract void runTest() throws Exception;
	
	protected void  assertTrue(boolean condition,String msg) throws Exception{
		if(!condition){
			throw new Exception(msg);
		}
	}
}
