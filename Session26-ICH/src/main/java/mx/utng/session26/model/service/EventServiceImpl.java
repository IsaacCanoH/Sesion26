package mx.utng.session26.model.service;

import mx.utng.session26.model.dao.IEventDao;
import mx.utng.session26.model.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private IEventDao eventDao;

    @Transactional(readOnly = true)
    @Override
    public List<Event> list() {
        return eventDao.list();
    }

    @Transactional
    @Override
    public void save(Event event) {
        eventDao.save(event);
    }

    @Transactional(readOnly = true)
    @Override
    public Event getById(Long id) {
        return eventDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        eventDao.delete(id);
    }
}
