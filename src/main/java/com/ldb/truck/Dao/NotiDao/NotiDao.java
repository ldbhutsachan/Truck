package com.ldb.truck.Dao.NotiDao;
import com.ldb.truck.Model.Login.Noti.NotiDetails;
import com.ldb.truck.Model.Login.Noti.NotiInvoice;
import com.ldb.truck.Model.Login.Noti.NotiPerFormace;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
@Repository
public class NotiDao implements NotiDaoIn{
    private static final Logger log = LogManager.getLogger(NotiDao.class);
    @Autowired
    @Qualifier("EBankJdbcTemplate")
    private JdbcTemplate EBankJdbcTemplate;
    String SQL="";
    @Override
    public List<NotiDetails> notiDetails() {
        try {
            SQL="select count(DETAILSTATUS) as DETAILSTATUS from V_NOTI_TB_DETAILS where DETAILSTATUS >='7'";
            return EBankJdbcTemplate.query(SQL, new RowMapper<NotiDetails>() {
                @Override
                public NotiDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                    NotiDetails tr =new NotiDetails();
                    tr.setDetailsStatus(rs.getString("DETAILSTATUS"));
                    return tr;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<NotiInvoice> notiInvoice() {
        try {
            SQL="select count(inVoiceStatus) as inVoiceStatus from V_NOTI_INVOICE where inVoiceStatus >='7'";
            return EBankJdbcTemplate.query(SQL, new RowMapper<NotiInvoice>() {
                @Override
                public NotiInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
                    NotiInvoice tr =new NotiInvoice();
                    tr.setInvoiceStatus(rs.getString("inVoiceStatus"));
                    return tr;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<NotiPerFormace> noTiPer() {
        try {
            SQL="select count(perstatus) as PERSTATUS from V_NOTI_PERFORMANCE where perstatus>='7'";
            return EBankJdbcTemplate.query(SQL, new RowMapper<NotiPerFormace>() {
                @Override
                public NotiPerFormace mapRow(ResultSet rs, int rowNum) throws SQLException {
                    NotiPerFormace tr =new NotiPerFormace();
                    tr.setPerStatus(rs.getString("PERSTATUS"));
                    return tr;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
