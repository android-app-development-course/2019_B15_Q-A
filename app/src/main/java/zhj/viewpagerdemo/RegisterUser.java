package zhj.viewpagerdemo;

import android.content.Intent;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class RegisterUser extends BmobObject {
    private String registerName;
    private String registerPassword;
    private String lingyu;
    private Integer xinyong;
    private  Integer money;

    public String getLingyu() {
        return lingyu;
    }

    public void setLingyu(String lingyu) {
        this.lingyu = lingyu;
    }

    public Integer getXinyong() {
        return xinyong;
    }

    public void setXinyong(Integer xinyong) {
        this.xinyong = xinyong;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    /*private BmobFile Picture;
    public BmobFile getPicture() {
        return Picture;
    }

    public void setPicture(BmobFile picture) {
        Picture = picture;
    }*/

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }
}

