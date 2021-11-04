package inheritance;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    private int index;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String el){
        this.data.add(el);
        index++;
    }

    public String peek(){
        return this.data.get(this.index);
    }

    public String pop(){
        return this.data.remove(index--);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
