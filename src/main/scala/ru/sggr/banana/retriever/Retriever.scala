package ru.sggr.banana.retriever

import ru.sggr.banana.queue.Queue

/**
 * trait for information retriever object
 * Created by Andrey Sviridov 1/27/15.
 */
trait Retriever {

  /**
   * every retriever has single method to start retrieve items
   */
  def retrieve(queue: Queue): Unit
}
