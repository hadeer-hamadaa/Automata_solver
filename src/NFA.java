import java.util.Arrays;

/**
 * @param alphabet        Array to store the alphabet symbols that the NFA can process
 * @param transition      3D array representing the transition table transition[currentState][inputIndex] gives an array of possible next states
 * @param startState      Integer representing the start state of the NFA
 * @param acceptingStates Array to store the accepting (final) states of the NFA
 */
record NFA(String[] alphabet, int[][][] transition, int startState, int[] acceptingStates) {
    // NFA fields

    // Constructor to initialize the NFA
    NFA(String[] alphabet, int[][][] transition, int startState, int[] acceptingStates) {
        // Initialize the alphabet
        this.alphabet = alphabet;

        // Initialize the transition table
        this.transition = transition;

        // Set the start state
        this.startState = startState;

        // Set the accepting states
        this.acceptingStates = acceptingStates;

        // Initialize the states array based on the transition table length
        // Array to store the states of the NFA
        String[] states = new String[transition.length];

        // Generate state names (q0, q1, q2, ...) based on the number of transitions
        for (int i = 0; i < transition.length; i++) {
            states[i] = "q" + i;
        }
    }

    // Method to simulate the NFA on a given input string
    public boolean simulateNFA(String input) {
        // Start the recursive simulation from the start state
        return simulateNFARecursive(input, startState);
    }

    // Helper method to recursively simulate NFA behavior
    private boolean simulateNFARecursive(String input, int currentState) {
        // Base case: if the input string is empty
        if (input.isEmpty()) {
            // Check if the current state is one of the accepting states
            for (int state : acceptingStates) {
                if (currentState == state) {
                    return true; // Accept the input
                }
            }
            return false; // Reject the input
        }

        // Read the first character from the input string
        char c = input.charAt(0);

        // Find the index of the current character in the alphabet array
        int inputIndex = Arrays.asList(alphabet).indexOf(String.valueOf(c));

        // If the character is not in the alphabet, return false (invalid input)
        if (inputIndex == -1) {
            return false;
        }

        // Retrieve possible next states for the current state and input character
        int[][] nextStates = transition[currentState];

        // Recursively check each possible next state
        for (int nextState : nextStates[inputIndex]) {
            // Check if the NFA can reach an accepting state from the next state
            // Either consume the current character and move to the next state or
            // consume an epsilon transition (if represented) and move to the next state
            if (simulateNFARecursive(input.substring(1), nextState) || simulateNFARecursive("E" + input.substring(1), nextState)) {
                return true;
            }
        }

        // If no accepting path is found, return false
        return false;
    }
}
