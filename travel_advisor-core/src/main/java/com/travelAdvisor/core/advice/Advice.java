package com.travelAdvisor.core.advice;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface Advice<T> {

    boolean calculate(T travelInformation);
}
