// <  >

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Challenge1
{
    public static void main(String[] args)
    {
        Scanner keyb = new Scanner(System.in);

        System.out.print("Insert your name: ");
        String name = keyb.nextLine();
        System.out.print("Insert your age: ");
        int age = keyb.nextInt();
        keyb.nextLine();
        System.out.print("Insert your Reddit username: ");
        String username = keyb.nextLine();

        System.out.format("\nYour name is %s, you are %d years old and your username is %s.", name, age, username);

        try
        {
            //File file = new File("data.txt");

            FileWriter myWriter = new FileWriter("data.txt");
            myWriter.write("Name: " + name + ", Age: " + age + ", Reddit username: " + username);
            myWriter.close();

        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}
