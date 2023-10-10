package ru.sadykoff.mod2.app.services;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(String bookIdToRemove);

    boolean removeItemByRegex(String queryRegex);
}
