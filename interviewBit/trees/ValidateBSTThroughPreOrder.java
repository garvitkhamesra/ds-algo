package trees;

import java.util.Stack;

public class ValidateBSTThroughPreOrder {
    public void check(int []pre, int lr, int rr, int []i){
        int idx = i[0];

        if(idx>=pre.length){
            return;
        }

        if(pre[idx] > lr && pre[idx] < rr){
            i[0]++;

            check(pre,lr,pre[idx],i);
            check(pre,pre[idx],rr,i);
        }
    }


    public int solve(int[] A) {
        int []i = new int[1];
        check(A,(int)-1e9,(int)1e9,i);
        return i[0] == A.length? 1:0;
    }

    /*
    *
    *
    * void makeBST(vector<int>& A, int &index, int low, int high){

    if(index >= A.size()) return; //preorder vector exhausted, means whole tree can be created

    if(A[index] <= low || A[index] >= high) return; // it means element cannot be pushed to either left or right

                                                    // by returning checking for parent node, to push element at right

    int root = A[index]; // value of root for limits

    index++;

    makeBST(A, index, low, root); //left call, higher limit will be root's data

    makeBST(A, index, root, high); //right call, lower limit will be root's data

}
* */
}
