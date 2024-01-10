package pl.foodrating;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private static final String DEFAULT_DATA_FILE = "src/main/resources/sample_data.txt";

    public static List<FoodOutlet> loadSampleData(String filePath) {
        List<FoodOutlet> foodOutlets = new ArrayList<>();

        try {
            InputStream inputStream = DataService.class.getClassLoader().getResourceAsStream(filePath);
            if (inputStream == null) {
                System.out.println("File not found. Loading default data from " + DEFAULT_DATA_FILE);
                filePath = DEFAULT_DATA_FILE;
                inputStream = DataService.class.getClassLoader().getResourceAsStream(filePath);
            }

            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);

                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String address = parts[1].trim();
                    String cuisineType = parts[2].trim();
                    String openingHours = parts[3].trim();
                    FoodOutlet outlet = new FoodOutlet(name, address, cuisineType, openingHours);
                    System.out.println(name + address);
                    foodOutlets.add(outlet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foodOutlets;
    }

    public static void saveSampleData(List<FoodOutlet> foodOutlets, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + filePath))) {
            for (FoodOutlet outlet : foodOutlets) {
                writer.write(outlet.getName() + "," + outlet.getAddress() + "," +
                        outlet.getCuisineType() + "," + outlet.getOpeningHours());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
