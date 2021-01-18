class FrontMiddleBackQueue {
    LinkedList<Integer> deque; 
    public FrontMiddleBackQueue() {
        deque = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        deque.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        deque.add(deque.size()/2, val);
    }
    
    public void pushBack(int val) {
        deque.addLast(val);
    }
    
    public int popFront() {
        return deque.isEmpty() ? -1:deque.removeFirst();
    }
    
    public int popMiddle() {
        return deque.isEmpty() ? -1:deque.remove((deque.size()-1)/2);
    }
    
    public int popBack() {
        return deque.isEmpty() ? -1:deque.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
