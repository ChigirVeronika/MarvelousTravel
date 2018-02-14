package by.bsuir.travel.controller;

import by.bsuir.travel.dto.GroupDto;
import by.bsuir.travel.entity.News;
import by.bsuir.travel.service.GroupService;
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

    @RequestMapping(value = {"/group/list"}, method = RequestMethod.GET)
    public String showGroupListPage(ModelMap model) {
        List<GroupDto> groups = groupService.findAllDtos();
        model.addAttribute("groups", groups);
        return "group-list";
    }

    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.GET)//todo use
    public String findGroupByIdAndShow(@PathVariable Integer id, ModelMap model) {

        GroupDto group = groupService.find(id);
        model.addAttribute("group", group);
        return "group";
    }

    @RequestMapping(value = {"/group/create"}, method = RequestMethod.GET)
    public String showGroupCreatePage(ModelMap model) {
        GroupDto groupDto = new GroupDto();
        model.addAttribute("groupDto", groupDto);
        return "group-create";
    }

    @RequestMapping(value = {"/group/create"}, method = RequestMethod.POST)
    public String createGroup(@Valid GroupDto group, ModelMap model, BindingResult result) {
        groupService.save(group);
        return "redirect:/group/list";
    }

    @RequestMapping(value = {"/group/edit/{id}"}, method = RequestMethod.GET)//todo use
    public String showGroupEditPage(@PathVariable Integer id, ModelMap model) {
        GroupDto group = groupService.find(id);
        model.addAttribute("group", group);
        return "group-create";
    }

    @RequestMapping(value = {"/group/edit/{id}"}, method = RequestMethod.POST)//todo use
    public String updateGroup(@Valid GroupDto group, ModelMap model,
                              BindingResult result, @PathVariable Integer id) {
        groupService.update(group);
        return "redirect:/group/list";
    }

    @RequestMapping(value = {"/group/delete/{name}"}, method = RequestMethod.GET)
    public String deleteGroup(@PathVariable String name) {
        groupService.delete(name);
        return "redirect:/group/list";
    }
}
