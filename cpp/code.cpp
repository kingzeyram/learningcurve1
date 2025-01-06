#include <iostream>

constexpr char*  s = "011101";
class Solution {
public:
    int maxScore(string s) {
        int totalOnes = 0;
        int maxScore = 0;

        // Count the total number of '1's in the string
        for (char c : s) {
            if (c == '1') totalOnes++;
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;

        // Iterate through the string, considering splits (excluding the last character)
        for (int i = 0; i < s.size() - 1; i++) {
            if (s[i] == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate the score for the current split
            int currentScore = leftZeros + rightOnes;
            maxScore = max(maxScore, currentScore);
        }

        return maxScore;
    }
};
