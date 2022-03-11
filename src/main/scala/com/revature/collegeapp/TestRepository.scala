package com.revature.collegeapp

object TestRepository {
  def main(args: Array[String]): Unit = {
   val cr:T_CourseDAO = CourseDAO(MyConnector.getConnection()) //Polymorphism - the idea is to change database for example instead of jdbc to a mongodb nosql

   /* var course = new Course("Javascript", "Clooney", DoWeek.Wednesday, Shift.Night)
    cr.save(course)
    println(course)*/


   //cr.remove(cr.getById(4))


//    curso = cr.getById(10)
//    if (curso != null && curso.getId != 0) {
//      curso.setProfesor("Pereyra")
//      cr.update(curso)
//    }

    System.out.println("**************************************************")
    cr.getAll().foreach(println)
    //cr.getAll.forEach(System.out.println)
    //cr.getLikeTitulo("ja").forEach(System.out::println);*/
  }
}
