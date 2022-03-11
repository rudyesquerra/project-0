package com.revature.collegeapp.test

import com.revature.collegeapp.connectors.MyConnector
import com.revature.collegeapp.entities.{Course, Student}
import com.revature.collegeapp.enums.{DoWeek, Shift}
import com.revature.collegeapp.repositories.{CourseDAO, StudentDAO, T_CourseDAO, T_StudentDAO}

object TestRepository {
  def main(args: Array[String]): Unit = {
    val cr: T_CourseDAO = CourseDAO(MyConnector.getConnection()) //Polymorphism - the idea is to change database for example instead of jdbc to a mongodb nosql
    val sr: T_StudentDAO = StudentDAO(MyConnector.getConnection())

    /* var course = new Course("PHP", "Lopez", DoWeek.Wednesday, Shift.Morning)
    cr.save(course)
    println(course)*/

   //cr.remove(cr.getById(4))


   /*     var course:List[String] = cr.getById(5)

        if (course != null && course(0) != 0) {
          var newCourse:List[String] = course.updated(2,"Pereyra")
          cr.update(newCourse)
        }*/

    //System.out.println("**************************************************")
    //    cr.getAll().foreach(println)
    //    println(cr.getAll())
    //    println(cr.getById(4))
    //    println(cr.getById(4).length)
    //    println(cr.getById(4)(1))

    //System.out.println("**************************************************")

  /*  val student = new Student("Henry", "Cooper", 25,2)
    sr.save(student)
    println(student)*/

    //println(sr.getAll())
    //println(sr.getById(3))
    //sr.remove(sr.getById(3))

       val student:List[String] = sr.getById(1)

       if (student != null && student(0) != 0) {
         var newStudent:List[String] = student.updated(2,"Pereyra")
         cr.update(newStudent)
       }
  }
}
