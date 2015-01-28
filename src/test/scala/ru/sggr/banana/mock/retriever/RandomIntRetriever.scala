package ru.sggr.banana.mock.retriever

import ru.sggr.banana.queue.Queue
import ru.sggr.banana.retriever.Retriever

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
  override def retrieve(queue: Queue): Unit = {
    for (i: Int <- 1 to repeat) {
      queue.push(Random.nextInt())
    }
  }
}
