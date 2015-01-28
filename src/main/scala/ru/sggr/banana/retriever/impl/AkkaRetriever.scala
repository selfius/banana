package ru.sggr.banana.retriever.impl

import ru.sggr.banana.retriever.Retriever

/**
 * @author tolya 
 * @since  28.01.15.
 */
trait AkkaRetriever[T] extends Retriever {

  /**
   * when retriever finds an item it should call save method immediately
   * the method would send information about collected item to
   * other part of system in async manner
   *
   * @param item just collected item
   */
  protected def save(item: T): Unit = {
    ???
  }
}
