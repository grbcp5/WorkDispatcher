package edu.mst.grbcp5.worker;

import java.util.Map;

public interface Workable {

  Object work( Map< String, Object > parameters );

}
