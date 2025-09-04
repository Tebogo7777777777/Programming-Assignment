package progass1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ProgAss1Test {
    
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private Scanner testScanner;
    
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        ProgAss1.resetSeriesList();
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        ProgAss1.restoreScanner();
        if (testScanner != null) {
            testScanner.close();
        }
    }
    
    private void setTestInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        testScanner = new Scanner(System.in);
        ProgAss1.setScanner(testScanner);
    }
    
    @Test
    public void testCaptureNewSeries() {
        // Prepare test input
        setTestInput("S001\nTest Series\n10\n12\n");
        
        // Call the method
        ProgAss1.captureNewSeries();
        
        // Verify results
        assertEquals(1, ProgAss1.seriesList.size(), "Should have one series in list");
        SeriesModel series = ProgAss1.seriesList.get(0);
        assertEquals("S001", series.getSeriesId(), "Series ID should match");
        assertEquals("Test Series", series.getTitle(), "Series title should match");
        assertEquals("10", series.getEpisodes(), "Series episodes should match");
        assertEquals(12, series.getAgeRestriction(), "Age restriction should match");
        
        // Verify success message
        String output = outputStream.toString();
        assertTrue(output.contains("Series captured successfully!"), "Should show success message");
    }
    
    @Test
    public void testSearchSeriesFound() {
        // Add a test series directly to the list
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgAss1.seriesList.add(series);
        
        // Prepare test input
        setTestInput("S001\n");
        
        // Call the method
        ProgAss1.searchSeries();
        
        // Verify output contains expected text
        String output = outputStream.toString();
        assertTrue(output.contains("Series found:"), "Output should contain 'Series found:'");
        assertTrue(output.contains("ID: S001"), "Output should contain series ID");
        assertTrue(output.contains("Title: Test Series"), "Output should contain series title");
    }
    
    @Test
    public void testSearchSeriesNotFound() {
        // Prepare test input for non-existent series
        setTestInput("NON_EXISTENT\n");
        
        // Call the method
        ProgAss1.searchSeries();
        
        // Verify output contains "not found" message
        String output = outputStream.toString();
        assertTrue(output.contains("Series not found"), "Output should contain 'Series not found'");
    }
    
    @Test
    public void testUpdateAgeRestriction() {
        // Add a test series
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgAss1.seriesList.add(series);
        
        // Prepare test input
        setTestInput("S001\n15\n");
        
        // Call the method
        ProgAss1.updateAgeRestriction();
        
        // Verify the age was updated
        assertEquals(15, ProgAss1.seriesList.get(0).getAgeRestriction(), "Age restriction should be updated to 15");
        
        // Verify success message
        String output = outputStream.toString();
        assertTrue(output.contains("Age restriction updated successfully!"), "Output should contain success message");
    }
    
    @Test
    public void testUpdateAgeRestrictionSeriesNotFound() {
        // Prepare test input for non-existent series
        setTestInput("NON_EXISTENT\n");
        
        // Call the method
        ProgAss1.updateAgeRestriction();
        
        // Verify error message
        String output = outputStream.toString();
        assertTrue(output.contains("Series not found!"), "Output should contain 'Series not found!'");
    }
    
    @Test
    public void testDeleteSeries() {
        // Add a test series
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgAss1.seriesList.add(series);
        
        // Prepare test input
        setTestInput("S001\n");
        
        // Call the method
        ProgAss1.deleteSeries();
        
        // Verify the series was deleted
        assertEquals(0, ProgAss1.seriesList.size(), "Series list should be empty after deletion");
        
        // Verify success message
        String output = outputStream.toString();
        assertTrue(output.contains("Series deleted successfully!"), "Output should contain success message");
    }
    
    @Test
    public void testDeleteSeries_SeriesNotFound() {
        // Prepare test input for non-existent series
        setTestInput("NON_EXISTENT\n");
        
        // Call the method
        ProgAss1.deleteSeries();
        
        // Verify output contains "not found" message
        String output = outputStream.toString();
        assertTrue(output.contains("Series not found!"), "Output should contain 'Series not found!'");
    }
    
    @Test
    public void testPrintSeriesReportEmpty() {
        // Ensure list is empty
        ProgAss1.resetSeriesList();
        
        // Call the method
        ProgAss1.printSeriesReport();
        
        // Verify output for empty list
        String output = outputStream.toString();
        assertTrue(output.contains("No series available."), "Output should show no series available");
    }
    
    @Test
    public void testPrintSeriesReportWithData() {
        // Add test series
        SeriesModel series1 = new SeriesModel();
        series1.setSeriesId("S001");
        series1.setTitle("Series One");
        series1.setEpisodes("10");
        series1.setAgeRestriction(12);
        ProgAss1.seriesList.add(series1);
        
        // Call the method
        ProgAss1.printSeriesReport();
        
        // Verify output contains series data
        String output = outputStream.toString();
        assertTrue(output.contains("Series Report 2025"), "Output should contain report header");
        assertTrue(output.contains("ID: S001"), "Output should contain series ID");
        assertTrue(output.contains("Title: Series One"), "Output should contain series title");
    }
}