package progass1;

public class SeriesModel {
    private String seriesId;
    private String title;
    private String episodes;
    private int ageRestriction;
    
    // Getters
    public String getSeriesId() {
        return seriesId;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisodes() {
        return episodes;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }
    
    // Setters
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}