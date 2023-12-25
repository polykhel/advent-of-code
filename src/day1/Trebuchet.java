package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Trebuchet {

    private static Map<String, Integer> digitMap = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/day1/input.txt"));
        int sum = 0;
        for (String line : lines) {
            try {
                int firstDigit = getFirstDigit(line);
                int lastDigit = getLastDigit(line);
                int result = Integer.parseInt("" + firstDigit + lastDigit);
//                System.out.format("%s --- %d %d\n", line, firstDigit, lastDigit);
                sum += result;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(sum);
    }

    private static int getFirstDigit(String line) {
        int lowestIndex = Integer.MAX_VALUE;
        int result = 0;
        for (Map.Entry<String, Integer> entry : digitMap.entrySet()) {
            int index = line.indexOf(entry.getKey());
            if (index != -1) {
                if (lowestIndex > index) {
                    lowestIndex = index;
                    result = entry.getValue();
                }
            }
        }

        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                if (lowestIndex > i) {
                    result = c - '0';
                }
                break;
            }
        }

        return result;
    }

    private static int getLastDigit(String line) {
        int highestIndex = Integer.MIN_VALUE;
        int result = 0;
        for (Map.Entry<String, Integer> entry : digitMap.entrySet()) {
            int index = line.lastIndexOf(entry.getKey());
            if (index != -1) {
                if (highestIndex < index) {
                    highestIndex = index;
                    result = entry.getValue();
                }
            }
        }

        char[] charArray = line.toCharArray();
        for (int i = charArray.length - 1; i > -1; i--) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                if (highestIndex < i) {
                    result = c - '0';
                    break;
                }
            }
        }
        return result;
    }
}
