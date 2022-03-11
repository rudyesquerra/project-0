package com.revature.collegeapp

import com.revature.collegeapp.DoWeek.DoWeek
import com.revature.collegeapp.Shift.Shift

case class Course(courseName:String, professor:String, doWeek: DoWeek, shift: Shift) {
  var id:Int = _;
  /*var courseName:String = _;
  var professor:String = _;
  var doWeek: DoWeek = _;
  var shift: Shift = _;*/


/*  def this(id:Int) = {
   this
  }

  def this(id:Int, courseName:String) = {
   this
  }

  def this(id:Int, courseName:String, professor:String) = {
    this
  }
  def this(id:Int, courseName:String, professor:String, doWeek: DoWeek) = {
    this
  }


  def this(id:Int, courseName:String, professor:String, doWeek: DoWeek, shift: Shift) {
   this
  }*/






def setId(value:Int) = {this.id = value}
def getId() = this.id

/* def setCourseName(value:String) = {this.courseName = value}
 def getCourseName() = this.courseName

 def setProfessor(value:String) = {this.professor = value}
 def getProfessor() = this.professor

 def setDoWeek(value:DoWeek) = {this.doWeek = value}
 def getDoWeek() = this.doWeek

 def setShift(value:Shift) = {this.shift = value}
 def getShift() = this.shift*/



}


object Course {


 def apply(
  id:Int,
  courseName:String,
  professor:String,
  doWeek: DoWeek,
  shift: Shift
          ):Course = {
   Course(id:Int, courseName:String, professor:String, doWeek: DoWeek, shift: Shift)
 }
}