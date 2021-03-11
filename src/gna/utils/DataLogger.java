package gna.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DataLogger {
	
	private DataPoint[] datapoints;
	private FileWriter fileWriter;
	
	public DataLogger() throws IOException {
		datapoints = new DataPoint[0];
		File file = generateFile();
		fileWriter = prepareFile(file);
	}
	
	private File generateFile() {
		return null;
	}

	private FileWriter prepareFile(File file) throws IOException {
		return null;
	}

	public void add(DataPoint datapoint) {
		Arrays.copyOf(datapoints, datapoints.length + 1);
		datapoints[datapoints.length - 1] = datapoint;
	}
	
	public void write() throws IOException {
		for (DataPoint datapoint : datapoints) {
			fileWriter.append("");
		}
	}
}
