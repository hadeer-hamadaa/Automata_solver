/**
 * @param alphabet        Array to store the alphabet symbols that the DFA can process
 * @param transition      2D array representing the transition table transition[currentState][inputIndex] gives the next state
 * @param startState      Integer representing the start state of the DFA
 * @param acceptingStates Array to store the accepting (final) states of the DFA
 */
record DFA(String[] alphabet, int[][] transition, int startState, int[] acceptingStates) {
    // DFA fields

    // Constructor to initialize the DFA
    DFA(String[] alphabet, int[][] transition, int startState, int[] acceptingStates) {
        // Initialize the alphabet
        this.alphabet = alphabet;

        // Initialize the transition table
        this.transition = transition;

        // Set the start state
        this.startState = startState;

        // Set the accepting states
        this.acceptingStates = acceptingStates;

        // Initialize the states array based on the transition table length
        // Array to store the states of the DFA
        String[] states = new String[transition.length];

        // Generate state names (q0, q1, q2, ...) based on the number of transitions
        for (int i = 0; i < transition.length; i++) {
            states[i] = "q" + i;
        }
    }

    // Method to simulate the DFA on a given input string
    public boolean simulateDFA(String input) {
        // Start with the initial state
        int currentState = startState;

        // Loop through each character in the input string
        for (char c : input.toCharArray()) {
            int inputIndex = -1; // Initialize the input index as -1

            // Find the index of the current character in the alphabet array
            for (int i = 0; i < alphabet.length; i++) {
                if (c == alphabet[i].charAt(0)) {
                    inputIndex = i; // Match found, set inputIndex
                    break;
                }
            }

            // If the character is not in the alphabet, return false (invalid input)
            if (inputIndex == -1) {
                return false;
            }

            // Move to the next state based on the transition table
            currentState = transition[currentState][inputIndex];
        }

        // After processing the input string, check if the current state is an accepting state
        for (int state : acceptingStates) {
            if (currentState == state) {
                return true; // If the current state is accepting, return true
            }
        }

        // If none of the accepting states match the current state, return false
        return false;
    }
}
