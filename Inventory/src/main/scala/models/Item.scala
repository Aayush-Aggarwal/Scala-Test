package main.scala.models

/**
  * Created by knoldus on 7/31/17.
  */
case class Item(description: String, photos: List[Photo], vendorInformation: Vendor,
                itemPrice: Price, category: String, itemName: String, id: Int, itemCount: Int) {

}
