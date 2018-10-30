package com.edu.xc.pojo.user;

public class Card {
    private Integer id;

    private String cardno;

    private String fontimgurl;

    private String reverseimgurl;

    private String handimgurl;

    private Integer check;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getFontimgurl() {
        return fontimgurl;
    }

    public void setFontimgurl(String fontimgurl) {
        this.fontimgurl = fontimgurl == null ? null : fontimgurl.trim();
    }

    public String getReverseimgurl() {
        return reverseimgurl;
    }

    public void setReverseimgurl(String reverseimgurl) {
        this.reverseimgurl = reverseimgurl == null ? null : reverseimgurl.trim();
    }

    public String getHandimgurl() {
        return handimgurl;
    }

    public void setHandimgurl(String handimgurl) {
        this.handimgurl = handimgurl == null ? null : handimgurl.trim();
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }
}