package online_voting_system;

public class Voter {
    private int voterId;
    private String name;
    private boolean hasVoted;

    public Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void markVoted() {
        hasVoted = true;
    }
}

