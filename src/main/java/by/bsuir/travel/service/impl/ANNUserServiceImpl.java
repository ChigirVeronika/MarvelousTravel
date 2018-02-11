package by.bsuir.travel.service.impl;

import by.bsuir.travel.entity.Group;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.ANNUserService;
import com.googlecode.fannj.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("annService")
public class ANNUserServiceImpl implements ANNUserService {

    public void retrainANN() {
        //1)заново собрать файл(пока что добавлять к существующему)-дата
        String trainFileName = createTrainingFile();
        String resultFileName = creteResultFile();

        //2)построить нейронную сеть
        //3)обучить ее и сохранить результаты в файл-дата
        Fann fann = buildANN(trainFileName, resultFileName);

        //4)по этим результатам обновить группу каждого юзера
//        List<User> users = userService.findAll();
//        for (User u : users) {
//            float age = 1l;
//            float gender =2l;
//            float maritalStatus = 3l;
//            float income = (float) 0.4;
//            float isParent = 5l;
//            float favoriteActivity = 6l;
//
//
//        }
    }

    private String creteResultFile() {
        String name = "D:\\_D\\MarvelousTravel\\dto\\result_" + new Date(0).toString() + ".dto";
        File file = new File(name);
        return name;
    }

    private String createTrainingFile(){

        //создать файл
        String name = "D:\\_D\\MarvelousTravel\\dto\\training_set_" + new Date(0).toString() + ".dto";
        File file = new File(name);
//
//        List<Group> groups = groupService.findAll();
//        for (Group group: groups){
//            //найти всех юзеров этой группы
//            //найти среднее для каждого параметра
//            //записать строчку в файл
//        }

        //сохранить файл
        return "ИМЯ_ФАЙЛА";
    }

    private Fann buildANN(String trainFileName, String resultFileName) {
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
        trainer.train(trainFileName,
                100000, 100, 0.0001f);
        //Сохраняем результат
        fann.save(resultFileName);

        return fann;
    }

}
