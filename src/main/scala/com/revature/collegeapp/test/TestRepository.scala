package com.revature.collegeapp.test

import com.revature.collegeapp.connectors.MyConnector
import com.revature.collegeapp.entities.Course
import com.revature.collegeapp.enums.{DoWeek, Shift}
import com.revature.collegeapp.repositories.{CourseDAO, T_CourseDAO}

object TestRepository {
  def main(args: Array[String]): Unit = {
    val cr: T_CourseDAO = CourseDAO(MyConnector.getConnection()) //Polymorphism - the idea is to change database for example instead of jdbc to a mongodb nosql

   /* var course = new Course("PHP", "Lopez", DoWeek.Wednesday, Shift.Morning)
    cr.save(course)
    println(course)*/


    //cr.remove(cr.getById(4))


        var course:List[String] = cr.getById(5)

        if (course != null && course(0) != 0) {
          var newCourse:List[String] = course.updated(2,"Pereyra")
          cr.update(newCourse)
        }

    System.out.println("**************************************************")
    //    cr.getAll().foreach(println)
    //    println(cr.getAll())
    //    println(cr.getById(4))
    //    println(cr.getById(4).length)
    //    println(cr.getById(4)(1))


    //cr.getAll.forEach(System.out.println)
    //cr.getLikeTitulo("ja").forEach(System.out::println);*/
  }
}
