// url: leetcode.com/problems/design-browser-history/

class BrowserHistory {

    Stack<String> pages;
    Stack<String> visited;
    
    public BrowserHistory(String homepage) {
        pages = new Stack<String>();
        visited = new Stack<String>();
        pages.push(homepage);
    }
    
    public void visit(String url) {
        pages.push(url);
        while(!visited.isEmpty())
            visited.pop();
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps; i++) {
            if(pages.size() == 1)
                return pages.peek();
            visited.push(pages.pop());
        }
        return pages.peek();
    }
    
    public String forward(int steps) {
        for(int i = 0; i < steps; i++) {
            if(visited.isEmpty())
                return pages.peek();
            pages.push(visited.pop());
        }
        return pages.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
