package stream_api;
import java.util.*;
import java.util.stream.*;

public class InsuranceClaimAnalysis {

    static class InsuranceClaim {
        String claimType;
        double claimAmount;

        InsuranceClaim(String claimType, double claimAmount) {
            this.claimType = claimType;
            this.claimAmount = claimAmount;
        }
    }

    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Health", 50000),
            new InsuranceClaim("Vehicle", 20000),
            new InsuranceClaim("Health", 30000),
            new InsuranceClaim("Home", 40000),
            new InsuranceClaim("Vehicle", 25000),
            new InsuranceClaim("Health", 45000)
        );

        Map<String, Double> averageClaimByType =
                claims.stream()
                      .collect(Collectors.groupingBy(
                          c -> c.claimType,
                          Collectors.averagingDouble(c -> c.claimAmount)
                      ));

        averageClaimByType.forEach((type, avg) ->
            System.out.println(type + " Average Claim Amount: " + avg)
        );
    }
}
