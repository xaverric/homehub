package cz.homehub.service.api;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CrudService<T> {

    List<T> getAll();
    T getById(Long id) throws EntityNotFoundException;
    T insert(T entity);
    T update(T entity) throws EntityNotFoundException;
    T delete(T entity) throws EntityNotFoundException;
}
