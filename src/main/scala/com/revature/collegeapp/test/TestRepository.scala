package com.revature.collegeapp.test

import com.revature.collegeapp.connectors.MyConnector
import com.revature.collegeapp.entities.{Course, Professor, Student}
import com.revature.collegeapp.enums.{DoWeek, Shift}
import com.revature.collegeapp.repositories.{CourseDAO, ProfessorDAO, StudentDAO, T_CourseDAO, T_ProfessorDAO, T_StudentDAO}

object TestRepository {
  def main(args: Array[String]): Unit = {
    val cr: T_CourseDAO = CourseDAO(MyConnector.getConnection()) //Polymorphism - the idea is to change database for example instead of jdbc to a mongodb nosql
    val sr: T_StudentDAO = StudentDAO(MyConnector.getConnection())
    val pr: T_ProfessorDAO = ProfessorDAO(MyConnector.getConnection())

    //System.out.println("********************COURSES******************************")

 /*   val course = new Course("Javascript", "Nelson", DoWeek.Monday, Shift.Night)
    cr.save(course)
    println(course)*/

   //cr.remove(cr.getById(4))


   /*     var course:List[String] = cr.getById(5)

        if (course != null && course(0) != 0) {
          var newCourse:List[String] = course.updated(2,"Pereyra")
          cr.update(newCourse)
        }*/


    //    cr.getAll().foreach(println)
    //    println(cr.getAll())
    //    println(cr.getById(4))
    //    println(cr.getById(4).length)
    //    println(cr.getById(4)(1))

    //System.out.println("******************STUDENTS********************************")

/*    val student = new Student("John", "Milton", 54,2)
    sr.save(student)
    println(student)*/

//    println(sr.getAll())
//    println(sr.getById(3))
//    sr.remove(sr.getById(3))

    /*   val student:List[String] = sr.getById(1)

       if (student != null && student(0) != 0) {
         var newStudent:List[String] = student.updated(2,"Pereyra")
         cr.update(newStudent)
       }*/

    //System.out.println("*********************PROFESSORS*****************************")

/*    val professor = new Professor("Carlos", "Rios", 2)
    pr.save(professor)
    println(professor)*/

//    pr.remove(pr.getById(5))


 /*        var professor:List[String] = pr.getById(6)

         if (professor != null && professor(0) != 0) {
           var newProfessor:List[String] = professor.updated(2,"Pereyra")
           pr.update(newProfessor)
         }*/


    //    pr.getAll().foreach(println)
    //    println(pr.getAll())
    //    println(pr.getById(4))
    //    println(pr.getById(4).length)
    //    println(pr.getById(4)(1))
  }
}
