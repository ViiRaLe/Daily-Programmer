// <  >
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class IntermediateChallenge1
{
    static Scanner keyb = new Scanner(System.in);
    static boolean eventsLoaded = false;
    static boolean eventsSaved = true;

    public static void main(String[] args)
    {
        List<HourEvent> events = new ArrayList<HourEvent>();


        while (true)
        {
            System.out.println("\n\n-- 1 Add Event --\n-- 2 Edit Event --\n-- 3 Remove Event --\n-- 4 List Events --\n-- 5 Save Events --\n-- 6 Load Events --\n-- 7 Close Program --\n");

            switch (keyb.nextInt())
            {
                case 1:
                    addEvent(events);
                    break;

                case 2:
                    editEvent(events);
                    break;

                case 3:
                    removeEvent(events);
                    break;

                case 4:
                    listEvents(events);
                    break;

                case 5:
                    saveEvents(events);
                    break;

                case 6:
                    loadEvents(events);
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nSelect one of the above options with 1, 2, 3, 4, 5, 6 or 7.");
                    break;
            }
        }
    }

    public static void addEvent(List<HourEvent> events)
    {
        HourEvent a = new HourEvent();

        keyb.nextLine();
        System.out.print("\nInsert the new event Name: ");
        a.name = keyb.nextLine();

        do
        {
            System.out.print("Insert the new event Hour: ");
            a.hour = keyb.nextFloat();
            keyb.nextLine();
        } while (a.hour > 23.595 || a.hour < 0);

        do
        {
            System.out.print("Insert the new event Year: ");
            a.year = keyb.nextInt();
            keyb.nextLine();
        } while (a.year > 3000 || a.year < 1900);

        do
        {
            System.out.print("Insert the new event Month: ");
            a.month = keyb.nextInt();
            keyb.nextLine();
        } while (a.month > 12 || a.month < 1);

        do
        {
            System.out.print("Insert the new event Day: ");
            a.day = keyb.nextInt();
            keyb.nextLine();
        } while (a.day > 31 || a.day < 1);  //TO CHECK DAY IN THE MONTH


        System.out.print("Insert the new event Place: ");
        a.place = keyb.nextLine();

        System.out.print("Insert the new event Description: ");
        a.description = keyb.nextLine();

        events.add(a);

        /*Collections.sort(events, new Comparator<HourEvent>() {
        @Override public int compare(HourEvent h1, HourEvent h2) {
            return (int)(h1.hour * 100) - (int)(h2.hour * 100);
        }
    });*/

        Collections.sort(events, new Comparator<HourEvent>() {
        @Override public int compare(HourEvent h1, HourEvent h2) {
            int c;
            c = h1.year - h2.year;
            if (c == 0)
               c = h1.month - h2.month;
           if (c == 0)
              c = h1.day - h2.day;
            if (c == 0)
               c = (int)(h1.hour * 100) - (int)(h2.hour * 100);
            return c;
        }
        });

        eventsSaved = false;
    }

    public static void editEvent(List<HourEvent> events)
    {
        if (events.size() == 0)
        {
            System.out.println("\nNo Events programmed.");
            return;
        }

        System.out.print("\nInsert the number of the Event to edit: ");
        int n = keyb.nextInt() - 1;
        keyb.nextLine();

        try
        {
            events.get(n);
        } catch (IndexOutOfBoundsException e) {

            System.out.println("Event non existent.");
            return;
        }

        System.out.print("\nInsert the new event Name: ");
        events.get(n).name = keyb.nextLine();

        do
        {
            System.out.print("Insert the new event Hour: ");
            events.get(n).hour = keyb.nextFloat();
            keyb.nextLine();
        } while (events.get(n).hour > 23.595 || events.get(n).hour < 0);

        do
        {
            System.out.print("Insert the new event Year: ");
            events.get(n).year = keyb.nextInt();
            keyb.nextLine();
        } while (events.get(n).year > 3000 || events.get(n).year < 1900);

        do
        {
            System.out.print("Insert the new event Month: ");
            events.get(n).month = keyb.nextInt();
            keyb.nextLine();
        } while (events.get(n).month > 12 || events.get(n).month < 1);

        do
        {
            System.out.print("Insert the new event Day: ");
            events.get(n).day = keyb.nextInt();
            keyb.nextLine();
        } while (events.get(n).day > 31 || events.get(n).day < 1);  //TO CHECK DAY IN THE MONTH

        System.out.print("Insert the new event Place: ");
        events.get(n).place = keyb.nextLine();

        System.out.print("Insert the new event Description: ");
        events.get(n).description = keyb.nextLine();

        Collections.sort(events, new Comparator<HourEvent>() {
        @Override public int compare(HourEvent h1, HourEvent h2) {
            return (int)(h1.hour * 100) - (int)(h2.hour * 100);
        }
    });

        eventsSaved = false;
    }

    public static void removeEvent(List<HourEvent> events)
    {
        if (events.size() == 0)
        {
            System.out.println("\nNo Events programmed.");
            return;
        }

        System.out.print("\nInsert the number of the Event to remove: ");
        int n = keyb.nextInt() - 1;
        keyb.nextLine();

        try
        {
            events.get(n);
        } catch (IndexOutOfBoundsException e) {

            System.out.println("Event non existent.");
            return;
        }

        events.remove(n);

        eventsSaved = false;
    }

    public static void listEvents(List<HourEvent> events)
    {
        if (events.size() == 0)
        {
            System.out.println("\nNo Events programmed.");
            return;
        }

        for (int i = 0; i < events.size(); i++)
        {
            System.out.format("\nEVENT %d\nEvent Name: %s\nEvent Hour: %.2f\nEvent Day/Month/Year: %d/%d/%d\nEvent Place: %s\nEvent Description: %s\n\n", i+1, events.get(i).name, events.get(i).hour, events.get(i).day,
                                                                                                                                        events.get(i).month, events.get(i).year, events.get(i).place, events.get(i).description);
        }
    }

    public static void saveEvents(List<HourEvent> events)
    {
        if (events.size() == 0 || eventsSaved)
        {
            System.out.print("\nNo events to save.");
            return;
        }

        try
        {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("events.txt"));

            for (int i = 0; i < events.size(); i++)
            {
                myWriter.newLine();
                myWriter.write("" + events.get(i).hour);
                myWriter.newLine();
                myWriter.write("" + events.get(i).day);
                myWriter.newLine();
                myWriter.write("" + events.get(i).month);
                myWriter.newLine();
                myWriter.write("" + events.get(i).year);
                myWriter.newLine();
                myWriter.write(events.get(i).name);
                myWriter.newLine();
                myWriter.write(events.get(i).place);
                myWriter.newLine();
                myWriter.write(events.get(i).description);
                myWriter.newLine();

            }

            myWriter.flush();
            myWriter.close();

            eventsSaved = true;
            eventsLoaded = true;

        } catch (IOException e) {
          System.out.print("\nAn error occurred saving the events.");
          //e.printStackTrace();
        }
    }

    public static void loadEvents(List<HourEvent> events)
    {
        if (eventsLoaded)
        {
            System.out.print("\nEvents already loaded.");
            return;
        }

        try
        {
            BufferedReader readFileBuffer = new BufferedReader(new FileReader("events.txt"));

            while (readFileBuffer.readLine() != null)
            {
                HourEvent a = new HourEvent();

                try
                {
                    String h = readFileBuffer.readLine();
                    a.hour = Float.valueOf(h);

                    String d = readFileBuffer.readLine();
                    a.day = Integer.valueOf(d);

                    String m = readFileBuffer.readLine();
                    a.month = Integer.valueOf(m);

                    String y = readFileBuffer.readLine();
                    a.year = Integer.valueOf(y);

                } catch (NumberFormatException  e) {
                    e.getMessage();
                }

                a.name = readFileBuffer.readLine();
                a.place = readFileBuffer.readLine();
                a.description = readFileBuffer.readLine();
                events.add(a);
            }

            readFileBuffer.close();

            eventsSaved = true;
            eventsLoaded = true;

        } catch (IOException e) {

            System.out.print("\nNo saved events.");
            //e.printStackTrace();
        }
    }


    static class HourEvent
    {
        float hour = 0f;
        int day = 1;
        int month = 1;
        int year = 2020;
        String name = "NewEvent";
        String place = "None";
        String description = "EmptyEvent";
    }
}
