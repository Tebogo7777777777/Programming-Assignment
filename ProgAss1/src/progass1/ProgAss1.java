package progass1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgAss1 {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    
    // Add a method to reset the list for testing
    public static void resetSeriesList() {
        seriesList = new ArrayList<>();
    }
    
    // Add a method to set scanner for testing
    public static void setScanner(Scanner testScanner) {
        scanner = testScanner;
    }
    
    // Add a method to restore original scanner
    public static void restoreScanner() {
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        System.out.println("Latest Series - 2025");
        System.out.println("*************************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");

        String input = scanner.nextLine();
        if ("1".equals(input)) {
            displayMainMenu();
        } else {
            System.out.println("Exiting the application...");
            System.exit(0);
        }
    }
    
    public static void displayMainMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report");
            System.out.println("(6) Exit the application");
            System.out.print("Please select what you would like to do: ");

            String input = scanner.nextLine();
            
            if (input.matches("[1-6]")) {
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        captureNewSeries();
                        break;
                    case 2:
                        searchSeries();
                        break;
                    case 3:
                        updateAgeRestriction();
                        break;
                    case 4:
                        deleteSeries();
                        break;
                    case 5:
                        printSeriesReport();
                        break;
                    case 6:
                        System.out.println("Exiting the application...");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please enter a number between 1-6.");
            }
        }
    }

    public static void captureNewSeries() {
        System.out.println("\n--- Capture New Series ---");

        System.out.print("Enter Series ID: ");
        String seriesId = scanner.nextLine();

        System.out.print("Enter Series Title: ");
        String seriesTitle = scanner.nextLine();

        System.out.print("Enter Series Episode: ");
        String seriesEpisodes = scanner.nextLine();

        int ageRestriction = 0;
        boolean validAge = false;

        while (!validAge) {
            System.out.print("Enter Age Restriction (2-18): ");
            String ageInput = scanner.nextLine();
            
            try {
                ageRestriction = Integer.parseInt(ageInput);
                if (ageRestriction >= 2 && ageRestriction <= 18) {
                    validAge = true;
                } else {
                    System.out.println("Please enter a number between 2 and 18");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter numbers only");
            }
        }

        SeriesModel newSeries = new SeriesModel();
        newSeries.setSeriesId(seriesId);
        newSeries.setTitle(seriesTitle);
        newSeries.setEpisodes(seriesEpisodes);
        newSeries.setAgeRestriction(ageRestriction);
        
        seriesList.add(newSeries);
        System.out.println("Series captured successfully!");
    }

    public static void searchSeries() {
        System.out.print("Enter the series id to search: ");
        String searchId = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(searchId)) {
                System.out.println("Series found:");
                System.out.println("ID: " + series.getSeriesId());
                System.out.println("Title: " + series.getTitle());
                System.out.println("Episodes: " + series.getEpisodes());
                System.out.println("Age Restriction: " + series.getAgeRestriction());
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series not found");
        }
    }

    public static void updateAgeRestriction() {
        System.out.print("Enter Series ID to update: ");
        String searchId = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(searchId)) {
                found = true;
                int newAge = 0;
                boolean validAge = false;
                
                while (!validAge) {
                    System.out.print("Enter new Age Restriction: ");
                    String ageInput = scanner.nextLine();
                    
                    try {
                        newAge = Integer.parseInt(ageInput);
                        if (newAge >= 2 && newAge <= 18) {
                            validAge = true;
                            series.setAgeRestriction(newAge);
                            System.out.println("Age restriction updated successfully!");
                        } else {
                            System.out.println("Please enter a number between 2 and 18");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter numbers only");
                    }
                }
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series not found!");
        }
    }

    public static void deleteSeries() {
        System.out.print("Enter Series ID to Delete: ");
        String searchId = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId().equals(searchId)) {
                seriesList.remove(i);
                System.out.println("Series deleted successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series not found!");
        }
    }

    public static void printSeriesReport() {
        System.out.println("\n--- Series Report 2025 ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        
        for (SeriesModel series : seriesList) {
            System.out.println("ID: " + series.getSeriesId() + " | Title: " + series.getTitle() + 
                             " | Episodes: " + series.getEpisodes() + " | Age: " + series.getAgeRestriction() + "+");
        }
    }
}