package org.geektrust.amith.SolrServer.config;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "org.geektrust.amith.SolrServer.repo" })
public class SolrContext {

    private static final String SOLR_HOST = "spring.data.solr.host";

    @Resource
    private Environment env;

    @Bean
    public SolrClient solrClient() {
        String solrHost = env.getRequiredProperty(SOLR_HOST);
        return new HttpSolrClient.Builder(solrHost).build();
    }
}
