
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
/*1.2*/import models.products.Category
/*2.2*/import models.products.Product
/*3.2*/import models.users.User

object listProducts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[Product],List[Category],Long,String,User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(products: List[Product], categories: List[Category], catId: Long, filter: String,user: User,env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.121*/("""


"""),_display_(/*7.2*/main("Products",user)/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""

"""),format.raw/*9.1*/("""<p class="lead">Product Catalogue</p>
<br>
<div class="row">
  <div class="col-sm-2">
    <h4>Categories</h4>
    <div class="list-group">
      <a href=""""),_display_(/*15.17*/routes/*15.23*/.ProductCtrl.listProducts(0, filter)),format.raw/*15.59*/("""" class="list-group-item">All Categories</a>
      """),_display_(/*16.8*/for(c <- categories) yield /*16.28*/ {_display_(Seq[Any](format.raw/*16.30*/("""
        """),format.raw/*17.9*/("""<a href=""""),_display_(/*17.19*/routes/*17.25*/.ProductCtrl.listProducts(c.getId, filter)),format.raw/*17.67*/("""" class="list-group-item">"""),_display_(/*17.94*/c/*17.95*/.getName),format.raw/*17.103*/("""
          """),format.raw/*18.11*/("""<span class="badge">"""),_display_(/*18.32*/c/*18.33*/.getProducts.size()),format.raw/*18.52*/("""</span>
        </a>
      """)))}),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""</div>
  </div>
  <div class="col-sm-10">
      """),_display_(/*24.8*/if(flash.containsKey("success"))/*24.40*/ {_display_(Seq[Any](format.raw/*24.42*/("""
        """),format.raw/*25.9*/("""<div class="alert alert-success">
          """),_display_(/*26.12*/flash/*26.17*/.get("success")),format.raw/*26.32*/("""
        """),format.raw/*27.9*/("""</div>
      """)))}),format.raw/*28.8*/("""

      			"""),format.raw/*30.10*/("""<!-- Search Form -->
			<div id="actions">
        <form action=""""),_display_(/*32.24*/routes/*32.30*/.ProductCtrl.listProducts(catId)),format.raw/*32.62*/("""" method="GET">
         <input type="search" id="searchbox" name="filter" value=""""),_display_(/*33.68*/filter),format.raw/*33.74*/("""" placeholder="Filter by product name...">
         <input type="submit" id="searchsubmit" value="Filter by name" class="btn-md btn-primary">
        </form>
       </div>
    <table class="table table-bordered table-hover table-condensed">   
      <thead>
        <tr>
          <th>ID</th>
          <th>Image</th>
          <th>Name</th>         
          <th>Description</th>
          <th>Stock</th>
          <th>Price</th>   
        </tr>
      </thead>

      <tbody>
        """),_display_(/*50.10*/for(p<-products) yield /*50.26*/ {_display_(Seq[Any](format.raw/*50.28*/("""
          """),format.raw/*51.11*/("""<tr>
              """),_display_(/*52.16*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*52.104*/ {_display_(Seq[Any](format.raw/*52.106*/("""
                """),format.raw/*53.17*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*53.72*/(p.getId + ".jpg")),format.raw/*53.90*/(""""/></td>
            """)))}/*54.15*/else/*54.20*/{_display_(Seq[Any](format.raw/*54.21*/("""
                """),format.raw/*55.17*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
            """)))}),format.raw/*56.14*/("""
            """),format.raw/*57.13*/("""<td class="numeric">"""),_display_(/*57.34*/p/*57.35*/.getId),format.raw/*57.41*/("""</td>
            <td><a href=""""),_display_(/*58.27*/routes/*58.33*/.ProductCtrl.productDetails(p.getId)),format.raw/*58.69*/("""">
                """),_display_(/*59.18*/p/*59.19*/.getName),format.raw/*59.27*/("""</td>
               </a>     
            <td>"""),_display_(/*61.18*/p/*61.19*/.getDescription),format.raw/*61.34*/("""</td>
            <td  class="numeric">"""),_display_(/*62.35*/p/*62.36*/.getStock),format.raw/*62.45*/("""</td>
            <td  class="numeric">€ """),_display_(/*63.37*/("%.2f".format(p.getPrice))),format.raw/*63.64*/("""</td>
            <td><a href=""""),_display_(/*64.27*/routes/*64.33*/.ShoppingCtrl.addToBasket(p.getId)),format.raw/*64.67*/(""""  class="btn btn-default btn-xs"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>

          </tr>
        """)))}),format.raw/*67.10*/("""
      """),format.raw/*68.7*/("""</tbody>

    </table>
  </div>
</div>
""")))}))
      }
    }
  }

  def render(products:List[Product],categories:List[Category],catId:Long,filter:String,user:User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,catId,filter,user,env)

  def f:((List[Product],List[Category],Long,String,User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,catId,filter,user,env) => apply(products,categories,catId,filter,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 23 16:07:57 GMT 2019
                  SOURCE: /home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/app/views/listProducts.scala.html
                  HASH: afd7ccd47da45a2052e20fe7fd9ce7c6383e78a8
                  MATRIX: 651->1|690->34|728->66|1124->92|1339->211|1368->215|1397->236|1436->238|1464->240|1646->395|1661->401|1718->437|1796->489|1832->509|1872->511|1908->520|1945->530|1960->536|2023->578|2077->605|2087->606|2117->614|2156->625|2204->646|2214->647|2254->666|2312->694|2344->699|2419->748|2460->780|2500->782|2536->791|2608->836|2622->841|2658->856|2694->865|2738->879|2777->890|2870->956|2885->962|2938->994|3048->1077|3075->1083|3590->1571|3622->1587|3662->1589|3701->1600|3748->1620|3846->1708|3887->1710|3932->1727|4014->1782|4053->1800|4094->1823|4107->1828|4146->1829|4191->1846|4309->1933|4350->1946|4398->1967|4408->1968|4435->1974|4494->2006|4509->2012|4566->2048|4613->2068|4623->2069|4652->2077|4727->2125|4737->2126|4773->2141|4840->2181|4850->2182|4880->2191|4949->2233|4997->2260|5056->2292|5071->2298|5126->2332|5282->2457|5316->2464
                  LINES: 24->1|25->2|26->3|31->4|36->4|39->7|39->7|39->7|41->9|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|52->20|53->21|56->24|56->24|56->24|57->25|58->26|58->26|58->26|59->27|60->28|62->30|64->32|64->32|64->32|65->33|65->33|82->50|82->50|82->50|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|86->54|86->54|87->55|88->56|89->57|89->57|89->57|89->57|90->58|90->58|90->58|91->59|91->59|91->59|93->61|93->61|93->61|94->62|94->62|94->62|95->63|95->63|96->64|96->64|96->64|99->67|100->68
                  -- GENERATED --
              */
          