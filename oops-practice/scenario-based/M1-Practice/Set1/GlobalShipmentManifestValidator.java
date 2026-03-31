package Set1;
import java.util.*;
import java.util.regex.*;
import java.time.*;

public class GlobalShipmentManifestValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern codePattern = Pattern.compile("^SHIP-(?!.*(\\d)\\1{3})[1-9]\\d{5}$");
        Pattern datePattern = Pattern.compile("^20\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
        Pattern modePattern = Pattern.compile("^(AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT)$");
        Pattern weightPattern = Pattern.compile("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$");
        Pattern statusPattern = Pattern.compile("^(DELIVERED|CANCELLED|IN_TRANSIT)$");

        for(int i=0;i<n;i++){

            String record = sc.nextLine();
            String[] parts = record.split("\\|");

            boolean valid = true;

            if(parts.length != 5)
                valid = false;
            else{

                if(!codePattern.matcher(parts[0]).matches())
                    valid = false;

                if(!datePattern.matcher(parts[1]).matches())
                    valid = false;
                else{
                    try{
                        LocalDate.parse(parts[1]);
                    }catch(Exception e){
                        valid = false;
                    }
                }

                if(!modePattern.matcher(parts[2]).matches())
                    valid = false;

                if(!weightPattern.matcher(parts[3]).matches())
                    valid = false;
                else{
                    double w = Double.parseDouble(parts[3]);
                    if(w > 999999.99)
                        valid = false;
                }

                if(!statusPattern.matcher(parts[4]).matches())
                    valid = false;
            }

            if(valid)
                System.out.println("COMPLIANT RECORD");
            else
                System.out.println("NON-COMPLIANT RECORD");
        }
        sc.close();
    }
}