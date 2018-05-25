package bean;

import java.util.ArrayList;
import java.util.List;

public class ListOutBean {
	public List<KaiinListBean> kList=new ArrayList<KaiinListBean>();
	public void setKaiin(KaiinListBean klb)
	{
		kList.add(klb);
	}
}
