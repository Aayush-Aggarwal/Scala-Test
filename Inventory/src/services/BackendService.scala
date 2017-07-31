package main.scala.services
import main.scala.models.{Inventory,Item}
/**
  * Created by knoldus on 7/31/17.
  */
trait BackendService {

  def addItem(inventory: Inventory,item: Item):(Inventory,Int)={

    val itemList=inventory.listOfItems
    val newList=item::itemList
    (Inventory(newList),item.id)
  }
}
