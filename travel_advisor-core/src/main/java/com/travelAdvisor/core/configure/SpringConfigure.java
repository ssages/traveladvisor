package com.travelAdvisor.core.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by myPc on 19/09/2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.travelAdvisor")
public class SpringConfigure {
}
