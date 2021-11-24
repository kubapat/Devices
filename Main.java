import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog();
        Scanner keyboardInput = new Scanner(System.in);
        String filename = keyboardInput.next();

        Main.readFromFile(catalog,filename);
        boolean continueProgram = true;

        while(continueProgram) {
            System.out.println("1 - Show the catalogue\n" +
                    "2 - Add a new refrigerator\n" +
                    "3 - Add a new dishwasher\n" +
                    "4 - Add a new washing machine\n" +
                    "5 - Show the entire catalogue sorted by appliance\n" +
                    "6 - Show the entire catalogue sorted by brand\n" +
                    "7 - Write to file\n" +
                    "8 - Stop the program\n");

            int choice = keyboardInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(catalog.toString());
                    break;
                case 2:
                    Main.addRefrigerator(catalog,keyboardInput);
                    break;

                case 3:
                    Main.addDishwasher(catalog,keyboardInput);
                    break;

                case 4:
                    Main.addWasher(catalog,keyboardInput);
                    break;

                case 5:
                    catalog.sortByClass();
                    break;

                case 6:
                    catalog.sortByBrand();
                    break;

                case 7:
                    Main.writeToFile(catalog);
                    break;

                case 8:
                    continueProgram = false;
                    break;
            }
        }
    }

    private static void readFromFile(Catalog catalog, String filename) throws FileNotFoundException {
        Scanner fileScreen = new Scanner(new File(filename));

        while(fileScreen.hasNextLine()) {
            String line = fileScreen.nextLine();
            String[] elems = line.split(", ");
            if(line.contains("REFRIGERATOR")) {
                catalog.addDevice(new Refrigerator(elems[0].replace("REFRIGERATOR ",""),elems[1],elems[2],elems[3],Integer.parseInt(elems[4].replace(" euros",""))));
            } else if (line.contains("DISHWASHER")) {
                catalog.addDevice(new Dishwasher(elems[0].replace("DISHWASHER ",""),elems[1],elems[2],elems[3],Integer.parseInt(elems[4].replace(" euros",""))));
            } else if(line.contains("WASHER")) {
                catalog.addDevice(new Washer(elems[0].replace("WASHER ",""),elems[1],elems[2],elems[4],Integer.parseInt(elems[3]),Integer.parseInt(elems[5].replace(" euros",""))));
            }
        }

    }

    private static void addRefrigerator(Catalog catalog, Scanner input) {
        String brand = input.next();
        String model = input.next();
        String capacity = input.next();
        String energy = input.next();
        int price = input.nextInt();
        catalog.addDevice(new Refrigerator(brand,model,capacity,energy,price));
    }

    private static void addDishwasher(Catalog catalog, Scanner input) {
        String brand = input.next();
        String model = input.next();
        String capacity = input.next();
        String energy = input.next();
        int price = input.nextInt();
        catalog.addDevice(new Dishwasher(brand,model,capacity,energy,price));
    }

    private static void addWasher(Catalog catalog, Scanner input) {
        String brand = input.next();
        String model = input.next();
        String capacity = input.next();
        int rotations = input.nextInt();
        String energy = input.next();
        int price = input.nextInt();
        catalog.addDevice(new Washer(brand,model,capacity,energy,price,rotations));
    }

    private static void writeToFile(Catalog catalog) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        writer.write(catalog.toString());
        writer.close();;
    }
}
