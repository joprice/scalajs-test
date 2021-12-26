import org.scalajs.linker.interface.ModuleSplitStyle

enablePlugins(ScalaJSPlugin)

name := "app"

scalaVersion := "2.13.7"

scalacOptions += "-Ymacro-annotations"

scalaJSLinkerConfig ~= (
  // setting this causes the following error:
  // target/scala-2.13/app-fastopt/java.lang.Object.js:819
  //   this._classOf = new $j_java$002elang$002eClass.$c_jl_Class(this)
  _.withModuleSplitStyle( ModuleSplitStyle.SmallestModules)
  .withModuleKind(ModuleKind.CommonJSModule)
)

scalaJSUseMainModuleInitializer := true
