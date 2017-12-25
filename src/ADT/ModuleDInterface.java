package ADT;

public interface ModuleDInterface<T>
{
    public void add(T newEntry);
    public T get(int position);
    public int getTotalEntries();
    public boolean isEmpty();
    public boolean updateDMClockInOut(String DMID);
    public void displayCustomerPendingOrderInTable(String CustID);
    public void displayCustomerAssignOrderInTable(String CustID);
    public void displayCustomerDeliverOrderInTable(String CustID);
    public void SortTotalDelivery();
}
