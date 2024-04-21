package com.chris.myfirstapp.Todoapp

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)