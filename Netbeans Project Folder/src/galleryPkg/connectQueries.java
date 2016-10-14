package galleryPkg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class connectQueries {
    static Connection conn = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "gallery";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName;
    static String passWord;
    
    public connectQueries(String username, String password){
        userName = username;
        passWord = password;
    }
    
    public static Connection ConnectDb(){

    
       try {
           Class.forName(driver).newInstance();
           conn = DriverManager.getConnection(url+dbName,userName,passWord);
           JOptionPane.showMessageDialog(null, "Connected successfully."); 
           return conn;
       } 
       catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
           JOptionPane.showMessageDialog(null, e); 
           return null;
       }
    }
    
    public static void disConnectDb(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Successfully disconnected from database."); 
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    +++++++++++++++++++++ MAIN FRAME SELECT METHODS +++++++++++++++++++++++
    
    
    public static ResultSet selectArtistMainFrame(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT * FROM artist;";
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static ResultSet selectArtworkMainFrame(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM artwork;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ResultSet selectCustomerMainFrame(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM customer;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ResultSet selectOrderMainFrame(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM order_;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ResultSet selectGroupMainFrame(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM group_;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    ++++++++++++++++++++++ POPULATING COMBOBOXES METHODS +++++++++++++++++++++++++++++
    
    
    //Populating combobox methods.
    
    //delete frame
    public static void FillDeleteFrameCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM artwork;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String title = rs.getString("title");
                cbx.addItem(title);
            
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    
    //insert frame
    public static void FillArtworkTitleCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM artwork;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String title = rs.getString("title");
                cbx.addItem(title);
            
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    
    public static void FillNameOfGroupCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql = "SELECT * FROM group_;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String nameGroup = rs.getString("name_group");
                cbx.addItem(nameGroup);
            
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    public static void FillArtistIdCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "SELECT * FROM artist;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String artistId = rs.getString("artist_id");
                cbx.addItem(artistId);
            
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
        
        
    }
    
    public static void FillOrderIdCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "SELECT * FROM order_;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String orderId = rs.getString("order_id");
                cbx.addItem(orderId);
            
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
    }
   
    
    public static void FillCustomerIdCbx(javax.swing.JComboBox cbx){
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "SELECT * FROM customer;";
        
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String customerId = rs.getString("cust_id");
                cbx.addItem(customerId);
            
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        } 
    }
   
//    +++++++++++++++++++++++++++ DELETE FRAME METHOD ++++++++++++++++++++++++++++++
    
    //DELETE ARTWORK
    public static boolean deleteArtworkDeleteFrame(String selection){
        
        PreparedStatement pst = null;
       
        
        try{
        String sql="DELETE FROM artwork WHERE title =?";
	pst=conn.prepareStatement(sql);
	pst.setString(1, selection);
	pst.executeUpdate();
        
        return true;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
            return false;
        }
    }
    
//    ++++++++++++++++++++++++++++++INSERT FRAME METHODS+++++++++++++++++++++++++++++++
    
    //INSERT ARTIST.
    public static boolean insertArtistInsertFrame(String name, String style, String loc, int phone){
        PreparedStatement pst = null;
        
        try{
            String sql="INSERT INTO artist (artist_id, style, artist_name, location, phone_num) VALUES (NULL, ?, ?, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, style);
            pst.setString(3, loc);
            pst.setInt(4, phone);
            pst.executeUpdate();
            
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //INSERT ARTWORK.
    public static boolean insertArtworkInsertFrame(String title, int orderId, int artistId, String genre, float price, int crYear, int inYear){
        PreparedStatement pst = null;
        
        try{
            String sql="INSERT INTO artwork (title, order_id, artist_id, genre, price, year_created, year_insert) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, title);
            
            if(orderId==0){
                pst.setNull(2, java.sql.Types.INTEGER);
            } else{
                pst.setInt(2, orderId);
            }
            
            
            pst.setInt(3, artistId);
            pst.setString(4, genre);
            pst.setFloat(5, price);
            pst.setInt(6, crYear);
            pst.setInt(7, inYear);
            
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //INSERT CUSTOMER
    public static boolean insertCustomerInsertFrame(String name, int phone){
            PreparedStatement pst = null;
        try{
            String sql="INSERT INTO customer (cust_id, cust_name, telephone) VALUES (NULL, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, phone);
            pst.executeUpdate();
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    
    }
    
    // INSERT ORDER
    public static boolean insertOrderInsertFrame(String title, int custId, int orderYear){
        PreparedStatement pst = null;
        
        try{
            String sql = "INSERT INTO order_ (order_id, title, cust_id, order_year) VALUES (NULL, ?, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, title);
            pst.setInt(2, custId);
            pst.setInt(3, orderYear);
            
            pst.executeUpdate();
            return true;
        
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //INSERT NAMEOFGROUP
    public static boolean insertNameOfGroupInsertFrame(String nameOfGroup){
        PreparedStatement pst = null;
        
        try{
            String sql="INSERT INTO group_ (name_group) VALUES(?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nameOfGroup);
            pst.executeUpdate();
            
            return true;
        } 
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //INSERT CUSTOMER LIKES ARTIST
    public static boolean insertCustLikesArtistInsertFrame(int custId, int artistId){
        PreparedStatement pst = null;
        
        try{
            String sql="INSERT INTO artist_customer (cust_id, artist_id) VALUES(?,?)";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, custId);
            pst.setInt(2, artistId);
            
            pst.executeUpdate();
            
            return true;
        } 
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //INSERT ARTWORK CLASSIFIED TO GROUP
    public static boolean insertArtworkClassGroupInsertFrame(String title, String nameOfGroup){
        PreparedStatement pst = null;
        
        try{
            String sql="INSERT INTO artwork_group (title, name_group) VALUES(?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, nameOfGroup);
            
            pst.executeUpdate();
            
            return true;
        } 
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
//    +++++++++++++++++++++++++++++ CHECK COMBOBOX VALUE METHOD ++++++++++++++++++++

    public static int checkComboboxInt(javax.swing.JComboBox cbx){
        int x;
        if(cbx.getSelectedItem().toString().equalsIgnoreCase("none")){
            x=0;
            return x;
        }else{
            x = Integer.parseInt(cbx.getSelectedItem().toString());
            return x;
        }
    }
    
    
//    +++++++++++++++++++++++++++++ SEARCH FRAME METHODS ++++++++++++++++++++++++++++
    
    // SEARCH ARTWORK BY ARTIST
    
    public static boolean searchArtworkByArtist(javax.swing.JTable table, String artist){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artist.artist_name \n" +
                    "FROM artist\n" +
                    "INNER JOIN artwork\n" +
                    "ON artist.artist_id=artwork.artist_id WHERE artist.artist_name=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, artist);
            rs=pst.executeQuery();
            
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //SEARCH ARTWORK BY GENRE
    public static boolean searchArtworkByGenre(javax.swing.JTable table,String genre){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT title, genre FROM artwork\n" +
                    "WHERE genre=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, genre);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    // SEARCH ARTWORK BY GROUP
    public static boolean searchArtworkByGroup(javax.swing.JTable table,String nameOfGroup){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artwork_group.name_group\n" +
                    "FROM artwork\n" +
                    "INNER JOIN artwork_group\n" +
                    "ON artwork.title = artwork_group.title\n" +
                    "WHERE name_group=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, nameOfGroup);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    //SEARCH ARTWORK BY ARTIST AND GENRE
    public static boolean searchArtworkByArtistAndGenre(javax.swing.JTable table, String artist, String genre){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artist.artist_name, artwork.genre \n" +
                    "FROM artist\n" +
                    "INNER JOIN artwork\n" +
                    "ON artist.artist_id=artwork.artist_id \n" +
                    "WHERE artist.artist_name=? AND artwork.genre=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, artist);
            pst.setString(2, genre);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //SEARCH ARTWORK BY ARTIST AND GROUP
    public static boolean searchArtworkByArtistAndGroup(javax.swing.JTable table, String artist, String nameOfGroup){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artist.artist_name, artwork_group.name_group\n" +
                    "FROM artist INNER JOIN artwork\n" +
                    "ON artist.artist_id=artwork.artist_id\n" +
                    "INNER JOIN artwork_group\n" +
                    "ON artwork.title=artwork_group.title\n" +
                    "WHERE artist.artist_name=? AND artwork_group.name_group=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, artist);
            pst.setString(2, nameOfGroup);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //SEARCH ARTWORK BY Genre AND GROUP
    public static boolean searchArtworkByGenreAndGroup(javax.swing.JTable table, String genre, String nameOfGroup){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artwork.genre, artwork_group.name_group\n" +
                    "FROM artwork INNER JOIN artwork_group\n" +
                    "ON artwork.title=artwork_group.title\n" +
                    "WHERE artwork.genre=? AND artwork_group.name_group=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, genre);
            pst.setString(2, nameOfGroup);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    //SEARCH ARTWORK BY ARTIST AND GENRE AND GROUP
    public static boolean searchArtworkByArtistAndGenreAndGroup(javax.swing.JTable table, String artist, String genre, String nameOfGroup){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT artwork.title, artist.artist_name, artwork.genre, artwork_group.name_group\n" +
                    "FROM artist INNER JOIN artwork\n" +
                    "ON artist.artist_id=artwork.artist_id\n" +
                    "INNER JOIN artwork_group\n" +
                    "ON artwork.title=artwork_group.title\n" +
                    "WHERE artist.artist_name=? AND artwork.genre=? AND artwork_group.name_group=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, artist);
            pst.setString(2, genre);
            pst.setString(3, nameOfGroup);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //SEARCH CUSTOMER PURCHASES BY YEAR
    public static boolean searchCustPurchasesByYear(javax.swing.JTable table, String cust){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT customer.cust_name as CUSTOMER_NAME, sum(artwork.price) as TOTAL,  order_.order_year as YEAR\n" +
                    "FROM artwork INNER JOIN order_\n" +
                    "ON artwork.order_id=order_.order_id\n" +
                    "INNER JOIN customer\n" +
                    "ON order_.cust_id=customer.cust_id\n" +
                    "WHERE customer.cust_name=?\n" +
                    "GROUP BY order_.order_year;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, cust);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    //SEARCH CUSTOMER LIKES ARTIST
    public static boolean searchCustLikesArtist(javax.swing.JTable table, String cust){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT customer.cust_name AS CustomerName, artist.artist_name AS ArtistName\n" +
                    "FROM customer INNER JOIN artist_customer\n" +
                    "ON customer.cust_id=artist_customer.cust_id\n" +
                    "INNER JOIN artist\n" +
                    "ON artist_customer.artist_id=artist.artist_id\n" +
                    "WHERE customer.cust_name=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, cust);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    //SEARCH NUMBER OF ARTWORKS CREATED BY ARTIST AND INSERTED BY YEAR
    public static boolean searchNumArtworkByArtistInsertedByYear(javax.swing.JTable table, String artist){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql ="SELECT count(artwork.title) as NumberOfArtworks, artist.artist_name as ARTIST, artwork.year_insert as YEAR\n" +
                    "from artist INNER JOIN artwork\n" +
                    "ON artist.artist_id=artwork.artist_id\n" +
                    "WHERE artist_name=?\n" +
                    "GROUP BY artwork.year_insert;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, artist);
            rs=pst.executeQuery();
            
            //Check if ResultSet empty.
            if(rs.next()){
                //reset to before first row.
                rs.beforeFirst();
            // populate table.
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            return true;
            } else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connectQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    
//    ++++++++++++++++++++++ UPDATE FRAME METHODS +++++++++++++++++++++++++++
    
    //Artist Txt Fill
    public static void selectionFillArtist(String selectionId, javax.swing.JTextField styleTxt, javax.swing.JTextField nameTxt, javax.swing.JTextField locTxt, javax.swing.JTextField phoneTxt ){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM artist WHERE artist_id=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, selectionId);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("style");
                styleTxt.setText(add1);
                
                String add2 = rs.getString("artist_name");
                nameTxt.setText(add2);
                
                String add3 = rs.getString("location");
                locTxt.setText(add3);
                
                String add4 = rs.getString("phone_num");
                phoneTxt.setText(add4); 
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Artwork txt fill
    public static void selectionFillArtwork(String selectionTitle, javax.swing.JTextField titleTxt, javax.swing.JTextField orderIdTxt, 
            javax.swing.JTextField artistIdTxt, javax.swing.JTextField genreTxt, javax.swing.JTextField priceTxt, 
            javax.swing.JTextField yearCrTxt, javax.swing.JTextField yearInTxt ){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM artwork WHERE title=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, selectionTitle);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("title");
                titleTxt.setText(add1);
                
                String add2 = rs.getString("order_id");
                orderIdTxt.setText(add2);
                
                String add3 = rs.getString("artist_id");
                artistIdTxt.setText(add3);
                
                String add4 = rs.getString("genre");
                genreTxt.setText(add4); 
                
                String add5 = rs.getString("price");
                priceTxt.setText(add5); 
                
                String add6 = rs.getString("year_created");
                yearCrTxt.setText(add6);
                
                String add7 = rs.getString("year_insert");
                yearInTxt.setText(add7); 
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Customer txt fill
    public static void selectionFillCustomer(String custId, javax.swing.JTextField nameTxt, javax.swing.JTextField phoneTxt){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM customer WHERE cust_id=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, custId);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("cust_name");
                nameTxt.setText(add1);
                
                String add2 = rs.getString("telephone");
                phoneTxt.setText(add2);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Order txt fill
    public static void selectionFillOrder(String orderId, javax.swing.JTextField titleTxt, javax.swing.JTextField custIdTxt, javax.swing.JTextField orderYearTxt){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM order_ WHERE order_id=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, orderId);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("title");
                titleTxt.setText(add1);
                
                String add2 = rs.getString("cust_id");
                custIdTxt.setText(add2);
                
                String add3 = rs.getString("order_year");
                orderYearTxt.setText(add3);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //Customer txt fill
    public static void selectionFillCustomerLikeArtist(String custId, javax.swing.JTextField custIdTxt, javax.swing.JTextField artistIdTxt){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM artist_customer WHERE cust_id=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, custId);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("cust_id");
                custIdTxt.setText(add1);
                
                String add2 = rs.getString("artist_id");
                artistIdTxt.setText(add2);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    //Artwork Class Group txt fill
    public static void selectionFillArtworkClassGroup(String artTitle, javax.swing.JTextField titleTxt, javax.swing.JTextField groupTxt){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM artwork_group WHERE title=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, artTitle);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("title");
                titleTxt.setText(add1);
                
                String add2 = rs.getString("name_group");
                groupTxt.setText(add2); 
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //Customer txt fill
    public static void selectionFillNameOfGroup(String groupName, javax.swing.JTextField groupNameTxt){
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String sql="SELECT * FROM group_ WHERE name_group=?;";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, groupName);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("name_group");
                groupNameTxt.setText(add1);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //UPDATE ARTIST METHOD
    public static boolean updateArtist(String artistId, String artistStyle, String artistName, String artistLoc, String artistPhone ){
        PreparedStatement pst = null;
        
        String sql="UPDATE artist set artist_id='"+artistId+"', style='"+artistStyle+"', artist_name='"+artistName+"', location='"+artistLoc+"', phone_num='"+artistPhone+"' WHERE artist_id='"+artistId+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //UPDATE ARTWORK METHOD
     public static boolean updateArtwork(String title, String orderId, String artistId, String genre, String price, String crYear, String inYear ){
        PreparedStatement pst = null;
        
        
        String sql="UPDATE artwork set title='"+title+"', order_id=?, artist_id='"+artistId+"', genre='"+genre+"', price='"+price+"', year_created='"+crYear+"', year_insert='"+inYear+"' WHERE artist_id='"+artistId+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            
            //Handle OrderId case.
            try{
                int orderInt = Integer.parseInt("orderId");
                pst.setInt(1, orderInt);
            } catch(NumberFormatException e){
                pst.setNull(1, java.sql.Types.INTEGER);
            }
            
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
     
     //UPDATE CUSTOMER METHOD
    public static boolean updateCustomer(String custId, String custName, String custPhone){
        PreparedStatement pst = null;
        
        String sql="UPDATE customer set cust_id='"+custId+"', cust_name='"+custName+"', telephone='"+custPhone+"' WHERE cust_id='"+custId+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
     //UPDATE ORDER METHOD
    public static boolean updateOrder(String orderId, String title, String custId, String orderYear){
        PreparedStatement pst = null;
        
        String sql="UPDATE order_ set order_id='"+orderId+"', title='"+title+"', cust_id='"+custId+"', order_year='"+orderYear+"' WHERE order_id='"+orderId+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //UPDATE CUSTOMER LIKES ARTIST METHOD
    public static boolean updateCustomerLikesArtist(String custId, String custIdTxt, String artistId){
        PreparedStatement pst = null;
        
        String sql="UPDATE artist_customer set cust_id='"+custIdTxt+"', artist_id='"+artistId+"' WHERE cust_id='"+custId+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //UPDATE ARTWORKCLASSGROUP METHOD
     public static boolean updateArtworkClassGroup(String artTitle, String title, String group){
        PreparedStatement pst = null;
        
        
        String sql="UPDATE artwork_group set title='"+title+"', name_group='"+group+"' WHERE title='"+artTitle+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
     
     
     //UPDATE ARTWORKCLASSGROUP METHOD
     public static boolean updateNameOfGroup(String groupName, String groupNameTxt){
        PreparedStatement pst = null;
        
        
        String sql="UPDATE group_ set name_group='"+groupNameTxt+"' WHERE name_group='"+groupName+"' ";
        
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
}
