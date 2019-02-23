
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/conf/routes
// @DATE:Sat Feb 23 16:07:56 GMT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
