package ho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRetrieveService {

	//Coordonn�es de la base
    public String user="root";
    public String password = "";
    public String url = "jdbc:mysql://localhost:3306/ho";

//Requete pour recuperer les donn�es
    public String query = "SELECT * FROM product_sale";
    //Methodes pour recuperer les produits
    public List<Product> retrieve() throws SQLException {
        List<Product> res = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery()
        ) {

            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setDate(rs.getDate("date"));
                product.setRegion(rs.getString("region"));
                product.setProduct(rs.getString("product"));
                product.setQty(rs.getInt("qty"));
                product.setCost(rs.getFloat("cost"));
                product.setAmt(rs.getDouble("amt"));
                product.setTax(rs.getFloat("tax"));
                product.setTotal(rs.getDouble("total"));
                product.setBo_num(rs.getInt("bo_num"));
                res.add(product);
            }

            return res;
        }
    }
}
