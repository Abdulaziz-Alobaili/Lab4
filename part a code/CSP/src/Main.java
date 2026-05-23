import java.util.*;

public class Main {

    static final String[] variables = {"A", "B", "C", "D", "E"};
    static final int[] domain = {1, 2, 3, 4};


    public static void main(String[] args) {

        int[] assignment = new int[5];

        solveCSP(0, assignment);

    }

    // This function solves the CSP recursively. The variablesAssigned parameter
    // refers to the current assigned variable from 0 to 4, which corresponds to
    // A to E. For example, when the value is 3, that means the variable is D
    // and all previous variables are assigned. The second parameter is an array
    // representing the current assignment.
    static void solveCSP(int variablesAssigned, int[] assignment) {
        for (int i = 0; i < domain.length; i++) {
            // assign (try) the values of the domain for the current variable
            assignment[variablesAssigned] = domain[i];

            if (i == 0) {
                if (variablesAssigned > 0) {
                    System.out.print(" ");
                }
            } else {
                System.out.println();
                for (int j = 0; j < variablesAssigned; j++) {
                    System.out.print("    ");
                }
            }

            System.out.print(variables[variablesAssigned] + " = " + assignment[variablesAssigned]);

            if (!isValid(variablesAssigned, assignment)) {
                System.out.print(" failure");
            } else {
                if (variablesAssigned == variables.length - 1) {
                    System.out.print(" solution");
                } else {
                    solveCSP(variablesAssigned + 1, assignment);
                }
            }
        }
    }

    static boolean isValid(int variablesAssigned, int[] assignment) {

        int A = assignment[0];
        int B = assignment[1];
        int C = assignment[2];
        int D = assignment[3];
        int E = assignment[4];

        if (variablesAssigned >= 2) {
            if (A == C) {
                return false;
            }

            if (B <= C) {
                return false;
            }
        }

        if (variablesAssigned >= 3) {
            if (C == D) {
                return false;
            }

            if (B <= D) {
                return false;
            }
        }

        if (variablesAssigned >= 4) {
            if ((E - A) % 2 != 0) {
                return false;
            }

            if (C <= E) {
                return false;
            }

            if (D <= E) {
                return false;
            }
        }

        return true;
    }
}