package com.stackroute.muzix;

import com.stackroute.muzix.dao.TrackDao;
import com.stackroute.muzix.model.Track;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MuzixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuzixApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TrackDao trackDao) {
        return args -> {
            trackDao.save(new Track(6, 2013, "Baarish", "Mohammed Irfan", "Romance", "Yaariyan", "hindi"));
            trackDao.save(new Track(3, 2019, "Vaaste", "Dhwani Bhanushali", "Romance", "Vaaste", "hindi"));
            trackDao.save(new Track(3, 2015, "Lean On", "Major Lazor", "Slow Rock", "Lean On", "english"));
            trackDao.save(new Track(4, 2018, "Pal", "Shreya Ghosal", "Romance", "Jalebi", "hindi"));
            trackDao.save(new Track(3, 2018, "Dilbar", "Neha Kakkar", "Dance", "Satyameva Jayate", "hindi"));
            trackDao.save(new Track(3, 2016, "Cold Water", "Justin Bieber", "Ballad", "Major Lazer Essentials", "english"));



        };
    }

}
