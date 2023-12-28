# url: https://leetcode.com/problems/string-compression-ii/

class Solution(object):
    def getLengthOfOptimalCompression(self, s, k):

        map = {}
        
        def dp(i, k, prev, prevCount):

            if (i, k, prev, prevCount) in map:
                return map[(i, k, prev, prevCount)]

            if k < 0:
                return float("inf")
            if i == len(s):
                return 0

            if s[i] == prev:
                inc = 1 if prevCount == 1 or prevCount == 9 or prevCount == 99 else 0
                res = inc + dp(i+1, k, prev, prevCount+1)
            else:
                res = min(dp(i+1, k-1, prev, prevCount), 1 + dp(i+1, k, s[i], 1))

            map[(i, k, prev, prevCount)] = res
            return res
        
        return dp(0, k, '0', 0)
