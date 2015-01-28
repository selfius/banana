package ru.sggr.banana.queue

/**
 * Trait for queue from here persisters cat take elements and persists.
 * Banana take items from retriever and push to queue.
 *
 * @author tolya
 * @since  27.01.15.
 */
trait Queue {

  /**
   * push item to queue
   *
   * @param item abstract data
   */
  def push(item: Any): Unit
}
