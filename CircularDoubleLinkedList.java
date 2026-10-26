import java.util.Scanner;

class Playlist {
    class Node {
        String song;
        Node next;
        Node prev;

        Node(String s) {
            song = s;
            next = null;
            prev = null;
        }
    }

    Node head = null;

    // Add a song
    void insert(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;

            newNode.next = head;
            head.prev = newNode;
        }

        System.out.println("Song added: " + song);
    }

    // Play next song
    void nextSong() {
        if (head == null) {
            System.out.println("Playlist is empty");
        } else {
            head = head.next;
            System.out.println("Current song: " + head.song);
        }
    }

    // Play previous song
    void previousSong() {
        if (head == null) {
            System.out.println("Playlist is empty");
        } else {
            head = head.prev;
            System.out.println("Current song: " + head.song);
        }
    }

    // Display playlist
    void display() {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }

        Node temp = head;

        System.out.println("Playlist:");

        do {
            System.out.println(temp.song);
            temp = temp.next;
        } while (temp != head);
    }
}

public class CircularDoubleLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist p = new Playlist();

        int choice;

        do {
            System.out.println("\n1. Add Song");
            System.out.println("2. Next Song");
            System.out.println("3. Previous Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    p.insert(song);
                    break;

                case 2:
                    p.nextSong();
                    break;

                case 3:
                    p.previousSong();
                    break;

                case 4:
                    p.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);

        sc.close();
    }
}

