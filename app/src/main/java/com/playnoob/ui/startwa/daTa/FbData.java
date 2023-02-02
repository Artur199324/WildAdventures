package com.playnoob.ui.startwa.daTa;

import com.playnoob.ui.startwa.Wdka;

public class FbData {

    private String dom;
    private String deep;

    public String getDom() {
        Wdka wdka = new Wdka();
        return wdka.getDd();
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getFdata(){
        return "&yyyrrrbbnmklllpo=" +getDeep();
    }
}
