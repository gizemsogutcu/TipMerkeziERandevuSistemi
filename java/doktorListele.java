import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 @ManagedBean( name="doktor")
 @SessionScoped
public class doktorListele{
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
  
    //çocuk doktorlarını getiren metod
     public ResultSet cocukDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=3" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        }
                
        finally{
            conn.close();
        } 
     }
     
     //kardiyoloji doktorlarını getiren metod
     public ResultSet kardiyolojiDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=2" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        }
                
        finally{
            conn.close();
        } 
     }
     
     public ResultSet dahiliyeDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=1" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        }
                
        finally{
            conn.close();
        } 
     }
     
     public ResultSet kbbDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=4" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        }
                
        finally{
            conn.close();
        } 
     }
     

    
    
}
    
    
    
    

