package ru.sggr.banana.mock.queue

import ru.sggr.banana.api.Item
import ru.sggr.banana.api.Queue

/**
 * Empty mock for queue.
 *
 * @author tolya 
 * @since  27.01.15.
 */
class NullQueue extends Queue {
  /**
   * push item to queue
   *
   * @param item abstract data
   */
  override def push(item: Item): Unit = {}
}
