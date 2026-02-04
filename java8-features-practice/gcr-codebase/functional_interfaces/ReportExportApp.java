package functional_interfaces;
interface DataExporter {

    void exportToCSV();
    void exportToPDF();

    default void exportToJSON() {
        System.out.println("Exporting data in JSON format (default implementation)");
    }
}

class SalesReportExporter implements DataExporter {

    public void exportToCSV() {
        System.out.println("Sales report exported as CSV");
    }

    public void exportToPDF() {
        System.out.println("Sales report exported as PDF");
    }
}

class InventoryReportExporter implements DataExporter {

    public void exportToCSV() {
        System.out.println("Inventory report exported as CSV");
    }

    public void exportToPDF() {
        System.out.println("Inventory report exported as PDF");
    }

    public void exportToJSON() {
        System.out.println("Inventory report exported as JSON");
    }
}

public class ReportExportApp {

    public static void main(String[] args) {

        DataExporter exporter1 = new SalesReportExporter();
        DataExporter exporter2 = new InventoryReportExporter();

        exporter1.exportToCSV();
        exporter1.exportToPDF();
        exporter1.exportToJSON(); 

        System.out.println();

        exporter2.exportToCSV();
        exporter2.exportToPDF();
        exporter2.exportToJSON();   
    }
}
