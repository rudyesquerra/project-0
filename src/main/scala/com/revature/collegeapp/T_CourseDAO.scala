package com.revature.collegeapp

trait T_CourseDAO {
  def save(course: Course); //insert in sql
  def remove(course: Course); //delete in sql
  def update(course: Course); //update in sql
  def getAll():List[Course]; //Obtains a list of courses -> select where
  def getById(id:Int):Course; //Input an id and responds with an object of type Course -> select where
  def getLikeCourse
}
