package com.app.controller;

import com.app.entities.Search;
import com.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    //http://localhost:8080/api/search/save
    @PostMapping("/save")
    public ResponseEntity<Search>  saveBus(@RequestBody Search search){
       Search savedBus= searchService.saveBus(search);
       return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/search/searchByPlace
    @GetMapping("/searchByPlace")
    public ResponseEntity<List<Search>> searchBus(@RequestParam("departure") String departure, @RequestParam("arrival") String arrival,@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture){
     List<Search> searchList =searchService.searchBusByPlace(departure,arrival,dateOfDeparture);
     return new ResponseEntity<>(searchList,HttpStatus.OK);
    }
}
