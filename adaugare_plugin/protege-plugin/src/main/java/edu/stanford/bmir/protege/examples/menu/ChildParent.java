package edu.stanford.bmir.protege.examples.menu;

/**
 * Created by Onu on 1/13/2018.
 */
public class ChildParent {
    public String child;
    public String father;
    public ChildParent(){};
    public ChildParent(String child, String father){
        this.child = child;
        this.father = father;
    }
    public void setChild(String child){
        this.child=child;
    }
    public void setFather(String father){
        this.father=father;
    }
    public String getChild(){
        return this.child;
    }
    public String getFather(){
        return this.father;
    }
    public String toString() {
        return "Child: '" + this.child + "', Father: '" + this.father + "'";
    }
}
