package com.go.leet_code.eb;

/**
 * Description: 动态规划算法
 * Created on 2022/5/25.
 * 有三种硬币，分别面值2元，5元和7元，每种硬币都有足够多
 * <p>
 * 买一本书需要27元
 * <p>
 * 如何用最少的硬币组合正好付清，不需要对方找钱
 *
 * @author go
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 7, 5};
        int M = 27;
        int i = coinChange(coins, M);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param coins 代表硬币的种类
     * @param M     代表拼凑的值 27
     * @return
     */
    public static int coinChange(int[] coins, int M) {
        int[] f = new int[M + 1];
        //number of kinds of coins
        int n = coins.length;
        //initialization
        f[0] = 0;

        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            //f[X]=min{f[X-2]+1,f[X-5]+1,f[X-7]+1}
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            return -1;
        }

        return f[M];

    }

}
