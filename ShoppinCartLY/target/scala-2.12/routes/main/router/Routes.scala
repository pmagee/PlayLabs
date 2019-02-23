
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/patricia/wdd1labs/PlayLabs/ShoppinCartLY/conf/routes
// @DATE:Sat Feb 23 16:07:56 GMT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ProductCtrl_0: controllers.ProductCtrl,
  // @LINE:14
  LoginCtrl_3: controllers.security.LoginCtrl,
  // @LINE:19
  ShoppingCtrl_1: controllers.ShoppingCtrl,
  // @LINE:30
  AdminProductCtrl_2: controllers.AdminProductCtrl,
  // @LINE:43
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ProductCtrl_0: controllers.ProductCtrl,
    // @LINE:14
    LoginCtrl_3: controllers.security.LoginCtrl,
    // @LINE:19
    ShoppingCtrl_1: controllers.ShoppingCtrl,
    // @LINE:30
    AdminProductCtrl_2: controllers.AdminProductCtrl,
    // @LINE:43
    Assets_4: controllers.Assets
  ) = this(errorHandler, ProductCtrl_0, LoginCtrl_3, ShoppingCtrl_1, AdminProductCtrl_2, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ProductCtrl_0, LoginCtrl_3, ShoppingCtrl_1, AdminProductCtrl_2, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ProductCtrl.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listProducts""", """controllers.ProductCtrl.listProducts(cat:Long ?= 0, filter:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productDetails/""" + "$" + """id<[^/]+>""", """controllers.ProductCtrl.productDetails(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.security.LoginCtrl.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.security.LoginCtrl.loginSubmit()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.security.LoginCtrl.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """showBasket""", """controllers.ShoppingCtrl.showBasket()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addToBasket/""" + "$" + """id<[^/]+>""", """controllers.ShoppingCtrl.addToBasket(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addOne/""" + "$" + """itemId<[^/]+>""", """controllers.ShoppingCtrl.addOne(itemId:Long, pid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeOne/""" + "$" + """itemId<[^/]+>""", """controllers.ShoppingCtrl.removeOne(itemId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """emptyBasket""", """controllers.ShoppingCtrl.emptyBasket()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """placeOrder""", """controllers.ShoppingCtrl.placeOrder()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cancelOrder""", """controllers.ShoppingCtrl.cancelOrder(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """viewOrders""", """controllers.ShoppingCtrl.viewOrders()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin""", """controllers.AdminProductCtrl.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/listProducts""", """controllers.AdminProductCtrl.listProducts(cat:Long ?= 0L)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/listProducts/""" + "$" + """cat<[^/]+>""", """controllers.AdminProductCtrl.listProducts(cat:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/addProduct""", """controllers.AdminProductCtrl.addProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/addProductSubmit""", """controllers.AdminProductCtrl.addProductSubmit()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/updateProduct/""" + "$" + """id<[^/]+>""", """controllers.AdminProductCtrl.updateProduct(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/updateProductSubmit/""" + "$" + """id<[^/]+>""", """controllers.AdminProductCtrl.updateProductSubmit(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Admin/deleteProduct/""" + "$" + """id<[^/]+>""", """controllers.AdminProductCtrl.deleteProduct(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ProductCtrl_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ProductCtrl_index0_invoker = createInvoker(
    ProductCtrl_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductCtrl",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ProductCtrl_listProducts1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listProducts")))
  )
  private[this] lazy val controllers_ProductCtrl_listProducts1_invoker = createInvoker(
    ProductCtrl_0.listProducts(fakeValue[Long], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductCtrl",
      "listProducts",
      Seq(classOf[Long], classOf[String]),
      "GET",
      this.prefix + """listProducts""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ProductCtrl_productDetails2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productDetails/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductCtrl_productDetails2_invoker = createInvoker(
    ProductCtrl_0.productDetails(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductCtrl",
      "productDetails",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """productDetails/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_security_LoginCtrl_login3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_security_LoginCtrl_login3_invoker = createInvoker(
    LoginCtrl_3.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.security.LoginCtrl",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """ Login form""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_security_LoginCtrl_loginSubmit4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_security_LoginCtrl_loginSubmit4_invoker = createInvoker(
    LoginCtrl_3.loginSubmit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.security.LoginCtrl",
      "loginSubmit",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_security_LoginCtrl_logout5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_security_LoginCtrl_logout5_invoker = createInvoker(
    LoginCtrl_3.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.security.LoginCtrl",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ShoppingCtrl_showBasket6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("showBasket")))
  )
  private[this] lazy val controllers_ShoppingCtrl_showBasket6_invoker = createInvoker(
    ShoppingCtrl_1.showBasket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "showBasket",
      Nil,
      "GET",
      this.prefix + """showBasket""",
      """ Shopping""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ShoppingCtrl_addToBasket7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addToBasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShoppingCtrl_addToBasket7_invoker = createInvoker(
    ShoppingCtrl_1.addToBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "addToBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """addToBasket/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ShoppingCtrl_addOne8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addOne/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShoppingCtrl_addOne8_invoker = createInvoker(
    ShoppingCtrl_1.addOne(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "addOne",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      this.prefix + """addOne/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ShoppingCtrl_removeOne9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeOne/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShoppingCtrl_removeOne9_invoker = createInvoker(
    ShoppingCtrl_1.removeOne(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "removeOne",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """removeOne/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ShoppingCtrl_emptyBasket10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("emptyBasket")))
  )
  private[this] lazy val controllers_ShoppingCtrl_emptyBasket10_invoker = createInvoker(
    ShoppingCtrl_1.emptyBasket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "emptyBasket",
      Nil,
      "GET",
      this.prefix + """emptyBasket""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ShoppingCtrl_placeOrder11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("placeOrder")))
  )
  private[this] lazy val controllers_ShoppingCtrl_placeOrder11_invoker = createInvoker(
    ShoppingCtrl_1.placeOrder(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "placeOrder",
      Nil,
      "GET",
      this.prefix + """placeOrder""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ShoppingCtrl_cancelOrder12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cancelOrder")))
  )
  private[this] lazy val controllers_ShoppingCtrl_cancelOrder12_invoker = createInvoker(
    ShoppingCtrl_1.cancelOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "cancelOrder",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """cancelOrder""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ShoppingCtrl_viewOrders13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("viewOrders")))
  )
  private[this] lazy val controllers_ShoppingCtrl_viewOrders13_invoker = createInvoker(
    ShoppingCtrl_1.viewOrders(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoppingCtrl",
      "viewOrders",
      Nil,
      "GET",
      this.prefix + """viewOrders""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_AdminProductCtrl_index14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin")))
  )
  private[this] lazy val controllers_AdminProductCtrl_index14_invoker = createInvoker(
    AdminProductCtrl_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "index",
      Nil,
      "GET",
      this.prefix + """Admin""",
      """ Product Administration""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_AdminProductCtrl_listProducts15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/listProducts")))
  )
  private[this] lazy val controllers_AdminProductCtrl_listProducts15_invoker = createInvoker(
    AdminProductCtrl_2.listProducts(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "listProducts",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Admin/listProducts""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_AdminProductCtrl_listProducts16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/listProducts/"), DynamicPart("cat", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminProductCtrl_listProducts16_invoker = createInvoker(
    AdminProductCtrl_2.listProducts(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "listProducts",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Admin/listProducts/""" + "$" + """cat<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_AdminProductCtrl_addProduct17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/addProduct")))
  )
  private[this] lazy val controllers_AdminProductCtrl_addProduct17_invoker = createInvoker(
    AdminProductCtrl_2.addProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "addProduct",
      Nil,
      "GET",
      this.prefix + """Admin/addProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_AdminProductCtrl_addProductSubmit18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/addProductSubmit")))
  )
  private[this] lazy val controllers_AdminProductCtrl_addProductSubmit18_invoker = createInvoker(
    AdminProductCtrl_2.addProductSubmit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "addProductSubmit",
      Nil,
      "POST",
      this.prefix + """Admin/addProductSubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_AdminProductCtrl_updateProduct19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/updateProduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminProductCtrl_updateProduct19_invoker = createInvoker(
    AdminProductCtrl_2.updateProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "updateProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Admin/updateProduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_AdminProductCtrl_updateProductSubmit20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/updateProductSubmit/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminProductCtrl_updateProductSubmit20_invoker = createInvoker(
    AdminProductCtrl_2.updateProductSubmit(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "updateProductSubmit",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """Admin/updateProductSubmit/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_AdminProductCtrl_deleteProduct21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Admin/deleteProduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminProductCtrl_deleteProduct21_invoker = createInvoker(
    AdminProductCtrl_2.deleteProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminProductCtrl",
      "deleteProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Admin/deleteProduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_Assets_versioned22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned22_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ProductCtrl_index0_route(params@_) =>
      call { 
        controllers_ProductCtrl_index0_invoker.call(ProductCtrl_0.index())
      }
  
    // @LINE:10
    case controllers_ProductCtrl_listProducts1_route(params@_) =>
      call(params.fromQuery[Long]("cat", Some(0)), params.fromQuery[String]("filter", Some(""))) { (cat, filter) =>
        controllers_ProductCtrl_listProducts1_invoker.call(ProductCtrl_0.listProducts(cat, filter))
      }
  
    // @LINE:11
    case controllers_ProductCtrl_productDetails2_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductCtrl_productDetails2_invoker.call(ProductCtrl_0.productDetails(id))
      }
  
    // @LINE:14
    case controllers_security_LoginCtrl_login3_route(params@_) =>
      call { 
        controllers_security_LoginCtrl_login3_invoker.call(LoginCtrl_3.login())
      }
  
    // @LINE:15
    case controllers_security_LoginCtrl_loginSubmit4_route(params@_) =>
      call { 
        controllers_security_LoginCtrl_loginSubmit4_invoker.call(LoginCtrl_3.loginSubmit())
      }
  
    // @LINE:16
    case controllers_security_LoginCtrl_logout5_route(params@_) =>
      call { 
        controllers_security_LoginCtrl_logout5_invoker.call(LoginCtrl_3.logout())
      }
  
    // @LINE:19
    case controllers_ShoppingCtrl_showBasket6_route(params@_) =>
      call { 
        controllers_ShoppingCtrl_showBasket6_invoker.call(ShoppingCtrl_1.showBasket())
      }
  
    // @LINE:20
    case controllers_ShoppingCtrl_addToBasket7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ShoppingCtrl_addToBasket7_invoker.call(ShoppingCtrl_1.addToBasket(id))
      }
  
    // @LINE:21
    case controllers_ShoppingCtrl_addOne8_route(params@_) =>
      call(params.fromPath[Long]("itemId", None), params.fromQuery[Long]("pid", None)) { (itemId, pid) =>
        controllers_ShoppingCtrl_addOne8_invoker.call(ShoppingCtrl_1.addOne(itemId, pid))
      }
  
    // @LINE:22
    case controllers_ShoppingCtrl_removeOne9_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ShoppingCtrl_removeOne9_invoker.call(ShoppingCtrl_1.removeOne(itemId))
      }
  
    // @LINE:23
    case controllers_ShoppingCtrl_emptyBasket10_route(params@_) =>
      call { 
        controllers_ShoppingCtrl_emptyBasket10_invoker.call(ShoppingCtrl_1.emptyBasket())
      }
  
    // @LINE:24
    case controllers_ShoppingCtrl_placeOrder11_route(params@_) =>
      call { 
        controllers_ShoppingCtrl_placeOrder11_invoker.call(ShoppingCtrl_1.placeOrder())
      }
  
    // @LINE:25
    case controllers_ShoppingCtrl_cancelOrder12_route(params@_) =>
      call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_ShoppingCtrl_cancelOrder12_invoker.call(ShoppingCtrl_1.cancelOrder(id))
      }
  
    // @LINE:26
    case controllers_ShoppingCtrl_viewOrders13_route(params@_) =>
      call { 
        controllers_ShoppingCtrl_viewOrders13_invoker.call(ShoppingCtrl_1.viewOrders())
      }
  
    // @LINE:30
    case controllers_AdminProductCtrl_index14_route(params@_) =>
      call { 
        controllers_AdminProductCtrl_index14_invoker.call(AdminProductCtrl_2.index())
      }
  
    // @LINE:32
    case controllers_AdminProductCtrl_listProducts15_route(params@_) =>
      call(params.fromQuery[Long]("cat", Some(0L))) { (cat) =>
        controllers_AdminProductCtrl_listProducts15_invoker.call(AdminProductCtrl_2.listProducts(cat))
      }
  
    // @LINE:33
    case controllers_AdminProductCtrl_listProducts16_route(params@_) =>
      call(params.fromPath[Long]("cat", None)) { (cat) =>
        controllers_AdminProductCtrl_listProducts16_invoker.call(AdminProductCtrl_2.listProducts(cat))
      }
  
    // @LINE:35
    case controllers_AdminProductCtrl_addProduct17_route(params@_) =>
      call { 
        controllers_AdminProductCtrl_addProduct17_invoker.call(AdminProductCtrl_2.addProduct())
      }
  
    // @LINE:36
    case controllers_AdminProductCtrl_addProductSubmit18_route(params@_) =>
      call { 
        controllers_AdminProductCtrl_addProductSubmit18_invoker.call(AdminProductCtrl_2.addProductSubmit())
      }
  
    // @LINE:38
    case controllers_AdminProductCtrl_updateProduct19_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AdminProductCtrl_updateProduct19_invoker.call(AdminProductCtrl_2.updateProduct(id))
      }
  
    // @LINE:39
    case controllers_AdminProductCtrl_updateProductSubmit20_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AdminProductCtrl_updateProductSubmit20_invoker.call(AdminProductCtrl_2.updateProductSubmit(id))
      }
  
    // @LINE:41
    case controllers_AdminProductCtrl_deleteProduct21_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AdminProductCtrl_deleteProduct21_invoker.call(AdminProductCtrl_2.deleteProduct(id))
      }
  
    // @LINE:43
    case controllers_Assets_versioned22_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned22_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
