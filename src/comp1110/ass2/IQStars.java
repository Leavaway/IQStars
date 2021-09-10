package comp1110.ass2;

import java.util.Set;

public class IQStars {

    /**
     * Determine whether a game string describing either a wizard or a piece
     * is well-formed according to the following criteria:
     * - It consists of exactly three or four characters
     * - If it consists of three characters, it is a well-formed wizard string:
     *      - the first character is a valid colour character (r,o,y,g,b,i,p)
     *      - the second character is a valid column number
     *          - (0 .. 6) if the row number is 0 or 2
     *          - (0 .. 5) otherwise
     *      - the third character is a valid row number (0 .. 3)
     * - If it consists of four characters, it is a well-formed piece string:
     *      - the first character is a valid colour character (r,o,y,g,b,i,p)
     *      - the second character is a valid rotation value
     *          - (0 .. 2) if the colour is r or i
     *          - (0 .. 5) otherwise
     *      - the third character is a valid column number
     *          - (0 .. 6) if the row number is 0 or 2
     *          - (0 .. 5) otherwise
     *      - the fourth character is a valid row number (0 .. 3)
     *      @param gameString A string describing either a piece or a wizard
     *      @return True if the string is well-formed
     */
    static boolean isGameStringWellFormed(String gameString) {
        // FIXME Task 3 (P): determine whether a wizard or piece string is well-formed

        char[] colors = {'r', 'o', 'y', 'g', 'b', 'i', 'p'};
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6'};

        // Check Length
        if (gameString.length() != 3 && gameString.length() != 4) { return false;}

        // Check color character
        for (int i = 0; i < colors.length; i++) {

            // Color valid
            if (gameString.charAt(0) == colors[i]) { break;}
            // Color not valid
            if (i == colors.length - 1) {return false;}
        }

        // The character now processing.
        int now = 1;
        // max - 1 = the maximum number of char[] numbers.
        int max = 6;
        if (gameString.charAt(0) == 'r' || gameString.charAt(0) == 'i') { max = 3;}

        // Check rotation value of a piece
        if (gameString.length() == 4) {

            for (int i = 0; i < max; i++) {

                // Number valid
                if (gameString.charAt(now) == numbers[i]) { break;}
                // Number not valid
                if (i == max - 1) { return false;}
            }
            // Only piece have rotation value
            now += 1;
        }

        // Processing row
        now += 1;
        max = 4;
        char row = gameString.charAt(now);

        // Check row value
        for (int i = 0; i < max; i++) {

            // Row valid
            if (row == numbers[i]) { break;}
            // Row not valid
            if (i == max - 1) { return false;}
        }

        // Check column value
        if (row == '0' || row == '2') { max = 7;}
        else { max = 6;}
        now -= 1;
        for (int i = 0; i < max; i++) {

            // Column valid
            if (gameString.charAt(now) == numbers[i]) { break;}
            // Column not valid
            if (i == max - 1) { return false;}
        }
        // All tests passed
        return true;
    }

