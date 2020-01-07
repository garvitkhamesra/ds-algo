package trees;

/**
 * Created by dot on 7/1/20 11:00 AM
 * Package: trees
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = helper(nums, 0, nums.length-1);
        return head;
    }
    public TreeNode helper(int[] nums, int l, int r) {
        if(l>r)return null;
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,l,mid-1);
        node.right = helper(nums,mid+1,r);
        return node;
    }
}
