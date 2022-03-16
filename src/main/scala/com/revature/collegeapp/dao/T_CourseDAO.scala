package com.revature.collegeapp.dao

import com.revature.collegeapp.entities.Course

trait T_CourseDAO {
  def save(course: Course); //insert in sql
  def remove(course: List[String]); //delete in sql
  def update(course:List[String]); //update in sql
  def getAll(): List[String]; //Obtains a list of courses -> select where
  def getById(id: Int): List[String]; //Input an id and responds with an object of type Course -> select where
}
