package com.revature.collegeapp
import java.sql.{Connection, PreparedStatement, ResultSet, Statement}
import java.util.List

import com.fasterxml.jackson.annotation.JsonFormat.Value
import com.revature.collegeapp.DoWeek.DoWeek
import com.revature.collegeapp.Shift.Shift

import scala.collection.mutable.ArrayBuffer

  case class CourseDAO(conn:Connection) extends T_CourseDAO {
    //Object of class Connection from java.sql.Connect because we can have an object from any sql connection and we can change it to Oracle, Postgres, etc.
    var course:Course = _

    //def this(conn:MyConnector) {this(CourseDAO.myConn)}
    //The user of this class will declare the connection that corresponds

    override def save(course: Course): Unit = {
      if (course == null) return


      //The main feature of a PreparedStatement object is that, unlike a Statement object, it is given a SQL statement when it is created.
      //Instead of hard coding queries, PreparedStatement object provides a feature to execute a parameterized query

      //PreparedStatement.getGeneratedKeys returns the key that was generated from the given statement
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

    override def remove(course: Course): Unit = {
      if(course == null) return
      val st:Statement = conn.createStatement()
      val query:String = "delete from courses where id=" + course.getId()
      try{
        st.execute(query)
      } catch {
        case e: Exception =>
          e.printStackTrace()
      }
    }

    override def update(course: Course): Unit = ???

    override def getAll(): scala.List[Course] = {
      var array = ArrayBuffer[Course]()
      val rs = conn.createStatement.executeQuery("select * from courses")
      try {
        while (rs.next) {
          array.append(Course(
            rs.getInt("id"),
            rs.getString("courseName"),
            rs.getString("professor"),
            DoWeek.withName(rs.getString("doWeek")),
            Shift.withName(rs.getString("shift"))
          ))
        }
      }
      catch {
        case e: Exception =>
          e.printStackTrace()
      }
       array.toList
    }

    override def getById(id: Int): Course = {
      val curso:Course = null
      val rs = conn.createStatement.executeQuery("select * from courses where id="+id)
      try {
        if (rs.next) {
            Course(
            rs.getInt("id"),
            rs.getString("courseName"),
            rs.getString("professor"),
            DoWeek.withName(rs.getString("doWeek")),
            Shift.withName(rs.getString("shift"))
          )
        }
      }
      catch {
        case e: Exception =>
          e.printStackTrace()
      }
      curso
    }

    override def getLikeCourse: Unit = ???


  }

object CourseDAO