package tddtest;

public class BookTest extends UnitTest{

	@Override
	public void runTest() throws Exception {
		Book book = new Book("a");
		assertTrue(book.title.equals("a"), "checking title");
	}

}
