package ru.khaustov.coursediplom.contriollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.khaustov.coursediplom.entity.Work;
import ru.khaustov.coursediplom.repository.WorkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WorkController {
    @Autowired
    private WorkRepository workRepository;

    @GetMapping("admin/showAllService")
    public String showAllService(Model model){
        Iterable<Work> works = workRepository.findAll();
        model.addAttribute("works", works);
        return "admin/showAllService";

    }

    @GetMapping("admin/{id}")
    public String serviceDetails(@PathVariable(value = "id") long id, Model model){
        if (!workRepository.existsById(id)){
            return "redirect:/admin/showAllService";
        }
        Optional<Work> work = workRepository.findById(id);
        List<Work> res = new ArrayList<>();
        work.ifPresent(res::add);
        model.addAttribute("work", res);
        return "admin/serviceDetails";
    }

    @GetMapping("admin/{id}/edit")
    public String serviceEdit(@PathVariable(value = "id") long id, Model model){
        if (!workRepository.existsById(id)){
            return "redirect:/admin/showAllService";
        }
        Optional<Work> work = workRepository.findById(id);
        List<Work> res = new ArrayList<>();
        work.ifPresent(res::add);
        model.addAttribute("work", res);
        return "admin/serviceEdit";
    }


    @GetMapping("admin/crudworks")
    public String workService(Model model){
        return "admin/crudworks";
    }


    @RequestMapping(value = "admin/addService", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("work", new Work());
        return "admin/addService";
    }


    @PostMapping("admin/addService")
    public String submitForm(@ModelAttribute Work work) {
        workRepository.save(work);
        return "redirect:/admin/addService";
    }

    @PostMapping("admin/{id}/edit")
    public String edditForm(@PathVariable(value = "id") long id, @RequestParam String typeOfService,
                            @RequestParam String description, @RequestParam String duration,
                            @RequestParam int price, Model model) {

        Work work = workRepository.findById(id).orElse(new Work());

        work.setTypeOfService(typeOfService);
        work.setDescription(description);
        work.setDuration(duration);
        work.setPrice(price);
        workRepository.save(work);
        return "redirect:/admin/{id}";
    }
    @PostMapping("admin/{id}/remove")
    public String deleteForm(@PathVariable(value = "id") long id, Model model) {

        Work work = workRepository.findById(id).orElse(new Work());
        workRepository.delete(work);
        return "redirect:/admin/showAllService";
    }




}
