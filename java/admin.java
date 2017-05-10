import static java.awt.SystemColor.text;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

 @ManagedBean( name="admin")
 @SessionScoped
public class admin{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public String kullaniciadi=null;
    public String mail=null;
    public String sifre=null;

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String girisyap() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from adminler \n" +
                                        "WHERE\n" +
                                        "a_kullaniciadi = '"+kullaniciadi+"'" +
                                        "and a_sifre='"+sifre+"'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            if(rs.next())
                return "adminpaneli?faces-redirect=true”";
            else{
                
                return "admingiris?faces-redirect=true”";
                
                
            }
        }
        catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        }
                
        finally{
            conn.close();
        }         
    }
    
    
    
}
    
    
    
    

