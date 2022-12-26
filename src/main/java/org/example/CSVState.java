package org.example;

import com.opencsv.bean.CsvBindByName;

public class CSVState {

    @CsvBindByName(column = "State Name", required = true)
    public String state;

    @CsvBindByName(column = "Tin", required = true)
    public String tin;


    @Override
    public String toString() {
        return "CSVState{" +
                ", state='" + state + '\'' +
                ", tin='" + tin + '\'' +
                '}';
    }
}
