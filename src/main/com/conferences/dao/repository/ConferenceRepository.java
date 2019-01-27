package conferences.dao.repository;

import conferences.dao.entities.Conferences;
import conferences.dao.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConferenceRepository {


    public List<Conferences> getConferences() {

        DataSource dataSource = new DataSource();

        String query = "SELECT id_cf, name_cf, info_cf, date_cf  FROM conferences_cf ";


        List<Conferences> conferencesList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
        ) {

            while (rs.next()) { conferencesList.add( new Conferences(
                        rs.getLong("id_cf"),
                        rs.getString("name_cf"),
                        rs.getString("info_cf"),
                        rs.getString("date_cf")
              ) );
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return conferencesList;
    }



}
