package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.History;
import com.infobell.one_stop.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History getHistoryById(int id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("History", "ID", id));
    }

    @Override
    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History updateHistory(int id, History history) {
        History existingHistory = getHistoryById(id);
        existingHistory.setProductName(history.getProductName());
        existingHistory.setProductImage(history.getProductImage());
        existingHistory.setProductPrice(history.getProductPrice());
        existingHistory.setTotalCost(history.getTotalCost());
        existingHistory.setOrderDate(history.getOrderDate());
        existingHistory.setOrder(history.getOrder());
        return historyRepository.save(existingHistory);
    }

    @Override
    public String deleteHistory(int id) {
        History history = getHistoryById(id);
        historyRepository.delete(history);
        return "History with ID " + id + " has been deleted.";
    }
}
