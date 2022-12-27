package indiastatecensusanalyser;

import org.example.StateCensusAnalyser;
import org.example.StateCensusAnalyserException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\resources\\IndianStateCensusData.csv";
    private static final String INDIAN_CENSUS_CSV_FILE_WITH_WRONG_FILE_TYPE = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusData.txt";
    private static final String INDIAN_CENSUS_CSV_FILE_WITH_DELIMITER = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusDataDelimiter.csv";
    private static final String INDIAN_STATE_CSV_FILE = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCode.csv";
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\resources\\IndianStateCode.csv";
    private static final String INDIAN_STATE_CODE_CSV_FILE_WITH_WRONG_TYPE = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCode.txt";
    private static final String INDIAN_STATE_CODE_WITH_WRONG_DELIMITER = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCodeDelimiter.csv";
    private static final String INDIAN_STATE_CODE_FILE_WITH_WRONG_HEADER = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCodeHeader.csv";

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

    @Test
    public void givenIndianStateCensusCSVFile_WithWrongType_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_WITH_WRONG_FILE_TYPE);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIndianStateCensusCSVFile_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_WITH_DELIMITER);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianStateCensusCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaCensusData(INDIAN_STATE_CSV_FILE);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianStateCSVFile_Returns_CorrectRecords() {
        try {

            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int numOfRecords = stateCensusAnalyser.loadIndiaStateData(INDIAN_STATE_CSV_FILE);
            Assertions.assertEquals(37, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCSVFile_WithWrongPath_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaStateData(WRONG_STATE_CODE_CSV_FILE_PATH);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianStateCSVFile_WithWrongType_ShouldThrowException() {
        try{
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaStateData(INDIAN_STATE_CODE_CSV_FILE_WITH_WRONG_TYPE);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIndianStateCSVFile_WithWrongFileDelimiter_ShouldThrowException() {
        try{
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaStateData(INDIAN_STATE_CODE_WITH_WRONG_DELIMITER);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianStateCSVFile_WithWrongFileHeader_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(StateCensusAnalyserException.CensusAnalyserException.class);
            stateCensusAnalyser.loadIndiaStateData(INDIAN_STATE_CODE_FILE_WITH_WRONG_HEADER);
        } catch (StateCensusAnalyserException.CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusAnalyserException.CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }

}