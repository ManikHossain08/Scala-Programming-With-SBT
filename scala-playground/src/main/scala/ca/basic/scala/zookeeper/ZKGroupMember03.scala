package ca.basic.scala.zookeeper

import org.apache.zookeeper.{CreateMode, ZooDefs, ZooKeeper}

object ZKGroupMember03 extends App {
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)

  zkClient.create("/bdsf2001/manik/Group1/Member3", "Member03 of Group1".getBytes,
    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL)

  println("Keep the application up forever....")
  while(true) Thread.sleep(1000)

  zkClient.close()
}
