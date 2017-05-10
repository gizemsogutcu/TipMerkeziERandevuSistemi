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
 @ManagedBean( name="dr")
 @SessionScoped
public class doktorEkleSil{
    Connection conn ;
    PreparedStatement ps ;
    PreparedStatement ps1 ;
    ResultSet rs ;
    ResultSet rs1 ;
   
    Connection con=null;
    String TC;
    String adi;
    String soyadi;
    String dogumtarihi;
    String telefon;
    String universite;
    String isbaslangictarihi;
    String mezuniyettarihi;
    String unvan;
    String uzmanlikalani;
    Integer muayeneucreti;
    String errorMessage;
    int i;
    int dahiliyeBolum = 1;
    int kardiyolojiBolum = 2;
    int cocukBolum = 3;
    int kbbBolum = 4;

    /**
     * @return the TC
     */
    public String getTC() {
        return TC;
    }

    /**
     * @param TC the TC to set
     */
    public void setTC(String TC) {
        this.TC = TC;
    }

    /**
     * @return the adi
     */
    public String getAdi() {
        return adi;
    }

    /**
     * @param adi the adi to set
     */
    public void setAdi(String adi) {
        this.adi = adi;
    }

    /**
     * @return the soyadi
     */
    public String getSoyadi() {
        return soyadi;
    }

    /**
     * @param soyadi the soyadi to set
     */
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    /**
     * @return the dogumtarihi
     */
    public String getDogumtarihi() {
        return dogumtarihi;
    }

    /**
     * @param dogumtarihi the dogumtarihi to set
     */
    public void setDogumtarihi(String dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the universite
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * @param universite the universite to set
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /**
     * @return the isbaslangictarihi
     */
    public String getIsbaslangictarihi() {
        return isbaslangictarihi;
    }

    /**
     * @param isbaslangictarihi the isbaslangictarihi to set
     */
    public void setIsbaslangictarihi(String isbaslangictarihi) {
        this.isbaslangictarihi = isbaslangictarihi;
    }

    /**
     * @return the mezuniyettarihi
     */
    public String getMezuniyettarihi() {
        return mezuniyettarihi;
    }

    /**
     * @param mezuniyettarihi the mezuniyettarihi to set
     */
    public void setMezuniyettarihi(String mezuniyettarihi) {
        this.mezuniyettarihi = mezuniyettarihi;
    }

    /**
     * @return the unvan
     */
    public String getUnvan() {
        return unvan;
    }

    /**
     * @param unvan the unvan to set
     */
    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    /**
     * @return the uzmanlikalani
     */
    public String getUzmanlikalani() {
        return uzmanlikalani;
    }

    /**
     * @param uzmanlikalani the uzmanlikalani to set
     */
    public void setUzmanlikalani(String uzmanlikalani) {
        this.uzmanlikalani = uzmanlikalani;
    }

    /**
     * @return the muayeneucreti
     */
    public Integer getMuayeneucreti() {
        return muayeneucreti;
    }

    /**
     * @param muayeneucreti the muayeneucreti to set
     */
    public void setMuayeneucreti(Integer muayeneucreti) {
        this.muayeneucreti = muayeneucreti;
    }
    
    
     public String getErrorMessage() {
        return errorMessage;
    }
 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
   

  
    //Ã§ocuk doktorlarÄ±nÄ± getiren metod
     public ResultSet cocukDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=3" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Baglanti basarisiz!");
        }
                
        finally{
            conn.close();
        } 
     }
     
