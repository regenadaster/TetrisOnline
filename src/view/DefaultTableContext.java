package view;

public class DefaultTableContext implements TableContext {
  private DefaultTableContextAttributeMap tableCloth;

  public DefaultTableContext() {
    tableCloth = new DefaultTableContextAttributeMap();
  }

  public Object getAttribute(Object key) {
    return getAttribute(tableCloth, key);
  }

  public void setAttribute(Object key, Object value) {
    setAttribute(tableCloth, key, value);
  }

  @Override
  public Object getAttribute(TableContextAttributeMap tca, Object key) {
    return tca.getAttribute(key);
  }

  @Override
  public void setAttribute(TableContextAttributeMap tca, Object key,
      Object value) {
    tca.setAttribute(key, value);
  }
}