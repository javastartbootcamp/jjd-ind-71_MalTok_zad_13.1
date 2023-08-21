package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private static final String FOR = "z";
    private static final String AGAINST = "p";
    private static final String ABSTAINED_FROM_VOTING = "w";
    private final List<String> correctVotes = List.of(FOR, AGAINST, ABSTAINED_FROM_VOTING);
    private List<Vote> voteList;

    public VotingResult() {
        this.voteList = new ArrayList<>();
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public List<String> getCorrectVotes() {
        return correctVotes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */

    public void printResults() {
        // metoda powinna drukować wyniki głosowania
        System.out.printf("Głosów za: %.2f%%\n", countVotingResult(FOR));
        System.out.printf("Głosów przeciw: %.2f%%\n", countVotingResult(AGAINST));
        System.out.printf("Wstrzymało się: %.2f%%\n", countVotingResult(ABSTAINED_FROM_VOTING));
        System.out.println();
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : voteList) {
            if (voterName.equals(vote.getVoter())) {
                System.out.printf("%s: %s", voterName, getVoteText(vote.getVote()));
            }
        }
    }

    public String getVoteText(String vote) {
        return switch (vote) {
            case FOR -> "ZA";
            case AGAINST -> "PRZECIW";
            case ABSTAINED_FROM_VOTING -> "WSTRZYMAŁ SIĘ";
            default -> throw new IllegalArgumentException("Wrong option");
        };
    }

    private double countVotingResult(String vote) {
        return (double) countVotes(vote) / voteList.size() * 100;
    }

    private int countVotes(String vote) {
        int votes = 0;
        for (Vote element : voteList) {
            if (vote.equals(element.getVote())) {
                votes++;
            }
        }
        return votes;
    }
}
