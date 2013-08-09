package com.example.flights;



/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 11.07.13
 * Time: 9:54
 * To change this template use File | Settings | File Templates.
 */
public class flight {
    String ldate, ltime, adate, atime, rldate, rltime, radate, ratime, organiz;
    int cost;

    public flight(String ldate, String ltime, String adate, String atime, String rldate, String rltime, String radate, String ratime, String organiz, int cost) {
        super();
        this.adate = adate;
        this.atime = atime;
        this.cost = 0;
        this.ldate = ldate;
        this.ltime = ltime;
        this.organiz = organiz;
        this.radate = radate;
        this.ratime = ratime;
        this.rldate = rldate;
        this.rltime = rltime;
    }

    public String getldate() {
        return ldate;
    }

    public void setldate(String ldate) {
        this.ldate = ldate;
    }

    public String getltime() {
        return ltime;
    }

    public void setltime(String ltime) {
        this.ltime = ltime;
    }
    public String getatime() {
        return atime;
    }

    public void setatime(String atime) {
        this.atime = atime;
    }
    public String getadate() {
        return adate;
    }

    public void setadate(String adate) {
        this.adate = adate;
    }
    public String getrldate() {
        return rldate;
    }

    public void setrldate(String rldate) {
        this.rldate = rldate;
    }
    public String getrltime() {
        return rltime;
    }

    public void setrltime(String rltime) {
        this.rltime = rltime;
    }
    public String getradate() {
        return radate;
    }

    public void setradate(String radate) {
        this.radate = radate;
    }
    public String getratime() {
        return ratime;
    }

    public void setratime(String ratime) {
        this.ratime = ratime;
    }
    public String getorganiz() {
        return organiz;
    }

    public void setorganiz(String organiz) {
        this.organiz = organiz;
    }
    public int getcost() {
        return cost;
    }

    public void setcost(int cost) {
        this.cost = cost;
    }
}
