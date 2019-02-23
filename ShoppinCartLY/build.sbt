name := """ShoppingCartLY"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice

// include the H2 Dependency 
libraryDependencies += "com.h2database" % "h2" % "1.4.192" 
// Load dependencies 
libraryDependencies ++= Seq(evolutions, jdbc)

