package com.restpractice.restpractice.springInDepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringInDepthApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringInDepthApplication.class);
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringInDepthApplication.class, args);
        ContentBasedFilter filter = context.getBean("id1", ContentBasedFilter.class);
        Movie movie1 = filter.getMovie();
        Movie movie2 = filter.getMovie();
        Movie movie3 = filter.getMovie();
        logger.info("Movie object {}", movie1);
        logger.info("Movie object {}", movie2);
        logger.info("Movie object {}", movie3);
        logger.info("checking");
        Movie movie4 = context.getBean(Movie.class);
        Movie movie5 = context.getBean(Movie.class);
        Movie movie6 = context.getBean(Movie.class);
        logger.info("Movie object {}", movie4);
        logger.info("Movie object {}", movie5);
        logger.info("Movie object {}", movie6);
        logger.info(String.valueOf(context.containsBean("id2")));
    }
}
