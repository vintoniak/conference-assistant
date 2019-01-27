package conferences.dao.repository;

import conferences.dao.entities.Questions;
import conferences.dao.entities.Reports;

import javax.management.ObjectName;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuestionRepository {

    public List<Questions> getQuestionsByIdRp(String id) {

        DataSource dataSource = new DataSource();
        String query = " SELECT id_question_qs, question_qs, answer_qs, ratind_qs,  fk_id_rp, fk_id_usr FROM questions_qs WHERE fk_id_rp = " + id;
        List<Questions> questionsList = new ArrayList<>();


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs1 = stmt.executeQuery(query);
        ) {
            while (rs1.next()) { questionsList.add( new Questions(
                    rs1.getLong("id_question_qs"),
                    rs1.getString("question_qs"),
                    rs1.getString("answer_qs"),
                    rs1.getLong("ratind_qs"),
                    rs1.getLong("fk_id_rp"),
                    rs1.getLong("fk_id_usr")
            ) );
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return questionsList;
    };


    public List<Questions> getQuestionByIdQs( String id_qs, String rating) {

        DataSource dataSource = new DataSource();
        String query = " SELECT id_question_qs, question_qs, answer_qs, ratind_qs,  fk_id_rp, fk_id_usr " +
                "FROM questions_qs WHERE id_question_qs='" + id_qs + "'";
        List<Questions> replaceList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs1 = stmt.executeQuery(query);
        ) {
            while (rs1.next()) { replaceList.add( new Questions(
                    rs1.getLong("id_question_qs"),
                    rs1.getString("question_qs"),
                    rs1.getString("answer_qs" ),
                    rs1.getLong("ratind_qs" +1),
                    rs1.getLong("fk_id_rp"),
                    rs1.getLong("fk_id_usr")
            ) );

            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return replaceList;
    };


    public void saveQuestion(Questions questions_qs) {
        DataSource dataSource = new DataSource();
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO questions_qs (question_qs, answer_qs, ratind_qs, fk_id_rp, fk_id_usr) VALUES (?,?,?,?,?)")
        ) {
            stmt.setString(1, questions_qs.getQuestion());
            stmt.setString(2, questions_qs.getAnswer());
            stmt.setLong(3, questions_qs.getRating());
            stmt.setLong(4, questions_qs.getId_rp());
            stmt.setLong(5, questions_qs.getId_usr());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

