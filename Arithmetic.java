package arithmetic;

import java.util.ArrayList;

public class Arithmetic {

    private final int NUM_MAX = 3;
    private ArrayList<Character> operators = new ArrayList<>();
    private boolean found = false;

    public ArrayList<Character> handleLines(String[] eq) {
        String[] inputsStr = eq[0].split(" ");
        String[] resultStr = eq[1].split(" ");
        String type = resultStr[1];
        int[] input = new int[NUM_MAX];
        int result = Integer.parseInt(resultStr[0]);
        try {
            input[0] = Integer.parseInt(inputsStr[0]);
            input[1] = Integer.parseInt(inputsStr[1]);
            input[2] = Integer.parseInt(inputsStr[2]);
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int isSolvable = solve(input, 1, input[0], result);
        System.out.println(isSolvable);
        return isSolvable == 1 ? this.operators : new ArrayList<Character>('x');
        
    }

    public int solve(int[] operands, int pos, int total, int target) {
        int currNum = operands[pos];
        if (found) return 1;

        if (pos == operands.length - 1) {
            if (currNum + total == target) {
                operators.add('+');
                found = true;
                return 1;
            }
            if (currNum * total == target) {
                operators.add('*');
                found = true;
                return 1;
            }
        } else {
            if (currNum + total < target) {
                this.operators.add('+');
                return solve(operands, pos + 1, currNum + total, target);      
            }
            if (currNum * total < target) {
                
                if (solve(operands, pos + 1, currNum * total, target) == 2) {
                    this.operators.add('*');
                    return 3;
                }
            }
        }
        return 0;
    }
}