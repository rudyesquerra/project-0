package com.revature.collegeapp.dao
import java.sql.{Connection, PreparedStatement, ResultSet, SQLException, SQLIntegrityConstraintViolationException, Statement}

import com.mysql.cj.jdbc.exceptions.{SQLError, SQLExceptionsMapping}
import com.revature.collegeapp.entities.Professor

import scala.collection.mutable.ArrayBuffer

case class ProfessorDAO(conn: Connection) extends T_ProfessorDAO {

  override def save(professor: Professor): Unit = {
    if (professor == null) return

    val ps: PreparedStatement = conn.prepareStatement("insert into professors (firstName,lastName,courseId) values (?,?,?)", Statement.RETURN_GENERATED_KEYS)

    try {
      ps.setString(1, professor.firstName) //Validates that these are secure coding sequences - validates security - we delegate security on Java
      ps.setString(2, professor.lastName)
      ps.setString(3, professor.courseId.toString)
      ps.execute()
      val rs: ResultSet = ps.getGeneratedKeys //This returns a ResultSet with the generated keys, in this case it will only return one key since we are only injecting one record
      if (rs.next) { //This returns a boolean
        professor.setProfessorId(rs.getInt(1))
      }
    } catch {
      case e: SQLIntegrityConstraintViolationException  => println("Course does not exists, please check and try again..." + e);
      case e: Exception => e.printStackTrace()
    }
  }

  override def remove(professor: scala.List[String]): Unit = {
    if (professor == null) return
    val st: Statement = conn.createStatement()
    val query: String = "delete from professors where professorid=" + professor(0)
    try {
      st.execute(query)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

  override def update(professor: scala.List[String]): Unit = {
    if (professor == null) return

    val ps = conn.prepareStatement("update professors set firstName=?, lastName=?, courseId=? where professorid=?")
    try {
      ps.setString(1, professor(1))
      ps.setString(2, professor(2))
      ps.setString(3, professor(3))
      ps.setInt(4, professor(0).toInt)
      ps.execute()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    } finally if (ps != null) ps.close()

  }

  override def getAll(): scala.List[String] = {
    val array = ArrayBuffer[String]()
    val rs = conn.createStatement.executeQuery("select * from professors")
    try {
      while (rs.next) {
        array.append(
          rs.getInt("professorId").toString,
          rs.getString("firstName"),
          rs.getString("lastName"),
          rs.getString("courseId")
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
    val rs = conn.createStatement.executeQuery("select * from professors where professorid=" + id)
    try {
      if (rs.next) {
        array.append(
          rs.getInt("professorId").toString,
          rs.getString("firstName"),
          rs.getString("lastName"),
          rs.getString("courseId")
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
