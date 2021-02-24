package ca.basic.scala.zookeeper

import org.apache.zookeeper.{WatchedEvent, Watcher}

class DummyWatcher extends Watcher {
  override def process(event: WatchedEvent): Unit = {
    println(event.toString)
  }
}
