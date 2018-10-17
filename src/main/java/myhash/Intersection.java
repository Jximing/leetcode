package myhash;

import java.util.Arrays;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        nums1 = sort(nums1);
        nums2 = sort(nums2);
        int i = 0, j = 0, length = 0;
        int[] res;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                while (nums2[j] == nums1[i]) {
                    j++;
                    if (j == nums2.length)
                        break;
                }
                nums1[length++] = nums1[i++];
            }
        }
        res = new int[length];
        for (int k = 0; k < length; k++) {
            res[k] = nums1[k];
        }
        return res;
    }

    private int[] sort(int[] nums1) {
        for (int i = 1; i < nums1.length; i++) {
            int temp = nums1[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums1[j] <= temp) {
                    break;
                }
                nums1[j + 1] = nums1[j];
            }
            nums1[j + 1] = temp;
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {9, 3, 7};
        int[] nums2 = {6, 4, 1, 0, 0, 4, 4, 8, 7};
        Intersection is = new Intersection();
        System.out.println(Arrays.asList(is.intersection(nums1, nums2)).stream());
    }
}
