package com.app.service.impl;

import com.app.entities.Search;
import com.app.repository.SearchRepository;
import com.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchRepository searchRepository;
    @Override
    public Search saveBus(Search search) {
        Search savedBus = searchRepository.save(search);
        return savedBus;
    }

    @Override
    public List<Search> searchBusByPlace(String departure, String arrival , Date dateOfDeparture) {
        List<Search> searchList = searchRepository.searchByPlace(departure, arrival,dateOfDeparture);
        return searchList;
    }
}
