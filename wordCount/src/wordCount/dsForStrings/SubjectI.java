package wordCount.dsForStrings;
public interface SubjectI {
	void registerObserver(Node clone);
	void removeObserver(Node clone);
	void notifyObserver();
}