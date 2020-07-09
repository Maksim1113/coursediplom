package ru.khaustov.coursediplom.contriollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.khaustov.coursediplom.repository.WorkRepository;

@Controller
public class WorkController {
    @Autowired
    private WorkRepository workRepository;


    @GetMapping("admin/crudworks")
    public String workService(Model model){
        return "admin/crudworks";
    }

    @GetMapping("admin/addService")
    public String addService(Model model){
        return "admin/addService";
    }


}
