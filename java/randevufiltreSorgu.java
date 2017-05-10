import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;

@ManagedBean(name = "rfiltre")
@SessionScoped
public class randevufiltreSorgu  {

   /* public void processAction(ActionEvent event) throws AbortProcessingException, SQLException {
        randevuonay randevu = (randevuonay) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("randevuonay");
        
        randevu.setBolumno(secilenbno);
        randevu.setDoktortc(secilendrtc);
        randevu.setRandevutarih(formTarih);
        
        
        
    }  */

   /* public String drtccevir() throws SQLException {
        String doktortc = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/tipmerkezivt", "postgres", "postgrecagla");
            ps = conn.prepareStatement("SELECT dr_tc from doktor where dr_adi='"+doktor[0]+"' and dr_soyadi='"+doktor[1]+"'");
            rs = ps.executeQuery();
            doktortc = rs.getString("dr_tc");
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(randevuonay.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            ps.close();
        }
        return doktortc;
    } */
    
  /*  public int bolumcevir() throws SQLException {
        int bolumno = 0 ;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/tipmerkezivt", "postgres", "postgrecagla");
            ps = conn.prepareStatement("SELECT b_no from bolum where b_adi='"+secilenBolum+"'");
            rs = ps.executeQuery();
            bolumno = rs.getInt("b_no");
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(randevuonay.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            ps.close();
        }
        return bolumno;
    }
    */
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public randevufiltreSorgu() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        PreparedStatement ps5 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs5 = null;
        Connection connt;
        PreparedStatement ps10; 
        ResultSet rs10=null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt", "postgres", "2569");
            ps = conn.prepareStatement("select b_no,b_adi from bolum");
            ps1 = conn.prepareStatement("select dr_adi|| ' ' || dr_soyadi as sonuc from doktor natural join bolum where b_adi='DAHİLİYE'");
            ps2 = conn.prepareStatement("select dr_adi|| ' ' || dr_soyadi as sonuc from doktor natural join bolum where b_adi='KARDİYOLOJİ'");
            ps3 = conn.prepareStatement("select dr_adi|| ' ' || dr_soyadi as sonuc from doktor natural join bolum where b_adi='KULAK BURUN BOĞAZ'");
            ps4 = conn.prepareStatement("select dr_adi|| ' ' || dr_soyadi as sonuc from doktor natural join bolum where b_adi='ÇOCUK HASTALIKLARI'");
            ps5 = conn.prepareStatement("select dr_adi|| ' ' || dr_soyadi as sonuc from doktor");
            rs = ps.executeQuery();
            rs1 = ps1.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            rs4 = ps4.executeQuery();
            rs5 = ps5.executeQuery();
            while (rs.next()) {
                this.bolumler.add(new SelectItem(rs.getString("b_adi")));
                //setSecilenbno(rs.getInt("b_no"));
            }
            while (rs1.next()) {
                this.dahiliyeDr.add(new SelectItem(rs1.getString("sonuc")));
                //setSecilendrtc(rs1.getString("dr_tc"));
            }
            while (rs2.next()) {
                this.kardiyolojiDr.add(new SelectItem(rs2.getString("sonuc")));
               // setSecilendrtc(rs1.getString("dr_tc"));
            }
            while (rs3.next()) {
                this.kbbDr.add(new SelectItem(rs3.getString("sonuc")));
               //setSecilendrtc(rs1.getString("dr_tc"));
            }
            while (rs4.next()) {
                this.cocukDr.add(new SelectItem(rs4.getString("sonuc")));
                //setSecilendrtc(rs1.getString("dr_tc"));
            }
            while (rs5.next()) {
                this.doktorlar.add(new SelectItem(rs5.getString("sonuc")));
               // setSecilendrtc(rs1.getString("dr_tc"));
            }
       
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (Exception e) {
                System.out.println("burası hata");
            }
        }

    }

    public int secilenbno;

    public int getSecilenbno() {
        return secilenbno;
    }

    public void setSecilenbno(int secilenbno) {
        this.secilenbno = secilenbno;
    }
    public String secilendrtc;

    public String getSecilendrtc() {
        return secilendrtc;
    }

    public void setSecilendrtc(String secilendrtc) {
        this.secilendrtc = secilendrtc;
    }
    private List<SelectItem> bolumler = new ArrayList<SelectItem>();
    private List<SelectItem> doktorlar = new ArrayList<SelectItem>();
    public String secilenBolum = "";
    public String secilenDoktor = "";
    public String doktorAdi;
    public String doktorSoyadi;
    public String[] doktor = new String[2];
    private Date secilenTarih = new Date();

    public Date getSecilenTarih() {
        return secilenTarih;
    }

    public void setSecilenTarih(Date secilenTarih) {
        this.secilenTarih = secilenTarih;
    }

    private List<SelectItem> dahiliyeDr = new ArrayList<SelectItem>();
    private List<SelectItem> kardiyolojiDr = new ArrayList<SelectItem>();
    private List<SelectItem> kbbDr = new ArrayList<SelectItem>();
    private List<SelectItem> cocukDr = new ArrayList<SelectItem>();

    public List<SelectItem> getDoktorlar() {
        return doktorlar;
    }

    public void setDoktorlar(List<SelectItem> doktorlar) {
        this.doktorlar = doktorlar;
    }

    public List<SelectItem> getDahiliyeDr() {
        return dahiliyeDr;
    }

    public void setDahiliyeDr(List<SelectItem> dahiliyeDr) {
        this.dahiliyeDr = dahiliyeDr;
    }

    public List<SelectItem> getKardiyolojiDr() {
        return kardiyolojiDr;
    }

    public void setKardiyolojiDr(List<SelectItem> kardiyolojiDr) {
        this.kardiyolojiDr = kardiyolojiDr;
    }

    public List<SelectItem> getKbbDr() {
        return kbbDr;
    }

    public void setKbbDr(List<SelectItem> kbbDr) {
        this.kbbDr = kbbDr;
    }

    public List<SelectItem> getCocukDr() {
        return cocukDr;
    }

    public void setCocukDr(List<SelectItem> cocukDr) {
        this.cocukDr = cocukDr;
    }

    public List<SelectItem> getBolumler() {
        return bolumler;
    }

    public void setBolumler(List<SelectItem> bolumler) {
        this.bolumler = bolumler;
    }

    public String getSecilenBolum() {
        return secilenBolum;
    }

    public void setSecilenBolum(String secilenBolum) {
        this.secilenBolum = secilenBolum;
    }

    public String getSecilenDoktor() {
        return secilenDoktor;
    }

    public void setSecilenDoktor(String secilenDoktor) {
        this.secilenDoktor = secilenDoktor;
    }

    
    public void fillDoktorList() {
        if (secilenBolum.equals("DAHİLİYE")) {
            doktorlar = dahiliyeDr;
            secilenbno=1;
        }
        else if (secilenBolum.equals("KARDİYOLOJİ")) {
            doktorlar = kardiyolojiDr;
            secilenbno=2;
        }
        else if (secilenBolum.equals("KULAK BURUN BOĞAZ")) {
            doktorlar = kbbDr;
            secilenbno=4;
        }
         else  {
            doktorlar = cocukDr;
            secilenbno=3;
        }
        
    }

    public String formTarih;
    private String formBolum;
    private String formDoktor;
    public String rndformTarih;

    public String getRndformTarih() {
        return rndformTarih;
    }

    public void setRndformTarih(String rndformTarih) {
        this.rndformTarih = rndformTarih;
    }

    public String getFormTarih() {
        return formTarih;
    }

    public void setFormTarih(String formTarih) {
        this.formTarih = formTarih;
    }

    public String getFormBolum() {
        return formBolum;
    }

    public void setFormBolum(String formBolum) {
        this.formBolum = formBolum;
    }

    public String getFormDoktor() {
        return formDoktor;
    }

    public void setFormDoktor(String formDoktor) {
        this.formDoktor = formDoktor;
    }

    public String gonder() throws Exception {
        //doktorAdi = secilenDoktor.substring(0, secilenDoktor.indexOf(" "));
        //doktorSoyadi = secilenDoktor.substring(secilenDoktor.indexOf(" "), secilenDoktor.length());
        doktor = secilenDoktor.split(" ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formTarih = df.format(secilenTarih);
        DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");
        rndformTarih = df1.format(secilenTarih);

        return "randevusec?faces-redirect=true";
    }

    Connection connection;
    PreparedStatement preparedstmt;
    ResultSet resultset;
    public ResultSet saatler() throws SQLException, Exception {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt", "postgres", "2569");
            ps = conn.prepareStatement("WITH Q1 AS(\n"
                    + "    select * from doktor natural join bolum where dr_adi='" + doktor[0] + "' and dr_soyadi='" + doktor[1] + "' and bolum.b_adi='" + secilenBolum + "'\n"
                    + "    )\n"
                    + "    select cs_saat, durum from doktorun_programi natural join Q1 where cs_tarih='" + formTarih + "' order by cs_saat\n"
                    + "    ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tipmerkezivt", "postgres", "2569");
            preparedstmt = connection.prepareStatement("select dr_tc from doktor where dr_adi='"+doktor[0]+"' and dr_soyadi='"+doktor[1]+"'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultset = preparedstmt.executeQuery();
                while(resultset.next()){
                    setSecilendrtc(resultset.getString("dr_tc"));
                }
            
            
            return rs;

        } catch (Exception e) {
            throw new Exception("Bağlantı başarısız!");
        } finally {
            conn.close();
            connection.close();
        }
    }

}