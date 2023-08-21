package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        VotingResult votingResult = new VotingResult();
        for (String voter : voters) {
            String votersVote;
            boolean correctVote;
            do {
                System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
                votersVote = scanner.nextLine();
                correctVote = checkIfCorrectVote(votersVote, votingResult);
            } while (!correctVote);
            votingResult.getVoteList().add(new Vote(voter, votersVote));
        }
        return votingResult; // to możesz (a nawet powinieneś/powinnaś) zmienić :)
    }

    private boolean checkIfCorrectVote(String vote, VotingResult votingResult) {
        boolean correctVote = false;
        for (String option : votingResult.getCorrectVotes()) {
            if (option.equals(vote)) {
                correctVote = true;
                break;
            }
        }
        return correctVote;
    }

}
