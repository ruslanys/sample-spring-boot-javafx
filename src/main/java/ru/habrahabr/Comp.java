package ru.habrahabr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Date: 27.08.15
 * Time: 11:36
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
@Component
public class Comp {

    private Logger logger = LoggerFactory.getLogger(Comp.class);

    public void test() {
        logger.info("HELLO!");
    }

}
