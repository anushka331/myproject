import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        int choice = 0;

        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome to Marvellous Packer-Unpacker");
        System.out.println("-----------------------------------------------------");

        while(true)
        {
            System.out.println("1. Pack files from folder");
            System.out.println("2. Unpack files from packed file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sobj.nextInt();
            sobj.nextLine(); // consume newline

            switch(choice)
            {
                case 1:
                    System.out.print("Enter folder name to pack: ");
                    String folder = sobj.nextLine();
                    System.out.print("Enter name of packed output file: ");
                    String packName = sobj.nextLine();
                    new Packer(folder, packName);
                    break;

                case 2:
                    System.out.print("Enter packed file name to unpack: ");
                    String unpackFile = sobj.nextLine();
                    new Unpacker(unpackFile);
                    break;

                case 3:
                    System.out.println("Thank you for using Marvellous Packer-Unpacker!");
                    sobj.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
