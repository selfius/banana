package ru.sggr.banana.mock.retriever

import ru.sggr.banana.api.Queue
import ru.sggr.banana.api.Retriever
import ru.sggr.banana.api.Item
import java.time.ZonedDateTime
import scala.util.Random

/**
 * Simple retriever
 *
 * @author tolya 
 * @since  28.01.15.
 */
class RandomIntRetriever(repeat: Int = 1) extends Retriever {
  /**
   * every retriever has single method to start retrieve items
   */
  override def retrieve(queue: Queue, lastUpdated: ZonedDateTime, items: String*): Unit = {
    for (i: Int <- 1 to repeat) {
      queue.push(new Item {
        override def getItemId=Random.nextInt.toString

        override def getRetrieverId="Some random string here"

        override def getRetrieveDate=ZonedDateTime.now

        override def getData = ??? 
      })
    }
  }
}
