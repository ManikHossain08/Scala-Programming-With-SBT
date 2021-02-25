package ca.basic.scala.zookeeper

import org.apache.zookeeper.{CreateMode, ZooDefs, ZooKeeper}

object ZKCreateGroup04 extends App {
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)

  zkClient.create("/bdsf2001/manik/Group1", "Persistent Group1".getBytes,ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)

  zkClient.close()
}
