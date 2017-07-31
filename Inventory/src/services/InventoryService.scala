package services

import main.scala.models.{Inventory, Item, Price}

import scala.concurrent.Future

trait InventoryService {

  def itemFilterCriteria(inventory: Inventory, itemName: String, category: String,
                         filterParameter: String): Future[List[Item]] = {

    Future {
      filterParameter match {

        case "price low to high" => inventory.listOfItems.sortBy(_.itemPrice.price)
        case "price high to low" => inventory.listOfItems.sortBy(_.itemPrice.price).reverse
        case _ => inventory.listOfItems

      }
    }
  }

  def priceInfo(inventory: Inventory, itemId: Int): Future[Price] = {
    Future {
      inventory.listOfItems.filter(_.id == itemId)(0).itemPrice
    }
  }

  def updateItemCount(inventory: Inventory, itemId: Int, update: Int)
                     (f: (Int, Int) => Int): Future[Option[Item]] = {
    Future {
      val itemValueBeforeUpdate = inventory.listOfItems.filter(_.id == itemId)(0)
      if (update != 0) {
        val itemValueAfterUpdate = itemValueBeforeUpdate.copy(itemCount = f(itemValueBeforeUpdate.itemCount, update))
        Some(itemValueAfterUpdate)
      }
      else None
    }


  }

}
