package conferences.dao.repository;

import conferences.dao.entities.Conferences;
import conferences.dao.entities.Reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportsRepository {

    public List<Reports> getReportsByIdCf(Long id) {

        DataSource dataSource = new DataSource();

        String query = "SELECT id_rp, name_rp, info_rp, date_rp, fk_id_cf FROM reports_rp WHERE fk_id_cf = " + id;

        List<Reports> reportsList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs1 = stmt.executeQuery(query);
        ) {
            while (rs1.next()) { reportsList.add( new Reports(
                    rs1.getLong("id_rp"),
                    rs1.getString("name_rp"),
                    rs1.getString("info_rp"),
                    rs1.getString("date_rp"),
                    rs1.getLong("fk_id_cf")
            ) );
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return reportsList;
    }

}
