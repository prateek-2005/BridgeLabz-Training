package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";
        String line;
        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            String header = br.readLine();
            writer.append(header).append("\n");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }
                writer.append(id + "," + name + "," + department + "," + salary + "\n");
            }
            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
