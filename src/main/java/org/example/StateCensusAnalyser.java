package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {
    public int loadIndiaCensusData(String indianCensusCsvFilePath) throws StateCensusAnalyserException.CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(indianCensusCsvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new StateCensusAnalyserException.CensusAnalyserException("File not present at the location", StateCensusAnalyserException.CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new StateCensusAnalyserException.CensusAnalyserException("Invalid file type", StateCensusAnalyserException.CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException.CensusAnalyserException("Wrong Input, please refer the POJO class or the CSV file", StateCensusAnalyserException.CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER);
        }
    }
}
