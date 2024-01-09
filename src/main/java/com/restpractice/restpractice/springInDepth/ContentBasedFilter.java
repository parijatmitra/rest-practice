package com.restpractice.restpractice.springInDepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("id1")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ContentBasedFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Movie movie;
    private static int instances = 0;
    public ContentBasedFilter() {
        instances++;
        logger.info("Constructor ContentBasedFilter");
    }


    public static int getInstances() {
        return instances;
    }

    @Lookup
    public Movie getMovie() {
        return movie;
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
