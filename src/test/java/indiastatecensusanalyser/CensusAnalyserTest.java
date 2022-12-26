package indiastatecensusanalyser;

import org.example.StateCensusAnalyser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "E:\\Projects\\intellijProjects\\IndianStatesCensusAnalyserProblem\\src\\main\\java\\org\\example\\IndianStateCensusData.csv";

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
}