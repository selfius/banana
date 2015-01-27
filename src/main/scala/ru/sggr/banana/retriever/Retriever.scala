package ru.sggr.banana.retriever

/**
 * trait for information retriever object
 * Created by Andrey Sviridov 1/27/15.
 */
trait Retriever[T] {

  /**
   * every retriever has single method to start retrieve items
   */
  def retrieve: Unit

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
