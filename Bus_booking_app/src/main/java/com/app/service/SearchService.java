package com.app.service;

import com.app.entities.Search;

import java.util.Date;
import java.util.List;

public interface SearchService {
    Search saveBus (Search search);

    List<Search> searchBusByPlace(String departure, String arrival, Date dateOfDeparture);
}
