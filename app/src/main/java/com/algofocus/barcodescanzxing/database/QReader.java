package com.algofocus.barcodescanzxing.database;

/**
 * Created by Ramon on 7/31/2016.
 */
public class QReader {
    private int id;
    private String info;
    QReader(){

    }
   public QReader(int id , String info){

        this.id=id;
        this.info=info;
    }
    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
