package edu.mst.grbcp5.worker;

import java.util.Map;

public interface Worker {

  int assign(
    Workable workable,
    Map< String, Object > parameters,
    Object result
  );

  boolean isWorkDone(
    int workKey
  );

  boolean waitForWork(
    int workKey
  );

  void absolve(
    int workKey
  );

  boolean isAllWorkDone();

  boolean waitForAllWork();

  boolean absolveAll();

}
