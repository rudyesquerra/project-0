package com.revature.collegeapp.entities

case class Professor(firstName:String, lastName:String, courseId:Int) {
  var professorId: Int = _;

  def setProfessorId(value:Int) = {this.professorId = value}
  def getProfessorId() = this.professorId
}
