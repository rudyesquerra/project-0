package com.revature.collegeapp.entities

case class Student(firstName:String, lastName:String, age:Int, courseId:Int) {
  var studentId: Int = _;

  def setStudentId(value:Int) = {this.studentId = value}
  def geStudentId() = this.studentId
}
