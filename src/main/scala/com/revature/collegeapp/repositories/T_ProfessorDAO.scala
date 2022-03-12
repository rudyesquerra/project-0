package com.revature.collegeapp.repositories

import com.revature.collegeapp.entities.Professor

trait T_ProfessorDAO {
  def save(professor: Professor); //insert in sql
  def remove(student: List[String]); //delete in sql
  def update(student: List[String]); //update in sql
  def getAll(): List[String]; //Obtains a list of courses -> select where
  def getById(id: Int): List[String]; //Input an id and responds with an object of type Student -> select where
}
