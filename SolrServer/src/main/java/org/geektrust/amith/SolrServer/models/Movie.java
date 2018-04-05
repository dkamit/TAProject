package org.geektrust.amith.SolrServer.models;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "movies")
public class Movie {
    @Id
    @Field
    private String id;

    @Field
    private String title;

    @Field
    private List<String> actors;

    @Field
    private List<String> directors;

    public Movie(String id, String title, List<String> actors, List<String> directors) {
        super();
        this.id = id;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }
    
    public Movie() {
        super();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actors == null) ? 0 : actors.hashCode());
        result = prime * result + ((directors == null) ? 0 : directors.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (actors == null) {
            if (other.actors != null)
                return false;
        } else if (!actors.equals(other.actors))
            return false;
        if (directors == null) {
            if (other.directors != null)
                return false;
        } else if (!directors.equals(other.directors))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", actors=" + actors + ", directors=" + directors + "]";
    }

}
