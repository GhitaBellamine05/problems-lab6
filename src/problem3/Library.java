package problem3;

import java.util.ArrayList;

public class Library {
    // attributes
    private int capacity;
    private ArrayList<Document> documents;
    // Constructor
    public Library(int capacity){
        this.capacity = capacity;
        this.documents = new ArrayList<>(capacity);
    }

    public boolean add(Document doc){
        if (documents.size() < capacity) {
            if (documents.contains(doc)) {
                return false;
            }
            documents.add(doc);
            return true;

        }
        return false;
    }
    public boolean delete(Document doc){
        if (documents.contains(doc)){
            documents.remove(doc);
            return true;
        }
        return false;
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Document d : documents) {
                System.out.println(d);
            }
        }
    }

    public Document document(int numEnreg) {
        for (Document d : documents) {
            if (d.getNumEnrg() == numEnreg)
                return d;
        }
        return null;
    }

    public void displayAuthors() {
        for (Document d : documents) {
            if (d instanceof Book) {
                System.out.println(((Book) d).getAuthor());
            }
        }
    }
}

