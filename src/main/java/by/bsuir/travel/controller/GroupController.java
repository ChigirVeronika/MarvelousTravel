package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.service.GroupService;
import by.bsuir.travel.util.GroupN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = {"/group-list"}, method = RequestMethod.GET)
    public String showGroupListPage(ModelMap model) {
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "group-list";
    }

    @RequestMapping(value = {"/group-{id}"}, method = RequestMethod.GET)
    public String findGroupByIdAndShow(@PathVariable Integer id, ModelMap model) {

        Group group = groupService.find(id);
        model.addAttribute("group", group);
        return "group";
    }

    //creating
    @RequestMapping(value = {"/group-create"}, method = RequestMethod.GET)
    public String showGroupCreatePage(ModelMap model) {
        GroupN group = new GroupN();
        model.addAttribute("group", group);
        return "group-create";
    }

    //TODO!!!ПЕРЕПИСАТЬ! смысл групп теряется, если не создавать их с параметрами
    @RequestMapping(value = {"/group-create"}, method = RequestMethod.POST)
    public String createGroup(@Valid Group group, ModelMap model, BindingResult result) {
        groupService.save(group);
        return "redirect:/group-list";
    }

    //updating
    @RequestMapping(value = {"/group-edit-{id}"}, method = RequestMethod.GET)
    public String showGroupEditPage(@PathVariable Integer id, ModelMap model) {
        Group group = groupService.find(id);
        model.addAttribute("group", group);
        return "group-create";
    }

    @RequestMapping(value = {"/group-edit-{id}"}, method = RequestMethod.POST)
    public String updateGroup(@Valid Group group, ModelMap model,
                              BindingResult result, @PathVariable Integer id) {
        groupService.update(group);
        
        return "redirect:/group-list";
    }

    //deleting
    @RequestMapping(value = {"/group-delete-{id}"}, method = RequestMethod.GET)
    public String deleteGroup(@PathVariable Integer id) {
        groupService.delete(id);
        return "redirect:/group-list";
    }
}
