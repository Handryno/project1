package com.example.project1.config;

import org.springframework.context.annotation.Bean;

public class SampleConfiguration {

    @Bean
    public SampleDecoder decoder(){return new SampleDecoder();}

    @Bean
    public SampleInterceptor interceptor(){return new SampleInterceptor();}
}
