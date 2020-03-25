import java.util.Scanner;

public class NecklaceMatching
{
    public static void main(String[] args)
    {
        Scanner keyb = new Scanner(System.in);

        System.out.print("Insert Necklace A: ");
        String necklaceA = keyb.nextLine();


        System.out.print("Insert Necklace B: ");
        String necklaceB = keyb.nextLine();

        System.out.format("\nAre %s and %s the same necklace?", necklaceA, necklaceB);

        System.out.println(isSameNecklace(necklaceA, necklaceB) ? " Yes, they are." : " No, they are not.");

        int n = repetition(necklaceA);
        System.out.format("\nHow many times %s is repeated in itself? It is repeated %d %s.", necklaceA, n,  (n <= 1 ? "time" : "times"));

    }

    public static boolean isSameNecklace(String necklaceA, String necklaceB)
    {
        if (necklaceA.length() != necklaceB.length()) return false;

        for (int i = 0; i < necklaceA.length(); i++)
        {
            if (necklaceA.equals(necklaceB)) return true;
            char a = necklaceA.charAt(0);
            necklaceA = necklaceA.substring(1) + a;
        }

        return false;
    }

    public static int repetition(String necklace)
    {
        int times = 0;
        String rotatingNecklace = necklace;

        for (int i = 0; i < rotatingNecklace.length(); i++)
        {
            if (rotatingNecklace.equals(necklace)) times++;
            char a = rotatingNecklace.charAt(0);
            rotatingNecklace = rotatingNecklace.substring(1) + a;
        }

        return times;
    }
}
