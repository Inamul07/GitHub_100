# url: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

class Solution(object):
    def maximumCandies(self, candies, k):
        sum = 0
        for candy in candies:
            sum += candy
        if sum < k:
            return 0
        l = 1
        r = sum // k
        res = 1
        while l <= r:
            mid = l + (r - l) / 2
            comp = 0
            valid = False
            for candy in candies:
                comp += (candy // mid)
                if comp >= k:
                    valid = True
                    break
            if valid:
                res = mid
                l = mid + 1
            else:
                r = mid - 1
        return res
        
