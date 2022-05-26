package com.example.springpractice.accessory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccessoryController {

    @Autowired AccessoryService accessoryService;

    // display list of accessories
    @GetMapping("/viewAccessoryPage")
    public String viewAccessoryPage(Model model){
        model.addAttribute("listOfAccessories", accessoryService.getAllAccessories());
        return "admin/accessory/accessoryPage";
    }

    // add new accessory
    @GetMapping("/showNewAccessoryForm")
    public String showNewAccessoryForm(Model model){
        Accessory accessory = new Accessory();
        model.addAttribute("accessory", accessory);
        return "admin/accessory/newAccessory";
    }

    @PostMapping("/saveAccessory")
        public String saveAccessory(@ModelAttribute("accessory") Accessory accessory){
            accessoryService.saveAccessory(accessory);
            return "redirect:viewAccessoryPage";
    }

    @GetMapping("/showAccessoryUpdateForm/{id}")
    public String showAccessoryUpdateForm(@PathVariable(value = "id") int id, Model model){
        Accessory accessory = accessoryService.getAccessoryById(id);
        model.addAttribute("accessory", accessory);
        return "admin/accessory/updateAccessory";
    }

    @GetMapping("/deleteAccessory/{id}")
    public String deleteAccessory(@PathVariable(value = "id") int id) {
        this.accessoryService.deleteAccessoryById(id);
        return "redirect:/viewAccessoryPage";
    }
}