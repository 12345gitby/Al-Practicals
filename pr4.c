#include <stdio.h>
#include <string.h>

#define MAX_PRODUCTIONS 10
#define MAX_PROD_LEN 20

void eliminateLeftRecursion(char nonTerm, char productions[MAX_PRODUCTIONS][MAX_PROD_LEN], int numProductions) {
    int i;
    for (i = 0; i < numProductions; i++) {
        if (productions[i][0] == nonTerm) {
            // A -> Aα becomes A -> βA', A' -> αA' | ε
            char newNonTerm = nonTerm + 1;
            printf("%c -> %s%c'\n", nonTerm, productions[i] + 1, nonTerm);
            printf("%c' -> ", nonTerm);
            while (productions[i][0] == nonTerm) {
                printf("%s%c' | ", productions[i] + 1, nonTerm);
                i++;
            }
            printf("ε\n");
            i--; // Adjust i to process the current production again
        } else {
            printf("%c -> %s\n", nonTerm, productions[i]);
        }
    }
}

int main() {
    char nonTerm;
    char productions[MAX_PRODUCTIONS][MAX_PROD_LEN];
    int numProductions;

    printf("Enter non-terminal: ");
    scanf(" %c", &nonTerm);

    printf("Enter number of productions: ");
    scanf("%d", &numProductions);

    printf("Enter productions:\n");
    for (int i = 0; i < numProductions; i++) {
        scanf("%s", productions[i]);
    }

    printf("\nGrammar without left recursion:\n");
    eliminateLeftRecursion(nonTerm, productions, numProductions);

    return 0;
}
