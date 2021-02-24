package ca.basic.scala.zookeeper

import org.apache.zookeeper.{CreateMode, ZooDefs, ZooKeeper}

object ZKEphemeralNode03  extends App {
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)

  // 2. Create an EPHEMERAL node
  zkClient.create("/bdsf2001/manik/EPHEMERAL", "Manik EphemeralNode".getBytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL)

  println("Keep the application up forever....")
  while(true) Thread.sleep(1000)

  // n. close the connection
  zkClient.close()
}
