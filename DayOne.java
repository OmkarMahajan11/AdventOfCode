import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.HashSet;

class DayOne {

    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    public static void partOne() throws IOException {
        var inputList = Files.lines(Paths.get("day1-input.txt"))
                .map(Integer::parseInt).collect(Collectors.toList());
        var inputSet = new HashSet();

        for (int i : inputList) {
            if (!inputSet.contains(2020-i))
                inputSet.add(i);
            else
                System.out.println(i * (2020-i));
        }
    }

    public static void partTwo() throws IOException {
        var inputList = Files.lines(Paths.get("day1-input.txt"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.sort(inputList);

        for (int i=0; i<inputList.size(); i++) {
            int l = i+1, r = inputList.size()-1;
            while (l <= r) {
                int sum = inputList.get(i) + inputList.get(l) + inputList.get(r);
                if (sum == 2020) {
                    System.out.println(inputList.get(i) * inputList.get(l) * inputList.get(r));
                    break;
                }
                else if (sum > 2020)
                    r--;
                else
                    l++;
            }
        }
    }
}