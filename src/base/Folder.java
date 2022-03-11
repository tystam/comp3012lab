package base;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Folder implements Comparable<Note> {
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
	
	public void sortNotes() {
		//TO Do
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords){
		//TODO
		Pattern p1 = Pattern.compile(Pattern.quote("(?U)(\\w+)\\W+or\\W+(\\w+)"), Pattern.CASE_INSENSITIVE);
		Pattern p2 = Pattern.compile(Pattern.quote("(?U)(\\w+)\\W+\s\\W+(\\w+)"), Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(keywords);
		Matcher m2 = p2.matcher(keywords);
		int cnt = 0;
		while (m1.find()||m2.find()) {
			if(cnt == 0) {
				if(m1.find()) {
					boolean val1 = notes.content.contains(m1.group(1));
					boolean val2 = notes.content.contains(m1.group(2));
					if(val1 == true || val2 == true)
						return notes;
				}
			}	
		    cnt++;
		}
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
		else if (this.getNotes() instanceof ImageNote) {
			nImage++;
		}
		return name + ":" + nText + ":" + nImage;
	}
	
	@Override
	public int compareTo(Note o) {
		//TODO Auto-generated method stub
		if(this.name.compareTo(o.getTitle())>0) {
			return 1;
		}
		else if(this.name.compareTo(o.getTitle())<0) {
			return -1;
		}
		else 
			return 0;
	}
	
}
