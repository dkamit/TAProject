package org.geektrust.amith.indexservice.resource;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {
    
    @GetMapping("/csv")
    public boolean getQuotes() throws IOException {
        return false;
        
    }
}
