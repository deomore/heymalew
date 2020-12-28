package Lab.DAO;

import Lab.Mod.GoodsM;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDAO {
    private final DataSource ds = new MysqlDataSource();
    private  final String user = "root";
    private final String password = "Z1s2e3";

    public  GoodsDAO(){
}


    public GoodsM getById(int GoodsID) throws SQLException {

        Connection connection = ds.getConnection(user, password);
        String getCommand = "SELECT * FROM shop.goods WHERE GoodsID = ?";
        PreparedStatement select = connection.prepareStatement(getCommand);
        select.setInt(1, GoodsID);
        ResultSet result = select.executeQuery();
        result.next();
        int newID = result.getInt("GoodsID");
        int Category = result.getInt("Category");
        String Manufactor = result.getString("Manufactor");
        float Price = result.getFloat("Price");
        GoodsM goodsM = new GoodsM(Manufactor, Category, Price);
        goodsM.setGoodsID(newID);
return goodsM;
    }

    public List<GoodsM> getAll() throws SQLException {

        List<GoodsM> goodsList = new ArrayList();
        Connection connection = ds.getConnection(this.user, this.password);
        String getCommand = "SELECT * FROM shop.goods";
        PreparedStatement select = connection.prepareStatement(getCommand);
        ResultSet result = select.executeQuery();

        while (result.next()) {
            int GoodsID = result.getInt("GoodsID");
            int Category = result.getInt("Category");
            String Manufactor = result.getString("Manufactor");
            float Price = result.getFloat("Price");
            GoodsM goodsm = new GoodsM(Manufactor, Category, Price);
            goodsm.setGoodsID(GoodsID);
            goodsList.add(goodsm);
        }

        return goodsList;

    }


    public void add (GoodsM goods) throws SQLException {

        Connection connection = ds.getConnection(this.user, this.password);
        String insertCommand = "INSERT INTO shop.goods (Category,Manufactor, Price) VALUES(?,?,?)";
        PreparedStatement insert = connection.prepareStatement(insertCommand);
        insert.setInt(1, goods.getCategory());
        insert.setString(2, goods.getManufactor());
        insert.setFloat(3, goods.getPrice());
        insert.execute();


    }

    public void update (GoodsM goods)throws SQLException {
        Connection connection = ds.getConnection(this.user, this.password);
        String updateCommand = "UPDATE shop.goods SET Category = ?, Manufactor = ?, Price = ? WHERE GoodsID = ?";
        PreparedStatement update = connection.prepareStatement(updateCommand);
        update.setInt(1, goods.getCategory());
        update.setString(2, goods.getManufactor());
        update.setFloat(3, goods.getPrice());
        update.setInt(4,goods.getGoodsID());
        update.execute();


    }


    public void delete ( int GID) throws SQLException {
        Connection connection = ds.getConnection(this.user, this.password);
        String deleteCommand = "DELETE FROM shop.goods WHERE GoodsID = ?";
        PreparedStatement deletee = connection.prepareStatement(deleteCommand);
        deletee.setInt(1, GID);
        deletee.execute();

    }
}


