import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }

    // Exercise 1
    static int getSumUpToN(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

    // Exercise 2
    static int getFactorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    // Exercise 3
    static int getNthPower(int a, int n) {
        return (int) Math.pow(a, n);
    }

    // Exercise 4
    static int getSumList(ArrayList<Integer> arl) {
        return arl.stream().mapToInt(Integer::intValue).sum();
    }

    // Exercise 5
    static double getMean(ArrayList<Integer> arl) {
        return arl.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    // Exercise 6
    static double getStandardDeviation(ArrayList<Integer> arl) {
        double mean = getMean(arl);
        double variance = arl.stream().mapToDouble(b -> Math.pow(b - mean, 2)).average().orElse(0);
        return Math.sqrt(variance);
    }

    // Exercise 7
    static int getSumEvenUpToN(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).sum();
    }

    // Exercise 8
    static int getSumEvenIntegersList(ArrayList<Integer> arl) {
        return arl.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    // Exercise 9
    static ArrayList<Integer> getUpdatedEvenArrayList(ArrayList<Integer> arl) {
        return arl.stream().filter(i -> i % 2 != 0).collect(Collectors.toCollection(ArrayList::new));
    }

    // Exercise 10
    static ArrayList<Integer> getArrayListUpToN(int n) {
        return IntStream.rangeClosed(0, n).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    // Exercise 11
    static int getDotProductMatrix(int[] arl1, int[] arl2) {
        return IntStream.range(0, arl1.length).map(i -> arl1[i] * arl2[i]).sum();
    }
}
