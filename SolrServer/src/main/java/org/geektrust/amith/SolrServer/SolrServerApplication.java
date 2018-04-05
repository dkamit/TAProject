package org.geektrust.amith.SolrServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.geektrust.amith.SolrServer.models.Movie;
import org.geektrust.amith.SolrServer.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolrServerApplication implements CommandLineRunner {

    @Autowired
    private MoviesRepository moviesRepository;
    
    @Autowired
    private SolrClient client;

    public static void main(String[] args) {
        SpringApplication.run(SolrServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        moviesRepository.deleteAll();

        List<String> actors = new ArrayList<>();
        actors.add("amith");
        actors.add("vaishnavi");
        List<String> directors = new ArrayList<>();
        directors.add("amith1");
        directors.add("vaishnavi1");
        List<String> actors2 = new ArrayList<>();
        actors2.add("amith2");
        actors2.add("vaishnavi2");
        List<String> directors2 = new ArrayList<>();
        directors2.add("amith12");
        directors2.add("vaishnavi12");
        moviesRepository.saveAll(Arrays.asList(new Movie("1", "Movie1", actors, directors), 
                                            new Movie("2", "Movie2", actors2, directors2)));

        // Fetch all customers
        System.out.println("--------------------------------");
        System.out.println("Select all Movies:");
        System.out.println("--------------------------------");

        for (Movie movie : this.moviesRepository.findAll()) {
            System.out.println(movie);
        }

        System.out.println("--------------------------------");
        System.out.println("Find Customers that have names EndsWith m:");
        System.out.println("--------------------------------");

        for (Movie movie : this.moviesRepository.findByActorsInOrDirectorsIn("amith12", "amith1")) {
            System.out.println(movie);
        }
        
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setFields("actors","directors","title");
        query.setRequestHandler("select");
//        query.set("defType", "edismax");
        QueryResponse response = client.query("movies", query);
        for (int i = 0; i < response.getResults().size(); i++) {
            SolrDocument x = response.getResults().get(i);
            Object fieldValue = x.getFieldValue("title");
            System.out.println(fieldValue);
            System.out.println(x);
        }
        System.exit(0);
    }
}
