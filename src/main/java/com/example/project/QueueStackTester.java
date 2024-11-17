package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {	
    	if(q.length() < 1)
    		return;
    	if(oq.length() <= eq.length())
    		oq.enqueue(q.serve());
    	else {
    		eq.enqueue(q.serve());
    	}
    		
    	split(q , oq ,eq);
    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {	
    	
    	LinkedPQ<T> tempQueue = new LinkedPQ<T>();
    	PQElement<T> tempData;
    	
    	while(pq.length() != 0) {
    		if((tempData = pq.serve()).p >= p )
    			tempQueue.enqueue(tempData.data, tempData.p);
    	}
    	
    	
    	
    	while(tempQueue.length() != 0) {
    		tempData = tempQueue.serve();
    		pq.enqueue(tempData.data, tempData.p);
    	}
    	
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
        if(st.empty())
        	return false;
        
        T temp = st.pop();
        if(e.equals(temp)) {
        	st.push(temp);
        	return true;
        }
        	
        
        boolean isFound = search(st,e);
        
        st.push(temp);
        return isFound;
 
    }
    public static <T> void moveToEnd(List<T> l , int i) {
    	l.findFirst();
    	
    	for(int j = 0 ; j < i ; j++) {
    		if(l.last())
    			return;
    		l.findNext();
    	}
    	T tmp = l.retrieve();
    	l.remove();
    	
    	while(!l.last()) {
    		l.findNext();
    	}
    	
    	l.insert(tmp);
    	
    }
}