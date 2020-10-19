package com.sunday;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
    }
}
