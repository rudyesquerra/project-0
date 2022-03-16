package com.revature.collegeapp.test

import java.sql.{SQLException, SQLIntegrityConstraintViolationException}

import com.revature.collegeapp.connectors.MyConnector
import com.revature.collegeapp.entities.{Course, Professor, Student}
import com.revature.collegeapp.enums.{DoWeek, Shift}
import com.revature.collegeapp.dao.{CourseDAO, ProfessorDAO, StudentDAO, T_CourseDAO, T_ProfessorDAO, T_StudentDAO}

import scala.io.StdIn._
import scala.util.control.Breaks.break

object TestDAO {
  def main(args: Array[String]): Unit = {
    val cr: T_CourseDAO = CourseDAO(MyConnector.getConnection()) //Polymorphism - the idea is to change database for example instead of jdbc to a mongodb nosql
    val sr: T_StudentDAO = StudentDAO(MyConnector.getConnection())
    val pr: T_ProfessorDAO = ProfessorDAO(MyConnector.getConnection())

    println("********************Welcome to the college app********************\n******************************************************************\n******************************************************************")
    while(true) {
      try {
        print("Enter 1 to CREATE, 2 to READ, 3 to UPDATE, 4 to DELETE: ")
        val input1 = readInt()
        input1 match {
          case 1 =>
            while(true) {
              try {
                print("Type 's' to create a STUDENT, 'p' for PROFESSOR or 'c' for COURSE: ")
                val inputType = readLine()
                inputType match {
                  case "s" =>
                    print("Enter the sudent first name: ")
                    val firstName = readLine()
                    print("Enter the sudent last name: ")
                    val lastName = readLine()
                    print("Enter the sudent age: ")
                    val studentAge = readInt()
                    print("Enter the course number: ")
                    val courseNumber = readInt()
                    val student = new Student(s"$firstName", s"$lastName", studentAge, courseNumber)
                    sr.save(student)
                    println("The student was saved succesfully")
                    return
                  case "p" =>
                    print("Enter the professor first name: ")
                    val firstName = readLine()
                    print("Enter the professor last name: ")
                    val lastName = readLine()
                    print("Enter the professor course number: ")
                    val courseNumber = readInt()
                    val professor = new Professor(s"$firstName", s"$lastName", courseNumber)
                    pr.save(professor)
                    println("The professor was saved succesfully")
                    return
                  case "c" =>
                    while(true){
                      try {
                        print("Enter the course name: ")
                        val courseName = readLine()
                        print("Enter the professor last name: ")
                        val lastName = readLine()
                        print("Enter the day of the week: ")
                        var doWeek = readLine().toLowerCase()
                        doWeek match {
                          case "monday" =>
                            while(true) {
                              var doWeek = DoWeek.Monday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case "tuesday" =>
                            while(true) {
                              var doWeek = DoWeek.Tuesday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case "wednesday" =>
                            while(true) {
                              var doWeek = DoWeek.Wednesday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case "thursday" =>
                            while(true) {
                              var doWeek = DoWeek.Thursday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case "friday" =>
                            while(true) {
                              var doWeek = DoWeek.Friday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case "saturday" =>
                            while(true) {
                              var doWeek = DoWeek.Saturday
                              print("Enter the shift: ")
                              var shift = readLine().toLowerCase()
                              shift match {
                                case "morning" =>
                                  var shift = Shift.Morning
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "evening" =>
                                  var shift = Shift.Evening
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case "night" =>
                                  var shift = Shift.Night
                                  val course = new Course(s"$courseName", s"$lastName", doWeek, shift)
                                  cr.save(course)
                                  println("The course was saved succesfully")
                                  return
                                case _ => println("Not an option, please enter morning, evening or night")
                              }
                            }
                          case _ => println("Not a valid option, enter enter Monday thru Saturday...")
                        }
                      }
                      catch {
                        case e: Exception => println("Not a valid option" + e);
                      }
                    }
                    return
                }
              }
              catch {
                case e: Exception => println("Not a valid option choose s, p or c " + e);
              }
            }
          case 2 =>
            while(true) {
              try {
                print("Type s to consult a STUDENT, p for PROFESSOR or c for COURSE: ")
                val inputType = readLine()
                inputType match {
                  case "s" =>
                    print("Enter the student id: ")
                    var studentId= readInt()
                    print("The student name is ")
                    print(sr.getById(studentId)(1)+ " ")
                    print(sr.getById(studentId)(2)+ " ")
                    return
                  case "p" =>
                    print("Enter the professor id: ")
                    var professorId= readInt()
                    print("The professor name is ")
                    print(pr.getById(professorId)(1)+ " ")
                    print(pr.getById(professorId)(2)+ " ")
                    return
                  case "c" =>
                    print("Enter the course id: ")
                    var courseId= readInt()
                    println("The course information is ")
                    cr.getById(courseId).foreach(println)
                    return
                  case _ => println("Not a valid option, enter enter \"s\" for student, \"p\" for professor or \"c\" for course...")
                }
              }
              catch {
                case e: Exception => println("Not a valid option" + e);
              }
            }
          case 3 => while(true) {
            try {
              print("Type s to update a STUDENT, p for PROFESSOR or c for COURSE: ")
              val inputType = readLine()
              inputType match {
                case "s" =>
                  print("Enter the student id: ")
                  val studentId = readInt()
                  print("Enter student updated last name: ")
                  val updatedLastName = readLine()
                  val student: List[String] = sr.getById(studentId)
                  if (student != null && student(0) != 0) {
                    val updatedStudent: List[String] = student.updated(2, updatedLastName)
                    sr.update(updatedStudent)
                    println("Student updated succesfully")
                  }
                  return
                case "p" =>
                  print("Enter the professor id: ")
                  val professorId = readInt()
                  print("Enter professor updated last name: ")
                  val updatedLastName = readLine()
                  val professor: List[String] = pr.getById(professorId)
                  if (professor != null && professor(0) != 0) {
                    val updatedProfessor: List[String] = professor.updated(2, updatedLastName)
                    pr.update(updatedProfessor)
                    println("Professor updated succesfully")
                  }
                  return
                case "c" =>
                  print("Enter the course id: ")
                  val courseId = readInt()
                  print("Enter course updated name: ")
                  val updatedCourseName = readLine()
                  val course: List[String] = cr.getById(courseId)
                  if (course != null && course(0) != 0) {
                    val updatedCourse: List[String] = course.updated(1, updatedCourseName)
                    cr.update(updatedCourse)
                    println("Course updated succesfully")
                  }
                  return
                case _ => println("Not a valid option, enter enter \"s\" for student, \"p\" for professor or \"c\" for course...")
              }
            }
            catch {
              case e: Exception => println("Not a valid option" + e);
            }
          }
          case 4 =>
            while(true) {
              try {
                print("Type s to delete a STUDENT, p for PROFESSOR or c for COURSE: ")
                val inputType = readLine()
                inputType match {
                  case "s" =>
                    print("Enter the student id: ")
                    var studentId= readInt()
                    sr.remove(sr.getById(studentId))
                    println("Student removed succesfully")
                    return
                  case "p" =>
                    print("Enter the professor id: ")
                    var professorId= readInt()
                    pr.remove(pr.getById(professorId))
                    println("Professor removed succesfully")
                    return
                  case "c" =>
                    print("Enter the course id: ")
                    var courseId= readInt()
                    cr.remove(cr.getById(courseId))
                    println("Course removed succesfully")
                    return
                  case _ => println("Not a valid option, enter enter \"s\" for student, \"p\" for professor or \"c\" for course...")
                }
              }
              catch {
                case e: Exception => println("Not a valid option" + e);
              }
            }
          case _ => println(s"Invalid input")
        }
      } catch {
        case e: Exception => println("Not a valid option " + e);
      }
    }
  }
}
