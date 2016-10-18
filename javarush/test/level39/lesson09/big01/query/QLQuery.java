package com.javarush.test.level39.lesson09.big01.query;

/**
 * Created by Alex on 18.10.2016.
 */

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}
