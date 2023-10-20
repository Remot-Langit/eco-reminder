package model;

import java.util.ArrayList;

public class ListChallange {
    private ArrayList<Challange> listChallange;

    public ListChallange() {
        this.listChallange = new ArrayList<Challange>();
    }

    public void addChallange(Challange challange) {
        this.listChallange.add(challange);
    }

    @Override
    public String toString() {
        String res = "";
        for (Challange c: this.listChallange) {
            res += c.toString();
        }
        return res;
    }
}
