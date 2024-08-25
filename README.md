# DFA and NFA Simulation

## Overview

This project simulates various Deterministic Finite Automata (DFA) and Nondeterministic Finite Automata (NFA) based on problem numbers specified in an input file. The results of the simulations are written to an output file.

## Problem Specifications

Each problem involves designing a DFA or NFA to recognize specific patterns or properties in strings. The problems are identified by problem numbers, and the specific requirements for each problem are detailed below:

1. **DFA for Strings Not Containing "ba"**:
   - **Alphabet**: {a, b}
   - **Description**: Accepts all strings that do not contain the substring "ba".

2. **DFA for Strings with Even Number of '0's Followed by a Single '1'**:
   - **Alphabet**: {0, 1}
   - **Description**: Accepts all strings that contain an even number of '0's followed by a single '1'.

3. **DFA for Strings with Odd Number of 'x's**:
   - **Alphabet**: {x, y}
   - **Description**: Accepts all strings that contain an odd number of 'x's.

4. **DFA for Strings Starting and Ending with the Same Character**:
   - **Alphabet**: {a, b}
   - **Description**: Accepts strings that start and end with the same character.

5. **DFA for Binary Strings Divisible by 4**:
   - **Alphabet**: {0, 1}
   - **Description**: Accepts binary strings that represent integers divisible by 4.

6. **DFA for Strings Except "11" and "111"**:
   - **Alphabet**: {0, 1}
   - **Description**: Accepts all strings except those that contain the substrings "11" or "111".

7. **NFA for Equal Occurrences of "01" and "10"**:
   - **Alphabet**: {0, 1, E}
   - **Description**: Accepts all strings containing an equal number of occurrences of "01" and "10".

8. **NFA for Strings Containing Substring "101" or "010"**:
   - **Alphabet**: {0, 1, E}
   - **Description**: Accepts all strings that contain either the substring "101" or "010".

9. **NFA for Strings with No Two Consecutive Characters the Same**:
   - **Alphabet**: {0, 1, E}
   - **Description**: Accepts all strings where no two consecutive characters are the same.

10. **NFA for Strings Where Every '0' is Followed by at Least One '1'**:
    - **Alphabet**: {0, 1, E}
    - **Description**: Accepts all strings where every '0' is followed by at least one '1'.


