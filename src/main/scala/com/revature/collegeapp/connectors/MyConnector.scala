package com.revature.collegeapp.connectors

import java.sql.{Connection, DriverManager, SQLException}

object MyConnector {
  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/college"
  val username = "root"
  val password = "nicole10"
  var conn: Connection = _;

  //synchronized avoids that two process run at the same time, when someone is creating the connection
  //the next process will have to wait until the creation process finishes, this gives our program more
  //stability and security

  def getConnection(): Connection = synchronized {
    try {
      if (conn == null || conn.isClosed()) {
        Class.forName(driver) //Register the driver because mysql class implement the Driver Interface
        conn = DriverManager.getConnection(url, username, password) //Returns the connection
        /*    val resultSet = conn.createStatement().executeQuery("select * from courses;")
        while (resultSet.next()) {
          println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getString(4))
        }*/
      }
    }
    catch {
      case e: Exception => println("exception caught inside the method: " + e);
      case e: SQLException => println("Conection problem" + e);
      case e: ClassNotFoundException => println("Couldn't find driver" + e)

    }
    return conn
    //conn.close()
  }

  //getConnection()
  //println(conn)
}
