import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericsKbAVLApp add = new GenericsKbAVLApp();
        String choice;
        String choice1;

        do{
            System.out.println("Enter S (to search) or Q (to quit) : ");
            choice = scanner.nextLine();
            if(choice.equals("Q")){
                System.out.println("Thank you!");
                System.exit(0);
            }
            do{
                System.out.println("Enter first file name");
                String filename1 = scanner.nextLine();
                add.MakeTree(filename1);

                System.out.println("Enter second file name");
                String filename2 = scanner.nextLine();
                add.searchItem(filename2);
                do{
                    System.out.println("Do you want to enter a new file (y/n)");
                    choice1 = scanner.nextLine();
                    scanner.nextLine();
                    if(choice1.equals("y"))
                    {
                        System.out.println("which file would you like to change (1 or 2 )");
                        int choice2 = scanner.nextInt();
                        scanner.nextLine();
                        if(choice2 ==1){
                            System.out.println("Enter first file name");
                            filename1 = scanner.nextLine();
                        }
                        else{System.out.println("Enter second file name");}
                        filename2 = scanner.nextLine();  
                    add.MakeTree(filename1);
                    add.searchItem(filename2);
                    }
                }while(!choice1.equals("n"));
            }while(!choice1.equals("n"));
        }while(!choice.equals("Q"));
        scanner.close();
    }
}
