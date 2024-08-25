import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Open input and output files for reading and writing
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String currLine;
            // Read each line from the input file
            while ((currLine = reader.readLine()) != null) {
                // Parse the problem number from the current line
                int problemNum = Integer.parseInt(currLine);

                // List to hold input values for the current problem
                List<String> inputValues = new ArrayList<>();
                // Read input values until "end" is encountered
                while (!(currLine = reader.readLine()).trim().equals("end")) {
                    // Additional check for "End" (case-insensitive handling)
                    if ((currLine.trim().equals("End"))) {
                        break;
                    }
                    // Add the current line to the list of input values
                    inputValues.add(currLine);
                }
                // Read the separator line after "end" keyword
                reader.readLine();

                // Write the problem number to the output file
                writer.write(problemNum + "\n");

                // Switch statement to handle different problem numbers
                switch (problemNum) {
                    // Design a DFA that accepts all strings which do not contain the substring ba over {a, b}
                    case 1 -> {
                        // Define the alphabet and transition table for the DFA
                        String[] alphabet = {"a", "b"};
                        int[][] transition = {
                                {0, 1},
                                {2, 1},
                                {2, 2}
                        };
                        int startState = 0;      // Define the start state
                        int[] acceptingStates = {0, 1}; // Define accepting states
                        DFA dfa = new DFA(alphabet, transition, startState, acceptingStates);

                        // Simulate DFA for each input value and write the result to the output file
                        for (String input : inputValues) {
                            boolean result = dfa.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Design a DFA that accepts allstrings that contains even number of 0's followed by single 1 over
                    case 2 -> {
                        // Define the alphabet and transition table for the DFA
                        String[] alphabet2 = {"0", "1"};
                        int[][] transition2 = {
                                {1, 2},
                                {0, 3},
                                {3, 3},
                                {3, 3}
                        };
                        int startState2 = 0;       // Define the start state
                        int[] acceptingStates2 = {2}; // Define accepting states
                        DFA dfa2 = new DFA(alphabet2, transition2, startState2, acceptingStates2);

                        // Simulate DFA for each input value and write the result to the output file
                        for (String input : inputValues) {
                            boolean result = dfa2.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Design a DFA that accepts all strings that contains odd number of x's over {x, y}.
                    case 3 -> {
                        String[] alphabet3 = {"x", "y"};
                        int[][] transition3 = {
                                {1, 0},
                                {0, 1}
                        };
                        int startState3 = 0;
                        int[] acceptingStates3 = {1};
                        DFA dfa3 = new DFA(alphabet3, transition3, startState3, acceptingStates3);
                        for (String input : inputValues) {
                            boolean result = dfa3.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Design a DFA that accepts strings starting and ending with the same characters over {a,b}.
                    case 4 -> {
                        String[] alphabet4 = {"a", "b"};
                        int[][] transition4 = {
                                {1, 2},
                                {1, 3},
                                {4, 2},
                                {1, 3},
                                {4, 2}
                        };
                        int startState4 = 0;
                        int[] acceptingStates4 = {1, 2};
                        DFA dfa4 = new DFA(alphabet4, transition4, startState4, acceptingStates4);
                        for (String input : inputValues) {
                            boolean result = dfa4.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Design a DFA that accepts all the strings that binary integers divisible by 4 over {0,1}.
                    case 5 -> {
                        String[] alphabet5 = {"0", "1"};
                        int[][] transition5 = {
                                {1, 2},
                                {1, 2},
                                {0, 2}
                        };
                        int startState5 = 0;
                        int[] acceptingStates5 = {1};
                        DFA dfa5 = new DFA(alphabet5, transition5, startState5, acceptingStates5);
                        for (String input : inputValues) {
                            boolean result = dfa5.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Construct an DFA that accepts all strings {W | W is any string except 11 and 111}
                    case 6 -> {
                        String[] alphabet6 = {"0", "1"};
                        int[][] transition6 = {
                                {4, 1},
                                {4, 2},
                                {4, 3},
                                {4, 4},
                                {4, 4}
                        };
                        int startState6 = 0;
                        int[] acceptingStates6 = {1, 4};
                        DFA dfa6 = new DFA(alphabet6, transition6, startState6, acceptingStates6);

                        // Simulate DFA for each input value and write the result to the output file
                        for (String input : inputValues) {
                            boolean result = dfa6.simulateDFA(input);
                            writer.write(result ? "True\n" : "False\n");
                        }
                    }
                    // Construct an NFA that accepts all strings over the alphabet {0, 1} containing an equal number of occurrences of '01' and '10'.
                    case 7 -> {
                        String[] alphabet7 = {"0", "1", "E"};
                        int[][][] transition7 = {
                                {{1}, {5}, {4}},
                                {{}, {2}, {4}},
                                {{3}, {2}, {}},
                                {{}, {}, {4, 2}},
                                {{}, {}, {}},
                                {{6}, {}, {4}},
                                {{6}, {7}, {}},
                                {{}, {}, {6, 4}}
                        };
                        int startState7 = 0;
                        int[] acceptingStates7 = {4};
                        NFA nfa7 = new NFA(alphabet7, transition7, startState7, acceptingStates7);
                        for (String input : inputValues) {
                            boolean result1 = nfa7.simulateNFA(input);
                            boolean result2 = nfa7.simulateNFA("E" + input);
                            writer.write(result1 || result2 ? "True\n" : "False\n");
                        }
                    }
                    // Design an NFA that accepts all strings over the alphabet {0, 1} that contain the substring "101"or "010
                    case 8 -> {
                        String[] alphabet8 = {"0", "1", "E"};
                        int[][][] transition8 = {
                                {{0, 5}, {1, 0}, {}},
                                {{2}, {}, {}},
                                {{}, {3}, {}},
                                {{}, {}, {4}},
                                {{4}, {4}, {}},
                                {{}, {6}, {}},
                                {{7}, {}, {}},
                                {{}, {}, {4}}
                        };
                        int startState8 = 0;
                        int[] acceptingStates8 = {4};
                        NFA nfa8 = new NFA(alphabet8, transition8, startState8, acceptingStates8);
                        for (String input : inputValues) {
                            boolean result1 = nfa8.simulateNFA(input);
                            boolean result2 = nfa8.simulateNFA("E" + input);
                            writer.write(result1 || result2 ? "True\n" : "False\n");
                        }
                    }
                    // Design an NFA that accepts all strings over the alphabet {0, 1} where no two consecutive characters are the same.
                    case 9 -> {
                        String[] alphabet9 = {"0", "1", "E"};
                        int[][][] transition9 = {
                                {{}, {}, {1, 5, 4}},
                                {{}, {2}, {}},
                                {{3}, {}, {4}},
                                {{}, {}, {1, 4}},
                                {{}, {}, {}},
                                {{6}, {}, {}},
                                {{}, {7}, {4}},
                                {{}, {}, {4, 5}}
                        };
                        int startState9 = 0;
                        int[] acceptingStates9 = {4};
                        NFA nfa9 = new NFA(alphabet9, transition9, startState9, acceptingStates9);
                        for (String input : inputValues) {
                            boolean result1 = nfa9.simulateNFA(input);
                            boolean result2 = nfa9.simulateNFA("E" + input);
                            writer.write(result1 || result2 ? "True\n" : "False\n");
                        }
                    }
                    // Design an NFA that recognizes strings over the alphabet {0, 1} where every '0' is followed by at least one '1'
                    case 10 -> {
                        String[] alphabet10 = {"0", "1", "E"};
                        int[][][] transition10 = {
                                {{1}, {0}, {}},
                                {{}, {2}, {}},
                                {{}, {}, {0}}
                        };
                        int startState10 = 0;
                        int[] acceptingStates10 = {0};
                        NFA nfa10 = new NFA(alphabet10, transition10, startState10, acceptingStates10);
                        for (String input : inputValues) {
                            boolean result1 = nfa10.simulateNFA(input);
                            boolean result2 = nfa10.simulateNFA("E" + input);
                            writer.write(result1 || result2 ? "True\n" : "False\n");
                        }
                    }
                }
                writer.write("End of problem " + problemNum + "\n\n");
            }
            // Close reader and writer objects
            reader.close();
            writer.close();
        } catch (IOException e) {
            // Print any exceptions encountered during file I/O
            e.printStackTrace();
        }
    }
}