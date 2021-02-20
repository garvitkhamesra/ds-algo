package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Activity {
    static class act {
        int st;
        int end;

        public act(int i, int i1) {
            st = i;
            end = i1;
        }
    }

    static int activitySelection(int start[], int end[], int n) {
        act[] acts = new act[n];
        for (int j = 0; j < n; j++) {
            acts[j] = new act(start[j], end[j]);
        }
        Arrays.sort(acts, Comparator.comparingInt(c -> c.end));
        int i=0, res = 1;
        for (int j = 1; j < n; j++) {
            if (acts[j].st >= acts[i].end) {
                res++;
                i = j;
            }
        }
        return res;
    }
}