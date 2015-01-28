package ru.sggr.banana.retriever

import org.scalatest.FunSuite
import ru.sggr.banana.mock.queue.NullQueue
import ru.sggr.banana.mock.retriever.RandomIntRetriever
import ru.sggr.banana.queue.Queue

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
      override def push(item: Any): Unit = {
        super.push(item)
        count = count + 1
      }
    }

    val retriever = new RandomIntRetriever(2)
    retriever.retrieve(queue)

    // balancing

    assert(count == 2)
  }

  /**
   * Our architecture must not modify items
   */
  test("unmodifiable item") {
    val generatedItem: String = "Banana does not modify item"

    val queue = new NullQueue {
      /**
       * push item to queue
       *
       * @param item abstract data
       */
      override def push(item: Any): Unit = {
        super.push(item)
        assert(item.isInstanceOf[String])
        assert(generatedItem.eq(item.asInstanceOf[AnyRef]))
      }
    }

    val retriever = new Retriever {
      /**
       * every retriever has single method to start retrieve items
       */
      override def retrieve(queue: Queue): Unit = queue.push(generatedItem)
    }

    // balancing

    retriever.retrieve(queue)
  }
}
