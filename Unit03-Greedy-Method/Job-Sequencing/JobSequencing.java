import java.util.Arrays;
import java.util.Scanner;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void jobSequencing(Job[] jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int totalProfit = 0;
        int jobsDone = 0;

        // Place each job in the latest available slot
        for (Job job : jobs) {
            for (int slot = job.deadline; slot > 0; slot--) {
                if (slots[slot] == -1) {
                    slots[slot] = job.id;
                    totalProfit += job.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        System.out.println("\nScheduled Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != -1) {
                System.out.print("J" + slots[i] + " ");
            }
        }

        System.out.println("\nTotal Jobs Completed: " + jobsDone);
        System.out.println("Maximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter deadline and profit for Job " + (i + 1) + ":");
            int deadline = sc.nextInt();
            int profit = sc.nextInt();

            jobs[i] = new Job(i + 1, deadline, profit);
        }

        jobSequencing(jobs);

        sc.close();
    }
}