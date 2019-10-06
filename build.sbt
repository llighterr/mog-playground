enablePlugins(ScalaJSPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.mogproject",
      scalaVersion := "2.12.0"
    )),
    name := "mog-playground",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.6",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.1",
      "com.lihaoyi" %%% "scalatags" % "0.6.2"
    ),
    scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation"),

    skip in packageJSDependencies := false,
  )
  .dependsOn(mogFrontend)

lazy val mogFrontend = ProjectRef(uri("git://github.com/llighterr/mog-frontend.git#master"), "root")
