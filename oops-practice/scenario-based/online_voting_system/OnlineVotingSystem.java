package online_voting_system;

public class OnlineVotingSystem {
	public static void main(String[] args) {

		ElectionService service = new Service();
		service.registerVoter(new Voter(1, "Rahul"));
		service.registerVoter(new Voter(2, "Anita"));
		service.addCandidate(new Candidate(101, "Candidate A"));
		service.addCandidate(new Candidate(102, "Candidate B"));

		try {
			service.castVote(1, 101);
			service.castVote(2, 102);
			service.castVote(1, 102); 
		} catch (DuplicateVoteException e) {
			System.out.println(e.getMessage());
		}
		service.declareResult();
	}

}
