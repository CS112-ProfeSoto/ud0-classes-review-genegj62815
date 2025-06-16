/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author Your Name
 * @version 1.0
 */
public class Main {

    /* ALGORITHM
     *
     1. Generate 52 card deck into Card array
     - Create array of size 52
     - Iterate through suits (♥, ♦, ♣, ♠)
     - For each suit, iterate through values (1-13)
     - Create new Card for each combination
     2. Print deck
     - For basic output: Loop through array, print toString(), 13 cards per row
     - For hacker challenge: Print ASCII art for each suit, 13 cards side by side
     *
     */
    public static void main(String[] args) {
        /*** RUNNING TESTER ***/
        // Uncomment line below to run CardTester:
        // CardTester.main(null);

        /*** DRIVER PROGRAM ***/
        // 1. Generate 52 card deck into Card array
        Card[] deck = new Card[52];
        int index = 0;
        char[] suits = {Card.HEART, Card.DIAMOND, Card.CLUB, Card.SPADE};

        for (char suit : suits) {
            for (int value = 1; value <= 13; value++) {
                deck[index++] = new Card(value, suit);
            }
        }

        // 2. Print deck (basic output)
        System.out.println("Basic Deck Output:");
        for (int i = 0; i < 52; i++) {
            System.out.print(deck[i].toString() + " ");
            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
        }

        // 2. Print deck (hacker challenge - ASCII art)
        System.out.println("\nHacker Challenge - ASCII Art Deck:");
        for (int i = 0; i < 52; i += 13) { // Process each suit (13 cards)
            String[][] cardLines = new String[13][5]; // Each card has 5 lines
            for (int j = 0; j < 13; j++) {
                cardLines[j] = deck[i + j].getPrintCard().split("\n");
            }

            // Print 13 cards side by side, line by line
            for (int line = 0; line < 5; line++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < 13; j++) {
                    row.append(cardLines[j][line]).append(" ");
                }
                System.out.println(row.toString().trim());
            }
        }
    }
}
