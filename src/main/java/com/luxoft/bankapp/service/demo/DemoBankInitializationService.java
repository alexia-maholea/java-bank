package com.luxoft.bankapp.service.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.io.File;

import com.luxoft.bankapp.service.feed.BankFeedService;

@Service
@Profile("dev")
public class DemoBankInitializationService implements BankInitializationService
{
    private static final String DEMO_FEED_FILE_NAME = "demo.feed";

    @Value("${feed.filename}")
    private String fileName;

    @Autowired 
    private BankFeedService feedService;
    
    @Override
    @PostConstruct 
    public void createClientsForDemo()
    {
        if (fileName == null) {
            fileName = DEMO_FEED_FILE_NAME;
        }
        feedService.loadFeed(new File(fileName));
    }
}
