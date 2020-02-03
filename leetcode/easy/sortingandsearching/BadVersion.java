package sortingandsearching;

/**
 * Created by dot on 10/1/20 9:43 PM
 * Package: sortingandsearching
 */
public class BadVersion {
    public int firstBadVersion(int n) {
        return badVersion(1,n);
    }

    public int badVersion(int l, int r) {
        int mid = l + (r - l) / 2;
        if(!isBadVersion(mid-1) && isBadVersion(mid)) return mid;
        if (isBadVersion(mid)) return badVersion(l, mid-1);
        else return badVersion(mid+1, r);
    }

    private boolean isBadVersion(int i) {
        return false;
    }

}
