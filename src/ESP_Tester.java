import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This Class Tests if the person has ESP by running x trials.
 * The values 0 - 9 represent people. If the shuffled numbers have the same
 * number as the represented people then the a point is added.
 */
public class ESP_Tester {
    /**
     * The number of Trials given in the Problem
     */
    private static int NUM_TRIALS = 20;
    /**
     * The number of people in the Problem
     */
    private static int NUM_PEOPLE = 10;

    /**
     * Initializes an array called Integers.
     * Then calls runTrials to run the Trails
     *
     * @param args no command line used
     */
    public static void main(String[] args) {
        ESP_Tester tester = new ESP_Tester();

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < NUM_PEOPLE; i++) {
            integers.add(i);
        }

        tester.runTrials(integers);

    }

    private void runTrials(ArrayList<Integer> integers) {
        double sum = 0;
        double total;
        for (int i = 1; i <= NUM_TRIALS; i++, sum += total) {
            ArrayList<Integer> list = shuffleList(integers);
            total = match(list);
            System.out.print("Trail: " + i + " | ");

            for (int num : list) System.out.print(num + " ");
            double passPerTrail = total / list.size() * 100;
            System.out.print("| " + (int) total + " | " + passPerTrail + "%");
            System.out.println();
        }
        System.out.println("Number of Trials: " + NUM_TRIALS);
        System.out.println("Number of People: " + NUM_PEOPLE);
        System.out.println("Number Correct: " + (int) sum);
        double overallPercent = sum / (integers.size() * NUM_TRIALS) * 100;
        System.out.println("Percent Correct: " + (int) overallPercent + "%");
    }

    /**
     * Checks if the values shuffled match the items in List
     *
     * @param shuffledList the items of the Shuffled List
     * @return the number of items that were same as the previous list.
     */
    public int match(ArrayList<Integer> shuffledList) {
        int total = 0;
        for (int i = 0; i < NUM_PEOPLE; i++) if (shuffledList.get(i) == i) total++;
        return total;
    }

    /**
     * Shuffles the items in the List
     *
     * @param list the given List
     * @return the shuffled List
     */
    public ArrayList<Integer> shuffleList(ArrayList<Integer> list) {
        ArrayList newList = (ArrayList) list.clone();
        long seed = System.nanoTime();
        Collections.shuffle(newList, new Random(seed));
        return newList;
    }
}
