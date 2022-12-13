package com.andro.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article {
    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Expose
    @SerializedName("results")
    private List<Results> results;
    @Expose
    @SerializedName("next")
    private String next;
    @Expose
    @SerializedName("count")
    private int count;

    public static class Results {
        @Expose
        @SerializedName("first_flight")
        private String first_flight;
        @Expose
        @SerializedName("last_flight")
        private String last_flight;
        @Expose
        @SerializedName("profile_image_thumbnail")
        private String profile_image_thumbnail;
        @Expose
        @SerializedName("profile_image")
        private String profile_image;
        @Expose
        @SerializedName("agency")
        private Agency agency;
        @Expose
        @SerializedName("wiki")
        private String wiki;
        @Expose
        @SerializedName("twitter")
        private String twitter;
        @Expose
        @SerializedName("bio")
        private String bio;
        @Expose
        @SerializedName("nationality")
        private String nationality;
        @Expose
        @SerializedName("date_of_death")
        private String date_of_death;
        @Expose
        @SerializedName("date_of_birth")
        private String date_of_birth;
        @Expose
        @SerializedName("type")
        private Type type;
        @Expose
        @SerializedName("status")
        private Status status;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("id")
        private int id;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(String date_of_birth) {
            this.date_of_birth = date_of_birth;
        }

        public Agency getAgency() {
            return agency;
        }

        public void setAgency(Agency agency) {
            this.agency = agency;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }
    }

    public static class Agency {
        @Expose
        @SerializedName("image_url")
        private String image_url;
        @Expose
        @SerializedName("spacecraft")
        private String spacecraft;
        @Expose
        @SerializedName("launchers")
        private String launchers;
        @Expose
        @SerializedName("founding_year")
        private String founding_year;
        @Expose
        @SerializedName("administrator")
        private String administrator;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("abbrev")
        private String abbrev;
        @Expose
        @SerializedName("country_code")
        private String country_code;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("featured")
        private boolean featured;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("id")
        private int id;

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }

    public static class Type {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
    }

    public static class Status {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
    }
}
