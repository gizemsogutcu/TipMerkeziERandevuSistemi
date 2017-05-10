
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.CloseEvent;
 
@ManagedBean
public class dialogView {
 
    public void messagebox() {
        addMessage("Basarili", "Doktor veri tabanindan silindi!");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
   /* public void doktorsil() throws SQLException{
        PreparedStatement ps=null;
        Connection con=null;

        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/tipmerkezivt","postgres","postgrecagla");
            ps=con.prepareStatement("DELETE * from doktor where (h_tc,h_adi,h_soyadi,h_cinsiyet,h_dogumtarihi,h_telefon,h_mail) VALUES(?,?,?,?,?,?,?)");

            
        }
        catch(Exception e){
            
        }
    }*/
   /* public String silDoktor(ResultSet rs) throws SQLException{
        rs.rowDeleted();
        messagebox();
        return null;
    }  */
    
    private String dr_tc;
    Connection con;
    PreparedStatement ps;
    int i;
 
    public void KayitSil(){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.dr_tc = dr_tcParametresiniAl(fc);
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");
            ps=con.prepareStatement("DELETE FROM doktor WHERE dr_tc=?");
            ps.setString(1, dr_tc);
            i=ps.executeUpdate();
            messagebox();
        }
        catch(SQLException | ClassNotFoundException exception)
        {
            System.out.print(exception);
        }
        finally {
            try {
                if(con!= null){
                    con.close();
                }
                if (ps!=null) {
                    ps.close();
                }
            } 
            catch (SQLException exception) {
                System.out.println("Bir Hata Meydana Geldi!\nHata:"+exception);
            }
        }
        /*if(i>0)
            return true;
        else
            return false;
    }*/
    }
    public String dr_tcParametresiniAl(FacesContext fc)
    {
        Map<String,String> parametreler = fc.getExternalContext().getRequestParameterMap();
	return parametreler.get("dr_tc");
    }
}
    
