package by.bsuir.travel.util;

import com.googlecode.fannj.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Train ann from dto/training_set.dto file.
 * Info is in dto/fann_training_set.docx
 */
public class Training {
//    public static void main(String[] args) throws InterruptedException {
//        org.apache.log4j.Logger log = Logger.getLogger(LogClass.class);
//
//        System.setProperty("jna.library.path", "D:\\_D\\MarvelousTravel\\src\\main\\resources\\ann\\");
//        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");
//
//        //Для сборки новой ИНС необходимо создасть список слоев
//        List<Layer> layerList = new ArrayList<Layer>();
//        layerList.add(Layer.create(6, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
//        layerList.add(Layer.create(49, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
//        layerList.add(Layer.create(7, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
//
//        Fann fann = new Fann(layerList);
//        //Создаем тренера и определяем алгоритм обучения
//        Trainer trainer = new Trainer(fann);
//        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
//        /* Проведем обучение взяв уроки из файла, с максимальным колличеством
//           циклов 100000, показывая отчет каждую 100ю итерацию и добиваемся
//        ошибки меньше 0.0001 */
//        trainer.train(new File("D:\\_D\\MarvelousTravel\\dto\\training_set.dto").getAbsolutePath(),
//                100000, 100, 0.0001f);
//        fann.save("D:\\_D\\MarvelousTravel\\dto\\result.dto");
//
//        float[][] tests = {
//                {26, 1, 0, 0.5f, 0, 1},//1
//                {37, 1, 1, 0.8f, 1, 1},//5
//                {26, 0, 1, 0.8f, 0, 3},//7
//                {25, 1, 0, 0.5f, 0, 2},//2
//                {23, 0, 0, 0.9f, 0, 1} //6
//        };
//        for (float[] test:tests){
//            System.out.println(Check.getAction(fann.run(test)));
//        }
//    }
//
//    public static String getAction(float[] out){
//        int i = 0;
//        for (int j = 1; j < 7; j++) {
//            if(out[i]<out[j]){
//                i = j;
//            }
//        }
//        switch (i){
//            case 0:return "1";
//            case 1:return "2";
//            case 2:return "3";
//            case 3:return "4";
//            case 4:return "5";
//            case 5:return "6";
//            case 6:return "7";
//        }
//        return "";
//    }

}
