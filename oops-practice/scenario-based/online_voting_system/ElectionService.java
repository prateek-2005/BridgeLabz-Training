package online_voting_system;

public abstract class ElectionService {

    public abstract void registerVoter(Voter voter);

    public abstract void addCandidate(Candidate candidate);

    public abstract void castVote(int voterId, int candidateId) throws DuplicateVoteException;

    public abstract void declareResult();
}

