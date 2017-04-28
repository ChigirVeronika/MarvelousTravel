package by.bsuir.travel.controller;

import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.UserService;
import com.googlecode.fannj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class ANNController {

    @Autowired
    private ANNService annService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/model-retrain"}, method = RequestMethod.GET)
    public String retrainModel(ModelMap model) {
        //1)заново собрать файл(пока что добавлять к существующему)-дата
        String trainFileName = annService.createFile();

        //2)построить нейронную сеть
        //3)обучить ее и сохранить результаты в файл-дата
        Fann fann = annService.buildANN(trainFileName);

        //4)по этим результатам обновить группу каждого юзера
        List<User> users = userService.findAll();
        for (User u : users) {
            float age = u.getBithday()
        }


        ///
        model.addAttribute("message", "Model has been successfully retrained.");
        return "message";
    }

    private static String actions() {
        String RESULT_FILE_NAME = "D:\\_D\\MarvelousTravel\\data\\result" + new Date(0).toString() + ".data";
        String TRAINIG_SET_FILE_NAME = "D:\\_D\\MarvelousTravel\\data\\training_set.data";
        File trainingSetFile = new File(TRAINIG_SET_FILE_NAME);

        //Для сборки новой ИНС необходимо создасть список слоев
        List<Layer> layerList = new ArrayList<Layer>();
        layerList.add(Layer.create(6, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(49, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(7, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        //Сборка ИНС
        Fann fann = new Fann(layerList);

        //Создаем тренера и определяем алгоритм обучения
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        //Тренировка
        trainer.train(trainingSetFile.getAbsolutePath(),
                100000, 100, 0.0001f);
        //Сораняем результат
        fann.save(RESULT_FILE_NAME);


    }
}
