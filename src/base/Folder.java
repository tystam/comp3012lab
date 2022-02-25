package base;
import java.util.ArrayList;
import java.util.Objects;
public class Folder {
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name) {
		notes = new ArrayList<Note>();
		this.name = name;
	}
	
	public void addNote(Note f){
		notes.add(f);
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Folder == false)
			return false;
		Folder other = (Folder) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		
		//TODO
		if(this.getNotes() instanceof TextNote) {
			nText++;
		}
		else if (this instanceof ImageNote) {
			nImage++;
		}
		return name + ":" + nText + ":" + nImage;
	}
	
}
