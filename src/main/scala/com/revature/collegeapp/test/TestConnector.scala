package com.revature.collegeapp.test

import java.sql.Connection

import com.revature.collegeapp.connectors.MyConnector

object TestConnector {
  def main(args: Array[String]): Unit = {
    val conn: Connection = MyConnector.getConnection()
    val query: String = "insert into courses (courseName,professor,doWeek,shift) values('PHP','Gomez','Friday','Morning')"
    conn.createStatement().execute(query)

    MyConnector.getConnection().createStatement().execute(("insert into courses (courseName,professor,doWeek,shift) values('HTML','Sosa','Monday','Night')"))

    val resultSet = MyConnector.getConnection().createStatement().executeQuery("select * from courses;")
    while (resultSet.next()) {
      println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getString(4))
    }
  }
}
