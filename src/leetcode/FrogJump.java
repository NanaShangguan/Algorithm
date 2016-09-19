package leetcode;

/**
 * Created by t-nashan on 9/19/2016.
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        boolean[] canReach = new boolean[stones.length];
        doJump(stones, 1, 1, canReach);
        return canReach[stones.length - 1];
    }

    void doJump(int[] stones, int curStoneIndex, int lastJumpUnit, boolean[] canReach) {
        if (canReach[stones.length - 1]) return;
        if (curStoneIndex >= stones.length) return;
        canReach[curStoneIndex] = true;
        //k
        int nextIndex = curStoneIndex + 1;
        while (nextIndex < stones.length
                && stones[nextIndex] - lastJumpUnit < stones[curStoneIndex]) nextIndex++;
        if (nextIndex < stones.length)
        {
            if (stones[nextIndex] - lastJumpUnit == stones[curStoneIndex])
                doJump(stones, nextIndex, lastJumpUnit, canReach);
            //k + 1
            else if (stones[nextIndex] - (lastJumpUnit + 1) == stones[curStoneIndex])
                doJump(stones, nextIndex, lastJumpUnit + 1, canReach);
            //k + 1
            if (nextIndex < stones.length - 1 && stones[nextIndex + 1] - (lastJumpUnit + 1) == stones[curStoneIndex])
                doJump(stones, nextIndex + 1, lastJumpUnit + 1, canReach);
        }
        //k - 1
        if (lastJumpUnit > 1 && stones[nextIndex - 1] - (lastJumpUnit - 1) == stones[curStoneIndex])
            doJump(stones, nextIndex - 1, lastJumpUnit - 1, canReach);
    }

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[]{0,1,3,4,5,7,9,10,12}));
    }
}
