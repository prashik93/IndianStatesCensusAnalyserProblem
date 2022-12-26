package org.example;

public class Main {
    public static void main(String[] args) throws StateCensusAnalyserException.CensusAnalyserException {
        System.out.println("Welcome to Indian States Census Analyser Problem!");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int numOfRecords = stateCensusAnalyser.loadIndiaCensusData("E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusData.csv");
        System.out.println("Number of Records = " + numOfRecords);
    }
}