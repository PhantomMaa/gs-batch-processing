package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchProcessingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
    }

    @Autowired
    Job importUserJob;

    @Autowired
    TaskExecutorJobLauncher jobLauncher;

    @Override
    public void run(String... args) throws Exception {
        JobParameters parameters = new JobParametersBuilder().toJobParameters();
        jobLauncher.run(importUserJob, parameters);
    }
}
