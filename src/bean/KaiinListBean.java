package bean;

import java.util.Date;

import domain.SexEnum;

public class KaiinListBean {
	private int kaiinId;
	private String kaiinName;
	private Date tourokubi;
	private String sex;
	private SexEnum sexEnum;
	public int getKaiinId() {
		return kaiinId;
	}
	public void setKaiinId(int kaiinId) {
		this.kaiinId = kaiinId;
	}
	public String getKaiinName() {
		return kaiinName;
	}
	public void setKaiinName(String kaiinName) {
		this.kaiinName = kaiinName;
	}
	public Date getTourokubi() {
		return tourokubi;
	}
	public void setTourokubi(Date tourokubi) {
		this.tourokubi = tourokubi;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public SexEnum getSexEnum() {
		return sexEnum;
	}
	public void setSexEnum(SexEnum sexEnum) {
		this.sexEnum = sexEnum;
	}
	public String getString()
	{
		return kaiinId+":"+kaiinName+":"+tourokubi;
	}
}
