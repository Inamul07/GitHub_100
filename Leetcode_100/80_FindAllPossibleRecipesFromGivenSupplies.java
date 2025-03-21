// url: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

class Solution {

    Map<String, Integer> iMap;
    Map<String, Boolean> cMap;
    String[] recipes;
    List<List<String>> ingredients;

    private boolean dfs(String r) {
        if(cMap.containsKey(r)) return cMap.get(r);
        if(!iMap.containsKey(r)) return false;
        cMap.put(r, false);
        for(String child: ingredients.get(iMap.get(r))) {
            if(!dfs(child)) {
                return false;
            }
        }
        cMap.put(r, true);
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        iMap = new HashMap<>();
        cMap = new HashMap<>();
        this.recipes = recipes;
        this.ingredients = ingredients;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++) iMap.put(recipes[i], i);
        for(String supply: supplies) cMap.put(supply, true);
        for(int i = 0; i < recipes.length; i++) if(dfs(recipes[i])) res.add(recipes[i]);
        return res;
    }
}
