package com.restpractice.restpractice.springInDepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("id2")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public CollaborativeFilter() {
        logger.info("Constructor CollaborativeFilter");
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
