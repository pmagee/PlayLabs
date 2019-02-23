
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
/*2.2*/import models.products.Category
/*3.2*/import models.products.Product
/*4.2*/import models.users.User

object listProducts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[Product],List[Category],User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(products: List[Product], categories: List[Category], user: User,env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.93*/("""

"""),_display_(/*7.2*/main("Products",user)/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""

"""),format.raw/*9.1*/("""<p class="lead">Product Catalogue</p>
<br>
<div class="row">
  <div class="col-sm-3">
    <h4>Categories</h4>
    <div class="list-group">
      <a href=""""),_display_(/*15.17*/routes/*15.23*/.AdminProductCtrl.listProducts(0)),format.raw/*15.56*/("""" class="list-group-item">All Categories</a>
      """),_display_(/*16.8*/for(c <- categories) yield /*16.28*/ {_display_(Seq[Any](format.raw/*16.30*/("""
        """),format.raw/*17.9*/("""<a href=""""),_display_(/*17.19*/routes/*17.25*/.AdminProductCtrl.listProducts(c.getId)),format.raw/*17.64*/("""" class="list-group-item">"""),_display_(/*17.91*/c/*17.92*/.getName),format.raw/*17.100*/("""
          """),format.raw/*18.11*/("""<span class="badge">"""),_display_(/*18.32*/c/*18.33*/.getProducts.size()),format.raw/*18.52*/("""</span>
        </a>
      """)))}),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""</div>
  </div>
  <div class="col-sm-9">
    <table class="table table-bordered table-hover table-condensed">
      """),_display_(/*25.8*/if(flash.containsKey("success"))/*25.40*/ {_display_(Seq[Any](format.raw/*25.42*/("""
        """),format.raw/*26.9*/("""<div class="alert alert-success">
          """),_display_(/*27.12*/flash/*27.17*/.get("success")),format.raw/*27.32*/("""
        """),format.raw/*28.9*/("""</div>
      """)))}),format.raw/*29.8*/("""
      """),format.raw/*30.7*/("""<thead>
        <tr>
          <th>Image</th>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Stock</th>
          <th>Price</th>
          <th colspan="2"></th>      
        </tr>
      </thead>

      <tbody>
        """),_display_(/*43.10*/for(p<-products) yield /*43.26*/ {_display_(Seq[Any](format.raw/*43.28*/("""
          """),format.raw/*44.11*/("""<tr>
              """),_display_(/*45.16*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*45.104*/ {_display_(Seq[Any](format.raw/*45.106*/("""
                """),format.raw/*46.17*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*46.72*/(p.getId + ".jpg")),format.raw/*46.90*/(""""/></td>
            """)))}/*47.15*/else/*47.20*/{_display_(Seq[Any](format.raw/*47.21*/("""
                """),format.raw/*48.17*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
            """)))}),format.raw/*49.14*/("""
            """),format.raw/*50.13*/("""<td class="numeric">"""),_display_(/*50.34*/p/*50.35*/.getId),format.raw/*50.41*/("""</td>
            <td><a href=""""),_display_(/*51.27*/routes/*51.33*/.ProductCtrl.productDetails(p.getId)),format.raw/*51.69*/("""">
             """),_display_(/*52.15*/p/*52.16*/.getName),format.raw/*52.24*/("""</td>
            </a>
     
            <td>"""),_display_(/*55.18*/p/*55.19*/.getDescription),format.raw/*55.34*/("""</td>
            <td  class="numeric">"""),_display_(/*56.35*/p/*56.36*/.getStock),format.raw/*56.45*/("""</td>
            <td  class="numeric">€ """),_display_(/*57.37*/("%.2f".format(p.getPrice))),format.raw/*57.64*/("""</td>
            <td>
              <a href=""""),_display_(/*59.25*/routes/*59.31*/.AdminProductCtrl.updateProduct(p.getId)),format.raw/*59.71*/("""" class="button xs btn-danger">
                <span class="glyphicon glyphicon-pencil"></span>
              </a>
            </td>        <td>
              <a href=""""),_display_(/*63.25*/routes/*63.31*/.AdminProductCtrl.deleteProduct(p.getId)),format.raw/*63.71*/("""" class="button xs btn-danger" onclick="return confirmDel();">
                <span class="glyphicon glyphicon-trash"></span>
              </a>
            </td>
          </tr>
        """)))}),format.raw/*68.10*/("""
      """),format.raw/*69.7*/("""</tbody>

    </table>

    <p>
      <a href=""""),_display_(/*74.17*/routes/*74.23*/.AdminProductCtrl.addProduct()),format.raw/*74.53*/("""">
        <button class="btn btn-primary">Add a product</button>
      </a>
    </p>
  </div>
</div>
""")))}))
      }
    }
  }

  def render(products:List[Product],categories:List[Category],user:User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,user,env)

  def f:((List[Product],List[Category],User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,user,env) => apply(products,categories,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 23 16:07:57 GMT 2019
                  SOURCE: /home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/app/views/productAdmin/listProducts.scala.html
                  HASH: 6c9ff08631b2e451a70c6947aeacdb40ec9ec46a
                  MATRIX: 664->2|703->35|741->67|1125->93|1311->184|1339->187|1368->208|1407->210|1435->212|1617->367|1632->373|1686->406|1764->458|1800->478|1840->480|1876->489|1913->499|1928->505|1988->544|2042->571|2052->572|2082->580|2121->591|2169->612|2179->613|2219->632|2277->660|2309->665|2452->782|2493->814|2533->816|2569->825|2641->870|2655->875|2691->890|2727->899|2771->913|2805->920|3096->1184|3128->1200|3168->1202|3207->1213|3254->1233|3352->1321|3393->1323|3438->1340|3520->1395|3559->1413|3600->1436|3613->1441|3652->1442|3697->1459|3815->1546|3856->1559|3904->1580|3914->1581|3941->1587|4000->1619|4015->1625|4072->1661|4116->1678|4126->1679|4155->1687|4228->1733|4238->1734|4274->1749|4341->1789|4351->1790|4381->1799|4450->1841|4498->1868|4572->1915|4587->1921|4648->1961|4845->2131|4860->2137|4921->2177|5141->2366|5175->2373|5250->2421|5265->2427|5316->2457
                  LINES: 24->2|25->3|26->4|31->5|36->5|38->7|38->7|38->7|40->9|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|48->17|48->17|48->17|48->17|49->18|49->18|49->18|49->18|51->20|52->21|56->25|56->25|56->25|57->26|58->27|58->27|58->27|59->28|60->29|61->30|74->43|74->43|74->43|75->44|76->45|76->45|76->45|77->46|77->46|77->46|78->47|78->47|78->47|79->48|80->49|81->50|81->50|81->50|81->50|82->51|82->51|82->51|83->52|83->52|83->52|86->55|86->55|86->55|87->56|87->56|87->56|88->57|88->57|90->59|90->59|90->59|94->63|94->63|94->63|99->68|100->69|105->74|105->74|105->74
                  -- GENERATED --
              */
          