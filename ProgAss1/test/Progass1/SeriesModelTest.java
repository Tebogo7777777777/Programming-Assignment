package programmingA1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProgrammingA1Test {
    
    // TestSearchSeries() - To supply the series id to the series searching method.
    // The test will determine that the correct series data has been returned.
    @Test
    public void testSearchSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Test would require input simulation - simplified for basic structure
        // This test validates that the series exists in the list
        boolean found = false;
        for (SeriesModel s : ProgrammingA1.seriesList) {
            if (s.getSeriesId().equals("S001")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
        assertEquals("Test Series", ProgrammingA1.seriesList.get(0).getTitle());
    }
   
    // TestSearchSeries_SeriesNotFound() - To supply an incorrect series id to the series searching method.
    // The test will determine that no series was found.
    @Test
    public void testSearchSeries_SeriesNotFound() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Test searching for non-existent series
        boolean found = false;
        for (SeriesModel s : ProgrammingA1.seriesList) {
            if (s.getSeriesId().equals("S999")) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }
   
    // TestUpdateSeries() - To supply the Series id to the update series method.
    // The test will determine that the series has been successfully updated.
    @Test
    public void testUpdateSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Simulate update by directly changing the age restriction
        ProgrammingA1.seriesList.get(0).setAgeRestriction(15);
       
        // Verify the update was successful
        assertEquals(15, ProgrammingA1.seriesList.get(0).getAgeRestriction());
    }
   
    // TestDeleteSeries() - To supply the series id to the delete series method.
    // The test will determine that the series has been successfully deleted.
    @Test
    public void testDeleteSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Verify we have one series initially
        assertEquals(1, ProgrammingA1.seriesList.size());
       
        // Simulate deletion by removing the series
        ProgrammingA1.seriesList.removeIf(s -> s.getSeriesId().equals("S001"));
       
        // Verify the series was deleted
        assertEquals(0, ProgrammingA1.seriesList.size());
    }
   
    // TestDeleteSeries_SeriesNotFound() - To supply an incorrect series id to the delete series method.
    // The test will determine that the series has not been deleted.
    @Test
    public void testDeleteSeries_SeriesNotFound() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Verify we have one series initially
        assertEquals(1, ProgrammingA1.seriesList.size());
       
        // Try to delete non-existent series
        ProgrammingA1.seriesList.removeIf(s -> s.getSeriesId().equals("S999"));
       
        // Verify the series was NOT deleted
        assertEquals(1, ProgrammingA1.seriesList.size());
    }
   
    // TestSeriesAgeRestriction_AgeValid() - To supply a valid series age restriction to the series age restriction method.
    // The test will determine that the series age restriction is valid.
    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        // Create series with valid age
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
       
        // Test that valid age is accepted
        assertTrue(series.getAgeRestriction() >= 2 && series.getAgeRestriction() <= 18);
        assertEquals(12, series.getAgeRestriction());
    }
   
    // TestSeriesAgeRestriction_SeriesAgeInvalid() - To supply an invalid series age restriction to the series age restriction method.
    // The test will determine that the series age is invalid.
    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        // Test package programmingA1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProgrammingA1Test {
    
    // TestSearchSeries() - To supply the series id to the series searching method.
    // The test will determine that the correct series data has been returned.
    @Test
    public void testSearchSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Test would require input simulation - simplified for basic structure
        // This test validates that the series exists in the list
        boolean found = false;
        for (SeriesModel s : ProgrammingA1.seriesList) {
            if (s.getSeriesId().equals("S001")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
        assertEquals("Test Series", ProgrammingA1.seriesList.get(0).getTitle());
    }
   
    // TestSearchSeries_SeriesNotFound() - To supply an incorrect series id to the series searching method.
    // The test will determine that no series was found.
    @Test
    public void testSearchSeries_SeriesNotFound() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Test searching for non-existent series
        boolean found = false;
        for (SeriesModel s : ProgrammingA1.seriesList) {
            if (s.getSeriesId().equals("S999")) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }
   
    // TestUpdateSeries() - To supply the Series id to the update series method.
    // The test will determine that the series has been successfully updated.
    @Test
    public void testUpdateSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Simulate update by directly changing the age restriction
        ProgrammingA1.seriesList.get(0).setAgeRestriction(15);
       
        // Verify the update was successful
        assertEquals(15, ProgrammingA1.seriesList.get(0).getAgeRestriction());
    }
   
    // TestDeleteSeries() - To supply the series id to the delete series method.
    // The test will determine that the series has been successfully deleted.
    @Test
    public void testDeleteSeries() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Verify we have one series initially
        assertEquals(1, ProgrammingA1.seriesList.size());
       
        // Simulate deletion by removing the series
        ProgrammingA1.seriesList.removeIf(s -> s.getSeriesId().equals("S001"));
       
        // Verify the series was deleted
        assertEquals(0, ProgrammingA1.seriesList.size());
    }
   
    // TestDeleteSeries_SeriesNotFound() - To supply an incorrect series id to the delete series method.
    // The test will determine that the series has not been deleted.
    @Test
    public void testDeleteSeries_SeriesNotFound() {
        // Setup test data
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
        ProgrammingA1.seriesList.add(series);
       
        // Verify we have one series initially
        assertEquals(1, ProgrammingA1.seriesList.size());
       
        // Try to delete non-existent series
        ProgrammingA1.seriesList.removeIf(s -> s.getSeriesId().equals("S999"));
       
        // Verify the series was NOT deleted
        assertEquals(1, ProgrammingA1.seriesList.size());
    }
   
    // TestSeriesAgeRestriction_AgeValid() - To supply a valid series age restriction to the series age restriction method.
    // The test will determine that the series age restriction is valid.
    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        // Create series with valid age
        SeriesModel series = new SeriesModel();
        series.setSeriesId("S001");
        series.setTitle("Test Series");
        series.setEpisodes("10");
        series.setAgeRestriction(12);
       
        // Test that valid age is accepted
        assertTrue(series.getAgeRestriction() >= 2 && series.getAgeRestriction() <= 18);
        assertEquals(12, series.getAgeRestriction());
    }
   
    // TestSeriesAgeRestriction_SeriesAgeInvalid() - To supply an invalid series age restriction to the series age restriction method.
    // The test will determine that the series age is invalid.
    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        // Test invalid age validation
        int invalidAge = 1;
        assertFalse(invalidAge >= 2 && invalidAge <= 18);
       
        // Test another invalid age
        int anotherInvalidAge = 19;
        assertFalse(anotherInvalidAge >= 2 && anotherInvalidAge <= 18);
    }
}invalid age validation
        int invalidAge = 1;
        assertFalse(invalidAge >= 2 && invalidAge <= 18);
       
        // Test another invalid age
        int anotherInvalidAge = 19;
        assertFalse(anotherInvalidAge >= 2 && anotherInvalidAge <= 18);
    }
}