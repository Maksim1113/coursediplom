package ru.khaustov.coursediplom.contriollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.khaustov.coursediplom.entity.Work;
import ru.khaustov.coursediplom.repository.WorkRepository;

@Controller
public class WorkController {
    @Autowired
    private WorkRepository workRepository;


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

    /*@GetMapping("admin/addService")
    public String addServiceForm(Model model){
        return "admin/addService";
    }

    @PostMapping ("admin/addService")
    public String addService(@RequestParam String typeOfService,
                             @RequestParam String description, @RequestParam String duration,
                             @RequestParam Integer price_type, Model model){
        return "admin/addService";
    }*/


}
