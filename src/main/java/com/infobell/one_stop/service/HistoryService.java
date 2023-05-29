package com.infobell.one_stop.service;

import com.infobell.one_stop.model.History;

public interface HistoryService {

    /**
     * Retrieves a history entry by its ID.
     *
     * @param id The ID of the history entry.
     * @return The history entry.
     */
    History getHistoryById(int id);

    /**
     * Creates a new history entry.
     *
     * @param history The history entry to create.
     * @return The created history entry.
     */
    History createHistory(History history);

    /**
     * Updates an existing history entry.
     *
     * @param id      The ID of the history entry to update.
     * @param history The updated history entry.
     * @return The updated history entry.
     */
    History updateHistory(int id, History history);

    /**
     * Deletes a history entry by its ID.
     *
     * @param id The ID of the history entry to delete.
     * @return A message indicating the deletion.
     */
    String deleteHistory(int id);
}
