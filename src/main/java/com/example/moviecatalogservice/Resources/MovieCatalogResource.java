package com.example.moviecatalogservice.Resources;

import com.example.moviecatalogservice.Models.CatalogItem;
import com.example.moviecatalogservice.Models.Movies;
import com.example.moviecatalogservice.Models.Rating;
import com.example.moviecatalogservice.Models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    WebClient.Builder webClientBuilder;



    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){

        UserRating ratings=restTemplate.getForObject("http://RATING-DATA-SERVICE/rating/users/"+userId, UserRating.class);
        return ratings.getRatings().stream().map(rating -> {
            //Sync call
            Movies mov=restTemplate.getForObject("http://movies-info-service/movies/"+rating.getMovieId(),Movies.class);

            // webclient is for Async call
//            Movies mov=webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movies.class)
//                    .block(); // but here we make it sync...basically wait for call to complete
            return new CatalogItem(mov.getName(),mov.getDesc(),rating.getRating());
        }).collect(Collectors.toList());
//        return Collections.singletonList(new CatalogItem("Transformers","Test",4));
    }
}
