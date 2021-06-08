package dao.media;

import entity.db.AIMSDB;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class MediaDAO {
	//Data coupling
	//Communicational conhesion vi getAllMedia va getMediaById cung tra ve  1 list cac media (cung tra ve 1 du lieu dau ra)
    public List getAllMedia() throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Media");
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media(
                    res.getInt("id"),
                    res.getString("title"),
                    res.getInt("quantity"),
                    res.getString("category"),
                    res.getString("imageUrl"),
                    res.getInt("price"),
                    res.getString("type"));
            medium.add(media);
        }
        return medium;
    }
  //Communicational conhesion vi getAllMedia va getMediaById cung tra ve  1 list cac media (cung tra ve 1 du lieu dau ra)
  //Data coupling
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM Media ;";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);

        if (res.next()) {
            return new Media(
                    res.getInt("id"),
                    res.getString("title"),
                    res.getInt("quantity"),
                    res.getString("category"),
                    res.getString("imageUrl"),
                    res.getInt("price"),
                    res.getString("type"));
        }
        return null;
    }
    //Procedural conhesion : vi phuong thuc updateMediaById duoc nhom lai 
    //vi theo 1 trinh tu la getMedia, updateMedia,(nhu la read, update, delete, create)
  //Data coupling
    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        if (value instanceof String){
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update Media set" + " "
                + field + "=" + value + " "
                + "where id=" + id + ";");
    }
}
