package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu May 24 15:42:03 JST 2018
 */
import java.io.Serializable;

import domain.SexEnum;

/**
 * KaiinVo.
 * @author takeshi.ino
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/24	takeshi.ino		Generated.
 */
public class KaiinVo implements Serializable{

    public static final String TABLE = "KAIIN";

    /**
     * kaiinNum:int(10) <Primary Key>
     */
    private int kaiinnum;

    /**
     * kaiinName:varchar(200)
     */
    private String kaiinname;

    /**
     * tourokubi:date(0)
     */
    private java.sql.Date tourokubi;

    /**
     * sex:varchar(45)
     */
    private String sex;

    private SexEnum se;

    public SexEnum getSe() {
        return se;
    }

    public void setSe(SexEnum se) {
        this.se = se;
    }

    /**
    * Constractor
    */
    public KaiinVo(){}

    /**
    * Constractor
    * @param <code>kaiinnum</code>
    */
    public KaiinVo(int kaiinnum){
        this.kaiinnum = kaiinnum;
    }

    public int getKaiinnum(){ return this.kaiinnum; }

    public void setKaiinnum(int kaiinnum){ this.kaiinnum = kaiinnum; }

    public String getKaiinname(){ return this.kaiinname; }

    public void setKaiinname(String kaiinname){ this.kaiinname = kaiinname; }

    public java.sql.Date getTourokubi(){ return this.tourokubi; }

    public void setTourokubi(java.sql.Date tourokubi){ this.tourokubi = tourokubi; }

    public String getSex(){ return sex; }

    public void setSex(String sex){ this.sex=sex; }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[KaiinVo:");
        buffer.append(" kaiinnum: ");
        buffer.append(kaiinnum);
        buffer.append(" kaiinname: ");
        buffer.append(kaiinname);
        buffer.append(" tourokubi: ");
        buffer.append(tourokubi);
        buffer.append(" sex: ");
        buffer.append(sex);
        buffer.append("]");
        return buffer.toString();
    }

}
