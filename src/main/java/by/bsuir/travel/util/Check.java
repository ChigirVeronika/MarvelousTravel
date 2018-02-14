package by.bsuir.travel.util;

import com.googlecode.fannj.Fann;

import java.io.File;

/**
 *
 */
public class Check {
    public static void main(String[] args) {

        System.setProperty("jna.library.path", "D:\\IdeaProjects\\MarvelousTravel\\src\\main\\resources\\ann\\");
        System.setProperty("fannj.library.path", "D:\\IdeaProjects\\MarvelousTravel\\src\\main\\resources\\ann\\fannj-0.6.jar");
        System.out.println( System.getProperty("jna.library.path") ); //maybe the path is malformed
        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");
        System.out.println("Is the dll file there:" + file.exists());
        System.load(file.getAbsolutePath());

        Fann fann = new Fann("D:\\IdeaProjects\\MarvelousTravel\\data\\result.dto");
        float[][] tests = {
                {26, 1, 0, 0.5f, 0, 1},
                {37, 1, 1, 0.8f, 1, 1},
                {26, 0, 0, 0.7f, 0, 3},
                {25, 1, 0, 0.5f, 0, 2}
        };
        for (float[] test:tests){
            System.out.println(getAction(fann.run(test)));
        }
    }

    public static String getAction(float[] out){
        int i = 0;
        for (int j = 1; j < 7; j++) {
            if(out[i]<out[j]){
                i = j;
            }
        }
        switch (i){
            case 0:return "1";
            case 1:return "2";
            case 2:return "3";
            case 3:return "4";
            case 4:return "5";
            case 5:return "6";
            case 6:return "7";
        }
        return "";
    }
}
