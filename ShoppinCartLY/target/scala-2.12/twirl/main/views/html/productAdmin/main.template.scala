
package views.html.productAdmin

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import models.users.User

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,User,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(title: String, user: User )(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.45*/("""

"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Online Shop - """),_display_(/*10.27*/title),format.raw/*10.32*/("""</title>
    <!-- Bootstrap Core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.65*/("""" rel="stylesheet" />
</head>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Online Shop</a>
            </div>

            <ul class="nav navbar-nav">

                <li """),_display_(/*27.22*/if(title =="Products" )/*27.45*/{_display_(Seq[Any](format.raw/*27.46*/("""class="active"""")))}),format.raw/*27.61*/(""">
                    <a href=""""),_display_(/*28.31*/routes/*28.37*/.AdminProductCtrl.listProducts(0)),format.raw/*28.70*/("""">Products</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>

                <li>
                    <a href="#">Contact</a>
                </li>
                <li """),_display_(/*40.22*/if(title=="Login")/*40.40*/{_display_(Seq[Any](format.raw/*40.41*/("""class="active"""")))}),format.raw/*40.56*/(""">
                    """),_display_(/*41.22*/if(user != null)/*41.38*/ {_display_(Seq[Any](format.raw/*41.40*/("""
                        """),format.raw/*42.25*/("""<a href=""""),_display_(/*42.35*/controllers/*42.46*/.security.routes.LoginCtrl.logout()),format.raw/*42.81*/("""">Logout """),_display_(/*42.91*/user/*42.95*/.getName()),format.raw/*42.105*/("""</a>
                    """)))}/*43.23*/else/*43.28*/{_display_(Seq[Any](format.raw/*43.29*/("""
                        """),format.raw/*44.25*/("""<a href=""""),_display_(/*44.35*/controllers/*44.46*/.security.routes.LoginCtrl.login()),format.raw/*44.80*/("""">Login</a>
                    """)))}),format.raw/*45.22*/("""

                """),format.raw/*47.17*/("""</li>
            </ul>

        </div>

    </nav>

    <container>
        <row>
            <div class="col-md-12">
                """),_display_(/*57.18*/content),format.raw/*57.25*/("""
            """),format.raw/*58.13*/("""</div>
        </row>
    </container>
<br>
    <container>
        <footer>
        <row>
            <div class="col-md-12">
                Copyright
                <strong>Online Shop</strong>
            </div>
        </row>
    </footer>
    </container>
    <script src=""""),_display_(/*72.19*/routes/*72.25*/.Assets.versioned("javascripts/main.js")),format.raw/*72.65*/(""""></script>
</body>

</html>
"""))
      }
    }
  }

  def render(title:String,user:User,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)

  def f:((String,User) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => apply(title,user)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 23 16:07:57 GMT 2019
                  SOURCE: /home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/app/views/productAdmin/main.scala.html
                  HASH: d203a15449a27501e24933815ff2406bc98790e0
                  MATRIX: 664->1|1002->27|1140->70|1168->72|1290->167|1316->172|1528->357|1543->363|1605->404|1936->708|1968->731|2007->732|2053->747|2112->779|2127->785|2181->818|2527->1137|2554->1155|2593->1156|2639->1171|2689->1194|2714->1210|2754->1212|2807->1237|2844->1247|2864->1258|2920->1293|2957->1303|2970->1307|3002->1317|3047->1344|3060->1349|3099->1350|3152->1375|3189->1385|3209->1396|3264->1430|3328->1463|3374->1481|3537->1617|3565->1624|3606->1637|3914->1918|3929->1924|3990->1964
                  LINES: 24->1|29->2|34->2|36->4|42->10|42->10|46->14|46->14|46->14|59->27|59->27|59->27|59->27|60->28|60->28|60->28|72->40|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42|74->42|74->42|74->42|74->42|75->43|75->43|75->43|76->44|76->44|76->44|76->44|77->45|79->47|89->57|89->57|90->58|104->72|104->72|104->72
                  -- GENERATED --
              */
          