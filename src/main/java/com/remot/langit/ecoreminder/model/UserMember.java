package com.remot.langit.ecoreminder.model;

import com.remot.langit.ecoreminder.utils.CapaianDAO;
import java.util.UUID;

/**
 *
 * @author WIN 10
 */
public class UserMember extends User {
    private int point;

    public UserMember(String username, String nama, String email, String password) {
        super(username, nama, email, password);
        this.point = 0;
    }

    public UserMember(UUID id,  String username, String nama, String email, String password, int point) {
        super(id, username, nama, email, password);
        this.point = point;
    }

    public void addCapaian(Challange challange) {
        var db = new CapaianDAO();
        db.insert(this, challange);
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int addPoint(int point) {
        this.point += point;
        return this.point;
    }

    public int getPoint() {
        return point;
    }

    // TODO
    public void getProfile() {

    }

}