//kardiyoloji doktorlarÄ±nÄ± getiren metod
     public ResultSet kardiyolojiDoktor() throws SQLException, Exception{
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where b_no=2" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            return rs;
            
          
        }
        catch (Exception e) {
            throw new Exception("Baglanti basarisiz!");
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
            throw new Exception("Baglanti basarisiz!");
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
            throw new Exception("Baglanti basarisiz!");
        }
                
        finally{
            conn.close();
        } 
     }
     
     public String cocukDoktorEkle()throws SQLException
    {
        
        
                try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres","2569");
            ps=con.prepareStatement("INSERT INTO doktor(dr_tc,dr_adi,dr_soyadi,dr_dogumtarihi,dr_telefon,dr_universite,"
                    + "dr_mezuniyettarihi,dr_isbaslangictarihi,dr_unvan,dr_muayeneucreti,dr_uzmanlikalani, b_no) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            

            
            ps.setString(1, getTC());
            ps.setString(2, getAdi());
            ps.setString(3, getSoyadi());
            ps.setString(4, getDogumtarihi());
            ps.setString(5, getTelefon());
            ps.setString(6, getUniversite());
            ps.setString(7, getMezuniyettarihi());
            ps.setString(8, getIsbaslangictarihi());
            ps.setString(9, getUnvan());
            ps.setInt(10, getMuayeneucreti());
            ps.setString(11, getUzmanlikalani());
            ps.setInt(12, cocukBolum);
            i=ps.executeUpdate();
                }
        catch(ClassNotFoundException | SQLException exception)
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally 
        {
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            catch(SQLException sqlException)
            {
                System.out.println(sqlException);
            }
 
        }
         return "adminpaneli?faces-redirect=true";
        
       
                
    }
    
    public String kardiyolojiDoktorEkle()throws SQLException
    {
        
        
                try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres","2569");
            ps=con.prepareStatement("INSERT INTO doktor(dr_tc,dr_adi,dr_soyadi,dr_dogumtarihi,dr_telefon,dr_universite,"
                    + "dr_mezuniyettarihi,dr_isbaslangictarihi,dr_unvan,dr_muayeneucreti,dr_uzmanlikalani, b_no) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            

            
            ps.setString(1, getTC());
            ps.setString(2, getAdi());
            ps.setString(3, getSoyadi());
            ps.setString(4, getDogumtarihi());
            ps.setString(5, getTelefon());
            ps.setString(6, getUniversite());
            ps.setString(7, getMezuniyettarihi());
            ps.setString(8, getIsbaslangictarihi());
            ps.setString(9, getUnvan());
            ps.setInt(10, getMuayeneucreti());
            ps.setString(11, getUzmanlikalani());
            ps.setInt(12, kardiyolojiBolum);
            i=ps.executeUpdate();
                }
        catch(ClassNotFoundException | SQLException exception)
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally 
        {
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            catch(SQLException sqlException)
            {
                System.out.println(sqlException);
            }
 
        }
         return "adminpaneli?faces-redirect=true";
        
       
                
    }
    
    public String dahiliyeDoktorEkle()throws SQLException
    {
        
        
                try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres","2569");
            ps=con.prepareStatement("INSERT INTO doktor(dr_tc,dr_adi,dr_soyadi,dr_dogumtarihi,dr_telefon,dr_universite,"
                    + "dr_mezuniyettarihi,dr_isbaslangictarihi,dr_unvan,dr_muayeneucreti,dr_uzmanlikalani, b_no) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            

            
            ps.setString(1, getTC());
            ps.setString(2, getAdi());
            ps.setString(3, getSoyadi());
            ps.setString(4, getDogumtarihi());
            ps.setString(5, getTelefon());
            ps.setString(6, getUniversite());
            ps.setString(7, getMezuniyettarihi());
            ps.setString(8, getIsbaslangictarihi());
            ps.setString(9, getUnvan());
            ps.setInt(10, getMuayeneucreti());
            ps.setString(11, getUzmanlikalani());
            ps.setInt(12, dahiliyeBolum);
            i=ps.executeUpdate();
                }
        catch(ClassNotFoundException | SQLException exception)
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally 
        {
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            catch(SQLException sqlException)
            {
                System.out.println(sqlException);
            }
 
        }
         return "adminpaneli?faces-redirect=true";
        
       
                
    }
    
    public String kbbDoktorEkle()throws SQLException
    {
        
        
                try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres","2569");
            ps=con.prepareStatement("INSERT INTO doktor(dr_tc,dr_adi,dr_soyadi,dr_dogumtarihi,dr_telefon,dr_universite,"
                    + "dr_mezuniyettarihi,dr_isbaslangictarihi,dr_unvan,dr_muayeneucreti,dr_uzmanlikalani, b_no) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            

            
            ps.setString(1, getTC());
            ps.setString(2, getAdi());
            ps.setString(3, getSoyadi());
            ps.setString(4, getDogumtarihi());
            ps.setString(5, getTelefon());
            ps.setString(6, getUniversite());
            ps.setString(7, getMezuniyettarihi());
            ps.setString(8, getIsbaslangictarihi());
            ps.setString(9, getUnvan());
            ps.setInt(10, getMuayeneucreti());
            ps.setString(11, getUzmanlikalani());
            ps.setInt(12, kbbBolum);
            i=ps.executeUpdate();
                }
        catch(ClassNotFoundException | SQLException exception)
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally 
        {
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            catch(SQLException sqlException)
            {
                System.out.println(sqlException);
            }
 
        }
         return "adminpaneli?faces-redirect=true";
        
       
                
    }

    
    
}
    

