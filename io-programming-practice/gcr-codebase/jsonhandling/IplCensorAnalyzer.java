package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IplCensorAnalyzer {

    private static String maskTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            parts[parts.length - 1] = "***";
        } else {
            parts[0] = "***";
        }
        return String.join(" ", parts);
    }

    private static String redactPlayer(String playerName) {
        return "REDACTED";
    }

    public static JSONArray processJSON(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject match = jsonArray.getJSONObject(i);

            String team1 = maskTeamName(match.getString("team1"));
            String team2 = maskTeamName(match.getString("team2"));
            match.put("team1", team1);
            match.put("team2", team2);

            JSONObject score = match.getJSONObject("score");
            JSONObject newScore = new JSONObject();
            for (String key : score.keySet()) {
                String maskedTeam = maskTeamName(key);
                newScore.put(maskedTeam, score.getInt(key));
            }
            match.put("score", newScore);

            String winner = maskTeamName(match.getString("winner"));
            match.put("winner", winner);

            match.put("player_of_match", redactPlayer(match.getString("player_of_match")));
        }
        return jsonArray;
    }

    public static void processCSV(String inputCsv, String outputCsv) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsv));
             PrintWriter pw = new PrintWriter(new FileWriter(outputCsv))) {

            String header = br.readLine();
            pw.println(header); 
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);

                parts[1] = maskTeamName(parts[1]); 
                parts[2] = maskTeamName(parts[2]); 
                parts[5] = maskTeamName(parts[5]); 
                parts[6] = redactPlayer(parts[6]);
                pw.println(String.join(",", parts));
            }

            System.out.println("CSV processing complete: " + outputCsv);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("ipl_matches.json")));
            JSONArray matches = new JSONArray(jsonContent);

            JSONArray censoredJSON = processJSON(matches);

            try (FileWriter file = new FileWriter("ipl_matches_censored.json")) {
                file.write(censoredJSON.toString(2)); // pretty print
            }

            System.out.println("JSON processing complete: ipl_matches_censored.json");

            processCSV("ipl_matches.csv", "ipl_matches_censored.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
