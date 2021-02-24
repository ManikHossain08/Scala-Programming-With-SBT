package ca.basic.scala.zookeeper

import org.apache.zookeeper.{CreateMode, ZooDefs, ZooKeeper}

object ZKCreateNode01 extends App {
  // 1. ZK client (it's same as running zkCli.sh)
  // zkCli.sh -server quickstart.cloudera:2181
  val zkClient = new ZooKeeper("quickstart.cloudera:2181", 500, new DummyWatcher)

  // 2. Create an persistent node
  zkClient.create("/bdsf2001/manik", "Manik Student MCIT".getBytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)

  // n. close the connection
  zkClient.close()

}
