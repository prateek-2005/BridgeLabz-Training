class TextStateNode {
    String text;
    TextStateNode next;
    TextStateNode prev;

    TextStateNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

public class TextEditorUndoRedo {
    private TextStateNode head = null;   
    private TextStateNode tail = null;  
    private TextStateNode current = null; 
    private final int MAX_HISTORY = 10; 
    private int size = 0;
    public void addState(String text) {
        TextStateNode newState = new TextStateNode(text);
        if (current != null && current != tail) {
            TextStateNode temp = current.next;
            while (temp != null) {
                TextStateNode next = temp.next;
                temp.prev = null;
                temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        current = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Added state: \"" + text + "\"");
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo. Already at earliest state.");
        } else {
            current = current.prev;
            System.out.println("Undo performed. Current state: \"" + current.text + "\"");
        }
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo. Already at latest state.");
        } else {
            current = current.next;
            System.out.println("Redo performed. Current state: \"" + current.text + "\"");
        }
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current Text: \"" + current.text + "\"");
        }
    }

    public void displayAllStates() {
        if (head == null) {
            System.out.println("No history available.");
            return;
        }
        TextStateNode temp = head;
        System.out.println("Full History:");
        while (temp != null) {
            String marker = (temp == current) ? " <- Current" : "";
            System.out.println("\"" + temp.text + "\"" + marker);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello, Java!");
        editor.displayAllStates();

        editor.undo();
        editor.undo();
        editor.undo();
        editor.redo();
        editor.redo();
        editor.redo();
    }
}
