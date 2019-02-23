
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

object basket extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[models.users.Customer,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(customer: models.users.Customer):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import play.api.Play.current
/*5.2*/import models.shopping._
/*6.2*/import models.products._


Seq[Any](format.raw/*1.35*/("""


"""),format.raw/*7.1*/("""
"""),format.raw/*8.1*/("""<!-- Pass page title and user on to main -->
"""),_display_(/*9.2*/main("Shopping Basket", customer)/*9.35*/ {_display_(Seq[Any](format.raw/*9.37*/("""


"""),format.raw/*12.1*/("""<div class="row">

	<div class="col-md-12">
		"""),_display_(/*15.4*/if(flash.containsKey("success"))/*15.36*/ {_display_(Seq[Any](format.raw/*15.38*/("""
			  """),format.raw/*16.6*/("""<div class="alert alert-success">
			      """),_display_(/*17.11*/flash/*17.16*/.get("success")),format.raw/*17.31*/("""
			  """),format.raw/*18.6*/("""</div>
		""")))}),format.raw/*19.4*/(""" 

		"""),format.raw/*21.3*/("""<table class="table table-bordered table-hover table-condensed">
			<thead>
			<!-- The header row-->
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Item Price</th>
				<th>Total</th>
				<th>Quantity</th>
                <th>dec.</th>
                <th>inc.</th>
			</tr>
			</thead>
			<tbody>
                """),_display_(/*35.18*/if(customer.getBasket() != null)/*35.50*/ {_display_(Seq[Any](format.raw/*35.52*/("""
                    """),format.raw/*36.21*/("""<!-- Start of For loop - For each p in products add a row -->
                    """),_display_(/*37.22*/for(i <- customer.getBasket().getBasketItems()) yield /*37.69*/ {_display_(Seq[Any](format.raw/*37.71*/("""
                    """),format.raw/*38.21*/("""<tr>
                        <td>"""),_display_(/*39.30*/i/*39.31*/.getProduct.getName),format.raw/*39.50*/("""</td>
                        <td>"""),_display_(/*40.30*/i/*40.31*/.getProduct.getDescription()),format.raw/*40.59*/("""</td>
                        <td>&euro; """),_display_(/*41.37*/("%.2f".format(i.getPrice))),format.raw/*41.64*/("""</td>
                        <td>&euro; """),_display_(/*42.37*/("%.2f".format(i.getItemTotal))),format.raw/*42.68*/("""</td>
                        <td>"""),_display_(/*43.30*/i/*43.31*/.getQuantity()),format.raw/*43.45*/("""</td>
                        <td><a href=""""),_display_(/*44.39*/routes/*44.45*/.ShoppingCtrl.removeOne(i.getId)),format.raw/*44.77*/(""""><span class="glyphicon glyphicon-minus-sign"></span></a></td>
                        <td><a href=""""),_display_(/*45.39*/routes/*45.45*/.ShoppingCtrl.addOne(i.getId,i.getProduct.getId())),format.raw/*45.95*/(""""><span class="glyphicon glyphicon-plus-sign"></span></a></td>
                    </tr>
                    """)))}),format.raw/*47.22*/("""<!-- End of For loop -->
              """)))}),format.raw/*48.16*/("""
			"""),format.raw/*49.4*/("""</tbody>
		</table>
        <div class="row">
            <div class="col-md-12">
                <p class="text-right"><strong>Basket Total: &euro; """),_display_(/*53.69*/("%.2f".format(customer.getBasket.getBasketTotal))),format.raw/*53.119*/("""</strong></p>
            </div>  
        </div>
        <div class="row">
            <div class="col-md-6">
                <p class="text-right">
                    <a href=""""),_display_(/*59.31*/routes/*59.37*/.ShoppingCtrl.emptyBasket()),format.raw/*59.64*/("""" class="btn btn-danger btn-sm" onclick="return confirmDel();">
                    <span class="glyphicon glyphicon-trash"></span> Empty Basket</a>
                </p>
            </div>  
            <div class="col-md-6">
                <p class="text-right">
                    <a href=""""),_display_(/*65.31*/routes/*65.37*/.ShoppingCtrl.placeOrder()),format.raw/*65.63*/("""" class="btn btn-success btn-sm">
                    <span class="glyphicon glyphicon-euro"></span> Place Order</a>
                </p>
            </div>  
        </div>
    </div>
</div>

<script>
	// JavaScript function returns true if user clicks yes, otherwise, false
	function confirmDel() """),format.raw/*75.24*/("""{"""),format.raw/*75.25*/("""
		"""),format.raw/*76.3*/("""return confirm('Are you sure?');
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/("""
"""),format.raw/*78.1*/("""</script>
""")))}))
      }
    }
  }

  def render(customer:models.users.Customer): play.twirl.api.HtmlFormat.Appendable = apply(customer)

  def f:((models.users.Customer) => play.twirl.api.HtmlFormat.Appendable) = (customer) => apply(customer)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 23 16:07:57 GMT 2019
                  SOURCE: /home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/app/views/basket.scala.html
                  HASH: 03a1dc57b625509be046bbffe99aa2dc6d2be91e
                  MATRIX: 964->1|1070->38|1106->68|1138->94|1192->34|1221->119|1248->120|1319->166|1360->199|1399->201|1429->204|1502->251|1543->283|1583->285|1616->291|1687->335|1701->340|1737->355|1770->361|1810->371|1842->376|2196->703|2237->735|2277->737|2326->758|2436->841|2499->888|2539->890|2588->911|2649->945|2659->946|2699->965|2761->1000|2771->1001|2820->1029|2889->1071|2937->1098|3006->1140|3058->1171|3120->1206|3130->1207|3165->1221|3236->1265|3251->1271|3304->1303|3433->1405|3448->1411|3519->1461|3660->1571|3731->1611|3762->1615|3939->1765|4011->1815|4218->1995|4233->2001|4281->2028|4603->2323|4618->2329|4665->2355|4992->2654|5021->2655|5051->2658|5112->2692|5140->2693|5168->2694
                  LINES: 28->1|31->4|32->5|33->6|36->1|39->7|40->8|41->9|41->9|41->9|44->12|47->15|47->15|47->15|48->16|49->17|49->17|49->17|50->18|51->19|53->21|67->35|67->35|67->35|68->36|69->37|69->37|69->37|70->38|71->39|71->39|71->39|72->40|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|75->43|76->44|76->44|76->44|77->45|77->45|77->45|79->47|80->48|81->49|85->53|85->53|91->59|91->59|91->59|97->65|97->65|97->65|107->75|107->75|108->76|109->77|109->77|110->78
                  -- GENERATED --
              */
          