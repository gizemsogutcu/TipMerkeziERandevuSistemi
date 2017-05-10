import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.SimpleDateFormat;
import java.util.*;

 
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import static java.time.OffsetTime.now;
import static java.time.OffsetTime.now;
import static java.time.Year.now;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;



@ManagedBean
@SessionScoped

public class Anasayfa {
     String identification;
     String name;
     String surname;
     String mail;
     String birthdate;
     String phone;
     String gender;
     String errorMessage;
     String formTarih;
     PreparedStatement ps1=null;
     PreparedStatement ps2 = null;
     Connection conn1=null;
     Connection conn2 = null;
   
    public String getIdentification()
        {
               return identification;
               
        }
        public void setIdentification(String identification)
        {
                this.identification=identification;
        }
        public String getName()
            {
                return name;
             } 
        public void setName( String name )
        {
            this.name = name;
        } 
        public String getSurname()
        {
            return surname;
        }
        public void setSurname( String surname )
        {
            this.surname = surname;
        }
        public String getMail()
        {
            return mail;
        } 
        public void setMail( String mail )
        {
            this.mail = mail;
        } 
        public String getBirthdate()
        {
            return birthdate;
        }
        public void setBirthdate(String birthdate){
                this.birthdate=birthdate;
        }
        public String getPhone()
        {
                return phone;
        } 
        public void setPhone( String phone )
        {
                this.phone = phone;
        }
 

        public String getGender()
        {
                return gender;
 
        }
        public void setGender(String gender)
        {
                this.gender=gender;
        }
       
    

    public String veritabaninaGönder()throws SQLException
    {
        
        
            try {
            Class.forName("org.postgresql.Driver");
            conn1=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres","2569");
            ps1=conn1.prepareStatement("INSERT INTO hasta(h_tc,h_adi,h_soyadi,h_cinsiyet,h_dogumtarihi,h_telefon,h_mail) VALUES(?,?,?,?,?,?,?)");
            
            ps1.setString(1, identification);
            ps1.setString(2, name);
            ps1.setString(3, surname);
            ps1.setString(4, gender);
            ps1.setString(5, birthdate);
            ps1.setString(6, phone);
            ps1.setString(7, mail);
            ps1.executeUpdate();
        }
        catch(ClassNotFoundException | SQLException exception)
        {
            System.out.println(exception);
            //setErrorMessage(exception.toString());
        }
        finally 
        {
            
                    conn1.close();
                    ps1.close();
             
        }
        
            return "randevufiltre?faces-redirect=true";
       
    }

    PreparedStatement ps=null;
     
     Connection con=null;
     Connection con1 = null;
     Connection con2 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
     
     private String artarih;
     private String arsaat;
     private String bolumadi;
     private String dradi;
     private String drsoyadi;
     private String ardurum;
    

 
         public String getArdurum() {
        return ardurum;
    }


    public void setArdurum(String ardurum) {
        this.ardurum = ardurum;
    }

    public String getArtarih() {
        return artarih;
    }


    public void setArtarih(String artarih) {
        this.artarih = artarih;
    }

 
    public String getArsaat() {
        return arsaat;
    }

    public void setArsaat(String arsaat) {
        this.arsaat = arsaat;
    }

    public String getBolumadi() {
        return bolumadi;
    }

   
    public void setBolumadi(String bolumadi) {
        this.bolumadi = bolumadi;
    }

    public String getDradi() {
        return dradi;
    }

 
    public void setDradi(String dradi) {
        this.dradi = dradi;
    }

 
    public String getDrsoyadi() {
        return drsoyadi;
    }

 
    public void setDrsoyadi(String drsoyadi) {
        this.drsoyadi = drsoyadi;
    }

       public int getArno() {
        return arno;
    }

    public void setArno(int arno) {
        this.arno = arno;
    }
    
    public String stringarno;

    public String getStringarno() {
        return stringarno;
    }

    public void setStringarno(String stringarno) {
        this.stringarno = stringarno;
    }
    
    
    
    
    Connection cn1;
    Connection cn2;
    PreparedStatement pt1;
    PreparedStatement pt2;
    
     public String donusmusTarih;

    public String getDonusmusTarih() {
        return donusmusTarih;
    }

    public void setDonusmusTarih(String donusmusTarih) {
        this.donusmusTarih = donusmusTarih;
    }
    
     public String tarihDonustur(Date[] tarih) throws Exception {
        DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");  
        donusmusTarih = df1.format(tarih);
       
        return donusmusTarih;
    }
     
    public String artarihh;

    public String getArtarihh() {
        return artarihh;
    }

    public void setArtarihh(String artarihh) {
        this.artarihh = artarihh;
    }
    
    public String donusenTarih;

    public String getDonusenTarih() {
        return donusenTarih;
    }

    public void setDonusenTarih(String donusenTarih) {
        this.donusenTarih = donusenTarih;
    }

     public ResultSet guncelrandevu()throws SQLException,Exception{
        
    try{
            
            Class.forName("org.postgresql.Driver");
            cn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   

            pt1 = cn1.prepareStatement("select dr_tc,ar_tarih,ar_saat,ar_no,"
                    + "b_adi,dr_adi,dr_soyadi from alinan_randevu natural join bolum natural join doktor where h_tc='"+identification+"' and ar_durumu='guncel'"
                    , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs1 = pt1.executeQuery(); 
            while(rs1.next()){
                setArno(rs1.getInt("ar_no"));
                setStringarno(Integer.toString(rs1.getInt("ar_no")));
            }

            return rs1;
 
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
                
        finally{
            
            cn1.close();
            
        } 
     }
   
    public ResultSet gecmisrandevu()throws SQLException,Exception{
  
    try{
            
            Class.forName("org.postgresql.Driver");
            cn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
 
            pt2 = cn2.prepareStatement("select ar_tarih,ar_saat,ar_no,"
                    + "b_adi,dr_adi,dr_soyadi from alinan_randevu natural join bolum natural join doktor where h_tc='"+identification+"' and ar_durumu='gecmis'"
                     , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs2 = pt2.executeQuery();
            while(rs2.next()){
                
            setArno(rs2.getInt("ar_no"));
            //setArtarih(tarihDonustur(rs2.getDate("ar_tarih")));
       
            }
            return rs2;
          
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
                
        finally{
            cn2.close();
            
        
        } 
    }
     Connection c;
     PreparedStatement p;
    public String randevudurumu() throws SQLException, Exception {
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt", "postgres", "2569");
            p = c.prepareStatement("update alinan_randevu set ar_durumu='gecmis' where DATE(ar_tarih)<Date(NOW())");
            p.executeUpdate();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }finally {

            cn1.close();

        }
        
        return "randevularim?faces-redirect=true";
    }
    
    Connection cn12;
    PreparedStatement ps12;
    public int arno;

    
}