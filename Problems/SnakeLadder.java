import java.util.*;

public class SnakeLadder {

    static List<List<Integer>> snakes = Arrays.asList(
            Arrays.asList(30, 7),
            Arrays.asList(47, 15),
            Arrays.asList(56, 19),
            Arrays.asList(73, 51),
            Arrays.asList(82, 42),
            Arrays.asList(92, 75),
            Arrays.asList(98, 55)
    );

    static List<List<Integer>> ladders = Arrays.asList(
            Arrays.asList(4, 25),
            Arrays.asList(21, 39),
            Arrays.asList(29, 74),
            Arrays.asList(43, 76),
            Arrays.asList(63, 80),
            Arrays.asList(71, 89)
    );

    static int rollDice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press Enter to roll dice: ");
        sc.nextLine();
        int dieValue = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled " + dieValue);
        return dieValue;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> snakeMap = new HashMap<>(), ladderMap = new HashMap<>();

        for(List<Integer> list: snakes) snakeMap.put(list.get(0), list.get(1));
        for(List<Integer> list: ladders) ladderMap.put(list.get(0), list.get(1));

        int position = 0;

        while(position < 100) {
            System.out.println("-".repeat(15));
            System.out.println("You are at position " + position);
            int dieValue = rollDice();
            if(position == 0 && dieValue != 1) {
                System.out.println("Roll 1 to start :(");
                continue;
            }
            if(position + dieValue > 100) {
                System.out.println("Can't Exceed 100 :(");
                continue;
            }
            position += dieValue;
            if(snakeMap.containsKey(position)){
                position = snakeMap.get(position);
                System.out.println("Ouch! You got bit by a snake :_(");
            }
            if(ladderMap.containsKey(position)) {
                position = ladderMap.get(position);
                System.out.println("Climbing Stairs... & Done");
            }
            if(position == 100) System.out.println("Yay! You Won");
        }
    }
}
