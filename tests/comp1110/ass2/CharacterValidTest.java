package comp1110.ass2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Timeout;
import java.util.Arrays;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1000, unit = MILLISECONDS)
public class CharacterValidTest {
    private void test(char[] arr_input, int range_input, char now_input, boolean expected) {

        boolean output = IQStars.isCharacterValid(arr_input, range_input, now_input);
        assertEquals(expected, output, "Wrong result when array is " + Arrays.toString(arr_input) + " and range is " + range_input + " and now position is " + now_input);
    }

    @Test
    public void CharacterIsInArray() {
        char[] colors = {'r', 'o', 'y', 'g', 'b', 'i', 'p'};
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6'};
        for (char c : colors) test(colors, colors.length, c, true);
        for (char c : colors) test(numbers, numbers.length, c, false);
        for (char c : numbers) test(numbers, numbers.length, c, true);
        for (char c : numbers) test(colors, colors.length, c, false);
    }

    @Test
    public void CharacterIsInRange() {
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6'};
        for (int range = 0; range < numbers.length; range++) {
            for (int i = 0; i < numbers.length; i++) {
                char c = numbers[i];
                if (i <= range) test(numbers, range + 1, c, true);
                if (i > range) test(numbers, range + 1, c, false);
            }
        }
    }
}

// Reference: GameStringWellFormedTest