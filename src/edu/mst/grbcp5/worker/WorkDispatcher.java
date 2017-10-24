package edu.mst.grbcp5.worker;

import java.util.Map;

public class WorkDispatcher implements Worker {

  public WorkDispatcher() {

  }

  @Override
  public int assign( Workable workable, Map< String, Object > parameters, Object result ) {

    result = workable.work( parameters );

    return 0;
  }

  @Override
  public boolean isWorkDone( int workKey ) {
    return false;
  }

  @Override
  public boolean waitForWork( int workKey ) {
    return false;
  }

  @Override
  public void absolve( int workKey ) {

  }

  @Override
  public boolean isAllWorkDone() {
    return false;
  }

  @Override
  public boolean waitForAllWork() {
    return false;
  }

  @Override
  public boolean absolveAll() {
    return false;
  }
}
