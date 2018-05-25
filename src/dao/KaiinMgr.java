package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import domain.SexEnum;
//import data.Kaiin;
import vo.KaiinVo;

public class KaiinMgr extends Dao{

    public KaiinMgr(Connection con) {
        super(con);
    }

    final static String INSERT_SQL = "INSERT INTO " +
            "kaiin " +
            "( kaiinNum " +
            ",kaiinname " +
            ",tourokubi  " +
            ",sex )"+
            "VALUES (?, ?, ?, ?);";

    final static String SEARCH_SQL = "SELECT " +
            "* " +
            "FROM " +
            "kaiin " +
            "WHERE " +
            "kaiinNum = ?;";

    final static String ALL_SQL = "SELECT " +
            "* " +
            "FROM " +
            "kaiin ;";

    // 会員登録
//	public void addKaiin(Kaiin k, Connection con) throws SQLException {
//
//		PreparedStatement stmt = null;
//
//		try {
//			/* Statkentの作成 */
//			stmt = con.prepareStatement(INSERT_SQL);
//
//			stmt.setInt		(1, k.getId());
//			stmt.setString	(2, k.getName());
//			stmt.setDate	(3, new java.sql.Date(k.getRegistDate().getTime()));
//			@SuppressWarnings("unused")
//			int num=stmt.executeUpdate();
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//			System.out.println("入力した会員番号は既に使用されています");
//		}
//
//	}

    // idから会員情報を表示
    public KaiinVo searchKaiin(int i) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        KaiinVo k = new KaiinVo();

        try {

            /* Statkentの作成 */
            stmt = con.prepareStatement(SEARCH_SQL);
            //検索するIDを登録
            stmt.setInt(1, i);

            /* ｓｑｌ実行 */
            rset = stmt.executeQuery();

            /* 取得したデータをKaiinVoに登録 */
            while (rset.next()) {

                //k.setkployeeid(rset.getInt("kPLOYEEID") );
                k.setKaiinnum		(rset.getInt(1));
                k.setKaiinname		(rset.getString(2));
                k.setTourokubi		(rset.getDate(3));
                //kaiinVoにSQLの結果
                k.setSe			(SexEnum.valueOf(rset.getString(4)) );
                //Systk.out.println(rset.getString(1));
            }
        }

        catch (SQLException e) {
            throw e;
        }

        return k;
    }
    public void registKaiin(KaiinVo kv) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {

            /* Statkentの作成 */
            stmt = con.prepareStatement(INSERT_SQL);

            stmt.setInt		(1, kv.getKaiinnum());
            stmt.setString	(2, kv.getKaiinname());
            stmt.setDate	(3, kv.getTourokubi());
            stmt.setString	(4, kv.getSe().name());
            @SuppressWarnings("unused")
            int num=stmt.executeUpdate();

        }
        catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("入力した会員番号は既に使用されています");
        }
    }
    public List<KaiinVo> getListOut() throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rset = null;

        List<KaiinVo>kvList=new ArrayList<KaiinVo>();
        try {

            /* Statkentの作成 */
            stmt = con.prepareStatement(ALL_SQL);

            /* ｓｑｌ実行 */
            rset = stmt.executeQuery();

            /* 取得したデータを表示します。 */
            while (rset.next()) {
                KaiinVo k = new KaiinVo();
                //k.setkployeeid(rset.getInt("kPLOYEEID") );
                k.setKaiinnum		(rset.getInt(1));
                k.setKaiinname		(rset.getString(2));
                k.setTourokubi		(rset.getDate(3));
                k.setSe			(SexEnum.valueOf(rset.getString(4)) );

                //Systk.out.println(rset.getString(1));
                kvList.add(k);
            }
        }

        catch (SQLException e) {
            throw e;
        }

        return kvList;
    }

    // 会員情報を全件取得
//	public List<Kaiin> allKaiin(Connection con) throws SQLException {
//
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//
//		List<Kaiin> list = new ArrayList<Kaiin>();
//
//		try {
//
//			/* Statkentの作成 */
//			stmt = con.prepareStatement(ALL_SQL);
//
//			/* ｓｑｌ実行 */
//			rset = stmt.executeQuery();
//
//			/* 取得したデータを表示します。 */
//			while (rset.next()) {
//				Kaiin k = new Kaiin();
//				k.setId			(rset.getInt(1));
//				k.setName		(rset.getString(2));
//				k.setRegistDate	(rset.getDate(3));
//				list.add(k);
//
//			}
//		}
//
//		catch (SQLException e) {
//			throw e;
//		}
//
//		return list;
//
//	}

}