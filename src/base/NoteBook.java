package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteBook {
	private ArrayList<Folder> folders;
	
	public NoteBook() {
		folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	
	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}
	
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	
	public boolean insertNote(String folderName, Note note){
		Folder f = null;
		for(Folder f1:folders) {
			if(f1.getName().equals(folderName)) {
				f = f1;
			}
		}
		
		if(f == null) {
			f = new Folder(folderName);
			folders.add(f);
		}
		for(Note e : f.getNotes()) {
			if(e.getTitle() == note.getTitle()) {
				System.out.println("Creating note "+note.getTitle()+" under foler "+folderName+" failed");
				return false;
			}
		}
		note = new Note(note.getTitle());
		return true;
	}
	
	public void sortFolders() {
		//TODO
		for(Folder f1:folders) {
			f1.sortNotes();
		}
	}
	
	public List<Note> searchNotes(String keywords){
		//TODO
		Folder.searchNotes(keywords);
	}
}
