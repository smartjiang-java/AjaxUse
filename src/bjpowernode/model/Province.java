package bjpowernode.model;

/**
 * ClassName :Province
 * Package :bjpowernode.model
 * Description:
 *
 * @Date :2020-05-21
 * @Author:Jqk
 */
public class Province {

    private Integer id;
    private String name;
    private String jiancheng;
    private String shenghui;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }
}
