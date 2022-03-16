package com.revature.collegeapp.dao

import com.revature.collegeapp.entities.{Course, Student}

trait T_StudentDAO {
  def save(student: Student); //insert in sql
  def remove(student: List[String]); //delete in sql
  def update(student: List[String]); //update in sql
  def getAll(): List[String]; //Obtains a list of courses -> select where
  def getById(id: Int): List[String]; //Input an id and responds with an object of type Student -> select where
  /*def getLikeLastName(lastname: String): List[Student]; //Input a lastname, and responds with a list that matches that string -> select where
  def getLikeCourse(course: Course): List[Student]; //Input a course name, and responds a list of students that matches that course string -> select where*/
}
