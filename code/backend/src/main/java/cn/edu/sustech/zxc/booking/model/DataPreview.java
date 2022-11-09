package cn.edu.sustech.zxc.booking.model;


import javax.persistence.*;

@Entity
public class DataPreview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    private String misscnt;
    private String missrate;
    private String psi;
    private String woe;
    private String iv;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMisscnt() {
        return misscnt;
    }

    public void setMisscnt(String misscnt) {
        this.misscnt = misscnt;
    }

    public String getMissrate() {
        return missrate;
    }

    public void setMissrate(String missrate) {
        this.missrate = missrate;
    }

    public String getPsi() {
        return psi;
    }

    public void setPsi(String psi) {
        this.psi = psi;
    }

    public String getWoe() {
        return woe;
    }

    public void setWoe(String woe) {
        this.woe = woe;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public DataPreview() {
    }
}
