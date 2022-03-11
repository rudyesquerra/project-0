package com.revature.collegeapp.entities

import com.revature.collegeapp.enums.DoWeek.DoWeek
import com.revature.collegeapp.enums.Shift.Shift

case class Course(courseName:String, professor:String, doWeek: DoWeek, shift: Shift) {
  private var id:Int = _


  def setId(value:Int) = {this.id = value}
  def getId() = this.id

}


object Course {
  def apply(
             id:Int,
             courseName:String,
             professor:String,
             doWeek: DoWeek,
             shift: Shift
           ):Course = {
    Course(id:Integer, courseName:String, professor:String, doWeek: DoWeek, shift: Shift)

  }


  def apply(
             professor:String,
             doWeek: DoWeek,
             shift: Shift
           ):Course = {
    Course(1,"courseName",professor:String, doWeek: DoWeek, shift: Shift)
  }
}