package org.geektrust.amith.indexservice.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String title;
    private List<String> actors;
    private List<String> crew;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setActors(List<String> actors) {
        this.actors = actors;
    }
    public void setCrew(List<String> crew) {
        this.crew = crew;
    }
    public void addCrew(String c) {
        this.crew.add(c);
    }
    public void addActor(String a) {
        this.actors.add(a);
    }
    public Movie() {
        super();
        this.actors = new ArrayList<String>();
        this.crew = new ArrayList<String>();
    }
    public void setId(String id) {
        this.id = id;
    }
}
