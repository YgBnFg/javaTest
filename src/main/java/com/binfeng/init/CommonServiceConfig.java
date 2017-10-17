package com.binfeng.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Created by bfyang on 2017/10/17.
 */
@Configuration
public class CommonServiceConfig {
    @Bean
    public Clock provideClock() {
        return Clock.systemUTC();
    }
}
