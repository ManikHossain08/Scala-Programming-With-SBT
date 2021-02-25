package ca.basic.scala.zookeeper

import org.apache.zookeeper.ZooKeeper

import scala.collection.JavaConversions.asScalaBuffer

object ZKGroupClient05 extends App {
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)

  val processList = zkClient.getChildren("/bdsf2001/manik/Group1", false)

  processList.foreach(println)

  zkClient.close()
}
