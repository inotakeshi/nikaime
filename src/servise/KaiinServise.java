package servise;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import bean.KaiinListBean;
import bean.ListOutBean;
import bean.RegistBean;
import bean.SerchBean;
import dao.Dao;
import dao.KaiinMgr;
import domain.SexEnum;
import vo.KaiinVo;

public class KaiinServise {

	//KaiinMgr mgr=new KaiinMgr();
	public SerchBean getSerch(int Id)
	{
		KaiinVo kv=null;
		SerchBean sb=new SerchBean();
		try (
				Connection con=Dao.getConnection();
			){
			KaiinMgr mgr=new KaiinMgr(con);
			kv= mgr.searchKaiin(Id);

			sb.setKaiinId(kv.getKaiinnum());
			sb.setKaiinName(kv.getKaiinname());
			sb.setTourokubi(kv.getTourokubi());
			sb.setSexEnum(SexEnum.valueOf(kv.getSex()));

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return sb;

	}
	public RegistBean setKaiin(int id,String name,String sex)
	{

		RegistBean rb=new RegistBean();
		try(Connection con=Dao.getConnection();
				) {

			KaiinMgr km=new KaiinMgr(con);
			KaiinVo kv=new KaiinVo();
			kv.setKaiinnum(id);
			kv.setKaiinname(name);
			kv.setTourokubi(new java.sql.Date(new Date().getTime()));
			kv.setSex(sex);

			km.registKaiin(kv);
			rb.setKaiinId(kv.getKaiinnum());
			rb.setKaiinName(kv.getKaiinname());
			rb.setTourokubi(kv.getTourokubi());
			rb.setSex(kv.getSex());
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return rb;
	}
	public ListOutBean getListKaiin()
	{
		ListOutBean lb=new ListOutBean();
		try(Connection con=Dao.getConnection();)
		{
			KaiinMgr mgr=new KaiinMgr(con);
			List<KaiinVo> returnList=mgr.getListOut();
			for(KaiinVo kv:returnList)
			{
				KaiinListBean klb=new KaiinListBean();
				klb.setKaiinId(kv.getKaiinnum());
				klb.setKaiinName(kv.getKaiinname());
				//klb.setSexEnum(klb.getSexEnum());
				klb.setTourokubi(klb.getTourokubi());

				lb.setKaiin(klb);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return lb;
	}
}
