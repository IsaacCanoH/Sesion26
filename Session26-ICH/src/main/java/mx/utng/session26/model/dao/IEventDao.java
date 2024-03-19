package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Event;

import java.util.List;

public interface IEventDao {
    List<Event> list();
    void save(Event event);
    Event getById(Long id);
    void delete(Long id);
}
