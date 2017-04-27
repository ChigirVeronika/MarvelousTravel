package by.bsuir.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ANNController {



    @RequestMapping(value = {"/model-retrain"}, method = RequestMethod.GET)
    public String retrainModel(ModelMap model){
        /*
        1)заново собрать файл(пока что добавлять к существующему)-дата
        2)построить нейронную сеть
        3)обучить ее и сохранить результаты в файл-дата
        4)по этим результатам обновить группу каждого юзера
        */

        model.addAttribute("message", "Model has been successfully retrained.");
        return "message";
    }
}
