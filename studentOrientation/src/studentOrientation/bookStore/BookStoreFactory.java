package studentOrientation.bookStore;
import studentOrientation.util.Logger;
public class BookStoreFactory {
		
	public static BookStore createBookStore(BookStoreOptions universityOption) {
		
		BookStore bookStore = null;	
		Logger.writeMessage("DEBUG_VALUE=1 [" + universityOption.name() + " BookStore constructed]", 
				Logger.DebugLevel.ACTIVITY);
	
		switch (universityOption) {
			case UNIVERSITY:
				bookStore = new UniversityBookStore();
				break;
			case MANDO:
				bookStore = new MandoBooks();
				break;
		}
		return bookStore;
	}
}