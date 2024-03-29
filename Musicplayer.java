import java.util.Scanner;

public class Musicplayer {
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;
    Node ptr_forward = null;

    Scanner sc = new Scanner(System.in);
    public void insert_at_begining() {
        String data;
        int user_choice;
        do{
        System.out.print("\nEnter Music Name : ");
        data = sc.nextLine();
        Node new_node = new Node(data);
        if (head == null) {
            ptr_forward = new_node;
            head = new_node;
            tail = new_node;
            new_node.next = head;
            new_node.prev = tail;
            System.out.print(ANSI_YELLOW + "Song Added Successully ...");
            System.out.println(ANSI_RESET);
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
            tail.next = head;
            head.prev = tail;
            System.out.print(ANSI_YELLOW + "Song Added Successully ...");
            System.out.println(ANSI_RESET);
        }
        System.out.print("\nDo you want to add another music press 1 or not press 2 : ");
        user_choice = sc.nextInt();
        sc.nextLine();
    } while (user_choice == 1);
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Playlist is empty ...");
        } else {
            System.out.print("Displaying All Songs In Forward Direction :\n");
            System.out.println(ANSI_BLUE + "-----------------------------------------------------------");
            do {
                System.out.print(" <--> " + temp.data);
                temp = temp.next;
            } while (temp != head);
            System.out.println(ANSI_BLUE+"\n-----------------------------------------------------------");
            displayback();
        }
        System.out.print(ANSI_RESET);
        System.out.println(ANSI_BLUE+"\n-----------------------------------------------------------");
    }
    
    public void displayback() {
            System.out.println();
        Node temp = tail;
        if (head == null) {
            System.out.println("Playlist is empty ...");
        } else {
            System.out.println(ANSI_RESET);
            System.out.print("\nDisplaying All Songs In Backword Direction :\n");
            System.out.println(ANSI_BLUE+"-----------------------------------------------------------");
            do {
                System.out.print(ANSI_YELLOW + " <--> " + temp.data);
                System.out.print(ANSI_RESET);
                temp = temp.prev;
            } while (temp != tail);
        }
    }

    public void playForward() {
        int n = 1;
        if (ptr_forward == null) {
            System.out.println("LinkedList doesnot exit ...");
        } else
            System.out.print(ANSI_BLUE+"-----------------------------------------------------------");
            ptr_forward = ptr_forward.next;
            System.out.println("\nPlaying Song : " + ptr_forward.data);
            System.out.println("-----------------------------------------------------------");
            
        }
    

        public void playBackward() {
            int n = 1;
            if (ptr_forward == null) {
                System.out.println("LinkedList doesnot exit ...");
            } else {
                System.out.print(ANSI_BLUE + "-----------------------------------------------------------");
                ptr_forward = ptr_forward.prev;
                System.out.println("\nPlaying Song : " + ptr_forward.data);
                System.out.println("-----------------------------------------------------------");

            }
        }

        public void DeleteMusic() {
            Node temp = head;
            int delete = 0;
            int flag1 = 0;
            String conf;
            // int found = 0;
            if (head == null) {
                System.out.println("Playlist is empty ...");
            } else {
                System.out.print("enter song : ");
                String str_delete = sc.nextLine();
                System.out.println(ANSI_BLUE + "-----------------------------------------------------------");
                do {
                    if (temp.next.equals(temp) && temp.data.equals(str_delete)) {
                        System.out.print(ANSI_RED+"Are you sure to delete this song (press y | n) : ");
                        conf = sc.nextLine();
                        if (conf.equals("y")) {
                            // System.out.println(ANSI_RED + "One file deleted! Playlist is Empty Now!\n");
                            head = null;
                            flag1++;
                        } 
                    
                    } else if (temp.data.equals(str_delete) && temp != head && temp != tail) {
                        System.out.print(ANSI_RED+"Are you sure to delete this song (press y | n) : ");
                        conf = sc.nextLine();
                        if (conf.equals("y")) {
                            // System.out.println(ANSI_RED + "One file deleted! Playlist is Empty Now!\n");

                            Node prev = temp.prev;
                            Node next = temp.next;
                            next.prev = prev;
                            prev.next = next;
                            head = prev;
                            tail = next;
                            delete++;
                            flag1++;
                        }
                    } else if (temp.data.equals(str_delete)) {
                        System.out.print(ANSI_RED+"Are you sure to delete this song (press y | n) : ");
                        conf = sc.nextLine();
                        if (conf.equals("y")) {
                            Node prev = temp.prev;
                            Node next = temp.next;
                            next.prev = prev;
                            prev.next = next;
                            head = next;
                            tail = prev;
                            delete++;
                            flag1++;
                            // System.out.println("Music deleted ...");
                        }
                    }
                  
                    temp = temp.next;
                } while (temp != head);
            }
            if (delete == 1 && flag1 == 1) {
                System.out.println(ANSI_GREEN + "Music deleted ...");
            }
            else if(delete == 0 && flag1 == 0){
                System.out.println(ANSI_YELLOW + "Music not deleted ...");
                System.out.println(ANSI_RESET);
            }
            else {
                System.out.println(ANSI_YELLOW + "Can't find music with this name");
                System.out.println(ANSI_RESET);
            }
            
            System.out.println("-----------------------------------------------------------");
        }

        public void SearchMusic() {
            Node temp = head;
            int found = 0;
            if (head == null) {
                System.out.println("Playlist is empty ...");
            } else {
                System.out.print("enter song : ");
                String str_search = sc.nextLine();
                System.out.println(ANSI_BLUE+"-----------------------------------------------------------");
                do {
                    if (temp.data.equals(str_search)) {
                        found++;
                        break;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (found == 1) {
                    System.out.println("Music Found");
                    System.out.println("Playing Music : " + str_search);
                    
                } else {
                    System.out.println("Can't found Music with name "+str_search);
                }
                System.out.println("-----------------------------------------------------------");
            }
           
        }

    static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Musicplayer mp3 = new Musicplayer();
        clearScreen();   // method call to clear terminal 
        Scanner sc = new Scanner(System.in);
        System.out.println(RED_BACKGROUND_BRIGHT+
                "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== MUSIC PLAYER ==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==");
        int userChoice;
        System.out.println(ANSI_RESET);
        do {
        System.out.println("\n"+ANSI_CYAN+"-----------------------------------------------------------");
        System.out.println("1. Add Music");
        System.out.println("2. Play Forword");
        System.out.println("3. Play Backword");
        System.out.println("4. Display Playlist");
        // System.out.println("5. Sort Alphabatically");
        System.out.println("5. Search");
        System.out.println("6. Delete");
        System.out.println("7. Exit");
        System.out.print("Enter Your Choice : ");
        userChoice = sc.nextInt();
        System.out.println("-----------------------------------------------------------");

        switch (userChoice) {
            case 1:
                System.out.println(ANSI_RESET);
                mp3.insert_at_begining();
                break;
            case 2:
                System.out.println(ANSI_RESET);
                clearScreen();
                System.out.println(RED_BACKGROUND_BRIGHT+
                        "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== MUSIC PLAYING FORWORD ==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==\n\n");
                System.out.println(ANSI_RESET);
                mp3.playForward();
                break;
            case 3:
                System.out.println(ANSI_RESET);
                clearScreen();
                System.out.println(RED_BACKGROUND_BRIGHT+
                        "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== MUSIC PLAYING BACKWORD =*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==\n\n");
                System.out.println(ANSI_RESET);
                mp3.playBackward();
                break;
            case 4:
                System.out.println(ANSI_RESET);
                clearScreen();
                System.out.println(RED_BACKGROUND_BRIGHT+
                        "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== DISPLAYING SONGS ==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==\n\n");
                System.out.println(ANSI_RESET);
                mp3.display();
                break;
                // case 5:
                // System.out.println(ANSI_RESET);
                // clearScreen();
                // mp3.insertionSort();
                // break;
            case 5:
                System.out.println(ANSI_RESET);
                clearScreen();
                System.out.println(RED_BACKGROUND_BRIGHT+
                        "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== SEARCH SONG ==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==\n\n");
                System.out.println(ANSI_RESET);
                mp3.SearchMusic();
                break;
            case 6:
                System.out.println(ANSI_RESET);
                clearScreen();
                System.out.println(RED_BACKGROUND_BRIGHT+
                        "\n\n==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*== DELETE MUSIC ==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==\n\n");
                System.out.println(ANSI_RESET);
                mp3.DeleteMusic();
                break;
            case 7:
                System.out.println("Exit Successfully ...");
                break;
            default:
                System.out.println(ANSI_RED+"Invalid Choice ...");
                break;
            }
 
    } while (userChoice != 7);
    }
}
