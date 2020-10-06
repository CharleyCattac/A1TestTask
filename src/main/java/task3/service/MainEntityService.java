package task3.service;

import task3.entity.MainEntity;

import java.util.List;
import java.util.Optional;

public interface MainEntityService<T extends MainEntity, K> {

    Optional<T> findById(K id);
    T save(T entity);
    List<T> saveAll(List<T> entities);
    List<T> findAll();
    void deleteAll();
}
