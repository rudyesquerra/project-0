package com.revature.collegeapp.repositories

import java.sql.{Connection, PreparedStatement, ResultSet, Statement}

import com.revature.collegeapp.entities.Course

import scala.collection.mutable.ArrayBuffer

case class CourseDAO(conn: Connection) extends T_CourseDAO {
  //Object of class Connection from java.sql.Connect because we can have an object from any sql connection and we can change it to Oracle, Postgres, etc.

  //def this(conn:MyConnector) {this(CourseDAO.myConn)}
  //The user of this class will declare the connection that corresponds

  override def save(course: Course): Unit = {
    if (course == null) return

    /* The main feature of a PreparedStatement object is that, unlike a Statement object, it is given a SQL statement when it is created.
    Instead of hard coding queries, PreparedStatement object provides a feature to execute a parameterized query
    PreparedStatement.getGeneratedKeys returns the key that was generated from the given statement*/

    val ps: PreparedStatement = conn.prepareStatement("insert into courses (courseName,professor,doWeek,shift) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)

    try {
      ps.setString(1, course.courseName) //Validates that these are secure coding sequences - validates security - we delegate security on Java
      ps.setString(2, course.professor)
      ps.setString(3, course.doWeek.toString)
      ps.setString(4, course.shift.toString)
      ps.execute()
      val rs: ResultSet = ps.getGeneratedKeys //This returns a ResultSet with the generated keys, in this case it will only return one key since we are only injecting one record
      if (rs.next) { //This returns a boolean
        course.setId(rs.getInt(1))
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  override def remove(course: scala.List[String]): Unit = {
    if (course == null) return
    val st: Statement = conn.createStatement()
    val query: String = "delete from courses where id=" + course(0)
    try {
      st.execute(query)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  override def update(course: scala.List[String]): Unit = {
    if (course == null) return

      val ps = conn.prepareStatement("update students set firstname=?, lastname=?, age=?, courseid=? where studentid=?")
      try {
        ps.setString(1, course(1))
        ps.setString(2, course(2))
        ps.setString(3, course(3))
        ps.setString(4, course(4))
        ps.setInt(5, course(0).toInt)
        ps.execute()
      } catch {
        case e: Exception =>
          e.printStackTrace()
      } finally if (ps != null) ps.close()

  }

  override def getAll(): scala.List[String] = {
    val array = ArrayBuffer[String]()
    val rs = conn.createStatement.executeQuery("select * from courses")
    try {
      while (rs.next) {
        array.append(
          rs.getInt("id").toString,
          rs.getString("courseName"),
          rs.getString("professor"),
          rs.getString("doWeek"),
          rs.getString("shift")
        )
      }
    }
    catch {
      case e: Exception =>
        e.printStackTrace()
    }
    array.toList
  }

  override def getById(id: Int): scala.List[String] = {
    val array = ArrayBuffer[String]()
    val rs = conn.createStatement.executeQuery("select * from courses where id=" + id)
    try {
      if (rs.next) {
        array.append(
          rs.getInt("id").toString,
          rs.getString("courseName"),
          rs.getString("professor"),
          rs.getString("doWeek"),
          rs.getString("shift")
        )
      }
    }
    catch {
      case e: Exception =>
        e.printStackTrace()
    }
    array.toList
  }
}
