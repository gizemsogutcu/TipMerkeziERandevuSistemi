import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import static javax.swing.UIManager.getInt;
import static jdk.nashorn.internal.objects.Global.getDate;

@ManagedBean(name = "randevuonay")
@RequestScoped
public class randevuonay implements Serializable {

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    Connection con = null;
    PreparedStatement p = null;
    ResultSet r;

    String hastatc;
     int bolumno;
     String doktortc;
     String randevusaat;
    String randevudurum="guncel";

        public Date tarihdonustur(String tarih) throws ParseException{
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(tarih);    
            java.sql.Date sqlDate = new Date(date.getTime());
            return sqlDate;
        }
        
        Connection cnc;
        PreparedStatement pst;
        public String GONDER() throws Exception{
        
        FacesContext fc = FacesContext.getCurrentInstance();
        this.hastatc = hastatcParametresiniAl(fc);
        FacesContext fc1 = FacesContext.getCurrentInstance();
        this.bolumno = bolumnoParametresiniAl(fc1);
        FacesContext fc2 = FacesContext.getCurrentInstance();
        this.doktortc = doktortcParametresiniAl(fc2);
        FacesContext fc3 = FacesContext.getCurrentInstance();
        this.randevutarih = randevutarihParametresiniAl(fc3);
        FacesContext fc4 = FacesContext.getCurrentInstance();
        this.randevusaat = randevusaatParametresiniAl(fc);
        FacesContext fc5 = FacesContext.getCurrentInstance();
        this.randevudurum = randevudurumtParametresiniAl(fc);
        
        
 
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");
            p=con.prepareStatement("INSERT INTO alinan_randevu(h_tc,b_no,dr_tc,ar_tarih,ar_saat,ar_durumu) VALUES(?,?,?,?,?,?)");
            p.setString(1, hastatc);
            p.setInt(2, bolumno);
            p.setString(3, doktortc);
            p.setDate(4, tarihdonustur(randevutarih));
            p.setString(5, randevusaat);
            p.setString(6, randevudurum);
            p.executeUpdate();
            
            
            
        }
        catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }
        finally {
            try {
                if(con!= null){
                    con.close();
                }
                if(p != null){
                    p.close();
                }
                cnc=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");
                pst=cnc.prepareStatement("update doktorun_programi set durum='dolu' where dr_tc='"+doktortc+"' and cs_tarih='"+tarihdonustur(randevutarih)+"' and cs_saat='"+randevusaat+"'");
                pst.executeUpdate();
                
                if (cnc!=null) {
                    cnc.close();
                }
                if(pst != null){
                    pst.close();
                }
            } 
            catch (Exception ee) {
                throw new Exception(ee.getMessage());
            }
        }
        
        return "randevularim?faces-redirect=true";
    }
    
    Connection cnc1;
    PreparedStatement pst1;
    Connection con12;
    PreparedStatement ps12;
    int intrandevuno;

    public int getIntrandevuno() {
        return intrandevuno;
    }

    public void setIntrandevuno(int intrandevuno) {
        this.intrandevuno = intrandevuno;
    }
    
    public int integeracevir(String randevuno){
        intrandevuno = Integer.parseInt(randevuno);
        return intrandevuno;
        
    }
    public String dr_tc;
    public String ar_saat;
    public String ar_tarih;

    public String getDr_tc() {
        return dr_tc;
    }

    public void setDr_tc(String dr_tc) {
        this.dr_tc = dr_tc;
    }

    public String getAr_saat() {
        return ar_saat;
    }

    public void setAr_saat(String ar_saat) {
        this.ar_saat = ar_saat;
    }

    public String getAr_tarih() {
        return ar_tarih;
    }

    public void setAr_tarih(String ar_tarih) {
        this.ar_tarih = ar_tarih;
    }
   
     public String KaydiSil() throws Exception{
        FacesContext fc6 = FacesContext.getCurrentInstance();
        this.randevuno = strrandevunoParametresiniAl(fc6);
        
        integeracevir(randevuno);
        
        FacesContext fc7 = FacesContext.getCurrentInstance();
        this.dr_tc = drtccParametresiniAl(fc7);
        FacesContext fc8 = FacesContext.getCurrentInstance();
        this.ar_saat = ar_saattParametresiniAl(fc8);
        FacesContext fc9 = FacesContext.getCurrentInstance();
        this.ar_tarih = ar_tarihhParametresiniAl(fc9);
        
     
        try {
            Class.forName("org.postgresql.Driver");
            con12=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");
            ps12=con12.prepareStatement("DELETE FROM alinan_randevu  WHERE  ar_no= '"+intrandevuno+"' ");
            ps12.executeUpdate();
            
        }
        catch(Exception exception)
        {
            throw new Exception(exception.getMessage());
        }
        finally {
            try {
                if(con12!= null){
                    con12.close();
                }
                if (ps12!=null) {
                    ps12.close();
                }
                cnc1=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");
                pst1=cnc1.prepareStatement("update doktorun_programi set durum='boş' where dr_tc='"+dr_tc+"' and cs_tarih='"+ar_tarih+"' and cs_saat='"+ar_saat+"'");
                pst1.executeUpdate();
                
                 if (cnc1!=null) {
                    cnc1.close();
                }
                if(pst1 != null){
                    pst1.close();
                }
            } 
            catch (Exception exception) {
                throw new Exception(exception.getMessage());
            }
        }
         return "randevularim?faces-redirect=true”";
     } 
    public int getBolumno() {
        return bolumno;
    }

    public void setBolumno(int bolumno) {
        this.bolumno = bolumno;
    }

    public String getHastatc() {
        return hastatc;
    }

    public void setHastatc(String hastatc) {
        this.hastatc = hastatc;
    }

    public String randevutarih;
    public String randevuno;

    public String getRandevuno() {
        return randevuno;
    }

    public void setRandevuno(String randevuno) {
        this.randevuno = randevuno;
    }
   public String getRandevutarih() {
        return randevutarih;
    }

    public void setRandevutarih(String randevutarih) {
        this.randevutarih = randevutarih;
    }

    public String getDoktortc() {
        return doktortc;
    }

    public void setDoktortc(String doktortc) {
        this.doktortc = doktortc;
    }
    
    public String getRandevusaat() {
        return randevusaat;
    }

    public void setRandevusaat(String randevusaat) {
        this.randevusaat = randevusaat;
    }

    public String getRandevudurum() {
        return randevudurum;
    }

    public void setRandevudurum(String randevudurum) {
        this.randevudurum = randevudurum;
    }

  public String randevusaatAyarla() {
      FacesContext fc=FacesContext.getCurrentInstance();
      this.randevusaat=randevusaatParametresiniAl(fc);
      return randevusaat;
    }

    public String randevusaatParametresiniAl(FacesContext fc) {
        Map<String, String> parametreler = fc.getExternalContext().getRequestParameterMap();
        return parametreler.get("randevusaat");
    }

     private String hastatcParametresiniAl(FacesContext fc) {
        Map<String, String> parametreler = fc.getExternalContext().getRequestParameterMap();
        return parametreler.get("hastatc");
    }

    private int bolumnoParametresiniAl(FacesContext fc1) {
        Map<String, String> parametreler = fc1.getExternalContext().getRequestParameterMap();
        String sayisal=parametreler.get("bolumno");
        return  Integer.parseInt(sayisal);
    }

    private String doktortcParametresiniAl(FacesContext fc2) {
        Map<String, String> parametreler = fc2.getExternalContext().getRequestParameterMap();
        return parametreler.get("doktortc");
    }

    private String randevutarihParametresiniAl(FacesContext fc3) {
        Map<String, String> parametreler = fc3.getExternalContext().getRequestParameterMap();
        return parametreler.get("randevutarih");
        
    }

    private String randevudurumtParametresiniAl(FacesContext fc) {
        Map<String, String> parametreler = fc.getExternalContext().getRequestParameterMap();
        return parametreler.get("randevudurum");
    }

    private String strrandevunoParametresiniAl(FacesContext fc6) {
        Map<String, String> parametreler = fc6.getExternalContext().getRequestParameterMap();
        return parametreler.get("strrandevuno");
    }
    private String drtccParametresiniAl(FacesContext fc7) {
        Map<String, String> parametreler = fc7.getExternalContext().getRequestParameterMap();
        return parametreler.get("drtcc");
    }
   private String ar_saattParametresiniAl(FacesContext fc8) {
        Map<String, String> parametreler = fc8.getExternalContext().getRequestParameterMap();
        return parametreler.get("ar_saatt");
    }
   
   private String ar_tarihhParametresiniAl(FacesContext fc9) {
        Map<String, String> parametreler = fc9.getExternalContext().getRequestParameterMap();
        return parametreler.get("ar_tarihh");
    }
  
}