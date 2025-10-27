package problem5;


public class Main {
    public static void main(String[] args) {

        // Create some books
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Clean Code", "Robert C.Martin", 2008);
        Book book3 = new Book("The Hobbit", "J.R.R Tolkien", 1973);

        System.out.println("=== Stack Test ===");
        BookStack stack = new BookStack();

        stack.push(book3);
        stack.push(book1);
        stack.push(book2);

        stack.display();

        System.out.println("Popped : " + stack.pop());
        System.out.println("Top : "+ stack.peek());
        stack.display();


        System.out.println("\n=== Queue Test ===");
        BookQueue queue = new BookQueue();

        queue.enqueue(book3);
        queue.enqueue(book1);
        queue.enqueue(book2);

        queue.display();

        System.out.println("Dequeued : " + queue.dequeue());
        System.out.println("Front : " + queue.peek());

        queue.display();
    }
}
