package org.geektrust.amith.SolrServer.repo;

import java.util.List;

import org.geektrust.amith.SolrServer.models.Movie;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface MoviesRepository extends SolrCrudRepository<Movie, String> {
    
    public List<Movie> findByActorsIn(String actor);

    public List<Movie> findByActorsInOrDirectorsIn(String string, String string2);
    
}
