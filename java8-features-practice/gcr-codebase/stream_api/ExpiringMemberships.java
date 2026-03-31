package stream_api;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class ExpiringMemberships {

    static class Member {
        String name;
        LocalDate expiryDate;

        Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return name + " | Expiry Date: " + expiryDate;
        }
    }

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Riya", LocalDate.now().plusDays(45)),
            new Member("Karan", LocalDate.now().plusDays(25)),
            new Member("Neha", LocalDate.now().minusDays(5)),
            new Member("Vikas", LocalDate.now().plusDays(30))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
               .filter(m -> !m.expiryDate.isBefore(today)
                         && !m.expiryDate.isAfter(next30Days))
               .forEach(System.out::println);
    }
}
