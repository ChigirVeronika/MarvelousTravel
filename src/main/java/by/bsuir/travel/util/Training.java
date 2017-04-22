package by.bsuir.travel.util;

import com.googlecode.fannj.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Train ann from data/training_set.data file.
 * Info is in data/fann_training_set.docx
 */
public class Training {
    public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\_D\\MarvelousTravel\\src\\main\\resources\\ann\\");
        //System.setProperty("fannj.library.path", "C:\\Users\\Veranika\\IdeaProjects\\TravelFANN\\src\\main\\resources\\fannj-0.6.jar\\");
        //System.out.println( System.getProperty("jna.library.path") ); //maybe the path is malformed
        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");
        //System.out.println("Is the dll file there:" + file.exists());
        //System.load(file.getAbsolutePath());


        //Для сборки новой ИНС необходимо создасть список слоев
        List<Layer> layerList = new ArrayList<Layer>();
        layerList.add(Layer.create(6, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(49, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(7, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));

        Fann fann = new Fann(layerList);
        //Создаем тренера и определяем алгоритм обучения
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        /* Проведем обучение взяв уроки из файла, с максимальным колличеством
           циклов 100000, показывая отчет каждую 100ю итерацию и добиваемся
        ошибки меньше 0.0001 */
        trainer.train(new File("D:\\_D\\MarvelousTravel\\data\\training_set.data").getAbsolutePath(), 100000, 100, 0.0001f);
        fann.save("D:\\_D\\MarvelousTravel\\data\\result.data");
    }

}
