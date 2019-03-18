package com.lesnyg.recyclerexam4.models;

public class Practice {
    String list;
    Class cls;

    public Practice(String list, Class cls) {
        this.list = list;
        this.cls = cls;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }
}
