package es.sergiomartinez.basecleanarchitecture.domain.inteactors;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public enum InteractorPriority {
  LOW(1),
  MEDIUM(50),
  HIGH(100),
  URGENT(200);

  private int priority;

  InteractorPriority(int priority) {
    this.priority = priority;
  }

  public int getPriorityValue() {
    return priority;
  }
}
