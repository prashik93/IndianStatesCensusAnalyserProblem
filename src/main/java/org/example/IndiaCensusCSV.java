package org.example;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
    @CsvBindByName(column = "State", required = true)
    public String State;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + State + '\'' +
                ", population=" + population +
                ", AreaInSqKm=" + AreaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
