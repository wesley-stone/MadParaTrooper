package main.model;

import shamir.Box;
import shamir.Key;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by wesley shi on 2017/6/13.
 */
public class Equipment implements Serializable{
    String id;
    Box box;
    Key key;
    String description;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    String state;

    public enum State{
        Open("open"),
        Close("close");
        String value;
        State(String val){
            value = val;
        }
        public String getValue(){
            return value;
        }
    }

    public Equipment(String id, Box box, Key key, String description) {
        this.id = id;
        this.description = description;
        this.box = box;
        this.key = key;

    }

    public boolean tryUnlock(Collection<Key> keys){
        int people = keys.size();
        Key[] param = keys.toArray(new Key[people]);
        return box.unLock(people, param);
    }

    public Key getKey() {
        return key;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return id + " " + description;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof Equipment)){
            return false;
        }
        Equipment e = (Equipment)o;
        return e.id.equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
