package model;

import java.util.ArrayList;

public class ListEdukasi {
    private ArrayList<Edukasi> listEdukasi;

    public ListEdukasi() {
        this.listEdukasi = new ArrayList<Edukasi>();
    }

    public void addEdukasi(Edukasi edukasi) {
        this.listEdukasi.add(edukasi);
    }

    @Override
    public String toString() {
        String res = "";
        for (Edukasi edukasi : this.listEdukasi) {
            res += edukasi.toString();
        }
        return res;
    }
}
