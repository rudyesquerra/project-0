package com.revature.collegeapp.dao
import java.sql.{Connection, PreparedStatement, ResultSet, Statement}

import com.revature.collegeapp.entities.{Student}

import scala.collection.mutable.ArrayBuffer

case class StudentDAO(conn: Connection) extends T_StudentDAO {

  override def save(student: Student): Unit = {
    if (student == null) return

    val ps: PreparedStatement = conn.prepareStatement("insert into students (firstName,lastName,age,courseId) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)

    try {
      ps.setString(1, student.firstName) //Validates that these are secure coding sequences - validates security - we delegate security on Java
      ps.setString(2, student.lastName)
      ps.setString(3, student.age.toString)
      ps.setString(4, student.courseId.toString)
      ps.execute()
      val rs: ResultSet = ps.getGeneratedKeys //This returns a ResultSet with the generated keys, in this case it will only return one key since we are only injecting one record
      if (rs.next) { //This returns a boolean
        student.setStudentId(rs.getInt(1))
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  override def remove(student: scala.List[String]): Unit = {
    if (student == null) return
    val st: Statement = conn.createStatement()
    val query: String = "delete from students where studentid=" + student(0)
    try {
      st.execute(query)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  override def update(student: scala.List[String]): Unit = {
    if (student == null) return

    val ps = conn.prepareStatement("update students set firstName=?, lastName=?, age=?, courseId=? where studentid=?")
    try {
      ps.setString(1, student(1))
      ps.setString(2, student(2))
      ps.setString(3, student(3))
      ps.setString(4, student(4))
      ps.setInt(5, student(0).toInt)
      ps.execute()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    } finally if (ps != null) ps.close()

  }

  override def getAll(): scala.List[String] = {
    val array = ArrayBuffer[String]()
    val rs = conn.createStatement.executeQuery("select * from students")
    try {
      while (rs.next) {
        array.append(
          rs.getInt("studentId").toString,
          rs.getString("firstName"),
          rs.getString("lastName"),
          rs.getString("age"),
          rs.getString("studentId")
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
    val rs = conn.createStatement.executeQuery("select * from students where studentid=" + id)
    try {
      if (rs.next) {
        array.append(
          rs.getInt("studentId").toString,
          rs.getString("firstName"),
          rs.getString("lastName"),
          rs.getString("age"),
          rs.getString("studentId")
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
