import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {
    public static final String CONNECTION_STRING=
            "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
private static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {
         connection = getConnection();
         
        System.out.println("Enter exercise number:");
        int exNum= Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 2: exTwo();
            case 3: exThree();
            case 4: exFour();
            case 5: exFive();
            case 6: exSix();
            case 7: printAllMinionsNames();
            case 8: exEight();
            case 9: exNine();
        }







        }




    private static void exTwo() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("select v.name , count(Distinct  mv.minion_id) as `m_count`  from villains v " +
                        "JOIN minions_villains mv on v.id = mv.villain_id " +
                        "group by v.name " +
                        "having m_count > ?; ");

        preparedStatement.setInt(1, 15);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d %n ", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void exThree() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

       String villainName= findVillainNameById(villainId);

        System.out.println(villainName);
    }
    private static void exFour() throws IOException, SQLException {
        System.out.println("Minion input:");
String minion = reader.readLine().split(": ")[1];
        System.out.println("Villain input:");
String villain = reader.readLine().split(": ")[1];
addMinion(minion,villain);
    }

    private static void exFive() throws IOException, SQLException {
        System.out.println("Enter country name:");
        String countryName = reader.readLine();
        PreparedStatement preparedStatement = connection.prepareStatement("update towns set name = upper(name) where country =?");
        preparedStatement.setString(1, countryName);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("No town names were affected.");

            return;
        }
        System.out.printf("%d town names were affected.%n", affectedRows);
        preparedStatement = connection.prepareStatement("SELECT name FROM towns WHERE country=?");
        preparedStatement.setString(1, countryName);
        ResultSet rs = preparedStatement.executeQuery();
        String[] result = new String[affectedRows];
        int i = 0;

        while (rs.next()) {
            result[i++] = rs.getString(1);
        }
        System.out.println(Arrays.toString(result));
    }



    private static void exSix() throws IOException, SQLException {
        System.out.println("Enter Villain ID:");
      Integer  id = Integer.parseInt(reader.readLine());
      removeVillainById(id);
    }
    private static void exEight() throws IOException, SQLException {
        System.out.println("Enter minion IDs (separated by space):");
        int[] minionsIds = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE minions SET age=age+1, name=LOWER(name)  WHERE id=?;");
        for (int minionId:minionsIds) {
preparedStatement.setInt(1,minionId);
preparedStatement.execute();
        }
        preparedStatement= connection.prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " + resultSet.getInt(3));
        }
    }
    private static void exNine() throws IOException, SQLException {
        //DELIMITER //
       // CREATE PROCEDURE usp_get_older( minion_id INT)
       // BEGIN
       // UPDATE minions
       // SET age = age + 1
       // WHERE id = minion_id;
       // END //
             //  DELIMITER ;
        System.out.println("Enter Minion Id:");
        int id = Integer.parseInt(reader.readLine());
        increaseAgeUsingStoredProcedure(id);
    }

    private static void increaseAgeUsingStoredProcedure(int id) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("CALL `usp_get_older`(?) ");
        callableStatement.setInt(1,id);
        callableStatement.execute();
        PreparedStatement preparedStatement= connection.prepareStatement("Select name,age from minions where id=?");
        preparedStatement.setInt(1,id);
      ResultSet resultSet= preparedStatement.executeQuery();
if (resultSet.next()){
    System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
}
    }


    private static void removeVillainById(Integer villainID) throws SQLException {
        String villainName = getEntityNameById("villains",villainID);
        if (villainName.equals("")){
            System.out.println("No such villain was found");
            return;
        }
        System.out.printf("%s was deleted.%n",villainName);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        preparedStatement.setInt(1,villainID);
        int affectedRows = preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM villains WHERE id=?");
preparedStatement.setInt(1,villainID);
preparedStatement.execute();
        System.out.printf("%d minions released%n", affectedRows);

    }

    private static void addMinion(String minion, String villain) throws SQLException {
        String townName = minion.split(" ")[2];
        String minionName = minion.split(" ")[0];
        Integer minionAge = Integer.parseInt(minion.split(" ")[1]);
        Integer minionId = getEntityIdByName("towns", minionName);
        Integer townId = getEntityIdByName("towns", townName);
        Integer villainId = getEntityIdByName("villains", villain);
        if (townId < 0) {
            String query = String.format("INSERT INTO towns (`name`)  VALUES (\"%s\");", townName);
         PreparedStatement   preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.printf("Town %s was added to the database.%n", townName);
            townId = getEntityIdByName("towns", townName);
        }
        if (villainId < 0) {
            String query = String.format("INSERT INTO villains (`name`,`evilness_factor`)  VALUES (\"%s\",\"evil\");", villain);
     PreparedStatement       preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.printf("Villain %s was added to the database.%n", villain);
            villainId = getEntityIdByName("villains", villain);
        }
        if (minionId < 0) {
            String query = String.format("INSERT INTO minions (`name`,`age`,`town_id`)  VALUES (\"%s\",\"%d\",\"%s\");", minionName, minionAge, townId);
      PreparedStatement      preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            minionId = getEntityIdByName("minions", minionName);
        }
        String query = String.format("INSERT INTO minions_villains   VALUES (\"%d\",\"%d\");", minionId, villainId);
      PreparedStatement  preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villain);

    }
    private static String getEntityNameById(String tableName, Integer id) throws SQLException {
        String query = String.format("Select  name from %s where id =?;", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);

        } else {
            return "";
        }
    }
    private static void getMinionNames(int villainId) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.name, m.name,m.age FROM minions_villains JOIN minions m on m.id = minions_villains.minion_id JOIN villains v on v.id = minions_villains.villain_id WHERE villain_id=?;");
        preparedStatement.setInt(1,villainId);
        ResultSet resultSet= preparedStatement.executeQuery();
        System.out.printf("Villain: %s%n", getEntityNameById("villains", villainId));
if (resultSet.isBeforeFirst()){
    while   (resultSet.next()){
        System.out.printf("%d. %s %d%n", resultSet.getRow(), resultSet.getString(2), resultSet.getInt(3));

    }

}else{
    System.out.printf("No villain with ID %d exists in the database.%n", villainId);

}
    }
    private static void getVillainsName() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT v.name, count(DISTINCT mv.minion_id) as countOfMinons FROM villains as v JOIN minions_villains mv on v.id = mv.villain_id GROUP BY name HAVING countOfMinons>15 ORDER BY countOfMinons DESC ;");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
        }
    }

    private static Integer getEntityIdByName(String tableName, String name) throws SQLException {
        String query = String.format("SELECT id FROM %s where name=?;", tableName);
       PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return -1;
        }
    }

    private static String findVillainNameById( int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.
                prepareStatement("select name from villains where id =?;");
        preparedStatement.setInt(1,villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    return resultSet.getString("name");
        }
    private static void printAllMinionsNames() throws SQLException {
      PreparedStatement  preparedStatement = connection.prepareStatement("SELECT name FROM minions");
        ResultSet rs = preparedStatement.executeQuery();
        List<String> minions = new ArrayList<>();

        while (rs.next()) {
            minions.add(rs.getString(1));
        }

        int start = 0;
        int end = minions.size() - 1;

        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minions.get(start++)
                    : minions.get(end--)
            );

        }
    }

    private static Connection getConnection() throws IOException, SQLException {
   //     System.out.println("Enter user:");
     //   String user = reader.readLine();
    //    System.out.println("Enter password:");
    //    String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "softuni93");

        return DriverManager
                .getConnection(CONNECTION_STRING + DB_NAME, properties);
    }
}

