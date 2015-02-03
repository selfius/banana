package ru.sggr.banana.retriever

import org.scalatest.FunSuite
import ru.sggr.banana.mock.queue.NullQueue
import ru.sggr.banana.mock.retriever.RandomIntRetriever
import ru.sggr.banana.api.Queue
import ru.sggr.banana.api.Retriever
import ru.sggr.banana.api.Item
import java.time.ZonedDateTime



/**
 * Test suite stub for [[Retriever]]
 * Created by Andrey Sviridov on 1/27/15.
 */
class RetrieverTest extends FunSuite {

  /**
   * We generate 2 items and queue receive 2 items
   */
  test("count of the generated items equal count of the receiving items") {
    var count: Int = 0

    val queue = new NullQueue {
      /**
       * push item to queue
       *
       * @param item abstract data
       */
      override def push(item: Item): Unit = {
        super.push(item)
        count = count + 1
      }
    }

    val retriever = new RandomIntRetriever(2)
    retriever.retrieve(queue, ZonedDateTime.now)

    // balancing

    assert(count == 2)
  }

  /**
   * Our architecture must not modify items
   */
  test("unmodifiable item") {
    val generatedItem = new Item {
      override def getItemId = "some id goes here"
      override def getRetrieverId = "Doesn't matter"
      override def getRetrieveDate = ZonedDateTime.now
      override def getData = "Banana does not modify item"
    }

    val queue = new NullQueue {
      /**
       * push item to queue
       *
       * @param item abstract data
       */
      override def push(item: Item): Unit = {
        assert(item.isInstanceOf[Item])
        assert(generatedItem.eq(item.asInstanceOf[AnyRef]))
      }
    }

    val retriever = new Retriever {
      /**
       * every retriever has single method to start retrieve items
       */
      override def retrieve(queue: Queue, lastUpdateDate: ZonedDateTime, items: String*) : Unit = 
        queue.push(generatedItem)
    }

    // balancing

    retriever.retrieve(queue, ZonedDateTime.now)
  }
}
