import java.sql.{Connection, DriverManager, Statement}


    // Database connection properties
    val url = "jdbc:postgresql://localhost:5432/test_1"
    val user = "root"
    val password = "root"

    // Create a connection to the database
    val connection: Connection = DriverManager.getConnection(url, user, password)

    // Create a statement object to execute SQL commands
    val statement: Statement = connection.createStatement()

    // SQL command to create a table
    val createTableSQL =
      """
        |CREATE TABLE IF NOT EXISTS users (
        |  id SERIAL PRIMARY KEY,
        |  name VARCHAR(255),
        |  age INT
        |);
      """.stripMargin

    // Execute the create table command
  statement.execute(createTableSQL)

  // Insert 100 records into the table
  for (i <- 1 to 100) {
    val name = s"User $i"
    val age = scala.util.Random.nextInt(100) + 1
    val insertSQL = s"INSERT INTO users (name, age) VALUES ('$name', $age);"
    statement.execute(insertSQL)
  }

  // Close the statement and connection
  statement.close()
  connection.close()

  println("Table created and 100 records inserted successfully.")

