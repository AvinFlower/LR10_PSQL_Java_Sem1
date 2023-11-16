package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static Connection connection = null;
    static Statement statement = null;
    public static void main(String[] args) throws SQLException {
        connect();
        statement.execute("DROP TABLE if EXISTS public.progress;\n" +
                "\n" +
                "DROP TABLE if EXISTS public.students;\n" +
                "\n" +
                "DROP TABLE if EXISTS public.subjects;");

        statement.execute("CREATE TABLE IF NOT EXISTS students\n" +
                "(id serial NOT NULL PRIMARY KEY,\n" +
                " Name varchar(30) NOT NULL,\n" +
                " PassportSerial varchar(4) not null,\n" +
                " PassportNumber varchar(6) not null,\n" +
                " UNIQUE (PassportSerial, PassportNumber)\n" +
                ");");

        statement.execute("CREATE TABLE IF NOT EXISTS subjects\n" +
                "(id serial NOT NULL PRIMARY KEY,\n" +
                " name varchar(50) NOT NULL\n" +
                ");");

        statement.execute("CREATE TABLE IF NOT EXISTS progress\n" +
                "(id serial NOT NULL PRIMARY KEY,\n" +
                " student int NOT NULL REFERENCES students(id) ON DELETE CASCADE,\n" +
                " subject int NOT NULL REFERENCES subjects(id) ON DELETE CASCADE,\n" +
                " mark smallint NOT NULL CHECK(mark BETWEEN 2 and 5)\n" +
                ");");


        statement.execute("INSERT into students (id, name, PassportSerial, PassportNumber)\n" +
                "values\n" +
                "    (1, 'Иван', 3344, 987654),\n" +
                "    (2, 'Аня', 3355, 876543),\n" +
                "    (3, 'Гриша', 3366, 765432),\n" +
                "    (4, 'Таня', 3377, 654321),\n" +
                "    (5, 'Сергей', 3388, 543210),\n" +
                "    (6, 'Миша', 3399, 432109),\n" +
                "    (7, 'Дима', 3300, 321098),\n" +
                "    (8, 'Наташа', 3311, 210987),\n" +
                "    (9, 'Вика', 3322, 109876),\n" +
                "    (10, 'Артем', 3333, 987012),\n" +
                "    (11, 'Ольга', 3344, 876543),\n" +
                "    (12, 'Денис', 3355, 765432),\n" +
                "    (13, 'Елена', 3366, 654321),\n" +
                "    (14, 'Саша', 3377, 543210),\n" +
                "    (15, 'Лев', 3388, 432109),\n" +
                "    (16, 'Алиса', 3399, 321098),\n" +
                "    (17, 'Влад', 3300, 210987),\n" +
                "    (18, 'Юлия', 3311, 109876),\n" +
                "    (19, 'Игорь', 3322, 987012),\n" +
                "    (20, 'Мария', 3333, 876543);");

        statement.execute("INSERT INTO subjects (id, name)\n" +
                "values\n" +
                "    (1, 'Математика'),\n" +
                "    (2, 'Русский язык'),\n" +
                "    (3, 'Физика'),\n" +
                "    (4, 'Иностранный язык'),\n" +
                "    (5, 'ОБЖ'),\n" +
                "    (6, 'Физкультура');\n");

        statement.execute("INSERT into progress (id, student, subject, mark)\n" +
                "values\n" +
                "    (1, 1, 4, 2),\n" +
                "    (2, 2, 1, 5),\n" +
                "    (3, 4, 6, 2),\n" +
                "    (4, 1, 1, 3),\n" +
                "    (5, 4, 2, 3),\n" +
                "    (6, 4, 3, 3),\n" +
                "    (7, 5, 4, 4),\n" +
                "    (8, 5, 5, 4),\n" +
                "    (9, 5, 6, 4),\n" +
                "    (10, 1, 1, 5),\n" +
                "    (11, 6, 2, 5),\n" +
                "    (12, 6, 3, 5),\n" +
                "    (13, 7, 4, 3),\n" +
                "    (14, 7, 5, 3),\n" +
                "    (15, 7, 6, 3),\n" +
                "    (16, 8, 1, 4),\n" +
                "    (17, 8, 2, 4),\n" +
                "    (18, 8, 3, 4),\n" +
                "    (19, 9, 4, 5),\n" +
                "    (20, 9, 5, 5),\n" +
                "    (21, 11, 4, 2),\n" +
                "    (22, 11, 5, 2),\n" +
                "    (23, 12, 6, 2),\n" +
                "    (24, 12, 1, 3),\n" +
                "    (25, 13, 2, 3),\n" +
                "    (26, 13, 3, 3),\n" +
                "    (27, 14, 4, 4),\n" +
                "    (28, 14, 5, 4),\n" +
                "    (29, 15, 6, 4),\n" +
                "    (30, 15, 1, 5),\n" +
                "    (31, 16, 2, 5),\n" +
                "    (32, 16, 3, 5),\n" +
                "    (33, 17, 4, 3),\n" +
                "    (34, 17, 5, 3),\n" +
                "    (35, 18, 6, 3),\n" +
                "    (36, 18, 1, 4),\n" +
                "    (37, 18, 2, 4),\n" +
                "    (38, 18, 3, 4),\n" +
                "    (39, 2, 4, 5),\n" +
                "    (40, 1, 5, 5),\n" +

                "    (41, 3, 1, 5),\n" +
                "    (42, 3, 2, 5),\n" +
                "    (43, 3, 3, 5),\n" +
                "    (44, 3, 4, 5),\n" +
                "    (45, 3, 5, 5),\n" +
                "    (46, 3, 6, 5),\n" +

                "    (47, 19, 1, 5),\n" +
                "    (48, 19, 2, 5),\n" +
                "    (49, 19, 3, 5),\n" +
                "    (50, 19, 4, 5),\n" +
                "    (51, 19, 5, 5),\n" +
                "    (52, 19, 6, 5);");

        statement.execute("DELETE FROM subjects\n" +
                "WHERE id = 6;");

        System.out.println("Список студентов, сдавших определенный предмет, на оценку выше 3");
        var marks = statement.executeQuery("SELECT s.name, p.mark, ss.name from students s\n" +
                "JOIN progress p\n" +
                "ON s.id = p.student\n" +
                "JOIN subjects ss\n" +
                "ON p.subject = ss.id\n" +
                "WHERE p.mark > 3 and ss.name = 'ОБЖ';");

        while (marks.next()) {
            String subN = marks.getString(1);
            int mark = marks.getInt(2);
            String studN = marks.getString(3);
            System.out.println(subN + " " + mark + " " + studN);
        }


        System.out.println("Cредний балл по определенному предмету");
        var marksavg = statement.executeQuery("SELECT avg(p.mark) AS \"Средний балл\" FROM progress p\n" +
                "JOIN subjects s\n" +
                "ON p.subject = s.id\n" +
                "WHERE s.name = 'Математика';");

        while (marksavg.next()) {
            double avg = marksavg.getDouble(1);
            System.out.println(avg);
        }


        System.out.println("Cредний балл по определенному студенту");
        var studentavg = statement.executeQuery("SELECT avg(p.mark) AS \"Средний балл\" FROM progress p\n" +
                "JOIN subjects s ON p.subject = s.id\n" +
                "JOIN students s2 ON p.student = s2.id\n" +
                "WHERE s2.name = 'Иван';");

        while (studentavg.next()) {
            double avg = studentavg.getDouble(1);
            System.out.println(avg);
        }


        System.out.println("Три премета, которые сдали наибольшее количество студентов");
        var maxSub = statement.executeQuery("SELECT count(*), s.name from progress p\n" +
                "JOIN subjects s \n" +
                "ON s.id = p.subject\n" +
                "WHERE p.mark > 3\n" +
                "GROUP BY s.name\n" +
                "ORDER BY count(*) desc limit 3;");
        while (maxSub.next()) {
            int cnt = maxSub.getInt(1);
            String name  =  maxSub.getString(2);
            System.out.println(cnt + " " + name);
        }

        System.out.println("Студенты на повышенной стипендии");
        var highStud = statement.executeQuery("SELECT s.name AS student, COUNT(p.subject) AS countSubjects FROM students s " +
                "JOIN progress p " +
                "ON s.id = p.student " +
                "WHERE p.mark = 5 " +
                "GROUP BY s.id, s.name " +
                "HAVING COUNT(p.subject) = (SELECT COUNT(*) FROM subjects);");

        while (highStud.next()) {
            String studN = highStud.getString(1);
            int mark = highStud.getInt(2);
            System.out.println(studN + " " + mark);
        }

        System.out.println();

        disconnect();
    }

    public static void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "299NhbnjY");
            statement = connection.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try{
            statement.close();
            System.out.println("Disconnected");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}