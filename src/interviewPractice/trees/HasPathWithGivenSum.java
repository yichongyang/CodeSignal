package interviewPractice.trees;

/**
 * Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values
 * equals s.
 *
 * Example
 *
 * For
 *
 * t = {
 *     "value": 4,
 *     "left": {
 *         "value": 1,
 *         "left": {
 *             "value": -2,
 *             "left": null,
 *             "right": {
 *                 "value": 3,
 *                 "left": null,
 *                 "right": null
 *             }
 *         },
 *         "right": null
 *     },
 *     "right": {
 *         "value": 3,
 *         "left": {
 *             "value": 1,
 *             "left": null,
 *             "right": null
 *         },
 *         "right": {
 *             "value": 2,
 *             "left": {
 *                 "value": -2,
 *                 "left": null,
 *                 "right": null
 *             },
 *             "right": {
 *                 "value": -3,
 *                 "left": null,
 *                 "right": null
 *             }
 *         }
 *     }
 * }
 * and
 * s = 7,
 * the output should be solution(t, s) = true.
 *
 * This is what this tree looks like:
 *
 *       4
 *      / \
 *     1   3
 *    /   / \
 *   -2  1   2
 *     \    / \
 *      3  -2 -3
 * Path 4 -> 3 -> 2 -> -2 gives us 7, the required sum.
 *
 * For
 *
 * t = {
 *     "value": 4,
 *     "left": {
 *         "value": 1,
 *         "left": {
 *             "value": -2,
 *             "left": null,
 *             "right": {
 *                 "value": 3,
 *                 "left": null,
 *                 "right": null
 *             }
 *         },
 *         "right": null
 *     },
 *     "right": {
 *         "value": 3,
 *         "left": {
 *             "value": 1,
 *             "left": null,
 *             "right": null
 *         },
 *         "right": {
 *             "value": 2,
 *             "left": {
 *                 "value": -4,
 *                 "left": null,
 *                 "right": null
 *             },
 *             "right": {
 *                 "value": -3,
 *                 "left": null,
 *                 "right": null
 *             }
 *         }
 *     }
 * }
 * and
 * s = 7,
 * the output should be solution(t, s) = false.
 *
 * This is what this tree looks like:
 *
 *       4
 *      / \
 *     1   3
 *    /   / \
 *   -2  1   2
 *     \    / \
 *      3  -4 -3
 * There is no path from root to leaf with the given sum 7.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [memory limit] 1 GB
 *
 * [input] tree.integer t
 *
 * A binary tree of integers.
 *
 * Guaranteed constraints:
 * 0 ≤ tree size ≤ 5 · 104,
 * -1000 ≤ node value ≤ 1000.
 *
 * [input] integer s
 *
 * An integer.
 *
 * Guaranteed constraints:
 * -4000 ≤ s ≤ 4000.
 *
 * [output] boolean
 *
 * Return true if there is a path from root to leaf in t such that the sum of node values in it is equal to s, otherwise return false.
 */
public class HasPathWithGivenSum {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>(4);
        tree.left = new Tree<Integer>(1);
        tree.left.left = new Tree<Integer>(-2);
        tree.left.right = new Tree<Integer>(3);
        tree.right = new Tree<Integer>(3);
        tree.right.left = new Tree<Integer>(1);
        tree.right.left.left = new Tree<Integer>(-2);
        tree.right.left.right = new Tree<Integer>(-3);
        tree.right.right = new Tree<Integer>(-3);
        tree.right.right.right = new Tree<Integer>(-1);
        solution(tree, 7);
    }

    static boolean solution(Tree<Integer> t, int s) {
        if (t == null) {
            return false;
        }
        if (t.left == null && t.right == null && t.value == s) {
            return true;
        }
        return solution(t.left, s - t.value) || solution(t.right, s - t.value);
    }

    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }
}
