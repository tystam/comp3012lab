package base;

public class TextNote extends Note{
	public TextNote(String title) {
		super(title);
	}
	
	public TextNote(String title, String content) {
		//TODO
		
	}
	
	public boolean createTextNote(String folderName, String title, String content) {
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}
}
