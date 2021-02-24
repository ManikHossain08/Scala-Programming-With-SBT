package ca.basic.scala.zookeeper

import org.apache.zookeeper.ZooKeeper

object ZKDeleteNode02 extends App {
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)
  zkClient.delete("/bdsf2001/manik",0)
  zkClient.close()
}
