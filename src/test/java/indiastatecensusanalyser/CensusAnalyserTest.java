package indiastatecensusanalyser;

import org.example.StateCensusAnalyser;
import org.example.StateCensusAnalyserException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\resources\\IndianStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_Returns_CorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WithWrongPath_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}