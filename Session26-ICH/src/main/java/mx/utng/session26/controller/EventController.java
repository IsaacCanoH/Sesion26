package mx.utng.session26.controller;

import mx.utng.session26.model.entity.Event;
import mx.utng.session26.model.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private IEventService eventService;

    @GetMapping("/list")
    public String listEvents(Model model) {
        List<Event> events = eventService.list();
        model.addAttribute("events", events);
        model.addAttribute("title", "Lista de Eventos");
        return "event-list";
    }

    @GetMapping("/create")
    public String createEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("title", "Crear Evento");
        return "event-form";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.save(event);
        return "redirect:/event/list";
    }

    @GetMapping("/edit/{id}")
    public String editEventForm(@PathVariable Long id, Model model) {
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        model.addAttribute("title", "Editar Evento");
        return "event-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/event/list";
    }
}

