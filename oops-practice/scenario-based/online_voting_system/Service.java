package online_voting_system;

public class Service extends ElectionService {

    private Voter[] voters = new Voter[10];
    private Candidate[] candidates = new Candidate[10];
    private Vote[] votes = new Vote[10];

    private int voterCount = 0;
    private int candidateCount = 0;
    private int voteCount = 0;

    @Override
    public void registerVoter(Voter voter) {
        voters[voterCount++] = voter;
        System.out.println("Voter registered: " + voter.getName());
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates[candidateCount++] = candidate;
        System.out.println("Candidate added: " + candidate.getName());
    }

    @Override
    public void castVote(int voterId, int candidateId)
            throws DuplicateVoteException {

        Voter voter = null;
        Candidate candidate = null;

        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getVoterId() == voterId) {
                voter = voters[i];
                break;
            }
        }
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].getCandidateId() == candidateId) {
                candidate = candidates[i];
                break;
            }
        }

        if (voter == null || candidate == null) {
            System.out.println("Invalid voter or candidate");
            return;
        }

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter " + voter.getName() + " has already voted!");
        }
        votes[voteCount++] = new Vote(voter, candidate);
        candidate.addVote();
        voter.markVoted();

        System.out.println("Vote cast successfully by " + voter.getName());
    }

    @Override
    public void declareResult() {
        System.out.println("\n--- Election Results ---");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i].getName() +
                    " : " + candidates[i].getVotes() + " votes");
        }
    }
}

