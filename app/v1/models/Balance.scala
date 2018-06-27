package v1.models

import play.api.libs.json._
import play.api.libs.functional.syntax._

class Balance(accountName:String,accountNumber: String,availableBalance: String)


/*
object Balance{
	//implicit val balanceReads = Json.reads[Balance]
  //implicit val balanceWrites = Json.format[Balance]
//implicit val balanceWrites = Json.writes[Balance]

  implicit val balanceWrites = new Writes[Balance] {
  def writes(balance: Balance) = Json.obj(
    "accountName" -> balance.accountName,
    "accountNumber" -> balance.accountNumber,
    "availableBalance" -> balance.availableBalance
  )
}
}*/

