package org.geektrust.amith.indexservice.resource;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.geektrust.amith.indexservice.models.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

@RestController
@RequestMapping("/rest/index")
public class IndexResource {

    @Value("${indexservice.csv}")
    private String csvFile;

    @GetMapping("/csv")
    public boolean getQuotes() throws IOException {
        String csvFileName = this.getClass().getClassLoader().getResource(csvFile).getFile();
        CSVReader reader = new CSVReader(new FileReader(csvFileName));
        String[] record = reader.readNext();

        while ((record = reader.readNext()) != null) {
            Movie movie = new Movie();
            movie.setId(record[0]);
            movie.setTitle(record[1]);
            ObjectMapper om = new ObjectMapper();
            
            ArrayList<HashMap<String, Object>> actorList = om.readValue(record[2], new TypeReference<ArrayList<HashMap<String, Object>>>(){});
            List<Object> collect = actorList.stream().map(obj -> obj.get("name")).collect(Collectors.toList());
            System.out.println(collect);
//            ArrayList<HashMap<String, Object>> crewList = om.readValue(record[2], new TypeReference<ArrayList<HashMap<String, Object>>>(){});
//            crewList.forEach(crew -> System.out.println(crew));
        }
        reader.close();
        return true;
    }
}
