package view;

public interface TableContext {
  public Object getAttribute(TableContextAttributeMap tca, Object key);

  public void setAttribute(TableContextAttributeMap tca, Object key,
      Object value);
}