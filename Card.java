/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author gene johnson
 * @version 1.0
 */
public class Card {

    /*** CONSTANT VARIABLES ***/
    public static final char HEART = '\u2665';   // ♥
    public static final char DIAMOND = '\u2666'; // ♦
    public static final char CLUB = '\u2663';    // ♣
    public static final char SPADE = '\u2660';   // ♠
    public static final int DEFAULT_VALUE = 1;   // Ace
    public static final char DEFAULT_SUIT = HEART; // ♥

    /*** INSTANCE VARIABLES ***/
    private int value; // 1-13 (A=1, J=11, Q=12, K=13)
    private char suit; // Unicode suit (♥, ♦, ♣, ♠)

    /*** CONSTRUCTOR METHODS ***/
    /**
     * Default constructor, builds default card object as: A ♥
     */
    public Card() {
        this.value = DEFAULT_VALUE;
        this.suit = DEFAULT_SUIT;
    }

    /**
     * Full constructor builds object with all data for instance variables provided.
     * If arguments are not valid, program shuts down with error message
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10, J, Q, K)
     * @param suit  one of four suit values (unicode value for heart, diamond, spade, or club)
     */
    public Card(int value, char suit) {
        if (!isValidValue(value) || !isValidSuit(suit)) {
            System.err.println("Invalid card data: value=" + value + ", suit=" + suit);
            System.exit(1);
        }
        this.value = value;
        this.suit = suit;
    }

    /**
     * Copy constructor builds object with all data from Card object provided. No
     * changes made to original object, no shallow copying
     *
     * @param original Card object to be copied
     */
    public Card(Card original) {
        if (original == null) {
            System.err.println("Cannot copy null card");
            System.exit(1);
        }
        this.value = original.value;
        this.suit = original.suit;
    }

    /*** MUTATOR METHODS (SETTERS) ***/
    /**
     * Sets value for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occurred (false) or
     * operation completed successfully (true)
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10, J, Q, K)
     * @return true if card value is between 1 and 13 (inclusive), false otherwise
     */
    public boolean setValue(int value) {
        if (isValidValue(value)) {
            this.value = value;
            return true;
        }
        return false;
    }

    /**
     * Sets suit for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occurred (false) or
     * operation completed successfully (true)
     *
     * @param suit one of four suit values (unicode value for heart, diamond, spade, or club)
     * @return true if card suit is unicode value for heart, diamond, club or spade, false otherwise
     */
    public boolean setSuit(char suit) {
        if (isValidSuit(suit)) {
            this.suit = suit;
            return true;
        }
        return false;
    }

    /**
     * Sets suit and value for card only if valid, returns boolean representing
     * whether error occurred (false) or operation completed successfully (true)
     *
     * @param suit  one of four suit values (unicode value for heart, diamond, spade, or club)
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10, J, Q, K)
     * @return true if card suit AND value are valid, false otherwise
     */
    public boolean setAll(int value, char suit) {
        if (isValidValue(value) && isValidSuit(suit)) {
            this.value = value;
            this.suit = suit;
            return true;
        }
        return false;
    }

    /*** ACCESSOR METHODS (GETTERS) ***/
    /**
     * Access unicode character representing suit of card
     *
     * @return suit as unicode character for heart, spade, diamond, or club
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Access numerical value of card (1-13)
     *
     * @return value as raw integer 1-13 (not what player sees as A, 2-10, J, Q, K)
     */
    public int getValue() {
        return value;
    }

    /**
     * Access value of card as seen by user (A, 2-10, J, Q, K) that would be printed on card
     *
     * @return value as String user sees on card (A, 2-10, J, Q, K), not numerical value 1-13
     */
    public String getPrintValue() {
        switch (value) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(value);
        }
    }

    /**
     * Access ASCII art version of card data, each line separated by newline
     * character, no newline character at end of String
     *
     * @return String containing ASCII art with card suit and card print value
     */
    public String getPrintCard() {
        String printValue = getPrintValue();
        String valueDisplay = printValue.length() == 1 ? "  " + printValue + "  " : " " + printValue + "  ";
        return "-------\n" +
               "|" + suit + "   " + suit + "|\n" +
               "|" + valueDisplay + "|\n" +
               "|" + suit + "   " + suit + "|\n" +
               "-------";
    }

    /*** OTHER REQUIRED METHODS ***/
    /**
     * String of all instance variables, no newline character at end of String.
     * Using print value to use as "condensed" version of printed card (ex: A ♥)
     *
     * @return String containing (print) value and suit, separated by a space
     */
    public String toString() {
        return getPrintValue() + " " + suit;
    }

    /**
     * Checking for equality of Card objects, all instance variables exactly equal
     * to each other (case-sensitive). Argument object not changed
     *
     * @param otherCard Card object to compare for equality
     * @return boolean representing equality between both objects, all data is exactly equal
     */
    public boolean equals(Object otherCard) {
        if (this == otherCard) return true;
        if (!(otherCard instanceof Card)) return false;
        Card other = (Card) otherCard;
        return this.value == other.value && this.suit == other.suit;
    }

    /*** EXTRA METHODS ***/
    /**
     * Prints card ASCII art to console
     */
    public void printCard() {
        System.out.println(getPrintCard());
    }

    /*** HELPER METHODS ***/
    /**
     * Validates card value (1-13)
     */
    private boolean isValidValue(int value) {
        return value >= 1 && value <= 13;
    }

    /**
     * Validates card suit (♥, ♦, ♣, ♠)
     */
    private boolean isValidSuit(char suit) {
        return suit == HEART || suit == DIAMOND || suit == CLUB || suit == SPADE;
    }
}
