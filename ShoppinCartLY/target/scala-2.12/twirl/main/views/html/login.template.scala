
package views.html

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
/*2.2*/import models.users.Login

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[Login],User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(loginForm: Form[Login], user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import helper._


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main("Login", user)/*6.21*/ {_display_(Seq[Any](format.raw/*6.23*/("""
    """),format.raw/*7.5*/("""<p class="lead">Product Catalogue</p>
    <div class="col-xs-5">
        <h3>Sign in</h3>
        """),_display_(/*10.10*/if(loginForm.hasGlobalErrors)/*10.39*/ {_display_(Seq[Any](format.raw/*10.41*/("""
            """),format.raw/*11.13*/("""<p class="alert alert-warning">
                """),_display_(/*12.18*/loginForm/*12.27*/.globalError.message),format.raw/*12.47*/(""";
            </p>
        """)))}),format.raw/*14.10*/("""
        """),_display_(/*15.10*/if(flash.containsKey("error"))/*15.40*/ {_display_(Seq[Any](format.raw/*15.42*/("""
            """),format.raw/*16.13*/("""<p class="alert alert-warning">
                """),_display_(/*17.18*/flash/*17.23*/.get("loginRequired")),format.raw/*17.44*/("""
            """),format.raw/*18.13*/("""</p>
        """)))}),format.raw/*19.10*/("""


        """),_display_(/*22.10*/helper/*22.16*/.form(controllers.security.routes.LoginCtrl.loginSubmit())/*22.74*/ {_display_(Seq[Any](format.raw/*22.76*/("""
            """),_display_(/*23.14*/CSRF/*23.18*/.formField),format.raw/*23.28*/("""

            """),format.raw/*25.13*/("""<div class="form-group">
                """),_display_(/*26.18*/inputText(loginForm("email"), '_label -> "", 
                'class -> "form-control input-xs", 'placeholder -> "Email")),format.raw/*27.76*/("""
            """),format.raw/*28.13*/("""</div>
            <div class="form-group">
                """),_display_(/*30.18*/inputPassword(loginForm("password"), '_label -> "", 
                'class -> "form-control input-xs", 'placeholder -> "Password")),format.raw/*31.79*/("""
            """),format.raw/*32.13*/("""</div>
            <div class="form-group">
                <input type="submit" value="Sign In" class="btn btn-primary">
            </div>
        """)))}),format.raw/*36.10*/("""
    """),format.raw/*37.5*/("""</div>
""")))}))
      }
    }
  }

  def render(loginForm:Form[Login],user:User): play.twirl.api.HtmlFormat.Appendable = apply(loginForm,user)

  def f:((Form[Login],User) => play.twirl.api.HtmlFormat.Appendable) = (loginForm,user) => apply(loginForm,user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 23 16:07:57 GMT 2019
                  SOURCE: /home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/app/views/login.scala.html
                  HASH: 6cd615382f10b22412fc5cf07db325250f03e544
                  MATRIX: 651->1|683->27|1023->54|1132->92|1177->90|1204->108|1231->110|1258->129|1297->131|1328->136|1454->235|1492->264|1532->266|1573->279|1649->328|1667->337|1708->357|1767->385|1804->395|1843->425|1883->427|1924->440|2000->489|2014->494|2056->515|2097->528|2142->542|2181->554|2196->560|2263->618|2303->620|2344->634|2357->638|2388->648|2430->662|2499->704|2641->825|2682->838|2770->899|2922->1030|2963->1043|3144->1193|3176->1198
                  LINES: 24->1|25->2|30->3|33->4|36->3|37->5|38->6|38->6|38->6|39->7|42->10|42->10|42->10|43->11|44->12|44->12|44->12|46->14|47->15|47->15|47->15|48->16|49->17|49->17|49->17|50->18|51->19|54->22|54->22|54->22|54->22|55->23|55->23|55->23|57->25|58->26|59->27|60->28|62->30|63->31|64->32|68->36|69->37
                  -- GENERATED --
              */
          