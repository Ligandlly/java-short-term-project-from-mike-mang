package user;

import java.io.Serializable;

public class User implements Serializable{
    // 用户类

    public String card;  // 一卡通
    public String name;  // 姓名 
    public String identity;  // 身份

    public User(String card, String name, String identity){
        this.card = card;
        this.name = name;
        this.identity = identity;
    }

	public User() {
	}
}