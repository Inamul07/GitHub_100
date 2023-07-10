package GoogleFoobar;

import java.math.BigInteger;

class Solution3 {

    private static long multiplier(long a, long b) {
        long diff = a - b;
        return (diff / b) + 1;
    }

    public static String solution(String x, String y) {
        /*
         * if((x.charAt(x.length()-1)-'0')%2 == 0 && (y.charAt(y.length()-1)-'0')%2 ==
         * 0) return "impossible";
         * BigInteger n1 = new BigInteger(x), n2 = new BigInteger(y);
         * long steps = 0;
         * while(true) {
         * if(n1.compareTo(new BigInteger("0")) <= 0 || n1.compareTo(new
         * BigInteger("0")) <= 0) break;
         * if(n1.compareTo(new BigInteger("100")) > 0 || n1.compareTo(new
         * BigInteger("100")) > 0) {
         * if(n1.compareTo(n2) > 0) {
         * BigInteger diff = n1.subtract(n2), mul = (diff.divide(n2)).add(new
         * BigInteger("1"));
         * n1 = n1.subtract(n2.multiply(mul));
         * steps += mul.longValue();
         * } else if(n2.compareTo(n1) > 0) {
         * BigInteger diff = n2.subtract(n1), mul = (diff.divide(n1)).add(new
         * BigInteger("1"));
         * n2 = n2.subtract(n1.multiply(mul));
         * steps += mul.longValue();
         * } else break;
         * } else {
         * if(n1.compareTo(n2) > 0) n1 = n1.subtract(n2);
         * else if(n2.compareTo(n1) > 0) n2 = n2.subtract(n1);
         * else break;
         * steps++;
         * }
         * }
         * if(!n1.equals(new BigInteger("1")) || !n2.equals(new BigInteger("1"))) return
         * "impossible";
         * return steps + "";
         */
        long step = 0L, m = Long.parseLong(x), f = Long.parseLong(y);
        while (true) {
            if (m <= 0 || f <= 0)
                break;
            if (m > 100 || f > 100) {
                if (m > f) {
                    long mul = Solution3.multiplier(m, f);
                    m -= f * mul;
                    step += mul;
                } else if (f > m) {
                    long mul = Solution3.multiplier(f, m);
                    f -= m * mul;
                    step += mul;
                } else {
                    break;
                }
            } else {
                if (m > f)
                    m -= f;
                else if (f > m)
                    f -= m;
                else
                    break;
                step += 1;
            }
        }

        if (m == 1 && f == 1 && step >= 0) {
            return Long.toString(step);
        }
        return "impossible";
    }
}

public class BombBaby {
    public static void main(String[] args) {
        System.out.println(Solution3.solution("7", "4"));
    }
}

/*
 * You're so close to destroying the LAMBCHOP doomsday device you can taste it!
 * But in order to do so, you need to deploy special self-replicating bombs
 * designed for you by the brightest scientists on Bunny Planet. There are two
 * types: Mach bombs (M) and Facula bombs (F). The bombs, once released into the
 * LAMBCHOP's inner workings, will automatically deploy to all the strategic
 * points you've identified and destroy them at the same time.
 * 
 * But there's a few catches. First, the bombs self-replicate via one of two
 * distinct processes:
 * Every Mach bomb retrieves a sync unit from a Facula bomb; for every Mach
 * bomb, a Facula bomb is created;
 * Every Facula bomb spontaneously creates a Mach bomb.
 * 
 * For example, if you had 3 Mach bombs and 2 Facula bombs, they could either
 * produce 3 Mach bombs and 5 Facula bombs, or 5 Mach bombs and 2 Facula bombs.
 * The replication process can be changed each cycle.
 * 
 * Second, you need to ensure that you have exactly the right number of Mach and
 * Facula bombs to destroy the LAMBCHOP device. Too few, and the device might
 * survive. Too many, and you might overload the mass capacitors and create a
 * singularity at the heart of the space station - not good!
 * 
 * And finally, you were only able to smuggle one of each type of bomb - one
 * Mach, one Facula - aboard the ship when you arrived, so that's all you have
 * to start with. (Thus it may be impossible to deploy the bombs to destroy the
 * LAMBCHOP, but that's not going to stop you from trying!)
 * 
 * You need to know how many replication cycles (generations) it will take to
 * generate the correct amount of bombs to destroy the LAMBCHOP. Write a
 * function answer(M, F) where M and F are the number of Mach and Facula bombs
 * needed. Return the fewest number of generations (as a string) that need to
 * pass before you'll have the exact number of bombs necessary to destroy the
 * LAMBCHOP, or the string "impossible" if this can't be done! M and F will be
 * string representations of positive integers no larger than 10^50. For
 * example, if M = "2" and F = "1", one generation would need to pass, so the
 * answer would be "1". However, if M = "2" and F = "4", it would not be
 * possible.
 */