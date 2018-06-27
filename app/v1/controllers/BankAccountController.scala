package v1.controllers
 
import play.api.mvc._
import play.api.libs.json._
import v1.models.Balance

//https://www.playframework.com/documentation/2.6.x/ScalaJson



class BankAccountController extends Controller {
  var availableBalance=140000;
  val accountName="Tony Afula Maganga";
 
  def balance(accountNumber: String) = Action {
  	 //val balance = Map("availableBalance" -> "$23,000.89", "accountNumber" -> accountNumber);
     //val balance= Balance("40,000","Tony Afula","01108128953100")
  	 //val response =Map("success"=>true,"balance"=>balance);



     val json: JsValue = JsObject(Seq(
      "success" -> JsBoolean(true),
      "balance" -> JsObject(Seq("accountName" -> JsString(accountName), 
        "accountNumber" -> JsString(accountNumber),"availableBalance" -> JsNumber(availableBalance)))
      )
    )
       
    // Ok(Json.toJson(Balance("Tony Afula",accountNumber,availableBalance)))
    val balanceJSON =Json.toJson(json);
     Ok(Json.prettyPrint(balanceJSON))
  
  }
 
  def withdraw(accountNumber: String,amount:String) =  Action {

     val newBalance=availableBalance.toDouble-amount.toDouble;
  	 val json: JsValue = JsObject(Seq(
      "success" -> JsBoolean(true),
      "balance" -> JsObject(Seq("accountName" -> JsString(accountName), 
        "accountNumber" -> JsString(accountNumber),"newBalance" -> JsNumber(newBalance)))
      )
    )
       
    // Ok(Json.toJson(Balance("Tony Afula",accountNumber,availableBalance)))
    val balanceJSON =Json.toJson(json);
     Ok(Json.prettyPrint(balanceJSON))
  }
 
  def deposit(accountNumber: String,amount:String) = Action {
  	 val newBalance=availableBalance.toDouble+amount.toDouble;
     val json: JsValue = JsObject(Seq(
      "success" -> JsBoolean(true),
      "balance" -> JsObject(Seq("accountName" -> JsString(accountName), 
        "accountNumber" -> JsString(accountNumber),"newBalance" -> JsNumber(newBalance)))
      )
    )
       
    // Ok(Json.toJson(Balance("Tony Afula",accountNumber,availableBalance)))
    val balanceJSON =Json.toJson(json);
    Ok(Json.prettyPrint(balanceJSON))
  }
  
}