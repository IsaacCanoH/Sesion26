package mx.utng.session26.controller;

import mx.utng.session26.model.entity.Teacher;
import mx.utng.session26.model.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/list")
    public String listTeachers(Model model) {
        List<Teacher> teachers = teacherService.list();
        model.addAttribute("teachers", teachers);
        model.addAttribute("title", "Lista de Profesores");
        return "teacher-list";
    }

    @GetMapping("/form")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("title", "Crear Profesor");
        return "teacher-form";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        model.addAttribute("teacher", teacher);
        model.addAttribute("title", "Editar Profesor");
        return "teacher-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
        return "redirect:/teacher/list";
    }
}

