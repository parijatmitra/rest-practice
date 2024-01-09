package com.restpractice.restpractice.springInDepth;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Movie {

    private Logger logger = LoggerFactory.getLogger(Movie.class);
    private static int instances = 0;
    private int id;
    private String name;
    private String genre;
    private String producer;

    public static int getInstances() {
        return instances;
    }

    public Movie() {
        instances++;
        logger.info("Constructor Movie");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("Movie Post constructor");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Movie Pre Destroy");
    }

//    @Override
//    public String toString() {
//        return "Movie{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", genre='" + genre + '\'' +
//                ", producer='" + producer + '\'' +
//
//                '}';
//    }
}
