package gna.datalogging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class DataLogger {

	private HashSet<DataPoint> datapoints;
	private boolean labled;
	private FileWriter fileWriter;

	public DataLogger() {
		this("data");
	}

	public DataLogger(String filename) {
		datapoints = new HashSet<>();
		File file = generateFile(filename);
		fileWriter = prepareFile(file);
		labled = false;
	}

	private File generateFile(String filename) {
		File dir = new File("./data");
		if (!dir.exists())
			dir.mkdirs();
		int current = dir.listFiles().length;
		File file = new File(dir, filename + "-" + this.hashCode() + "-" + current + ".txt");
		return file;
	}

	private FileWriter prepareFile(File file) {
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileWriter;
	}

	public void add(DataPoint datapoint) {
		if (labled == false) {
			try {
				String line = "";
				for (String key : datapoint.getData().keySet()) {
					line = line + key + "\t";
				}
				line = line + System.lineSeparator();
				fileWriter.append(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
			labled = true;
		}
		datapoints.add(datapoint);
	}

	public void write() {
		try {
			for (DataPoint datapoint : datapoints) {
				String line = "";
				for (String key : datapoint.getData().keySet()) {
					line = line + datapoint.get(key) + "\t";
				}
				line = line + System.lineSeparator();
				fileWriter.append(line);
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print(Comparable[] comparables) {
		System.out.println("--- Start ---");
		for (Comparable comparable : comparables) {
			System.out.println(comparable.toString());
		}
		System.out.println("--- Stop ---");
	}
}
