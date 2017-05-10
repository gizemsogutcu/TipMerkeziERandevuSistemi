import javax.faces.event.ActionEvent;
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

 @ManagedBean( name="drgor")
 @SessionScoped
public class doktorgoruntule {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String drAdi;
    String drSoyadi;

    public String getDrAdi() {
        return drAdi;
    }

    public void setDrAdi(String drAdi) {
        this.drAdi = drAdi;
    }

    public String getDrSoyadi() {
        return drSoyadi;
    }

    public void setDrSoyadi(String drSoyadi) {
        this.drSoyadi = drSoyadi;
    }

    
    public String dr_tc;

    public void setDr_tc(String dr_tc) {
        this.dr_tc = dr_tc;
    }

    public String getDr_tc() {
        return dr_tc;
    }

    
    /*public String dr_tcParametresiniAl(FacesContext fc)
    {
        Map<String,String> parametreler = fc.getExternalContext().getRequestParameterMap();
	return parametreler.get("dr_tc");
    }*/
    
    /*public void drtcAyarla(ActionEvent e){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.dr_tc = dr_tcParametresiniAl(fc);
    }*/
    
   /* public void drtcAyarla(ActionEvent event){
        dr_tc = (String)event.getComponent().getAttributes().get("dr_tc");
    }
    */
   /* public String sayfaYonlendirme(){
        return "cocukDoktorGoruntule?faces-redirect=true”";
 }*/
    public String drtc;
    public String dradi;
    public String drsoyadi;
    public String drdogumtarihi;
    public String drtelefon;
    public String druniversite;
    public String drmezuniyettarihi;
    public String drisbaslangictarihi;
    public String drunvan;
    public int drmuayeneucreti;
    public String druzmanlikalani;

    public String getDrtc() {
        return drtc;
    }

    public void setDrtc(String drtc) {
        this.drtc = drtc;
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

    public String getDrdogumtarihi() {
        return drdogumtarihi;
    }

    public void setDrdogumtarihi(String drdogumtarihi) {
        this.drdogumtarihi = drdogumtarihi;
    }

    public String getDrtelefon() {
        return drtelefon;
    }

    public void setDrtelefon(String drtelefon) {
        this.drtelefon = drtelefon;
    }

    public String getDruniversite() {
        return druniversite;
    }

    public void setDruniversite(String druniversite) {
        this.druniversite = druniversite;
    }

    public String getDrmezuniyettarihi() {
        return drmezuniyettarihi;
    }

    public void setDrmezuniyettarihi(String drmezuniyettarihi) {
        this.drmezuniyettarihi = drmezuniyettarihi;
    }

    public String getDrisbaslangictarihi() {
        return drisbaslangictarihi;
    }

    public void setDrisbaslangictarihi(String drisbaslangictarihi) {
        this.drisbaslangictarihi = drisbaslangictarihi;
    }

    public String getDrunvan() {
        return drunvan;
    }

    public void setDrunvan(String drunvan) {
        this.drunvan = drunvan;
    }

    public int getDrmuayeneucreti() {
        return drmuayeneucreti;
    }

    public void setDrmuayeneucreti(int drmuayeneucreti) {
        this.drmuayeneucreti = drmuayeneucreti;
    }

    public String getDruzmanlikalani() {
        return druzmanlikalani;
    }

    public void setDruzmanlikalani(String druzmanlikalani) {
        this.druzmanlikalani = druzmanlikalani;
    }
    
    
   public String cocukdoktorGoruntule() throws Exception{
 
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt","postgres", "2569");   
            ps = conn.prepareStatement("select * from doktor where dr_tc='15891225596' " , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            while(rs.next()){
                setDrtc(rs.getString("dr_tc"));
                setDradi(rs.getString("dr_adi"));
                setDrsoyadi(rs.getString("dr_soyadi"));
                setDrdogumtarihi(rs.getString("dr_dogumtarihi"));
                setDrtelefon(rs.getString("dr_telefon"));
                setDruniversite(rs.getString("dr_universite"));
                setDrmezuniyettarihi(rs.getString("dr_mezuniyettarihi"));
                setDrisbaslangictarihi(rs.getString("dr_isbaslangictarihi"));
                setDrunvan(rs.getString("dr_unvan"));
                setDrmuayeneucreti(rs.getInt("dr_muayeneucreti"));
                setDruzmanlikalani(rs.getString("dr_uzmanlikalani"));
            }
            
        }
        catch (Exception e) {
            throw new Exception("Hata");
        }
                
        finally{
            conn.close();
        }  
         return "cocukDoktorGoruntule?faces-redirect=true”"; 
    }
   
  
     
}

