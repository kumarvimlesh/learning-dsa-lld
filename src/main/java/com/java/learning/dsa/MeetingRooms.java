package com.java.learning.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.mostBooked(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}));
    }
    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        boolean[] oc = new boolean[n];
        meetings = Arrays.stream(meetings).sorted(Comparator.comparing(a-> a[0])).toArray(int[][]::new);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[1]!=b[1]){
                return a[1] - b[1];
            }
            else return a[2] - b[2];
        });
        for(int[] meeting : meetings){
            while (!priorityQueue.isEmpty() && (priorityQueue.peek() != null ? priorityQueue.peek()[1] : 0) <=meeting[0]){
                oc[priorityQueue.peek()[2]] = false;
                priorityQueue.poll();

            }
            if(ocupiedRooms(oc)>=n){
                int[] finishingMeeting = priorityQueue.poll();
                if (finishingMeeting!=null) {

                    int[] rescheduled = new int[]{finishingMeeting[1],finishingMeeting[1] + meeting[1] - meeting[0]};
                    priorityQueue.add(new int[]{rescheduled[0], rescheduled[1], finishingMeeting[2]});
                    ans[finishingMeeting[2]]++;
                }
            }
            else {
                int room = roomToOccupy(oc);
                priorityQueue.add(new int[]{meeting[0], meeting[1], room});
                ans[room]++;
                oc[room] = true;
            }
        }
        int lowInd = 0;
        for(int i = 1; i< n; i++){
            if(ans[i]>ans[lowInd]) lowInd = i;
        }
        return lowInd;
    }

    private int ocupiedRooms(boolean[] oc) {
        int count = 0;
        for (boolean o: oc){
            if (o) count++;
        }
        return count;
    }

    private int roomToOccupy(boolean[] oc) {
        for (int i = 0; i < oc.length; i++) {
            if (!oc[i]) return i;
        }
        return 0;
    }
}