    /**
     * Determine whether a game state string is well-formed:
     * - The string is of the form [piecePlacement]W[wizardPlacement],
     *      where [piecePlacement] and [wizardPlacement] are replaced by the
     *      corresponding strings below
     * - [piecePlacement] string specification:
     *      - it consists of exactly n four-character piece strings (where n = 0 .. 7);
     *      - each piece string is well-formed
     *      - no piece appears more than once in the string
     *      - the pieces are ordered correctly within the string (r,o,y,g,b,i,p)
     * - [wizardPlacement] string specification:
     *      - it consists of exactly n three-character wizard strings (where n is some non-negative integer)
     *      - each wizard string is well-formed
     *      - the strings are ordered correctly within the string (r,o,y,g,b,i,p)
     *      - if there is more than one wizard of a single colour these wizards are ordered first by
     *          row and then by column in ascending order (note that this does not prevent two
     *          wizards of the same colour being placed in the same location - we will check for this
     *          in a later task).
     * @param gameStateString A string describing a game state
     * @return True if the game state string is well-formed
     */
    public static boolean isGameStateStringWellFormed(String gameStateString) {
        // FIXME Task 4 (P): determine whether a game state string is well-formed

        // Length of string
        int str_len = 4;
        // Find numbers of pieces and wizards
        int piece_num = 0;
        int wizard_num = 0;
        // Loop through the gameStateString, for every character:
        for (int i = 0; i < gameStateString.length(); i++) {

            // If now processing 'W', process wizard strings later
            if (gameStateString.charAt(i) == 'W') {
                // If piece number is not exactly n or too much, return false
                if (piece_num % 4 != 0 || piece_num > 28) { return false;}
                // Wizard mode on
                str_len = 3;
            }
            // Cumulate numbers of both piece and wizard
            else {
                if (str_len == 4) {
                    piece_num += 1;
                }
                else {
                    wizard_num += 1;
                }
            }
        }
        // If wizard number is not exactly n, return false
        if (wizard_num % 3 != 0) { return false;}

        // Transform them to real numbers (rather than number of characters)
        piece_num /= 4;

        // Check every substring:
        str_len = 4;
        char[] colors = {'r', 'o', 'y', 'g', 'b', 'i', 'p'};
        for (int i = 0; i < gameStateString.length(); i += str_len) {

            // Changing mode from piece to wizard
            if (str_len == 1) { str_len = 3;}
            if (gameStateString.charAt(i) == 'W') { str_len = 1;}

            if (str_len != 1) {

                // e.g. string = "r012b033W", subst(i=0) = "r012"
                // e.g. string = "Wr01r02", subst(i=2) = "r02"
                String subst = gameStateString.substring(i, i+str_len);

                // Check if the string well-formed
                if (!isGameStringWellFormed(subst)) { return false;}

                for (int j = i + str_len; j < gameStateString.length(); j += str_len) {

                    // Avoid OutOfBoundsException
                    if (j > piece_num * 4 - 1 && i < piece_num * 4) {break;}

                    // Another substring just like subst but comes behind, to compare with it
                    // e.g. string = "r012b033W", subst = "r012", subst2 = "b033"
                    String subst2 = gameStateString.substring(j,j+str_len);

                    for (int k = 0; k < str_len; k++) {

                        // In case of two piece strings have the same color, return false
                        if (str_len == 4 && k == 0 && subst.charAt(k) == subst2.charAt(k)) {return false;}

                        // Check order of color
                        // e.g. subst = "b01", subst2 = "r12",
                        // color_order(subst) = 4, color_order(subst2) = 0,
                        // 4 > 0 therefore it's not in the order.
                        if (k == 0) {
                            int color_order1 = 0;
                            int color_order2 = 0;
                            for (char color : colors) {
                                if (subst.charAt(k) != color) {
                                    color_order1++;
                                } else {
                                    break;
                                }
                            }
                            for (char color : colors) {
                                if (subst2.charAt(k) != color) {
                                    color_order2++;
                                } else {
                                    break;
                                }
                            }
                            if (color_order1 > color_order2) {return false;}
                        }

                    // Check wizardOrder
                    if (str_len == 3 && subst.charAt(0) == subst2.charAt(0)) {
                        if (subst.charAt(2) > subst2.charAt(2)) { return false;}
                        if (subst.charAt(2) == subst2.charAt(2) && subst.charAt(1) > subst2.charAt(1)) { return false;}
                        }
                    }
                }
            }
        }
        // All tests passed
        return true;
    }

    /**
     * Determine whether a game state is valid.
     *
     * To be valid, the game state must satisfy the following requirements:
     * - string must be well-formed
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     * - wizards must be on the board
     * - each location may have at most one wizard
     * - each piece must cover all wizards of the same colour
     * - each piece must not cover any wizards of a different colour
     *
     * @param gameStateString A game state string
     * @return True if the game state represented by the string is valid
     */
    public static boolean isGameStateValid(String gameStateString) {
        return false;  // FIXME Task 6 (D): determine whether a game state is valid
    }

    /**
     * Given a string describing a game state, and a location
     * that must be covered by the next move, return a set of all
     * possible viable piece strings which cover the location.
     *
     * For a piece string to be viable it must:
     *  - be a well formed piece string
     *  - be a piece that is not already placed
     *  - not overlap a piece that is already placed
     *  - cover the given location
     *  - cover all wizards of the same colour
     *  - not cover any wizards of a different colour
     *
     * @param gameStateString A starting game state string
     * @param col      The location's column.
     * @param row      The location's row.
     * @return A set of all viable piece strings, or null if there are none.
     */
    static Set<String> getViablePieceStrings(String gameStateString, int col, int row) {
        return null;  // FIXME Task 7 (P): determine the set of all viable piece strings given an existing game state
    }

    /**
     * Implement a solver for this game that can return the solution to a
     * particular challenge.
     *
     * This task is at the heart of the assignment and requires you to write
     * solver, similar to the boggle solver presented as part of the J14 lecture.
     *
     * NOTE: Simply looking up the provided answers does not constitute a general
     * solver.  Such an implementation is not a solution to this task, and
     * will not receive marks.
     *
     * @param challenge A game state string describing the starting game state.
     * @return A game state string describing the encoding of the solution to
     * the challenge.
     */
    public static String getSolution(String challenge) {
        return null;  // FIXME Task 10 (CR): determine the solution to the game, given a particular challenge
    }
}
