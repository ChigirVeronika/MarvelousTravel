package by.bsuir.travel.fann.entity;

public class TrainingParams {

    private String trainingAlgorithm;
    private String activationFunction;
    private Integer maxEpoch;
    private Float desiredError;


    public TrainingParams(String trainingAlgorithm, String activationFunction) {
        this.trainingAlgorithm = trainingAlgorithm;
        this.activationFunction = activationFunction;
    }

    public String getTrainingAlgorithm() {
        return trainingAlgorithm;
    }

    public void setTrainingAlgorithm(String trainingAlgorithm) {
        this.trainingAlgorithm = trainingAlgorithm;
    }

    public String getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(String activationFunction) {
        this.activationFunction = activationFunction;
    }
}
