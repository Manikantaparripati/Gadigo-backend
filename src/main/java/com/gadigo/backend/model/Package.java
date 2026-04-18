package com.gadigo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "packages")
public class Package {

    @Id
    private String id;
    
    private String title;
    private String description;
    private Double price;
    private Integer durationDays;
    private List<ItineraryDay> itinerary;
    private List<String> images;
    private LocalDateTime createdAt;

    public Package() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getDurationDays() { return durationDays; }
    public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }

    public List<ItineraryDay> getItinerary() { return itinerary; }
    public void setItinerary(List<ItineraryDay> itinerary) { this.itinerary = itinerary; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public static class ItineraryDay {
        private Integer day;
        private List<String> activities;

        public ItineraryDay() {}
        public ItineraryDay(Integer day, List<String> activities) {
            this.day = day;
            this.activities = activities;
        }

        public Integer getDay() { return day; }
        public void setDay(Integer day) { this.day = day; }

        public List<String> getActivities() { return activities; }
        public void setActivities(List<String> activities) { this.activities = activities; }
    }
}
