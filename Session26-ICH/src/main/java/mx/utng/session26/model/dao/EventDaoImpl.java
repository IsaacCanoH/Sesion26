package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Event;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EventDaoImpl implements IEventDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Event> list() {
        return entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList();
    }

    @Override
    public void save(Event event) {
        if (event.getId() != null && event.getId() > 0) {
            entityManager.merge(event);
        } else {
            entityManager.persist(event);
        }
    }

    @Override
    public Event getById(Long id) {
        return entityManager.find(Event.class, id);
    }

    @Override
    public void delete(Long id) {
        Event event = getById(id);
        entityManager.remove(event);
    }
}
