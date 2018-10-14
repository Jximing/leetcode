package myhash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangliuhong
 * @since TODO
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
