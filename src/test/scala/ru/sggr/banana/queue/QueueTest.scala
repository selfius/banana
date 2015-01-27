package ru.sggr.banana.queue

import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSuite

/**
 * @author tolya 
 * @since  27.01.15.
 */
class QueueTest extends FunSuite with MockFactory {

  val queue = stub[Queue]
  (queue.push _).when(1).returns(true)

  test("simple queue stub") {
    assert(queue.push(1))
  }
}
