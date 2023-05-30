package com.infobell.one_stop.controller;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.History;
import com.infobell.one_stop.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/{id}")
    public History getHistoryById(@PathVariable int id) {
        try {
            return historyService.getHistoryById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("History", "id", id);
        }
    }

    @PostMapping("/create")
    public History createHistory(@RequestBody History history) {
        return historyService.createHistory(history);
    }

    @PutMapping("/{id}")
    public History updateHistory(@PathVariable int id, @RequestBody History history) {
        try {
            return historyService.updateHistory(id, history);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("History", "id", id);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable int id) {
        try {
            return historyService.deleteHistory(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("History", "id", id);
        }
    }
}
