import java.util.*;


public class VaccinationSchedule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int N = scanner.nextInt();
        int[] villages = new int[N];

        for (int i = 0; i < N; i++) {
            villages[i] = scanner.nextInt();
        }

        int result = findMinimumTime(m1, m2, villages);
        System.out.println(result);
    }

    private static int findMinimumTime(int m1, int m2, int[] villages) {
        Arrays.sort(villages);
        int totalMinutes = 0;
        int n = villages.length;
        int i = n - 1;

        while (i >= 0) {
            if (m1 <= m2) {
                totalMinutes += villages[i] * m1;
                i--;
            } else {
                totalMinutes += villages[i] * m2;
                i--;
                if (i >= 0) {
                    totalMinutes += villages[i] * m2;
                    i--;
                }
            }
        }

        return totalMinutes;
    }
}
