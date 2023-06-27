import javax.sound.midi.SysexMessage;
import java.util.*;
public class test {

    class pair implements  Comparable<pair>
    {
        int sum,u,v;
        pair(int ui, int vi, int sumi)
        {
            u = ui;
            v = vi;
            sum = sumi;
        }

        @Override
        public int compareTo(pair o) {
            if(this.sum < o.sum)
                return -1;
            return  1;
        }
    }



    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<pair> pq = new PriorityQueue<pair>();
        int cnt = 0;
        int i =0, j =0;
        int size = nums1.length;
        int size2 = nums2.length;

        while(cnt < k)
        {
            for(int ji = j; ji < size2 ;ji++)
            {
                pq.add(new pair(nums1[i], nums2[ji], nums1[i]+nums2[ji]) );
            }


            i++;
            for(int ii = i; ii<size ;ii++)
            {
                pq.add(new pair(nums1[ii], nums2[j], nums1[ii]+nums2[j]) );
            }
            j++;






        }


        return  res;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        int costs[]=  new int[n];
        for(int i = 0;i<n;i++)
            costs[i]= sc.nextInt();

        int can = sc.nextInt();

        for(int i : costs)
            System.out.print(i +"\t");
        System.out.println();



        long ans = new test().totalCost(costs, k, can);
        System.out.println("Answer: "+ans);
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();

        // headWorkers stores the first k workers.
        // tailWorkers stores at most last k workers without any workers from the first k workers.
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();

                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            }

            else {
                answer += tailWorkers.poll();

                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return answer;


    }





}
